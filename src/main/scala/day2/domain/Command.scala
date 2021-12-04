package day2.domain
import parser.TypeParser

enum Command:
  case Forward(steps: Int)
  case Down(steps: Int)
  case Up(steps: Int)

object Command:

  given TypeParser[String,Command] with
    def parse(input: String): Command = input match {
      case s"forward $steps" => Forward(steps.toInt)
      case s"down $steps" => Down(steps.toInt)
      case s"up $steps" => Up(steps.toInt)
      case s: _ => throw new IllegalArgumentException(s"UNKNOWN input $s")
    }

case class Position private[domain](horizontal: Int, depth: Int, aim: Int)

object Position:
  def empty: Position = new Position(0, 0, 0)
