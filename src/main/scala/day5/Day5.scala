package day5

import day5.domain.{Line, Point}

object Day5:

  def ventPositions(lines: Seq[Line]): Int = solve(
    lines.filter(line => line.isVertical || line.isHorizontal)
  )

  def ventDiagonals(lines: Seq[Line]): Int = solve(lines)

  def solve(lines: Seq[Line]): Int =
    lines
      .foldLeft(Map.empty[Point, Int]) { (acc, line) =>
        line.allCoordinates.foldLeft(acc) {
          (m, p) =>
            m.updatedWith(p) {
              case Some(n) => Some(n + 1)
              case None => Some(1)
            }
        }
      }.values.count(_ >= 2)