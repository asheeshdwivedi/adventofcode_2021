package day3.domain

import day3.domain.{Binary, Bit}
import Binary.toBinary
import day3.domain.Bit.Zero

import scala.annotation.tailrec

class Binary(bits: Seq[Bit]):

  def apply(index: Int): Bit = bits(index)

  def *(byte: Binary): Binary = (this.intValue * byte.intValue).toBinary

  def invert: Binary = Binary(bits.map(_.invert))

  def intValue: Int = bits.view.reverse
    .zipWithIndex
    .filter((bits ,_)  => bits == Bit.One)
    .map((_, index) => Math.pow(2, index).toInt).sum

  def length: Int = bits.length

  override def toString: String = bits.map(_.value).mkString

object Binary:
  extension (input: Int)
    def toBinary = {
      val fromInt: Int => Bit = value => if value % 2 == 0 then Bit.Zero else Bit.One

      @tailrec
      def toBinary(n: Int, acc: List[Bit]): List[Bit] = {
        if n / 2 == 1 then Bit.One :: fromInt(n) :: acc
        else toBinary(n / 2, fromInt(n % 2) :: acc)
      }

      Binary(toBinary(input, Nil))
    }

  extension (input: String)
    def toBinary: Binary = Binary(input.collect {
      case '0' => Bit.Zero
      case '1' => Bit.One
    })
