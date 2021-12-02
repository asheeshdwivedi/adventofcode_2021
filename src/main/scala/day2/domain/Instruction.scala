package day2.domain


case class Instruction(direction: Direction, steps: Int)

enum Direction:
  case Forward, Down, Up

object Direction:

  def fromString(input: String): Direction =
    input match
      case "forward" => Direction.Forward
      case "down" => Direction.Down
      case "up" => Direction.Up


case class Position private[domain](horizontal: Int, depth: Int, aim: Int)

object Position:
  def empty: Position = new Position(0, 0, 0)
