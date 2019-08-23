package com.example.wenow;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public class weapi {


    private static final String baseurl = "https://api.openweathermap.org/data/2.5/";

    public static api ap = null;

    public static api getresult(){
        if(ap==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            ap = retrofit.create(api.class);
        }
        return ap;
    }


    public interface api{
        @GET//("weather?q={city}&appid="+key)
        Call<Weather> getweather(@Url String city2);
    }
}
