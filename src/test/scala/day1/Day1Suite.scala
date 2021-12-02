package day1

import org.scalatest.funsuite.AnyFunSuite
import extension.ReadInput.readInput;

class Day1Suite extends AnyFunSuite :

  test("count the number of times a depth measurement increases") {
    val input = "day1/input1"
    val depth = input.readInput.map(_.toInt)
    val result = Day1.depthMeasurementIncreases(depth)
    println(result)
  }

  test("the number of times the sum of measurements in this sliding window increases"){
    val input = "day1/input2".readInput.map(_.toInt)
    val result = Day1.threeMeasurementSlidingWindow(input)
    println(result)
  }


