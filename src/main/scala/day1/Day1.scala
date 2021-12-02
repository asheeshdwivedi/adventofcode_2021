package day1

object Day1:

  def depthMeasurementIncreases(input: Seq[Int]): Int =
    input.sliding(2)
      .count(window => window.head < window.last)

  def threeMeasurementSlidingWindow(input: Seq[Int]) =
    input.sliding(3)
      .map(_.sum)
      .sliding(2)
      .count(window => window.head < window.last)

