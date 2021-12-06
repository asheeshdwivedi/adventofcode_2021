package day5

import day5.domain.{Line, Point}
import org.scalatest.funsuite.AnyFunSuite
import parser.TypeParser.*

class Day5Suit extends AnyFunSuite :

  test("part 1 test with sample data") {
    val input = "day5/sampleData".as[Seq[Line]]
    val result = Day5.ventPositions(input)
    assert(5 == result)
  }

  test("part 1 test with input data") {
    val input = "day5/input1".as[Seq[Line]]
    val result = Day5.ventPositions(input)
    println(result)
    assert(7269 == result)
  }

  test("part 2 test with sample data") {
    val input = "day5/sampleData".as[Seq[Line]]
    val result = Day5.ventDiagonals(input)
    assert(12 == result)
  }

  test("part 2 test with input data") {
    val input = "day5/input2".as[Seq[Line]]
    val result = Day5.ventDiagonals(input)
    println(result)
    assert(21140 == result)
  }
