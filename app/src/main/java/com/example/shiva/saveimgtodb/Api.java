package com.example.shiva.saveimgtodb;

import com.example.shiva.saveimgtodb.Models.Media.Media;
import com.example.shiva.saveimgtodb.Models.PostList.PostList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("posts?per_page=5")
    Call<List<PostList>> getPostList();

    @GET("media")
    Call<List<Media>> resposForImg(@Query("parent") int id);


}
