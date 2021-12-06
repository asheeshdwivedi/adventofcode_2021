package day5.domain

import parser.TypeParser
import parser.TypeParser._

case class Point(x: Int, y: Int)

object Point:
  given TypeParser[String, Point] with
    def parse(input: String): Point =
      val pointPattern = """(\d+),(\d+)""".r
      val pointPattern(x, y) = input
      Point(x.toInt, y.toInt)

case class Line(start: Point, end: Point):

  def isHorizontal: Boolean = start.y == end.y

  def isVertical: Boolean = start.x == end.x

  /**
   * All coordinate for a line
   */
  def allCoordinates: Seq[Point] =
    val xDelta = if start.x <= end.x then 1 else -1
    val yDelta = if start.y <= end.y then 1 else -1
    if isHorizontal || isVertical then
      start.x.to(end.x, xDelta)
        .flatMap(x => start.y.to(end.y, yDelta)
          .map(y => Point(x, y)))
    else
      start.x.to(end.x, xDelta)
        .zip(start.y.to(end.y, yDelta))
        .map(Point.apply)

object Line:
  given TypeParser[String, Line] with
    override def parse(input: String): Line =
      val linePattern = """(.*) -> (.*)""".r
      val linePattern(x, y) = input
      Line(x.as[Point], y.as[Point])