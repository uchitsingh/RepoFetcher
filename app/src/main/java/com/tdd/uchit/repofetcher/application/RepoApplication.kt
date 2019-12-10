package com.tdd.uchit.repofetcher.application

import android.app.Application
import com.tdd.uchit.repofetcher.BuildConfig
import com.tdd.uchit.repofetcher.dagger.AppComponent
import com.tdd.uchit.repofetcher.dagger.AppModule
import com.tdd.uchit.repofetcher.dagger.DaggerAppComponent
import timber.log.Timber

class RepoApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = initDagger()
    }

    private fun initDagger(): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
}
