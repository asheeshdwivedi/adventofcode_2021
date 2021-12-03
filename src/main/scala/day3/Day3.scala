package day3

import day3.domain.{Binary, Bit, LifeSupportRatingType}
import day3.domain.LifeSupportRatingType._

import scala.annotation.tailrec

object Day3:

  def powerConsumption(input: Seq[Binary]): Int = {
    val totalBits = input.head.length - 1
    val gamaRateBits = for i <- 0 to totalBits yield
      val (zeros, ones) = input.map(_ (i)).partition(_ == Bit.Zero)
      if zeros.length > ones.length then Bit.Zero
      else Bit.One

    val gammaRate = Binary(gamaRateBits)
    val epsilonRate = gammaRate.invert

    gammaRate.intValue * epsilonRate.intValue
  }

  def lifeSupportRating(input: Seq[Binary]): Int = {
    val totalBits = input.head.length - 1
    @tailrec
    def compute(remaining: Seq[Binary], ratingType: LifeSupportRatingType, position: Int = 0): Binary = {
      if remaining.tail.isEmpty then remaining.head
      else
        val (zeros, ones) = remaining.map(_ (position)).partition(_ == Bit.Zero)
        val bit = ratingType match
          case Oxygen => if ones.length >= zeros.length then Bit.One else Bit.Zero
          case Carbon => if ones.length >= zeros.length then Bit.Zero else Bit.One
        val nextInput = remaining.filter(_ (position) == bit)
        compute(nextInput, ratingType, position + 1)
    }

    val oxygenGeneratorRating = compute(input, Oxygen)
    val CO2ScrubberRating = compute(input, Carbon)
    oxygenGeneratorRating.intValue * CO2ScrubberRating.intValue
  }



