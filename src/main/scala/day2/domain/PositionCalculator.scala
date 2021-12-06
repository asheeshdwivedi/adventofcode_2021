package day2.domain

object PositionCalculator:

  extension (position: Position)

    def increaseHorizontal(by: Int): Position = position.copy(horizontal = position.horizontal + by)

    def increaseDepth(by: Int): Position = position.copy(depth = position.depth + by)

    def decreaseDepth(by: Int): Position = position.copy(depth = position.depth - by)

    def decreaseAim(by: Int): Position = position.copy(aim = position.aim - by)

    def increaseAim(by: Int): Position = position.copy(aim = position.aim + by)

    def increaseDepthByAimTimes(by: Int): Position =
      position.copy(depth = (by * position.aim) + position.depth)
