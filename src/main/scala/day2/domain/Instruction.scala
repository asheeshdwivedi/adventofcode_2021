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


case class Position private(horizontal: Int, depth: Int):

  def increaseHorizontal(by: Int): Position = this.copy(horizontal = this.horizontal + by)

  def increaseDepth(by: Int): Position = this.copy(depth = this.depth + by)

  def decreaseDepthBy(by: Int): Position = this.copy(depth = this.depth - by)

end Position

object Position:
  def empty: Position = new Position(0, 0)
