package me.sergeich.voltmobi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.sergeich.voltmobi.data.VoltRepository

class DetailActivityViewModelFactory(
    private val repository: VoltRepository,
    private val postId: Int
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailActivityViewModel(repository, postId) as T
    }
}
