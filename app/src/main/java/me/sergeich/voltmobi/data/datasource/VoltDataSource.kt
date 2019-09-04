package me.sergeich.voltmobi.data.datasource

import androidx.annotation.WorkerThread
import me.sergeich.voltmobi.model.Post

interface VoltDataSource {
    @WorkerThread
    fun getData(): List<Post>
}
