package day3.domain

import day3.domain.Bit.Zero

enum Bit(val value: Int):

  def invert: Bit =
    this match
      case Zero => One
      case One => Zero

  case Zero extends Bit(0)
  case One extends Bit(1)


