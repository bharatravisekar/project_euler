package com.project_euler

/**
 * Special Pythagorean triplet.
 *
 * https://projecteuler.net/problem=9
 *
 * @author Bharat Ravisekar
 */
object Problem9 extends App {
  private val SUM = 1000

  // a, b and c are natural numbers
  // a < b < c               // (1)
  // a^2 + b^2 = c^2         // (2)
  // a + b + c = 1000        // (3)
  // abc?

  // Brute force all possible values.
  private def pythagoreanTripletForC(c: Int): Option[(Int, Int, Int)] = {
    for (a <- 1 to c - 2; b <- a + 1 to c - 1) {
      if ((a * a + b * b == c * c) && (a + b + c == SUM)) {
        return Some(a, b, c)
      }
    }

    None
  }

  // Brute force all values of c.
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(pythagoreanTripletForC)

  if(pythagoreanTriplets.isEmpty) {
    println("No pythagorean triplet found")
  } else {
    pythagoreanTriplets foreach { triplet =>
      val (a, b, c) = triplet
      println(s"a: $a, b: $b, c: $c. abc = ${a * b * c}")
    }
  }
}
