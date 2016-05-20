package com.milklab34.retrofitbasicsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.milklab34.retrofitbasicsample.model.GetRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView repoName;

    Retrofit retrofit;
    MyApi myApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repoName = (TextView) findViewById(R.id.textview);

        retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi  = retrofit.create(MyApi.class);

        myApi.getRepo().enqueue(new Callback<GetRepo>() {
            @Override
            public void onResponse(Call<GetRepo> call, Response<GetRepo> response) {
                Toast.makeText(getApplicationContext(),"Response is succes",Toast.LENGTH_SHORT).show();
                if (response.isSuccess()){
                    repoName.setText(response.body().getFullName());
                }
            }

            @Override
            public void onFailure(Call<GetRepo> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Response is failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
