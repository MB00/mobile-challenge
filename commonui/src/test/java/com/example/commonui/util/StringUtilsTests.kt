package com.example.commonui.util

import org.junit.Test

import org.junit.Assert.*

class StringUtilsTests {

    @Test
    fun `verify phone number formatting`() {
        assertEquals("(999) 999-9999", StringUtils.formatPhoneNumber("9999999999"))
        assertEquals("N/A", StringUtils.formatPhoneNumber("999999999"))
        assertEquals("N/A", "")
    }

}