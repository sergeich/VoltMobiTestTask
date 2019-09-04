package me.sergeich.voltmobi.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.sergeich.voltmobi.model.Post
import me.sergeich.voltmobi.util.SingletonWithArg

@Database(
    entities = [Post::class],
    exportSchema = false,
    version = 1
)
abstract class VoltDatabase : RoomDatabase() {

    abstract fun voltDao(): VoltDao

    companion object : SingletonWithArg<VoltDatabase, Context>(
        creator = { context ->
            Room.databaseBuilder(
                context.applicationContext,
                VoltDatabase::class.java,
                "volt.db"
            )
                .build()
        })
}
