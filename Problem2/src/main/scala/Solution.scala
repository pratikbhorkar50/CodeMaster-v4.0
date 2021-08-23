package com.worldline.codemaster.problem2

import java.io.{File, PrintWriter}
import scala.io.Source

object Solution extends App {
  val input = Source.fromResource("input.txt").getLines()
  val writer = new PrintWriter(new File("output.txt"))

  writer.close()
}
