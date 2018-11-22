package com.devandroid.basemodule.sample.apis

import io.reactivex.Flowable
import retrofit2.http.GET

/*https://jsonplaceholder.typicode.com/posts/1/comments
    https://jsonplaceholder.typicode.com/albums/1/photos
    https://jsonplaceholder.typicode.com/users/1/albums
    https://jsonplaceholder.typicode.com/users/1/todos
    https://jsonplaceholder.typicode.com/users/1/posts*/
interface FakeWebService {

    @GET("/posts/1/comments")
    fun <T : Any?> getComments(): Flowable<T>

    @GET("/albums/1/photos")
    fun <T : Any?> getPhotos(): Flowable<T>

    @GET("/users/1/albums")
    fun <T : Any?> getAlbums(): Flowable<T>

    @GET("/users/1/todos")
    fun <T : Any?> getToDos(): Flowable<T>

    @GET("/users/1/posts")
    fun <T : Any?> getPosts(): Flowable<T>


    companion object {
        //Base url for the web services
        val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    }
}