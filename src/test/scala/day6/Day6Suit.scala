package day6

import parser.TypeParser._
import org.scalatest.funsuite.AnyFunSuite

class Day6Suit extends AnyFunSuite :

  test("test with sample data") {
    val input = "day6/sampleData".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day6.solve(input, 80)
    assert(result == 5934)
  }

  test("with test data") {
    val input = "day6/input1".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day6.solve(input, 80)
    assert(350605 == result)
  }

  test("test part 2 with sample data") {
    val input = "day6/sampleData".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day6.solve(input, 256)
    assert(result == 26984457539l)
    println(result)
  }

  test("part 2 with test data") {
    val input = "day6/input2".as[Seq[String]].flatMap(_.split(",").map(_.toInt))
    val result = Day6.solve(input, 256)
    assert(1592778185024l == result)
    println(result)
  }



