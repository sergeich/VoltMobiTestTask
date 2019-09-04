package me.sergeich.voltmobi.ui.detail

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_detail.*
import me.sergeich.voltmobi.R
import me.sergeich.voltmobi.util.Injector
import me.sergeich.voltmobi.viewmodels.DetailActivityViewModel

class DetailActivity : FragmentActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val postId = intent.getIntExtra(ARG_POST_ID, -1)

        val factory = Injector.provideDetailActivityViewModelFactory(this, postId)
        viewModel = ViewModelProviders.of(this, factory).get(DetailActivityViewModel::class.java)
        viewModel.post.observe(this, Observer { post ->
            detail_post_title.text = post.title
            detail_post_body.text = post.body
        })
    }

    companion object {
        const val ARG_POST_ID = "me.sergeich.voltmobi.ui.detail.DetailActivity.postId"
    }
}
