package com.project_euler

/**
 * Sum of the digits of a factorial.
 *
 * https://projecteuler.net/problem=20
 *
 * @author Bharat Ravisekar
 */
object Problem20 extends App {

  // A sequence of numbers to double
  private def seqToNum(number: Seq[Int]): Double = number.foldLeft(0.0){(sum, d) => sum * 10 + d}

  // Adds two numbers represented as sequence of integers
  private def add(number1: Seq[Int], number2: Seq[Int]): Seq[Int] = {
    val n1 = number1.reverse
    val n2 = number2.reverse
    val resultSize = Math.max(n1.size, n2.size)
    var result = Seq.empty[Int]
    var carry = 0

    for (i <- 0 until resultSize) {
      val digitSum = (if (i < n1.size) n1(i) else 0) + (if (i < n2.size) n2(i) else 0) + carry
      result = result :+ (digitSum % 10)
      carry = digitSum / 10
    }

    if (carry > 0)
      result = result :+ carry

    result.reverse
  }

  // Multiplies two numbers represented as sequence of integers
  private def multiply(number1: Seq[Int], number2: Seq[Int]): Seq[Int] = {
    var i = seqToNum(number2)
    var result = Seq(0)
    while (i > 0) {
      result = add(result, number1)
      i -= 1
    }
    result
  }

  // Extracts digits (does not parse negative or stuff after decimal point)
  private def extractDigits(number: Double): Seq[Int] = {
    var n = number
    var digits = Seq.empty[Int]
    while(n >= 1) {
      digits = digits :+ Math.floor(n % 10).toInt
      n = n / 10
    }
    digits.reverse
  }

  // Calculates factorial
  private def factorial(n: Double): Seq[Int] = {
    var i = 1
    var result = Seq(1)

    while(i <= n) {
      result = multiply(result, extractDigits(i))
      i += 1
    }

    result
  }

  println(factorial(100).sum)
}
