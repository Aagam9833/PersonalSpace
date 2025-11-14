package com.aagamshah.personalspace

import android.app.Application
import com.aagamshah.data.di.dataModule
import com.aagamshah.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PersonalSpaceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PersonalSpaceApp)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }

    }

}