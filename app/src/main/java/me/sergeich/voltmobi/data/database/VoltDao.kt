package me.sergeich.voltmobi.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import me.sergeich.voltmobi.model.Post

@Dao
interface VoltDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg posts: Post)

    @Query("SELECT * FROM post ORDER BY post_id DESC")
    @Transaction
    fun getPostsList(): LiveData<List<Post>>

    @Query("SELECT COUNT(post_id) FROM post")
    fun postCount(): Int

    @Query("SELECT * FROM post WHERE post_id = :postId")
    fun getPost(postId: Int): LiveData<Post>
}
