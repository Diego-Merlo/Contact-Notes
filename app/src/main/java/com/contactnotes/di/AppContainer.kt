package com.contactnotes.di

import android.content.Context

/**
 * Manual DI: builds and holds app-wide singletons (database, repositories).
 * Access via `(context.applicationContext as ContactNotesApp).container`.
 *
 * Phase 2 adds: AppDatabase (Room + SQLCipher) and NoteRepository.
 */
class AppContainer(context: Context) {
    val appContext: Context = context.applicationContext
}
