package com.contactnotes

import android.app.Application
import com.contactnotes.di.AppContainer

class ContactNotesApp : Application() {

    /** Manual dependency container. Created once per process. */
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
