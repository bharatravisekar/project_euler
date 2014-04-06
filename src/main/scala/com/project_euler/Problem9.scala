package com.project_euler

/**
 * Special Pythagorean triplet.
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(pythagoreanTripletForC)
=======
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(x => pythagoreanTripletForC(x))
>>>>>>> e5e9d9dd43c0ee4a93fa29c5a02e237a00ae07fc
=======
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(x => pythagoreanTripletForC(x))
>>>>>>> e5e9d9dd43c0ee4a93fa29c5a02e237a00ae07fc
=======
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(x => pythagoreanTripletForC(x))
>>>>>>> e5e9d9dd43c0ee4a93fa29c5a02e237a00ae07fc
=======
  private val pythagoreanTriplets = (3 to SUM - 3).flatMap(x => pythagoreanTripletForC(x))
>>>>>>> e5e9d9dd43c0ee4a93fa29c5a02e237a00ae07fc

  if(pythagoreanTriplets.isEmpty) {
    println("No pythagorean triplet found")
  } else {
    pythagoreanTriplets foreach { triplet =>
      val (a, b, c) = triplet
      println(s"a: $a, b: $b, c: $c. abc = ${a * b * c}")
    }
  }
}
