package day3

import day3.Day3
import day3.domain.Binary
import org.scalatest.funsuite.AnyFunSuite;
import parser.TypeParser._
import day3.domain.Binary.toBinary

class Day3Suit extends AnyFunSuite :

  test("test with sample data") {
    val input = "day3/sampleData".as[Seq[Binary]]
    val result = Day3.powerConsumption(input)
    assert(result == 198)
  }

  test("with test data") {
    val input = "day3/input1".as[Seq[Binary]]
    val result = Day3.powerConsumption(input)
    println(result)
  }

  test("test part 2 with sample data") {
    val input = "day3/sampleData".as[Seq[Binary]]
    val result = Day3.lifeSupportRating(input)
    assert(result == 230)
  }

  test("part 2 with test data") {
    val input = "day3/input2".as[Seq[Binary]]
    val result = Day3.lifeSupportRating(input)
    println(result)
  }


