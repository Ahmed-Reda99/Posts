package com.example.android.facebookv2.data;

import com.example.android.facebookv2.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    // SINGLETON Design Pattern
    public static PostsClient getINSTANCE() {
        if(INSTANCE == null)
        {
            INSTANCE = new PostsClient();
        }

        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts()
    {
        return postInterface.getPosts();
    }
}
