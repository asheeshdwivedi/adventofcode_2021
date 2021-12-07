package day7

object Day7:

  def solvePart1(input: Seq[Int]): Int =
    val sortedCollection = input.sorted
    val median = sortedCollection(sortedCollection.size / 2)
    input.map(item => Math.abs(median - item)).sum

  def solvePart2(input: Seq[Int]): Int =
    val range = input.min to input.max
    range.map(item => input.map { x =>
      val difference = Math.abs(x - item)
      difference * (difference + 1) / 2
    }.sum).min

//def solvePart2(input: Seq[Int]): Int =
//val average = input.sum / input.size // not rounding properly
//input.map { item =>
//val difference = Math.abs(average - item)
//difference * (difference + 1) / 2h
//}.sum
