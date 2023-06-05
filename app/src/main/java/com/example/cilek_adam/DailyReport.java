package com.example.cilek_adam;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Console;

public class DailyReport extends AppCompatActivity {

    TextView headerText, calorieTakenText, calorieTakenInput, calorieBurnText, calorieBurnInput, BMIInput, helpText, netCalText, netCalInput, basalText, basalInput;

    ProgressBar calorieBar;

    UserInfo info;

    Switch dailySwitch;
    boolean sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));
        sw = getIntent().getBooleanExtra("sw", false);

        info = new UserInfo();
        headerText = findViewById(R.id.daily_header);
        calorieTakenText = findViewById(R.id.daily_calorieTakenText);
        calorieTakenInput = findViewById(R.id.daily_calorieTakenInput);
        calorieBurnText = findViewById(R.id.daily_calorieBurnText);
        calorieBurnInput = findViewById(R.id.daily_calorieBurnInput);
        dailySwitch = findViewById(R.id.dailySwitch);
        calorieBar = findViewById(R.id.daily_progressBar);
        BMIInput = findViewById(R.id.daily_BMIInput);
        helpText = findViewById(R.id.daily_helpText);
        netCalInput = findViewById(R.id.daily_netCalInput);
        netCalText = findViewById(R.id.daily_netCalText);
        basalText = findViewById(R.id.daily_basalText);
        basalInput = findViewById(R.id.daily_basalInput);

        int calorieTaken = info.getCalorie_taken();
        int calorieBurn = info.getCalorie_burn();
        int basalMetabolism = info.getBasalMetabolism();
        int calorieNet = calorieTaken - (calorieBurn + basalMetabolism);
        double bmi = info.getBMI();

        calorieTakenInput.setText(String.valueOf(calorieTaken));
        calorieBurnInput.setText(String.valueOf(calorieBurn));
        netCalInput.setText(String.valueOf(calorieNet));
        BMIInput.setText(String.valueOf((int) Math.round(bmi)));
        basalInput.setText(String.valueOf(basalMetabolism));

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(bmi<=18){
                    calorieBar.setProgress((calorieTaken/2700) * 100);
                    calorieBar.setMax(100);
                }else if (bmi<=25){
                    calorieBar.setProgress((calorieTaken/2200) * 100);
                    calorieBar.setMax(100);
                } else if(bmi<=35){
                    calorieBar.setProgress((calorieTaken/1800) * 100);
                    calorieBar.setMax(100);
                } else{
                    calorieBar.setProgress((calorieTaken/1600) * 100);
                    calorieBar.setMax(100);
                }
            }
        }).start();




        dailySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    headerText.setText(R.string.daily_header_E);
                    calorieTakenText.setText(R.string.daily_calorieTakenText_E);
                    calorieBurnText.setText(R.string.daily_calorieBurnText_E);
                } else {
                    headerText.setText(R.string.daily_header_T);
                    calorieTakenText.setText(R.string.daily_calorieTakenText_T);
                    calorieBurnText.setText(R.string.daily_calorieBurnText_T);
                }
            }
        });
        dailySwitch.setChecked(sw);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Geri düğmesine basıldığında yapılacak işlemler
            // Burada belirli bir aktiviteye yönlendirebilirsiniz
            Intent intent = new Intent(this, menu.class);
            sw = dailySwitch.isChecked();
            intent.putExtra("sw", sw);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}