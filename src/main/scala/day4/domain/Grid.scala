package day4.domain

import parser.TypeParser
import parser.TypeParser._

final case class Grid[+T](private val board: Seq[Seq[Item[T]]]):

  def visit[T1 >: T](t: T1): Grid[T1] =
    copy(board = board.map(_.map(item => item.copy(isVisited = item.isVisited || item.input == t))))

  /** returns true if any row on the grid visited completely
    */
  def isAnyRowVisitedCompletely: Boolean = board.exists(_.forall(_.isVisited))

  /** returns true if any column on the grid visited completely
    */
  def isAnyColumnVisitedCompletely: Boolean = board.transpose.exists(_.forall(_.isVisited))

  def isAnyRowOrColumnVisitedCompletely: Boolean =
    isAnyRowVisitedCompletely || isAnyColumnVisitedCompletely

  /** collect non visited items
    */
  def nonVisitedItems: Seq[T] = board.flatMap(_.filter(s => !s.isVisited).map(_.input))

object Grid:
  given typeParser[T](using TypeParser[String, Item[T]]): TypeParser[String, Grid[T]] with
    override def parse(input: String): Grid[T] =
      val items = input
        .split("\\n")
        .map(_.trim.split("\\s+").map(_.as[Item[T]]).toSeq)
        .toSeq
      Grid(items)
