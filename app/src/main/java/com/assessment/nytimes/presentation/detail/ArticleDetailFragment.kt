package com.assessment.nytimes.presentation.detail

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View
import androidx.core.text.util.LinkifyCompat
import androidx.recyclerview.widget.PagerSnapHelper
import com.assessment.nytimes.BR
import com.assessment.nytimes.R
import com.assessment.nytimes.databinding.ArticleDetailFragmentBinding
import com.assessment.nytimes.presentation.base.BaseFragment

class ArticleDetailFragment : BaseFragment<ArticleDetailFragmentBinding, ArticleDetailViewModel>() {
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.article_detail_fragment
    override val viewModel: Class<ArticleDetailViewModel>
        get() = ArticleDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = ArticleDetailFragmentArgs.fromBundle(requireArguments()).article

        injectedViewModel.updateView(article)

        val subList = article.media.firstOrNull()?.mediaMetadata

        val adapter = MediaAdapter(subList?.subList(1, subList.size - 1))
        viewDataBinding.recyclerView.adapter = adapter
        viewDataBinding.recyclerView.visibility =
            if (adapter.itemCount == 0) View.GONE else View.VISIBLE
        PagerSnapHelper().attachToRecyclerView(viewDataBinding.recyclerView)

        viewDataBinding.link.movementMethod = LinkMovementMethod.getInstance()
    }
}