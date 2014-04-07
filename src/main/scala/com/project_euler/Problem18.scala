package com.project_euler

/**
 * Maximum path sum.
 *
 * https://projecteuler.net/problem=18
 *
 * @author Bharat Ravisekar
 */
object Problem18 extends App {
  private val testTriangle = Array(
    Array(3),
    Array(7, 4),
    Array(2, 4, 6),
    Array(8, 5, 9, 3)
  )

  private val triangle = Array(
    Array(75),
    Array(95, 64),
    Array(17, 47, 82),
    Array(18, 35, 87, 10),
    Array(20,  4, 82, 47, 65),
    Array(19,  1, 23, 75,  3, 34),
    Array(88,  2, 77, 73,  7, 63, 67),
    Array(99, 65,  4, 28,  6, 16, 70, 92),
    Array(41, 41, 26, 56, 83, 40, 80, 70, 33),
    Array(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
    Array(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
    Array(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
    Array(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
    Array(63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
    Array( 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23)
  )

  private val HEIGHT = triangle.size

  private def leftParent(i: Int, j: Int): Option[(Int, Int)] =
    if ((i - 1) >= 0 && (j - 1) >= 0) {
      Some(i - 1, j - 1)
    } else {
      None
    }

  private def rightParent(i: Int, j: Int): Option[(Int, Int)] =
    if ((i - 1) >= 0 && j <= (i - 1)) {
      Some(i - 1, j)
    } else {
      None
    }

  // Initialize longest path lengths to 0.
  private val longestPath = Array.ofDim[Array[Int]](HEIGHT)
  for (i <- 0 until HEIGHT)
    longestPath(i) = Array.fill[Int](i + 1)(0)

  // Set the length for root
  longestPath(0)(0) = triangle(0)(0)

  // Update each node based on left and right parents. Go top-down and left-right.
  for { i <- 1 until HEIGHT
        j <- 0 to i }
    longestPath(i)(j) = {
      val leftParentMaxLength = leftParent(i, j) match {
        case None => 0
        case Some((pi, pj)) => longestPath(pi)(pj)
      }

      val rightParentMaxLength = rightParent(i, j) match {
        case None => 0
        case Some((pi, pj)) => longestPath(pi)(pj)
      }

      // Maximum of left and right parent path
      Math.max(leftParentMaxLength, rightParentMaxLength) + triangle(i)(j)
    }

  println(longestPath.toList.map(_.toList.mkString(" ")).mkString("\n"))
  println(longestPath(HEIGHT - 1).toList.max)
}
