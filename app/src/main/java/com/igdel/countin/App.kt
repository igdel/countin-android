package com.igdel.countin

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.igdel.countin.di.appModule
import com.igdel.countin.di.mapperModule
import com.igdel.countin.di.networkModule
import com.igdel.countin.di.repositoryModule
import com.igdel.countin.di.useCaseModule
import com.igdel.countin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    companion object {
        const val ONBOARDING_COMPLETED_KEY = "onboarding_completed"
        lateinit var prefs: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule, networkModule, repositoryModule, useCaseModule, mapperModule))
        }
    }
}