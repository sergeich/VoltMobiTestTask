package me.sergeich.voltmobi.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.NO_ID
import me.sergeich.voltmobi.model.Post

class PostAdapter : ListAdapter<Post, PostViewHolder>(DIFF_CALLBACK) {

    init {
        setHasStableIds(true)
    }

    public override fun getItem(position: Int): Post? {
        return super.getItem(position)
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: NO_ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { post ->
            holder.bind(post)
        }
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
