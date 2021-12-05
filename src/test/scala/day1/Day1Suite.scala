package day1

import org.scalatest.funsuite.AnyFunSuite
import parser.TypeParser._

class Day1Suite extends AnyFunSuite :

  test("count the number of times a depth measurement increases") {
    val depth = "day1/input1".as[Seq[Int]]
    val result = Day1.depthMeasurementIncreases(depth)
    println(result)
  }

  test("the number of times the sum of measurements in this sliding window increases"){
    val depth = "day1/input2".as[Seq[Int]]
    val result = Day1.threeMeasurementSlidingWindow(depth)
    println(result)
  }


