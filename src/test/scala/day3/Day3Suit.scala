package day3

import day3.Day3
import day3.domain.Binary
import day3.domain.Binary.toBinary
import extension.ReadInput.readInput
import org.scalatest.funsuite.AnyFunSuite;

class Day3Suit extends AnyFunSuite :

  test("test with sample data") {
    val input = List(
      "00100".toBinary,
      "11110".toBinary,
      "10110".toBinary,
      "10111".toBinary,
      "10101".toBinary,
      "01111".toBinary,
      "00111".toBinary,
      "11100".toBinary,
      "10000".toBinary,
      "11001".toBinary,
      "00010".toBinary,
      "01010".toBinary
    )
    val result = Day3.powerConsumption(input)
    assert(result == 198)
  }

  test("with test data") {
    val input = "day3/input1".readInput.map(_.toBinary)
    val result = Day3.powerConsumption(input)
    println(result)
  }

  test("test part 2 with sample data") {
    val input = List(
      "00100".toBinary,
      "11110".toBinary,
      "10110".toBinary,
      "10111".toBinary,
      "10101".toBinary,
      "01111".toBinary,
      "00111".toBinary,
      "11100".toBinary,
      "10000".toBinary,
      "11001".toBinary,
      "00010".toBinary,
      "01010".toBinary
    )
    val result = Day3.lifeSupportRating(input)
    assert(result == 230)
  }

  test("part 2 with test data") {
    val input = "day3/input2".readInput.map(_.toBinary)
    val result = Day3.lifeSupportRating(input)
    println(result)
  }


