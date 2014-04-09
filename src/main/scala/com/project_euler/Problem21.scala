package com.project_euler

/**
 * Amicable numbers.
 *
 * https://projecteuler.net/problem=21
 *
 * @author Bharat Ravisekar
 */
object Problem21 extends App {

  private def properDivisors(number: Int): Seq[Int] = (1 to number/2) filter { number % _ == 0 }

  val divisorSumMap = (1 until 10000).foldLeft(Map.empty[Int, Int]) { (map, i) =>
    map + (i -> properDivisors(i).sum)
  }

  val amicablePairs = divisorSumMap filter { kv => divisorSumMap exists {
    kv1 => (kv._1 == kv1._2 && kv._2 == kv1._1 && kv._1 != kv1._1) }
  }

  println(amicablePairs.keySet.sum)
}
