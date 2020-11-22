package com.assessment.nytimes.presentation.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.nytimes.databinding.ArticleItemBinding
import com.assessment.nytimes.data.model.Article
import com.assessment.nytimes.presentation.articles.ArticlesAdapter.ArticleViewHolder

class ArticlesAdapter(private val articleList: List<Article>?, private val itemClickListener: ItemClickListener?) :
    RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding =
            ArticleItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        return ArticleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList!![position])
        holder.itemView.setOnClickListener {
            itemClickListener?.onClick(holder.binding.item!!)
        }
    }

    override fun getItemCount(): Int {
        return articleList?.size ?: 0
    }

    class ArticleViewHolder(val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article?) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    interface ItemClickListener {
        fun onClick(article: Article)
    }
}