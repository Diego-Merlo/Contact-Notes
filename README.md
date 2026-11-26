# Contact Notes

An Android app that lets you keep private notes about your WhatsApp contacts. When you open a chat,
a small floating bubble appears; tap it to see or edit your notes for that person.

Useful for anyone who talks to many clients or customers on WhatsApp and needs to remember context:
preferences, past orders, follow-ups, or anything else.

> **Status:** early development. Not ready for everyday use yet.

## Features

- Floating bubble over WhatsApp and WhatsApp Business, shown only while a chat is open
- Notes tied to each contact (by phone number when available)
- All data stays on your device, encrypted at rest
- No internet permission: notes never leave the phone
- Export / import notes as a backup *(planned)*

## How it works

WhatsApp has no plugin system, and this app does **not** modify WhatsApp. It uses two standard Android features:

1. **Accessibility service**: detects which chat is open by reading only the chat header (contact name or number).
   Message content is never read, stored, or logged. The service only receives events from WhatsApp.
2. **Overlay window**: draws the notes bubble on top of WhatsApp.

Notes are stored in a local SQLite database encrypted with SQLCipher. The encryption key is kept in the Android Keystore.

## Requirements

- Android 8.0 (API 26) or newer
- WhatsApp or WhatsApp Business installed

iOS is not supported: iOS does not allow apps to draw over other apps or read other apps' screens.

## Installation

Pre-built APKs will be published on the [Releases](../../releases) page.

After installing:

1. Open **Contact Notes** and follow the setup steps.
2. Enable the app under **Settings → Accessibility → Contact Notes**.
3. On Android 13+, if the toggle is greyed out ("restricted setting"), open
   **Settings → Apps → Contact Notes → ⋮ → Allow restricted settings**, then try again.
   Android does this for every app installed outside the Play Store.

## Building from source

Requirements: [Android Studio](https://developer.android.com/studio) (recent stable version). It includes the JDK
and the Android SDK manager. Kotlin and Gradle are downloaded automatically by the Gradle wrapper.

```bash
git clone https://github.com/Diego-Merlo/Contact-Notes.git
cd Contact-Notes
./gradlew assembleDebug      # build debug APK → app/build/outputs/apk/debug/
./gradlew test               # run unit tests
./gradlew installDebug       # install on a connected device
```

Or open the folder in Android Studio and press **Run**.

## Tech stack

Kotlin · Jetpack Compose · Room + SQLCipher · Android AccessibilityService · Gradle (Kotlin DSL, version catalog)

## Project structure

```
app/src/main/java/com/contactnotes/
├── accessibility/   Detects the open WhatsApp chat (header only)
├── overlay/         Floating bubble and notes panel
├── data/            Encrypted database, repository, backup
├── core/            Plain Kotlin logic (e.g. contact identification)
├── di/              Manual dependency container
└── ui/              App screens (Compose)
```

## Privacy

- Reads only the chat header of WhatsApp, never messages.
- No network access, no analytics, no ads.
- Data is excluded from Android cloud backups; use the in-app export to move notes between devices.

## Disclaimer

This is an independent project. It is not affiliated with, endorsed by, or sponsored by WhatsApp or Meta.
"WhatsApp" is a trademark of WhatsApp LLC.
