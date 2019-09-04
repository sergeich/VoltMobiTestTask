package me.sergeich.voltmobi.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.sergeich.voltmobi.data.VoltRepository

class MainActivityViewModelFactory(private val repository: VoltRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}
