package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Account extends AppCompatActivity {
UserInfo info;
TextView accountTV,nameTV,emailTV,yearsTV,weightTV,heightTV,sexTV;
    TextView nameTV2,emailTV2,yearsTV2,weightTV2,heightTV2,sexTV2,BMITV2,BMITV3;
Button updateB;
Switch Aswitch;
FirebaseAuth mAuth;
FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        info = new UserInfo();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        accountTV = findViewById(R.id.accountTV);
        nameTV = findViewById(R.id.accountNameTV);
        emailTV = findViewById(R.id.accountEmailTV);
        yearsTV = findViewById(R.id.accountYearsTV);
        weightTV = findViewById(R.id.accountWeightTV);
        heightTV = findViewById(R.id.accountHeightTV);
        sexTV= findViewById(R.id.accountSexTV);
        updateB = findViewById(R.id.accountButton);
        Aswitch = findViewById(R.id.accountSwitch);

        nameTV2 = findViewById(R.id.accountNameTV2);
        emailTV2 = findViewById(R.id.accountEmailTV2);
        yearsTV2 = findViewById(R.id.accountYearsTV2);
        weightTV2 = findViewById(R.id.accountWeightTV2);
        heightTV2 = findViewById(R.id.accountHeightTV2);
        sexTV2= findViewById(R.id.accountSexTV2);
        BMITV2 = findViewById(R.id.accountBMITV2);
        BMITV3 = findViewById(R.id.accountBMITV3);
        updateB.setText(R.string.update_updateInfo_T);

        nameTV2.setText(":  "+info.getName());
        emailTV2.setText(":  "+mUser.getEmail());
        yearsTV2.setText(":  "+info.getYearsString());
        weightTV2.setText(":  "+info.getWeightString());
        heightTV2.setText(":  "+info.getHeightString());
        if(info.getSex().equals("Men")){ sexTV2.setText(":  "+"Erkek");}
        else {sexTV2.setText(":  "+"Kadın");}
        BMITV2.setText(":  "+info.getBMIString());
        BMITV3.setText("-->  "+info.getBmiRateTR());



        updateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateInfo.class);
                startActivity(intent);
                finish();
            }
        });
        Aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    accountTV.setText(R.string.account_myAccount_E);
                    nameTV.setText(R.string.reg2_name_E );
                    emailTV.setText(R.string.account_email);
                    yearsTV.setText(R.string.reg2_years_E);
                    weightTV.setText(R.string.reg2_weight_E );
                    heightTV.setText(R.string.reg2_height_E);
                    sexTV.setText(R.string.account_sex_E);
                    updateB.setText(R.string.update_updateInfo_E);
                    sexTV2.setText(":  "+info.getSex());
                    BMITV3.setText("-->  "+info.getBmiRate());

                }else {
                    accountTV.setText(R.string.account_myAccount_T);
                    nameTV.setText(R.string.reg2_name_T);
                    emailTV.setText(R.string.account_email);
                    yearsTV.setText(R.string.reg2_years_T);
                    weightTV.setText(R.string.reg2_weight_T);
                    heightTV.setText(R.string.reg2_height_T);
                    sexTV.setText(R.string.account_sex_T);
                    updateB.setText(R.string.update_updateInfo_T);
                    if(info.getSex().equals("Men")){ sexTV2.setText(":  "+"Erkek");}
                    else {sexTV2.setText(":  "+"Kadın");}
                    BMITV3.setText("-->  "+info.getBmiRateTR());
                }
            }
        });
    }
}