package com.tdd.uchit.repofetcher.data.remote

import com.tdd.uchit.repofetcher.data.model.Repo
import com.tdd.uchit.repofetcher.utils.Constant
import io.reactivex.Single
import retrofit2.http.GET

interface RepoService {

    @GET(Constant.REPO_URL)
    fun fetchRepos(): Single<List<Repo>>

}