package com.project_euler

/**
 * Power digit sum.
 *
 * https://projecteuler.net/problem=17
 *
 * @author Bharat Ravisekar
 */
object Problem17 extends App {
  private val N = 1000

  private val numberMap = Map(
    0 -> "",
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen",
    20 -> "twenty",
    30 -> "thirty",
    40 -> "forty",
    50 -> "fifty",
    60 -> "sixty",
    70 -> "seventy",
    80 -> "eighty",
    90 -> "ninety"
  )
  private val AND = "and"
  private val HUNDRED = "hundred"
  private val THOUSAND = "thousand"
  private val MILLION = "million"
  private val BILLION = "billion"

  private def extractDigits(number: Long): Seq[Int] = {
    var n = number
    var digits = Seq.empty[Int]
    while(n != 0) {
      digits = digits :+ (n % 10).toInt
      n = n / 10
    }
    digits.reverse
  }

  private def oneDigitInWords(digit: Int): String = numberMap(digit)

  private def twoDigitsInWords(digits: Seq[Int]): String = {
    require(digits.size == 2, "Invalid input")

    if (digits.head == 0) {
      oneDigitInWords(digits.last)
    } else if (digits.head == 1) {
      numberMap(digits.head * 10 + digits.last)
    } else {
      s"${numberMap(digits.head * 10)} ${oneDigitInWords(digits.last)}"
    }
  }

  private def threeDigitsInWords(digits: Seq[Int]): String = {
    require(digits.size == 3, "Invalid input")
    if (digits(0) == 0)
      twoDigitsInWords(digits.tail)
    else if (digits(1) == 0 && digits(2) == 0)
      s"${oneDigitInWords(digits.head)} $HUNDRED"
    else
      s"${oneDigitInWords(digits.head)} $HUNDRED $AND ${twoDigitsInWords(digits.tail)}"
  }

  private def numberInWords(n: Int): String = {
    val stringBuilder = new StringBuilder
    if (n == 0)
      stringBuilder.append("zero")
    else {
      var number: Long = n
      if (number < 0) {
        stringBuilder.append("minus ")
        number = -number
      }

      val digits = extractDigits(number)
      val numDigits = digits.size

      if (numDigits == 10)
        stringBuilder.append(s"${oneDigitInWords(digits(0))} $BILLION ")

      if (digits.size >= 9) {
        stringBuilder.append(s"${threeDigitsInWords(digits.slice(numDigits - 9, numDigits - 6))} $MILLION ")
      } else if (digits.size >= 8) {
        stringBuilder.append(s"${twoDigitsInWords(digits.slice(numDigits - 8, numDigits - 6))} $MILLION ")
      } else if (digits.size >= 7) {
        stringBuilder.append(s"${oneDigitInWords(digits(numDigits - 7))} $MILLION ")
      }

      if (digits.size >= 6) {
        stringBuilder.append(s"${threeDigitsInWords(digits.slice(numDigits - 6, numDigits - 3))} $THOUSAND ")
      } else if (digits.size >= 5) {
        stringBuilder.append(s"${twoDigitsInWords(digits.slice(numDigits - 5, numDigits - 3))} $THOUSAND ")
      } else if (digits.size >= 4) {
        stringBuilder.append(s"${oneDigitInWords(digits(numDigits - 4))} $THOUSAND ")
      }

      if (digits.size >= 3) {
        stringBuilder.append(s"${threeDigitsInWords(digits.slice(numDigits - 3, numDigits))}")
      } else if (digits.size >= 2) {
        stringBuilder.append(s"${twoDigitsInWords(digits.slice(numDigits - 2, numDigits))}")
      } else if (digits.size >= 1) {
        stringBuilder.append(s"${oneDigitInWords(digits(numDigits - 1))}")
      }
    }

    stringBuilder.toString()
  }

  var sum = 0
  for (i <- 1 to N)
    sum += numberInWords(i).filter(_ != ' ').size

  println(sum)
}
