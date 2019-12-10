package com.tdd.uchit.repofetcher.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tdd.uchit.repofetcher.data.model.Repo
import com.tdd.uchit.repofetcher.data.repository.RepoRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import java.net.UnknownHostException

@RunWith(BlockJUnit4ClassRunner::class)
class RepoViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var repoRepository: RepoRepository
    private lateinit var repoViewModel: RepoViewModel

    private val repos = listOf(
        Repo("Repo name 1", "Repo description 1"),
        Repo("Repo name 2", "Repo description 2"),
        Repo("Repo name 3", "Repo description 3")
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repoViewModel = RepoViewModel()
    }

    @Test
    fun fetchRepos_success() {
        //given
        every { repoRepository.fetchRepos() }.returns(Single.just(repos))

        //when
        repoViewModel.fetchRepos()

        //then
        Assert.assertEquals(repos, repoViewModel.repoObservable.value)
    }

    @Test
    fun fetchRepos_networkError() {
        //given
        every { repoRepository.fetchRepos() }.returns(Single.error(UnknownHostException("UNKNOWN HOST EXCEPTION")))

        //when
        repoViewModel.fetchRepos()

        //then
        Assert.assertEquals(null, repoViewModel.repoObservable.value)
    }
}