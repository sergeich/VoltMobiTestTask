package me.sergeich.voltmobi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.sergeich.voltmobi.data.VoltRepository
import me.sergeich.voltmobi.model.Post


class MainActivityViewModel(repository: VoltRepository) : ViewModel() {

    val posts: LiveData<List<Post>> = repository.getPostsList()

}
