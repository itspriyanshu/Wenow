package com.example.wenow;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected EditText city;
    protected Button find;
    protected ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.cityname);
        find = findViewById(R.id.button);

        pb = findViewById(R.id.progressBar);

        find.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button){
            find.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);
            final String s = city.getText().toString();

            Call<Weather> weatherCall = weapi.getresult().getweather("https://api.openweathermap.org/data/2.5/weather?q="+s+"&appid=XXXXXXXXXXXXXXXXXX78e39ecca1458e");
            weatherCall.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {

                    Weather weather = response.body();
                    int code = response.code();
                    if(code==404){
                        Toast.makeText(MainActivity.this,"City Not Found",Toast.LENGTH_LONG).show();
                        find.setVisibility(View.VISIBLE);
                        pb.setVisibility(View.GONE);
                    }else{
                        Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,display.class);
                        intent.putExtra("we",weather);
                        intent.putExtra("cityname",s);
                        startActivity(intent);
                    }


                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {

                    Toast.makeText(MainActivity.this,"Unsuccessful",Toast.LENGTH_LONG).show();
                    find.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        find.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
    }
}
