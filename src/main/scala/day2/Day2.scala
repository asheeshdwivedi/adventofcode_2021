package day2

import day2.domain.{Direction, Instruction, Position}
import day2.domain.PositionCalculator.*

object Day2:

  def computePart1(input: Seq[Instruction]): Int = {
    val accumulatedPosition = input.foldLeft(Position.empty)((position, instruction) =>
      instruction.direction match
        case Direction.Forward => position.increaseHorizontal(instruction.steps)
        case Direction.Down => position.increaseDepth(instruction.steps)
        case Direction.Up => position.decreaseDepth(instruction.steps)
    )
    accumulatedPosition.horizontal * accumulatedPosition.depth
  }

  def computePart2(input: Seq[Instruction]): Int = {
    val accumulatedPosition = input.foldLeft(Position.empty)((position, instruction) =>
      instruction.direction match
        case Direction.Forward => position.increaseHorizontal(instruction.steps)
          .increaseDepthByAimTimes(instruction.steps)
        case Direction.Down => position.increaseAim(instruction.steps)
        case Direction.Up => position.decreaseAim(instruction.steps)
    )
    accumulatedPosition.horizontal * accumulatedPosition.depth
  }

