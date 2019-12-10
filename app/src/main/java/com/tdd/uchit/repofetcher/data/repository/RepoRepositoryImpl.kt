package com.tdd.uchit.repofetcher.data.repository

import com.tdd.uchit.repofetcher.data.model.Repo
import com.tdd.uchit.repofetcher.data.remote.RepoService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoRepositoryImpl(private val repoService: RepoService) : RepoRepository {
    override fun fetchRepos(): Single<List<Repo>> {
        return repoService.fetchRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}