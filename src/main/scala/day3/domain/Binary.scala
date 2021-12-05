package day3.domain

import day3.domain.{Binary, Bit}
import Binary.toBinary
import day2.domain.Command
import day3.domain.Bit
import parser.TypeParser
import parser.TypeParser._


import scala.annotation.tailrec

class Binary(bits: Seq[Bit]):

  def apply(index: Int): Bit = bits(index)

  def *(byte: Binary): Binary = (this.intValue * byte.intValue).toBinary

  def invert: Binary = Binary(bits.map(_.invert))

  def intValue: Int = bits.view.reverse
    .zipWithIndex
    .filter((bits, _) => bits == Bit.One)
    .map((_, index) => Math.pow(2, index).toInt).sum

  def length: Int = bits.length

  override def toString: String = bits.map(_.value).mkString

object Binary:

  given TypeParser[String, Binary] with
    def parse(input: String): Binary = Binary(input.map(_.as[Bit]))

  extension (input: Int)
    def toBinary = 
      val fromInt: Int => Bit = value => if value % 2 == 0 then Bit.Zero else Bit.One
      @tailrec
      def toBinary(n: Int, acc: List[Bit]): List[Bit] = 
        if n / 2 == 1 then Bit.One :: fromInt(n) :: acc
        else toBinary(n / 2, fromInt(n % 2) :: acc)
        
      Binary(toBinary(input, Nil))
    