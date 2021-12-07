package day6


import scala.annotation.tailrec

object Day6:

  def solve(input: Seq[Int], day: Int): Long =
    @tailrec
    def doSolve(fishCountByStage: IndexedSeq[Long], remainingDay: Int): Long =
      if remainingDay == 0 then fishCountByStage.sum
      else
        //each day number of fish at head stage brings that many fishes with the timer of six
        //update number of fishes at 6th by adding 0th stage fishes and then append 0th stage (head) to last stage
        val (head, tail) = (fishCountByStage.head, fishCountByStage.tail)
        val updated = tail.updated(6, tail(6) + head) :+ head
        doSolve(updated, remainingDay - 1)

    val initialFishCountByStage = input.foldLeft(IndexedSeq.fill(9)(0l))((acc, age) => acc.updated(age, acc(age) + 1))
    doSolve(initialFishCountByStage, day)







