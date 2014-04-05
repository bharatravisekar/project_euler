package com.project_euler

import scala.annotation.tailrec

/**
 * Sum even Fibonacci numbers.
 *
 * https://projecteuler.net/problem=2
 *
 * @author Bharat Ravisekar
 */
object Problem2 extends App {
  @tailrec private def sumEvenFibonacciNumbers(elem1: Int = 1, elem2: Int = 1, sum: Int = 0): Int =
  {
    val nextElement = elem1 + elem2
    if (nextElement >= 4000000) {
      sum
    } else {
      sumEvenFibonacciNumbers(elem2, nextElement,
        if (nextElement % 2 == 0)  sum + nextElement else sum)
    }
  }

  println(sumEvenFibonacciNumbers())
}
