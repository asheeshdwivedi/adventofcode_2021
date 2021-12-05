package day4

import day4.domain.{BingoInput, Grid}

import scala.annotation.tailrec

object Day4:

  def playBingo(input: BingoInput): Int =
    @tailrec
    def untilBingo(remainingDraws: Seq[Int], grids: Seq[Grid[Int]]): Int =
      val draw = remainingDraws.head
      val updateGrid = grids.map(_.visit(draw))
      updateGrid.find(_.isAnyRowOrColumnVisitedCompletely) match
        case Some(value) => value.nonVisitedItem.sum * draw
        case None => untilBingo(remainingDraws.tail, updateGrid)

    untilBingo(input.draws, input.grids)


  def lastWinner(input: BingoInput): Int =
    @tailrec
    def untilLastWinner(remainingDraws: Seq[Int], grids: Seq[Grid[Int]], winner: Int): Int =
      if remainingDraws.isEmpty then winner
      else
        val draw = remainingDraws.head
        val updateGrid = grids.map(_.visit(draw))
        val completedGrid = grids.zip(updateGrid).find(
          (previous, current) => !previous.isAnyRowOrColumnVisitedCompletely && current.isAnyRowOrColumnVisitedCompletely
        )
        val newWinner = completedGrid match
          case Some(_, completed) => completed.nonVisitedItem.sum * draw
          case None => winner

        untilLastWinner(remainingDraws.tail, updateGrid, newWinner)

    untilLastWinner(input.draws, input.grids, 0)

