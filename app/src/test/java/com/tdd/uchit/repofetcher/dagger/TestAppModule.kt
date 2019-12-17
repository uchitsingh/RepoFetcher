package com.tdd.uchit.repofetcher.dagger

import com.tdd.uchit.repofetcher.data.remote.RepoService
import com.tdd.uchit.repofetcher.data.repository.RepoRepository
import io.mockk.mockk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class TestAppModule : AppModule() {
    override fun provideRepoRepository(repoService: RepoService): RepoRepository = mockk()
    override fun provideRepoService(retrofit: Retrofit): RepoService = mockk()
    override fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = mockk()
    override fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = mockk()
    override fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = mockk()
}

