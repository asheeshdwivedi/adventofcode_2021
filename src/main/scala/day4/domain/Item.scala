package day4.domain

import parser.TypeParser
import parser.TypeParser._

final case class Item[+T](input: T, isVisited: Boolean = false)

object Item:
  given itemParser[T](using TypeParser[String, T]): TypeParser[String, Item[T]] with
    override def parse(input: String): Item[T] = Item(input.as[T])