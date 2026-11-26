package com.contactnotes.core

/**
 * Stable identifier for a contact's notes.
 *
 * Prefer a phone number (digits only, with leading "+"), because display names can change
 * or repeat. Fall back to the trimmed display name when no number is visible.
 */
@JvmInline
value class ContactKey(val value: String) {

    companion object {
        private val NON_DIGITS = Regex("[^0-9]")
        private const val MIN_PHONE_DIGITS = 7

        /** Builds a key from whatever WhatsApp shows in the chat header. */
        fun fromHeader(header: String): ContactKey? {
            val trimmed = header.trim()
            if (trimmed.isEmpty()) return null

            val looksLikePhone = trimmed.all { it.isDigit() || it in "+-() ." }
            if (looksLikePhone) {
                val digits = trimmed.replace(NON_DIGITS, "")
                if (digits.length >= MIN_PHONE_DIGITS) return ContactKey("+$digits")
            }
            return ContactKey("name:" + trimmed.lowercase())
        }
    }
}
