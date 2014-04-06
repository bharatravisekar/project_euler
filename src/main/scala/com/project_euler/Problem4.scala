package com.project_euler

import scala.annotation.tailrec

/**
 * Largest palindrome number formed by product for two 3-digit numbers.
 *
 * https://projecteuler.net/problem=4
 *
 * @author Bharat Ravisekar
 */
object Problem4 extends App {
  @tailrec private def isPalindrome(string: String): Boolean = {
    if (string.length <= 1)
      true
    else if (string.head != string.last)
      false
    else
      isPalindrome(string.tail.init)
  }

  private def isPalindrome(number: Long): Boolean = isPalindrome(number.toString)

  val products = for { i <- 999L to 100L by -1
                       j <- i to 100L by -1 } yield i * j

  val largestPalindrome = products.sortWith(_ > _).find(isPalindrome)
  println(largestPalindrome.get)
}
