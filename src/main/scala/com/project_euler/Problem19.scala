package com.project_euler

/**
 * Counting sundays.
 *
 * https://projecteuler.net/problem=19
 *
 * @author Bharat Ravisekar
 */
object Problem19 extends App {
  private val monthsWith30Days = Set(4, 6, 9, 11)

  private val dayName = Map(
    0 -> "Monday", 1 -> "Tuesday", 2 -> "Wednesday", 3 -> "Thursday",
    4 -> "Friday", 5 -> "Saturday", 6 -> "Sunday"
  )

  private def isLeap(year: Int): Boolean =
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

  private def daysInMonth(year: Int, month: Int): Int = {
    if (month == 2) {
      if (isLeap(year)) 29 else 28
    } else if (monthsWith30Days.contains(month)) {
      30
    } else {
      31
    }
  }

  private def daysInYear(year: Int): Int = if (isLeap(year)) 366 else 365

  // Jan 1 1900 was a Monday
  private def day(year: Int, month: Int, day: Int): Int = {
    require(year >= 1900, "Only 20th century onwards allowed.")
    require((month >= 1 && month <= 12), "Only values between 1 and 12 are allowed")
    require((day >= 1 && day <= 31), "Only values between 1 and 31 are allowed")

    val daysBetween1Jan1900And31DecPreviousYear = ((1900 until year) map daysInYear).sum

    val daysBetween1JanThisYearAndEndOfPreviousMonth =
      ((1 until month) map { daysInMonth(year, _) }).sum

    // Doing -1 here to subtract Jan 1 1900.
    (daysBetween1Jan1900And31DecPreviousYear +
      daysBetween1JanThisYearAndEndOfPreviousMonth +
      day - 1) % 7
  }

  val sundayCount =
    (for (year <- 1901 to 2000; month <- 1 to 12) yield day(year, month, 1)).count(_ == 6)

  println(sundayCount)
}
