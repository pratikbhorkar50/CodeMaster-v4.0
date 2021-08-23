package com.worldline.codemaster.promlem1

import java.io.{File, PrintWriter}
import scala.io.Source

object Solution extends App {
  val input = Source.fromResource("input.txt").getLines()
  val writer = new PrintWriter(new File("output.txt"))

  var remainingLines = input.drop(1).toList
  var count = 1
  while (remainingLines.nonEmpty) {
    val linesToTake = remainingLines.head.split(" ").map(_.trim).last.toInt + 1
    doSomething(count, remainingLines.take(linesToTake))
    remainingLines = remainingLines.drop(linesToTake)
    count = count + 1
  }

  def doSomething(count: Int, lines: List[String]): Unit = {
    val totalKM = lines.head.split(" ").map(_.trim).head.toInt
    val blah = lines.drop(1).map(line => {
      val somethings = line.split(" ").map(_.trim)
      val sol = (totalKM - somethings.head.toInt) / somethings.last.toInt
      sol
    }).sum
    val calc = totalKM.toDouble / blah.toDouble
    writer.write(s"Trip-$count: $calc\n")
  }
  writer.close()
}
