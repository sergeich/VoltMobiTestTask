package me.sergeich.voltmobi.data.network

import me.sergeich.voltmobi.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface VoltService {
    @GET("posts")
    fun listPosts(): Call<List<Post>>
}
