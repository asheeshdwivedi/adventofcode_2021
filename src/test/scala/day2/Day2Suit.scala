package day2

import day2.domain.Command
import day2.domain.Command.{Down, Forward, Up}
import org.scalatest.funsuite.AnyFunSuite
import parser.TypeParser._

class Day2Suit extends AnyFunSuite :

  test("test with sample data") {
    val sampleData = Forward(5) ::
      Down(5) ::
      Forward(8) ::
      Up(3) ::
      Down(8) ::
      Forward(2) :: Nil

    val result = Day2.computePart1(sampleData)
    assert(result == 150)
  }

  test("part 1 with test data") {
    val input = "day2/input1".as[Seq[Command]]
    val result = Day2.computePart1(input)
    println(result)
  }

  test("part 2 test with sample data") {
    val sampleData = Forward(5) ::
      Down(5) ::
      Forward(8) ::
      Up(3) ::
      Down(8) ::
      Forward(2) :: Nil

    val result = Day2.computePart2(sampleData)
    assert(result == 900)
  }

  test("part 2 with test data ") {
    val input = "day2/input2".as[Seq[Command]]
    val result = Day2.computePart2(input)
    println(result)
  }




