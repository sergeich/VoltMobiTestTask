package me.sergeich.voltmobi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.sergeich.voltmobi.data.VoltRepository
import me.sergeich.voltmobi.model.Post


class DetailActivityViewModel(
    repository: VoltRepository,
    postId: Int
) : ViewModel() {

    val post: LiveData<Post> = repository.getPost(postId)

}
