package com.tdd.uchit.repofetcher.dagger

import com.tdd.uchit.repofetcher.ui.activity.RepoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(repoActivity: RepoActivity)
}