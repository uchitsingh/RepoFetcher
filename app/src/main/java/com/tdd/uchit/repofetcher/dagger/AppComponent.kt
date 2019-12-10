package com.tdd.uchit.repofetcher.dagger

import com.tdd.uchit.repofetcher.viewmodel.RepoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(repoViewModel: RepoViewModel)
}