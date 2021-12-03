package day2

import day2.domain.Command.{Forward, Down, Up}
import org.scalatest.funsuite.AnyFunSuite
import extension.ReadInput.readInput;

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
    val input = "day2/input1".readInput.map {
      case s"forward $steps" => Forward(steps.toInt)
      case s"down $steps" => Down(steps.toInt)
      case s"up $steps" => Up(steps.toInt)
    }
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
    val input = "day2/input2".readInput.map {
      case s"forward $steps" => Forward(steps.toInt)
      case s"down $steps" => Down(steps.toInt)
      case s"up $steps" => Up(steps.toInt)
    }
    val result = Day2.computePart2(input)
    println(result)
  }




