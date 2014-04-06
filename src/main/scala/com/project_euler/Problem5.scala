package com.project_euler

/**
 * Smallest positive number that is evenly divisible by all of the numbers from 1 to 20.
 *
 * https://projecteuler.net/problem=5
 *
 * @author Bharat Ravisekar
 */
object Problem5 extends App {

  private def addAFactor(factors: Map[Long, Int], d: Long): Map[Long, Int] =
    factors + (d -> (factors.getOrElse(d, 0) + 1))

  private def primeFactors(number: Long, d: Long = 2, factors: Map[Long, Int] = Map.empty):
  Map[Long, Int] =
    if (number == 1)
      factors
    else
      if (number % d == 0)
        primeFactors(number/d, d, addAFactor(factors, d))
      else
        primeFactors(number, d + 1, factors)

  // A minimal set of factors that cover the numbers we are considering
  private val factorCover = scala.collection.mutable.Map.empty[Long, Int]

  // Updates factor cover by updating it to the max of what is there vs what new has come in.
  private def updateFactorCover(factors: Map[Long, Int]): Unit =
    factors foreach {
      case (k, v) => factorCover.put(k, Math.max(factorCover.getOrElse(k, 0), v))
    }

  (1L to 20L) foreach { x => updateFactorCover(primeFactors(x)) }

  // Evaluates the factor cover
  private val result = factorCover.foldLeft(1L) {
    case (product, (factor, power)) => product * Math.pow(factor, power).toLong
  }

  println(result)
}
