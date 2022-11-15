package com.little.pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.little.pin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    View mainView;
    String pin = "";
    char p;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainView = mainBinding.getRoot();
        setContentView(mainView);


        mainBinding.txtOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '1';
                if (pin != null && pin.length() <= 3){
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }

            }
        });

        mainBinding.txtTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '2';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '3';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '4';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '5';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '6';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '7';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '8';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '9';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '0';
                if (pin != null && pin.length() <= 3) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.imgBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() > 0){
                    sb = new StringBuffer(pin);
                    sb.deleteCharAt(sb.length()-1);
                    Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fillCircleDrawables(){}

    private void unFillCircleDrawables(){}
}