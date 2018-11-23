package com.devandroid.basemodule.sample.apis

import com.devandroid.basemodule.sample.model.*
import io.reactivex.Flowable
import retrofit2.http.GET

/*https://jsonplaceholder.typicode.com/posts/1/comments
    https://jsonplaceholder.typicode.com/albums/1/photos
    https://jsonplaceholder.typicode.com/users/1/albums
    https://jsonplaceholder.typicode.com/users/1/todos
    https://jsonplaceholder.typicode.com/users/1/posts*/
interface FakeWebService {

    @GET("/posts/1/comments")
    fun getComments(): Flowable<List<CommentInfo>>

    @GET("/albums/1/photos")
    fun getPhotos(): Flowable<List<PhotoInfo>>

    @GET("/users/1/albums")
    fun getAlbums(): Flowable<List<AlbumInfo>>

    @GET("/users/1/todos")
    fun getToDos(): Flowable<List<ToDoInfo>>

    @GET("/users/1/posts")
    fun getPosts(): Flowable<List<PostInfo>>


    companion object {
        //Base url for the web services
        val BASE_URL: String = "http://jsonplaceholder.typicode.com/"
    }
}