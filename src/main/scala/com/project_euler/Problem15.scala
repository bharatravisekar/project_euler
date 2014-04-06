package com.project_euler

/**
 * Lattice paths.
 *
 * https://projecteuler.net/problem=15
 *
 * @author Bharat Ravisekar
 */
object Problem15 extends App {
  private val GRID_SIZE = 20

  // Number of points are 1 more than the grid size.
  private val N = GRID_SIZE + 1
  private val lattice = Array.fill(N, N)(0L)

  // There is only one path to destination from points on the right and bottom edges of lattice.
  for (i <- 0 until N) {
    lattice(i)(N - 1) = 1
    lattice(N - 1)(i) = 1
  }

  // From any internal points the number of ways to reach the destination is the sum of paths
  // from the point on right and on the bottom. Going here from bottom-right to top-left.
  for (i <- N - 2 to 0 by -1) {
    for (j <- i to 0 by -1) {
      lattice(i)(j) = lattice(i + 1)(j) + lattice(i)(j + 1)
      lattice(j)(i) = lattice(j + 1)(i) + lattice(j)(i + 1)
    }
  }

  println((lattice map {_.toList.mkString(" ")}).toList.mkString("\n"))
  println(lattice(0)(0))
}
