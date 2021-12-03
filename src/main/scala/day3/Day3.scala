package day3

import day3.domain.{Binary, Bit}

object Day3:

  def powerConsumption(input: Seq[Binary]): Int = {
    val size = input.head.length
    val gamaRateBits = for i <- 0 until size yield
      val (zeros, ones) = input.map(_ (i)).partition(_ == Bit.Zero)
      if zeros.length > ones.length then Bit.Zero
      else Bit.One

    val gammaRate = Binary(gamaRateBits)
    val epsilonRate = gammaRate.invert

    gammaRate.intValue * epsilonRate.intValue
  }



