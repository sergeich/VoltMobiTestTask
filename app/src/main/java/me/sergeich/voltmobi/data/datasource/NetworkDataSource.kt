package me.sergeich.voltmobi.data.datasource

import androidx.annotation.WorkerThread
import me.sergeich.voltmobi.data.network.VoltService
import me.sergeich.voltmobi.model.Post
import me.sergeich.voltmobi.util.SingletonWithArg


class NetworkDataSource(private val voltService: VoltService): VoltDataSource {

    @WorkerThread
    override fun getData(): List<Post> {
        return voltService.listPosts().execute().body() ?: emptyList()
    }

    companion object : SingletonWithArg<NetworkDataSource, VoltService>(::NetworkDataSource)

}
