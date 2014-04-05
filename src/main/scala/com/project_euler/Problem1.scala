package com.project_euler

/**
 * Sum of multiples of 3 or 5 under 1000.
 *
 * https://projecteuler.net/problem=1
 *
 * @author Bharat Ravisekar
 */
object Problem1 extends App {
  private val result = (1 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).sum
  println(result)
}
