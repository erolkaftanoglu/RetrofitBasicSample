package com.milklab34.retrofitbasicsample;

/**
 * Created by erolkaftanoglu on 20/05/16.
 */

public interface MyApi {
    String url = "https://api.github.com/repos/";

    @GET("erolkaftanoglu/gitworkshop")
    Call<GetRepo> getRepo();
}
