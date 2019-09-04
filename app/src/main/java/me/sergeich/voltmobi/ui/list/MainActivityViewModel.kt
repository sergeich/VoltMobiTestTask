package me.sergeich.voltmobi.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.sergeich.voltmobi.data.VoltRepository
import me.sergeich.voltmobi.model.Post


class MainActivityViewModel(private val repository: VoltRepository) : ViewModel() {

    var posts: LiveData<List<Post>>
        private set

    init {
        posts = repository.getPostsList()
    }
}
