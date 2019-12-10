package com.tdd.uchit.repofetcher.data.repository

import com.tdd.uchit.repofetcher.data.model.Repo
import io.reactivex.Single

interface RepoRepository {
    fun fetchRepos(): Single<List<Repo>>
}