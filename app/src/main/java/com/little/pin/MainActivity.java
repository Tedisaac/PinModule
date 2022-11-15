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
    String pin = null;
    char p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainView = mainBinding.getRoot();
        setContentView(mainView);


        mainBinding.txtOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4){
                    p = '1';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }

            }
        });

        mainBinding.txtTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '2';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '3';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = '4';
                if (pin.length() == 0) {
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '5';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '6';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '7';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '8';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '9';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.txtZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pin.length() <= 4) {
                    p = '0';
                    pin = pin + p;
                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}