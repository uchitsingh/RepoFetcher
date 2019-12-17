package com.tdd.uchit.repofetcher.dagger

import com.tdd.uchit.repofetcher.viewmodel.RepoViewModelTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface TestAppComponent : AppComponent {
    fun inject(repoViewModelTest: RepoViewModelTest)
}