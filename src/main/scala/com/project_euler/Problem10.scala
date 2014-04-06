package com.project_euler

/**
 * Summation of primes.
 *
 * https://projecteuler.net/problem=10
 *
 * @author Bharat Ravisekar
 */
object Problem10 extends App {
  private val N = 2000000

  private def isPrime(n: Int, d: Int = 2): Boolean = {
    if (n == 1)
      false
    else if (d > n/2)
      true
    else if (n % d == 0)
      false
    else
      isPrime(n, d + 1)
  }

  private val result =
    (1 to N).foldLeft(0L){ (sum, number) => sum + (if(isPrime(number)) number else 0) }

  println(result)
}
