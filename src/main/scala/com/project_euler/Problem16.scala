package com.project_euler

/**
 * Power digit sum.
 *
 * https://projecteuler.net/problem=16
 *
 * @author Bharat Ravisekar
 */
object Problem16 extends App {
  private val N = 1000

  private def listAdder(number1: Seq[Int], number2: Seq[Int]): Seq[Int] = {
    val n1 = number1.reverse
    val n2 = number2.reverse
    val resultSize = Math.max(n1.size, n2.size)
    var result = Seq.empty[Int]
    var carry = 0

    for (i <- 0 until resultSize) {
      val tempSum = (if (i < n1.size) n1(i) else 0) + (if (i < n2.size) n2(i) else 0) + carry
      result = result :+ (tempSum % 10)
      carry = tempSum / 10
    }

    if (carry > 0)
      result = result :+ carry

    result.reverse
  }

  private def powerOfTwo(n: Int, value: Seq[Int] = Seq(1)): Seq[Int] = {
    if (n == 0)
      value
    else
      powerOfTwo(n - 1, listAdder(value, value))
  }

  println(powerOfTwo(N))
  println(powerOfTwo(N).sum)
}
