package day4

import day3.Day3
import day3.domain.Binary
import day4.domain.BingoInput
import org.scalatest.funsuite.AnyFunSuite
import parser.TypeParser._

class Day4Suit extends AnyFunSuite :

  test("part 1 test with sample data") {
    val input = "day4/sampleData".as[BingoInput]
    val result = Day4.playBingo(input)
    assert(4512 == result)
  }

  test("part 1 test with input data") {
    val input = "day4/input1".as[BingoInput]
    val result = Day4.playBingo(input)
    println(result)
  }


