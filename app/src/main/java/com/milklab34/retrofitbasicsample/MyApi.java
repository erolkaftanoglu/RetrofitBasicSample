package com.milklab34.retrofitbasicsample;

import com.milklab34.retrofitbasicsample.model.GetRepo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by erolkaftanoglu on 20/05/16.
 */

public interface MyApi {
    String url = "https://api.github.com/repos/";

    @GET("erolkaftanoglu/RetrofitBasicSample")
    Call<GetRepo> getRepo();
}
