package com.project_euler

/**
 * Largest prime factor of 600851475143
 *
 * https://projecteuler.net/problem=3
 *
 * @author Bharat Ravisekar
 */
object Problem3 extends App {
  private def addAFactor(factors: Map[Long, Int], d: Long): Map[Long, Int] =
    factors + (d -> (factors.getOrElse(d, 0) + 1))

  private def primeFactors(number: Long, d: Long = 2, factors: Map[Long, Int] = Map.empty):
  Map[Long, Int] =
    if (number == 1)
      factors
    else
    if (number % d == 0)
      primeFactors(number/d, d, addAFactor(factors, d))
    else
      primeFactors(number, d + 1, factors)

  private val result = primeFactors(600851475143L).keys.toList.sorted.last
  println(result)
}
