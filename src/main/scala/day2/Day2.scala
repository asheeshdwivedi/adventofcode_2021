package day2

import day2.domain.{Direction, Instruction, Position}

object Day2:

  def compute(input: Seq[Instruction]): Int = {
    val accumulatedPosition = input.foldLeft(Position.empty)((position, instruction) =>
      instruction.direction match
        case Direction.Forward => position.increaseHorizontal(instruction.steps)
        case Direction.Down => position.increaseDepth(instruction.steps)
        case Direction.Up => position.decreaseDepthBy(instruction.steps)
    )
    accumulatedPosition.horizontal * accumulatedPosition.depth
  }

