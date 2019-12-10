package com.tdd.uchit.repofetcher.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tdd.uchit.repofetcher.R
import com.tdd.uchit.repofetcher.application.RepoApplication
import com.tdd.uchit.repofetcher.ui.adapter.RepoAdapter
import com.tdd.uchit.repofetcher.viewmodel.RepoViewModel
import com.tdd.uchit.repofetcher.viewmodel.RepoViewModelFactory
import kotlinx.android.synthetic.main.activity_repo.*

class RepoActivity : AppCompatActivity() {

    private lateinit var repoViewModel: RepoViewModel
    private lateinit var repoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)

        initRecyclerView()

        repoViewModel = ViewModelProvider(
            this, RepoViewModelFactory()
        ).get(RepoViewModel::class.java)

        (application as RepoApplication).appComponent.inject(repoViewModel)

        repoViewModel.fetchRepos()

        repoViewModel.repoObservable.observe(this, Observer {
            repoAdapter.setData(it)

        })
    }

    private fun initRecyclerView() {
        repo_rv.layoutManager = LinearLayoutManager(this)
        repoAdapter = RepoAdapter()
        repo_rv.adapter = repoAdapter
    }
}
