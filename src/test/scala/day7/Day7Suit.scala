package day7

import day6.Day6
import org.scalatest.funsuite.AnyFunSuite
import parser.TypeParser._

class Day7Suit extends AnyFunSuite :

  test("test part 1 with sample data") {
    val input = "day7/sampleData".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day7.solvePart1(input )
    assert(result == 37)
  }

  test("test part 1 with test data") {
    val input = "day7/input1".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day7.solvePart1(input)
    println(result)
    assert(344735 == result)
  }

  test("test part 2 with sample data") {
    val input = "day7/sampleData".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day7.solvePart2(input )
    assert(result == 168)
  }

  test("test part 2 with test data") {
    val input = "day7/input2".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day7.solvePart2(input)
    println(result)
    assert(96798233 == result)
  }






