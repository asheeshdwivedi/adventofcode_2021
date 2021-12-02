package day2

import day2.domain.{Direction, Instruction}
import org.scalatest.funsuite.AnyFunSuite
import extension.ReadInput.readInput;

class Day2Suit extends AnyFunSuite :

  test("test with sample data") {
    val sampleData = Instruction(Direction.Forward, 5) ::
      Instruction(Direction.Down, 5) ::
      Instruction(Direction.Forward, 8) ::
      Instruction(Direction.Up, 3) ::
      Instruction(Direction.Down, 8) ::
      Instruction(Direction.Forward, 2) :: Nil

    val result = Day2.computePart1(sampleData)
    assert(result == 150)
  }

  test("part 1 with test data"){
    val input = "day2/input1".readInput.map{
      case s"$direction $steps" => Instruction(Direction.fromString(direction) , steps.toInt)
    }
    val result = Day2.computePart1(input)
    println(result)
  }

  test("part 2 test with sample data") {
    val sampleData = Instruction(Direction.Forward, 5) ::
      Instruction(Direction.Down, 5) ::
      Instruction(Direction.Forward, 8) ::
      Instruction(Direction.Up, 3) ::
      Instruction(Direction.Down, 8) ::
      Instruction(Direction.Forward, 2) :: Nil

    val result = Day2.computePart2(sampleData)
    assert(result == 900)
  }

  test("part 2 with test data "){
    val input = "day2/input2".readInput.map{
      case s"$direction $steps" => Instruction(Direction.fromString(direction) , steps.toInt)
    }
    val result = Day2.computePart2(input)
    println(result)
  }




