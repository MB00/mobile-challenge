package com.example.commonui.util

import java.lang.StringBuilder

object StringUtils {

    @JvmStatic
    fun formatPhoneNumber(rawNum: String): String {
        // assuming US-based phone numbers for the purposes of this project
        if (rawNum.length != 10) {
            return "N/A";
        }
        return StringBuilder().apply {
            for (i in rawNum.indices) {
                when(i) {
                    0 -> append("(")
                    3 -> append(") ")
                    6 -> append("-")
                }
                append(rawNum[i])
            }
        }.toString()
    }

}