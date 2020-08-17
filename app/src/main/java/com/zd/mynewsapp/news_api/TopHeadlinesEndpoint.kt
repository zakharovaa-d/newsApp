package com.zd.mynewsapp.news_api
import com.zd.mynewsapp.model.TopHeadlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesEndpoint {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Observable<TopHeadlines>

    @GET("top-headlines")
    fun getUserSearchInput(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String
    ): Observable<TopHeadlines>
}