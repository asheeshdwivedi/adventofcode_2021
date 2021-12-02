package extension

import java.nio.file.{Files, Paths}
import scala.io.Source

object ReadInput:

  extension (path: String)
    def readInput: Seq[String] = Source.fromResource(path).getLines().toSeq

