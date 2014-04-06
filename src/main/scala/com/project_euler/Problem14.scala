package com.project_euler

/**
 * Longest Collatz sequence.
 *
 * https://projecteuler.net/problem=14
 *
 * @author Bharat Ravisekar
 */
object Problem14 extends App {
  private val MAX = 1000000

  private def collatzSequence(n: Long, seq: Seq[Long] = Seq.empty): Seq[Long] = {
    if (n == 1)
      seq :+ n
    else {
      val nextN = if (n % 2 == 0) n/2 else 3 * n + 1
      collatzSequence(nextN, seq :+ n)
    }
  }

  var longestChainSize = -1
  var longestChainN = -1
  (1 until MAX) foreach { n =>
    val sequence = collatzSequence(n)
    if (sequence.size > longestChainSize) {
      longestChainSize = sequence.size
      longestChainN = n
    }
  }

  println(longestChainN)
}
