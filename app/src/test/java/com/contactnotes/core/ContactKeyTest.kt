package com.contactnotes.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ContactKeyTest {

    @Test
    fun `formatted phone number becomes digits with plus`() {
        assertEquals("+5215512345678", ContactKey.fromHeader("+52 1 55 1234 5678")?.value)
    }

    @Test
    fun `same number in different formats gives same key`() {
        assertEquals(
            ContactKey.fromHeader("+52 (55) 1234-5678"),
            ContactKey.fromHeader("+525512345678"),
        )
    }

    @Test
    fun `display name is normalized`() {
        assertEquals("name:juan pérez", ContactKey.fromHeader("  Juan Pérez ")?.value)
    }

    @Test
    fun `blank header gives null`() {
        assertNull(ContactKey.fromHeader("   "))
    }
}
