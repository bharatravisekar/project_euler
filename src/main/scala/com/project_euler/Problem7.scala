package com.project_euler

/**
 * 10001st prime number.
 *
 * @author Bharat Ravisekar
 */
object Problem7 extends App {
  private val N = 10001

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

  private var candidateNumber = 0
  private var primeNumberCount = 0
  while(primeNumberCount < N) {
    candidateNumber += 1

    if (isPrime(candidateNumber))
      primeNumberCount += 1
  }

  println(candidateNumber)
}
