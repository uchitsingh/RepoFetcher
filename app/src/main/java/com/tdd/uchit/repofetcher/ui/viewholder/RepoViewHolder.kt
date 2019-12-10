package com.tdd.uchit.repofetcher.ui.viewholder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tdd.uchit.repofetcher.data.model.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("DefaultLocale")
    fun bindItem(repo: Repo) {
        repo.apply {
            itemView.repo_name?.text = this.name.capitalize()
            itemView.repo_description?.text = this.description
        }
    }
}
