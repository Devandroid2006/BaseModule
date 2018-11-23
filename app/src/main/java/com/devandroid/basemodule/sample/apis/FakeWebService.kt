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
    fun getComments(): Flowable<List<Comments>>

    @GET("/albums/1/photos")
    fun getPhotos(): Flowable<List<Photos>>

    @GET("/users/1/albums")
    fun getAlbums(): Flowable<List<Albums>>

    @GET("/users/1/todos")
    fun getToDos(): Flowable<List<ToDos>>

    @GET("/users/1/posts")
    fun getPosts(): Flowable<List<Posts>>


    companion object {
        //Base url for the web services
        val BASE_URL: String = "http://jsonplaceholder.typicode.com/"
    }
}