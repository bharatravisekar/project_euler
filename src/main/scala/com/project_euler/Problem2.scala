package com.project_euler

/**
 * Sum even Fibonacci numbers.
 *
 * https://projecteuler.net/problem=2
 *
 * @author Bharat Ravisekar
 */
object Problem2 extends App {
  def sumEvenFibonacciNumbers(elem1: Int = 1, elem2: Int = 1, sum: Int = 0): Int = {
    val nextElement = elem1 + elem2
    if (nextElement < 4000000) {
      sumEvenFibonacciNumbers(elem2, nextElement, sum +
        (if (nextElement % 2 == 0) nextElement else 0))
    } else {
      sum
    }
  }

  println(sumEvenFibonacciNumbers())
}
