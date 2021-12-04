package day3.domain

import day2.domain.Command
import day2.domain.Command.{Down, Forward, Up}
import day3.domain.Bit.Zero
import parser.TypeParser

object Bit:
  given TypeParser[Char,Bit] with
    def parse(input: Char): Bit = input match {
      case '0' => Bit.Zero
      case '1' => Bit.One
      case s: Char => throw new IllegalArgumentException(s"UNKNOWN input ${s.toString}")
    }

enum Bit(val value: Int):

  def invert: Bit =
    this match
      case Zero => One
      case One  => Zero

  case Zero extends Bit(0)
  case One extends Bit(1)

enum LifeSupportRatingType:
  case Oxygen, Carbon
