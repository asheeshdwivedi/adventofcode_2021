package day2.domain

enum Command:
  case Forward(steps: Int)
  case Down(steps: Int)
  case Up(steps: Int)

case class Position private[domain](horizontal: Int, depth: Int, aim: Int)

object Position:
  def empty: Position = new Position(0, 0, 0)
