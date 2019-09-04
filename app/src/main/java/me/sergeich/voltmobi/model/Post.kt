package me.sergeich.voltmobi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "post",
    indices = [
        Index(value = ["post_id"], unique = true)
    ]
)
data class Post(
    @ColumnInfo(name = "user_id")
    val userId: Int,

    @PrimaryKey @ColumnInfo(name = "post_id")
    val id: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "body")
    val body: String
)
