package day4

import day4.domain.{BingoInput, Grid}

import scala.annotation.tailrec

object Day4:

  def playBingo(input: BingoInput): Int =
    @tailrec
    def untilBingo(remainingDraws: Seq[Int], grids: Seq[Grid[Int]]): Int =
      val draw = remainingDraws.head
      val updatedGrid = grids.map(_.visit(draw))
      updatedGrid.find(_.isAnyRowOrColumnVisitedCompletely) match
        case Some(value) => value.nonVisitedItems.sum * draw
        case None => untilBingo(remainingDraws.tail, updatedGrid)

    untilBingo(input.draws, input.grids)


  def lastWinner(input: BingoInput): Int =
    @tailrec
    def untilLastWinner(remainingDraws: Seq[Int], grids: Seq[Grid[Int]], winner: Int): Int =
      if remainingDraws.isEmpty then winner
      else
        val draw = remainingDraws.head
        val updatedGrid = grids.map(_.visit(draw))
        val completedGrid = grids.zip(updatedGrid).find(
          (previous, current) => !previous.isAnyRowOrColumnVisitedCompletely && current.isAnyRowOrColumnVisitedCompletely
        )
        val newWinner = completedGrid match
          case Some(_, completed) => completed.nonVisitedItems.sum * draw
          case None => winner

        untilLastWinner(remainingDraws.tail, updatedGrid, newWinner)

    untilLastWinner(input.draws, input.grids, 0)

