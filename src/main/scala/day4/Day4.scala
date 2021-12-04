package day4

import day4.domain.{BingoInput, Grid}

import scala.annotation.tailrec

object Day4:

  def playBingo(input:BingoInput): Int =
    @tailrec
    def untilBingo(draw: Int, remainingDraws: Seq[Int], grids: Seq[Grid[Int]]): Int =
      val updateGrid = grids.map(_.visit(draw))
      updateGrid.find(_.isAnyRowOrColumnVisitedCompletely) match
        case Some(value) => value.nonVisitedItem.sum * draw
        case None => untilBingo(remainingDraws.head, remainingDraws.tail, updateGrid)

    untilBingo(input.draws.head, input.draws.tail, input.grids)



