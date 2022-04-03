package com.example.brexmobilechallenge.ui.util

object TransactionUtils {

    @JvmStatic
    fun parseAmount(rawAmount: Int?): String {
        return rawAmount?.let {
            var raw = it
            StringBuilder().apply {
                while (raw > 0) {
                    val digit = raw % 10
                    append(digit)
                    raw /= 10
                    if (length == 2) append(".")
                }
                append("$")
            }.reverse().toString()
        } ?: "ERROR"
    }

    @JvmStatic
    fun parseTime(rawTime: String?): String {
        // 2019-03-26T21:44:54.000000Z
        // Mar 26, 9:44 PM

        return rawTime?.let {
            StringBuilder().apply {
                append(getMonthText(rawTime.substring(5, 7)))
                append(" ")
                append(rawTime.substring(8, 10))
                append(", ")
                append(getHourAndMinutes(rawTime.substring(11, 16)))
            }.toString()
        } ?: "ERROR"
    }

    private fun getMonthText(rawMonth: String): String {
        return when(rawMonth) {
            "01" -> "Jan"
            "02" -> "Feb"
            "03" -> "Mar"
            "04" -> "Apr"
            "05" -> "May"
            "06" -> "Jun"
            "07" -> "Jul"
            "08" -> "Aug"
            "09" -> "Sep"
            "10" -> "Oct"
            "11" -> "Nov"
            "12" -> "Dec"
            else -> "???"
        }
    }

    private fun getHourAndMinutes(raw: String): String {
        val hour = Integer.valueOf(raw.substring(0, 2))
        val meridiem = if (hour <= 12) " AM" else " PM"
        return StringBuilder().apply {
            append(hour % 12)
            append(":")
            append(raw.substring(3, 5))
            append(meridiem)
        }.toString()
    }

}