package me.sergeich.voltmobi.data.datasource

import android.content.Context
import androidx.annotation.WorkerThread
import com.google.gson.GsonBuilder
import me.sergeich.voltmobi.model.Post
import me.sergeich.voltmobi.util.SingletonWithArg
import java.io.BufferedReader
import java.io.InputStreamReader
import com.google.gson.reflect.TypeToken



class MockDataSource(private val context: Context): VoltDataSource {

    @WorkerThread
    override fun getData(): List<Post> {
        val reader = BufferedReader(InputStreamReader(context.assets.open("data.json")))
        return GsonBuilder().serializeNulls().create().fromJson(reader,
            object : TypeToken<List<Post>>() {}.type)
    }

    companion object : SingletonWithArg<MockDataSource, Context>(::MockDataSource)

}
