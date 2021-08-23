package com.worldline.codemaster.promlem1

import java.io.{File, PrintWriter}
import scala.io.Source

object Solution extends App {
  val input = Source.fromResource("input.txt").getLines()
  val writer = new PrintWriter(new File("output.txt"))

  var remainingLines = input.drop(1)
  var count = 0
  while (remainingLines.nonEmpty) {
    val linesToTake = remainingLines.next().split(" ").map(_.trim).last.toInt + 1
    doSomething(count, remainingLines.take(linesToTake).toList)
    remainingLines = remainingLines.drop(linesToTake)
    count = count + 1
  }

  def doSomething(count: Int, lines: List[String]) = {
    val totalKM = lines.head.split(" ").map(_.trim).head.toInt
    val blah = lines.drop(1).map(line => {
      val somethings = line.split(" ").map(_.trim)
      (totalKM - somethings.head.toInt) / somethings.last.toInt
    }).sum
    val calc = totalKM / blah
    writer.write(s"Trip-$count: $calc\n")
  }
  writer.close()
}
