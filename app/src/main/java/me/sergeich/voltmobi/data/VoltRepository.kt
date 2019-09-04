package me.sergeich.voltmobi.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.sergeich.voltmobi.data.database.VoltDao
import me.sergeich.voltmobi.data.datasource.VoltDataSource
import me.sergeich.voltmobi.model.Post

class VoltRepository(
    private val dataSource: VoltDataSource,
    private val voltDao: VoltDao
) {

    private var isInitialized = false

    private fun initData() {
        if (!isInitialized) {
            isInitialized = true

            GlobalScope.launch {
                if (isUpdateNeeded()) {
                    update()
                }
            }
        }
    }

    @WorkerThread
    private fun isUpdateNeeded(): Boolean {
        return voltDao.postCount() == 0
    }

    @WorkerThread
    private fun update() {
        val data = dataSource.getData()
        voltDao.insert(*data.toTypedArray())
    }

    fun getPostsList(): LiveData<List<Post>> {
        initData()
        return voltDao.getPostsList()
    }

    companion object {
        private val LOCK = Any()

        @Volatile
        private var INSTANCE: VoltRepository? = null

        fun getInstance(dataSource: VoltDataSource, dao: VoltDao): VoltRepository {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = VoltRepository(dataSource, dao)
                    }
                }
            }
            return INSTANCE!!
        }
    }
}
