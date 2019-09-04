package me.sergeich.voltmobi.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.sergeich.voltmobi.R
import me.sergeich.voltmobi.model.Post

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var postClickListener: PostAdapter.PostClickListener? = null
    private val title: TextView = view.findViewById(R.id.item_post_title)
    private val body: TextView = view.findViewById(R.id.item_post_body)

    fun bind(post: Post) {
        title.text = post.title
        body.text = post.body
        itemView.setOnClickListener {
            postClickListener?.onPostClick(post.id)
        }
    }

    companion object {
        fun inflate(
            parent: ViewGroup,
            postClickListener: PostAdapter.PostClickListener?
        ): PostViewHolder {

            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.item_post, parent, false)
            return PostViewHolder(view).apply {
                this.postClickListener = postClickListener
            }
        }
    }
}
