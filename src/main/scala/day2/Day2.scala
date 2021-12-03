package day2

import day2.domain.{Command, Position}
import day2.domain.Command.{Forward, Up, Down}
import day2.domain.PositionCalculator.*

object Day2:

  def computePart1(input: Seq[Command]): Int = {
    val accumulatedPosition = input.foldLeft(Position.empty)((position, instruction) =>
      instruction match
        case Forward(steps) => position.increaseHorizontal(steps)
        case Down(steps) => position.increaseDepth(steps)
        case Up(steps) => position.decreaseDepth(steps)
    )
    accumulatedPosition.horizontal * accumulatedPosition.depth
  }

  def computePart2(input: Seq[Command]): Int = {
    val accumulatedPosition = input.foldLeft(Position.empty)((position, instruction) =>
      instruction match
        case Forward(steps) => position.increaseHorizontal(steps)
          .increaseDepthByAimTimes(steps)
        case Down(steps) => position.increaseAim(steps)
        case Up(steps) => position.decreaseAim(steps)
    )
    accumulatedPosition.horizontal * accumulatedPosition.depth
  }

