package com.tdd.uchit.repofetcher.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tdd.uchit.repofetcher.R
import com.tdd.uchit.repofetcher.data.model.Repo
import com.tdd.uchit.repofetcher.ui.viewholder.RepoViewHolder

class RepoAdapter : RecyclerView.Adapter<RepoViewHolder>() {
    private val repos = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_repo,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bindItem(repos[position])
    }

    fun setData(repoList: List<Repo>) {
        repos.clear()
        repos.addAll(repoList)
        notifyDataSetChanged()
    }
}
