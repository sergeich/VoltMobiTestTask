package me.sergeich.voltmobi.util

import android.content.Context
import me.sergeich.voltmobi.data.VoltRepository
import me.sergeich.voltmobi.data.database.VoltDatabase
import me.sergeich.voltmobi.data.datasource.MockDataSource
import me.sergeich.voltmobi.data.datasource.NetworkDataSource
import me.sergeich.voltmobi.data.datasource.VoltDataSource
import me.sergeich.voltmobi.data.network.VoltService
import me.sergeich.voltmobi.viewmodels.DetailActivityViewModelFactory
import me.sergeich.voltmobi.viewmodels.MainActivityViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Simple "DI"
 * Used for simplicity. There is no point in using Dagger or any other DI framework here
 */
object Injector {

    private fun provideDatabase(context: Context): VoltDatabase =
        VoltDatabase.getInstance(context)

    private fun provideRetrofit(): VoltService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(VoltService::class.java)
    }

    private fun provideDataSource(): VoltDataSource =
        NetworkDataSource.getInstance(provideRetrofit())

    private fun provideRepository(context: Context): VoltRepository {
        val dataSource = provideDataSource()
        val db = provideDatabase(context)
        val dao = db.voltDao()
        return VoltRepository.getInstance(dataSource, dao)
    }

    fun provideMainActivityViewModelFactory(context: Context): MainActivityViewModelFactory {
        val repository = provideRepository(context)
        return MainActivityViewModelFactory(repository)
    }

    fun provideDetailActivityViewModelFactory(
        context: Context,
        postId: Int
    ): DetailActivityViewModelFactory {
        val repository = provideRepository(context)
        return DetailActivityViewModelFactory(repository, postId)
    }
}
