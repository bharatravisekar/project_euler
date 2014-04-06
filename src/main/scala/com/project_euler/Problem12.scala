package com.project_euler

/**
 * Highly divisible triangular number.
 * Brute force solution.
 *
 * https://projecteuler.net/problem=12
 *
 * @author Bharat Ravisekar
 */
object Problem12 extends App {
  private def divisors(number: Long): Seq[Long] =
    ((2L to number/2) flatMap { d: Long =>
      if (number % d == 0)
        Some(d)
      else
        None
    }) ++ Seq(1, number)

  var n = 0L
  var triNum = 0L
  var divisorCount = 0
  while(divisorCount <= 500) {
    n += 1
    triNum += n
    divisorCount = divisors(triNum).size
  }

  println(triNum)
}
