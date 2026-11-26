package com.contactnotes.accessibility

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

/**
 * Watches WhatsApp windows to find which chat is open.
 *
 * Privacy rule: only ever read the chat header (contact name / number). Never message content.
 * Scope is limited in res/xml/accessibility_service_config.xml to WhatsApp packages.
 *
 * Phase 1 (spike): parse the header and log the detected contact.
 */
class WhatsAppWatcherService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Phase 1: delegate to a HeaderParser and emit the current contact.
    }

    override fun onInterrupt() = Unit
}
