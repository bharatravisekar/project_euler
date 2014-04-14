package com.project_euler

import scala.io.Source

/**
 * Name nameScores
 *
 * https://projecteuler.net/problem=22
 *
 * @author Bharat Ravisekar
 */
object Problem22 extends App {
  private val CharA = 'A'.toLong
  private def nameScore(name: String): Long = name.map(_.toLong - CharA + 1).sum
  private val filePath = this.getClass.getClassLoader.getResource("names.txt").getPath

  // Trimming the first and last character because they are double quotes ".
  private val sortedNames = Source.fromFile(filePath).getLines.toList.head.split(",").
    map(_.trim.toUpperCase.tail.init.toUpperCase).sorted

  val nameScoreSum = (for (i <- 0 until sortedNames.size) yield
    (i+1) * nameScore(sortedNames(i))).sum

  assert(nameScore("COLIN") == 53, "COLIN should be worth 53.")
  assert(sortedNames(937) == "COLIN", "COLIN should be the 938th name.")
  assert(nameScoreSum == 871198282, "Sum of name scores should be 871198282.")
}
