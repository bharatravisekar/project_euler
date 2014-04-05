package com.project_euler

import scala.annotation.tailrec

/**
 * Largest prime factor of 600851475143
 *
 * https://projecteuler.net/problem=3
 *
 * @author Bharat Ravisekar
 */
object Problem3 extends App {
  @tailrec private def deepDivide(n: Long, d: Long): Long =
    if(n % d != 0)
      n
    else
      deepDivide(n/d, d)

  private def largestPrimeFactor(number: Long, d: Long = 2, factors: Seq[Long] = Seq(1L)): Long =
    if (number == 1)
      factors.last
    else
      largestPrimeFactor(deepDivide(number, d), d + 1,
        if(number % d == 0) factors :+ d else factors)

  println(largestPrimeFactor(600851475143L))
}
