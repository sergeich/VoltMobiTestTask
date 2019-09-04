package me.sergeich.voltmobi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.sergeich.voltmobi.data.VoltRepository
import me.sergeich.voltmobi.model.Post


class DetailActivityViewModel(
    private val repository: VoltRepository,
    private val postId: Int
) : ViewModel() {

    var post: LiveData<Post>
        private set

    init {
        post = repository.getPost(postId)
    }
}
