package me.sergeich.voltmobi.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import me.sergeich.voltmobi.R
import me.sergeich.voltmobi.ui.detail.DetailActivity
import me.sergeich.voltmobi.util.Injector
import me.sergeich.voltmobi.viewmodels.MainActivityViewModel


class MainActivity : FragmentActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PostAdapter()
        adapter.postClickListener = object : PostAdapter.PostClickListener {
            override fun onPostClick(postId: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.ARG_POST_ID, postId)
                startActivity(intent)
            }
        }

        recyclerView = findViewById(R.id.main_recycler)
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = DefaultItemAnimator()

        val factory = Injector.provideMainActivityViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        viewModel.posts.observe(this, Observer { pagedList ->
            adapter.submitList(pagedList)
        })

    }
}
