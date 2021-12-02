package day2

import day2.domain.{Direction, Instruction}
import org.scalatest.funsuite.AnyFunSuite

class Day2Suit extends AnyFunSuite :

  test("test with sample data") {
    val sampleData = Instruction(Direction.Forward, 5) ::
      Instruction(Direction.Down, 5) ::
      Instruction(Direction.Forward, 8) ::
      Instruction(Direction.Up, 3) ::
      Instruction(Direction.Down, 8) ::
      Instruction(Direction.Forward, 2) :: Nil

    val result = Day2.compute(sampleData)
    assert(result == 150)
  }




