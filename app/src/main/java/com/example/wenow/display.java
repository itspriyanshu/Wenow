package com.example.wenow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Math.round;

public class display extends AppCompatActivity {

    protected RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        Weather weather = (Weather) intent.getSerializableExtra("we");

        String string = intent.getExtras().getString("cityname");
        rv = findViewById(R.id.programlist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        String[] s = {"City : "+string,"Wind Speed : "+weather.getWind().getSpeed()+" m/s",
                "Tempreture :"+ Double.toString(Math.round(weather.getMain().getTemp()-273.0))+" C",
                "Pressure : "+weather.getMain().getPressure()+" hPa",
                "Humidity : "+weather.getMain().getHumidity()+" %",
                "Visibility : "+weather.getVisibility(),
                weather.getWeather().get(0).getMain()+"\n"+weather.getWeather().get(0).getDescription()
        };
        rv.setAdapter(new adapter(s));

    }
}
