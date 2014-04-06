package com.project_euler

/**
 * Sum square difference for first 100 natural numbers.
 *
 * https://projecteuler.net/problem=6
 *
 * @author Bharat Ravisekar
 */
object Problem6 extends App {
  private val N = 100
  private val result = Math.pow((1 to N).sum, 2) - (1 to N).map(Math.pow(_, 2)).sum
  println(result.toLong)
}
