package day4.domain

import day3.domain.{Binary, Bit}
import parser.TypeParser
import parser.TypeParser.as

case class BingoInput(draws: Seq[Int], grids: Seq[Grid[Int]])

object BingoInput:
  given TypeParser[String, BingoInput] with
    def parse(input: String): BingoInput = {
      val rawInput:Seq[String] = input.as[Seq[String]]
      val draws = rawInput.head.split(",").map(_.as[Int])
      val bordLength = 5
      val grid = rawInput.tail.grouped(bordLength + 1).map(_.tail.mkString("\n").as[Grid[Int]]).toSeq
      BingoInput(draws, grid)
    }
