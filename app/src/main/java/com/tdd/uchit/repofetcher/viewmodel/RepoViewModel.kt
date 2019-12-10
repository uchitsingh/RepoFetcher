package com.tdd.uchit.repofetcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tdd.uchit.repofetcher.data.model.Repo
import com.tdd.uchit.repofetcher.data.repository.RepoRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class RepoViewModel : ViewModel() {

    @Inject
    lateinit var repoRepository: RepoRepository

    private val disposable: CompositeDisposable = CompositeDisposable()
    private var _repoObservable: MutableLiveData<List<Repo>> = MutableLiveData()
    val repoObservable: LiveData<List<Repo>>
        get() = _repoObservable

    fun fetchRepos() {
        Timber.d("Fetch Repos initiated")
        disposable.add(repoRepository.fetchRepos().subscribe({
            Timber.d("Fetch Repos success")
            _repoObservable.value = it
        }, {
            Timber.e("Fetch Repos error with ${it.message}")
        }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}