package com.little.pin;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.little.pin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    ActivityMainBinding mainBinding;
    View mainView;
    String pin = "";
    String realPin = "2022";
    char p;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainView = mainBinding.getRoot();
        setContentView(mainView);

        getSupportActionBar().hide();

        mainBinding.txtOne.setOnClickListener(this);
        mainBinding.txtTwo.setOnClickListener(this);
        mainBinding.txtThree.setOnClickListener(this);
        mainBinding.txtFour.setOnClickListener(this);
        mainBinding.txtFive.setOnClickListener(this);
        mainBinding.txtSix.setOnClickListener(this);
        mainBinding.txtSeven.setOnClickListener(this);
        mainBinding.txtEight.setOnClickListener(this);
        mainBinding.txtNine.setOnClickListener(this);
        mainBinding.txtZero.setOnClickListener(this);

        mainBinding.imgBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb = new StringBuffer(pin);
                if (pin.length() >= 1){
                    sb.deleteCharAt(sb.length()-1);
                    pin = sb.toString();
                    unFillCircleDrawables();
                }
            }
        });
    }

    private void AddCharToPin(char p) {
        if (pin != null && pin.length() <= 3) {
            pin = pin + p;
            fillCircleDrawables();
            checkPinLength();
        }
    }

    private void fillCircleDrawables(){
        if (pin.length() == 1){
            animateCircle(mainBinding.imgPinCircle1);
            mainBinding.imgPinCircle1.setBackground(ContextCompat.getDrawable(this, R.drawable.filled_circle));
        }if (pin.length() == 2){
            animateCircle(mainBinding.imgPinCircle2);
            mainBinding.imgPinCircle2.setBackground(ContextCompat.getDrawable(this, R.drawable.filled_circle));
        }if (pin.length() == 3){
            animateCircle(mainBinding.imgPinCircle3);
            mainBinding.imgPinCircle3.setBackground(ContextCompat.getDrawable(this, R.drawable.filled_circle));
        }if (pin.length() == 4){
            animateCircle(mainBinding.imgPinCircle4);
            mainBinding.imgPinCircle4.setBackground(ContextCompat.getDrawable(this, R.drawable.filled_circle));
        }
    }

    private void fillErrorCircleDrawables() {
        setImageHollowRedCircle(mainBinding.imgPinCircle1);
        setImageHollowRedCircle(mainBinding.imgPinCircle2);
        setImageHollowRedCircle(mainBinding.imgPinCircle3);
        setImageHollowRedCircle(mainBinding.imgPinCircle4);

        mainBinding.imgPinCircle1.setBackground(ContextCompat.getDrawable(this, R.drawable.red_filled_circle));
        mainBinding.imgPinCircle2.setBackground(ContextCompat.getDrawable(this, R.drawable.red_filled_circle));
        mainBinding.imgPinCircle3.setBackground(ContextCompat.getDrawable(this, R.drawable.red_filled_circle));
        mainBinding.imgPinCircle4.setBackground(ContextCompat.getDrawable(this, R.drawable.red_filled_circle));

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        mainBinding.imgPinCircle1.startAnimation(animShake);
        mainBinding.imgPinCircle2.startAnimation(animShake);
        mainBinding.imgPinCircle3.startAnimation(animShake);
        mainBinding.imgPinCircle4.startAnimation(animShake);
    }

    private void unFillCircleDrawables(){
        if (pin.length() == 1){
            animateCircle(mainBinding.imgPinCircle2);
            mainBinding.imgPinCircle2.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        }if (pin.length() == 2){
            animateCircle(mainBinding.imgPinCircle3);
            mainBinding.imgPinCircle3.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        }if (pin.length() == 3){
            animateCircle(mainBinding.imgPinCircle4);
            mainBinding.imgPinCircle4.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        }if (pin.length() == 0){
            animateCircle(mainBinding.imgPinCircle1);
            mainBinding.imgPinCircle1.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        }
    }

    private void unFillAllCircleDrawables() {

        setImageHollowCircle(mainBinding.imgPinCircle1);
        setImageHollowCircle(mainBinding.imgPinCircle2);
        setImageHollowCircle(mainBinding.imgPinCircle3);
        setImageHollowCircle(mainBinding.imgPinCircle4);

        mainBinding.imgPinCircle1.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        mainBinding.imgPinCircle2.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        mainBinding.imgPinCircle3.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
        mainBinding.imgPinCircle4.setBackground(ContextCompat.getDrawable(this, R.drawable.hollow_circle));
    }

    private void animateCircle(View view) {
        ObjectAnimator objAnimator = ObjectAnimator.ofFloat(view, "alpha",0f,1f);
        objAnimator.setDuration(1000);
        objAnimator.start();
    }

    private void setImageHollowCircle(ImageView view) {
        view.setImageResource(R.drawable.hollow_circle);
    }

    private void setImageHollowRedCircle(ImageView view) {
        view.setImageResource(R.drawable.hollow_red_circle);
    }

    private void checkPinLength() {
        if (pin.length() == 4){
            if(realPin.equals(pin)){
                switchToSecondScreen();
            }else{
                disableNumbers();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pin = "";
                        enableNumbers();
                    }
                }, 1000);
            }
        }
    }

    private void enableNumbers() {
        mainBinding.txtOne.setEnabled(true);
        mainBinding.txtOne.setClickable(true);
        mainBinding.txtTwo.setEnabled(true);
        mainBinding.txtTwo.setClickable(true);
        mainBinding.txtThree.setEnabled(true);
        mainBinding.txtThree.setClickable(true);
        mainBinding.txtFour.setEnabled(true);
        mainBinding.txtFour.setClickable(true);
        mainBinding.txtFive.setEnabled(true);
        mainBinding.txtFive.setClickable(true);
        mainBinding.txtSix.setEnabled(true);
        mainBinding.txtSix.setClickable(true);
        mainBinding.txtSeven.setEnabled(true);
        mainBinding.txtSeven.setClickable(true);
        mainBinding.txtEight.setEnabled(true);
        mainBinding.txtEight.setClickable(true);
        mainBinding.txtNine.setEnabled(true);
        mainBinding.txtNine.setClickable(true);
        mainBinding.txtZero.setEnabled(true);
        mainBinding.txtZero.setClickable(true);
        mainBinding.imgBackSpace.setEnabled(true);
        mainBinding.imgBackSpace.setClickable(true);

        unFillAllCircleDrawables();
    }

    private void disableNumbers() {
        mainBinding.txtOne.setEnabled(false);
        mainBinding.txtOne.setClickable(false);
        mainBinding.txtTwo.setEnabled(false);
        mainBinding.txtTwo.setClickable(false);
        mainBinding.txtThree.setEnabled(false);
        mainBinding.txtThree.setClickable(false);
        mainBinding.txtFour.setEnabled(false);
        mainBinding.txtFour.setClickable(false);
        mainBinding.txtFive.setEnabled(false);
        mainBinding.txtFive.setClickable(false);
        mainBinding.txtSix.setEnabled(false);
        mainBinding.txtSix.setClickable(false);
        mainBinding.txtSeven.setEnabled(false);
        mainBinding.txtSeven.setClickable(false);
        mainBinding.txtEight.setEnabled(false);
        mainBinding.txtEight.setClickable(false);
        mainBinding.txtNine.setEnabled(false);
        mainBinding.txtNine.setClickable(false);
        mainBinding.txtZero.setEnabled(false);
        mainBinding.txtZero.setClickable(false);
        mainBinding.imgBackSpace.setEnabled(false);
        mainBinding.imgBackSpace.setClickable(false);

        fillErrorCircleDrawables();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.txtOne:
                p = '1';
                AddCharToPin(p);
                break;
            case R.id.txtTwo:
                p = '2';
                AddCharToPin(p);
                break;
            case R.id.txtThree:
                p = '3';
                AddCharToPin(p);
                break;
            case R.id.txtFour:
                p = '4';
                AddCharToPin(p);
                break;
            case R.id.txtFive:
                p = '5';
                AddCharToPin(p);
                break;
            case R.id.txtSix:
                p = '6';
                AddCharToPin(p);
                break;
            case R.id.txtSeven:
                p = '7';
                AddCharToPin(p);
                break;
            case R.id.txtEight:
                p = '8';
                AddCharToPin(p);
                break;
            case R.id.txtNine:
                p = '9';
                AddCharToPin(p);
                break;
            case R.id.txtZero:
                p = '0';
                AddCharToPin(p);
                break;
        }
    }

    private void switchToSecondScreen() {
        Intent secondScreenIntent = new Intent(this, SecondActivity.class);
        startActivity(secondScreenIntent);
        finish();
    }
}