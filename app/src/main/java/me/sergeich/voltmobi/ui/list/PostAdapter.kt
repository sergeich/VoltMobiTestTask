package me.sergeich.voltmobi.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.NO_ID
import me.sergeich.voltmobi.model.Post

class PostAdapter : ListAdapter<Post, PostViewHolder>(DIFF_CALLBACK) {

    var postClickListener: PostClickListener? = null

    init {
        setHasStableIds(true)
    }

    public override fun getItem(position: Int): Post? {
        return super.getItem(position)
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id?.toLong() ?: NO_ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.inflate(parent, postClickListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { post ->
            holder.bind(post)
        }
    }

    interface PostClickListener {
        fun onPostClick(postId: Int)
    }


    companion object {

        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(
                oldPost: Post,
                newPost: Post
            ): Boolean =
                oldPost.id == newPost.id

            override fun areContentsTheSame(
                oldPost: Post,
                newPost: Post
            ): Boolean =
                oldPost == newPost
        }
    }
}
