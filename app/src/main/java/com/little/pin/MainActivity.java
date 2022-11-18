package com.little.pin;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.little.pin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    ActivityMainBinding mainBinding;
    View mainView;
    String pin = "";
    String realPin = "2022";
    char p;
    StringBuffer sb;
    Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainView = mainBinding.getRoot();
        setContentView(mainView);

        getSupportActionBar().hide();

        helper = new Helper();

        clickListeners();

    }

    private void clickListeners() {
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
        mainBinding.imgBackSpace.setOnClickListener(this);
    }

    private void removeCharFromPin() {
        sb = new StringBuffer(pin);
        if (pin.length() >= 1){
            sb.deleteCharAt(sb.length()-1);
            pin = sb.toString();
            unFillCircleDrawables();
        }
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
            helper.animateCircle(mainBinding.imgPinCircle1);
            helper.setBackgroundFilledCircle(this, mainBinding.imgPinCircle1);
        }if (pin.length() == 2){
            helper.animateCircle(mainBinding.imgPinCircle2);
            helper.setBackgroundFilledCircle(this, mainBinding.imgPinCircle2);
        }if (pin.length() == 3){
            helper.animateCircle(mainBinding.imgPinCircle3);
            helper.setBackgroundFilledCircle(this, mainBinding.imgPinCircle3);
        }if (pin.length() == 4){
            helper.animateCircle(mainBinding.imgPinCircle4);
            helper.setBackgroundFilledCircle(this, mainBinding.imgPinCircle4);
        }
    }

    private void fillErrorCircleDrawables() {
        helper.setImageHollowRedCircle(mainBinding.imgPinCircle1);
        helper.setImageHollowRedCircle(mainBinding.imgPinCircle2);
        helper.setImageHollowRedCircle(mainBinding.imgPinCircle3);
        helper.setImageHollowRedCircle(mainBinding.imgPinCircle4);

        helper.setBackgroundFilledRedCircle(this, mainBinding.imgPinCircle1);
        helper.setBackgroundFilledRedCircle(this, mainBinding.imgPinCircle2);
        helper.setBackgroundFilledRedCircle(this, mainBinding.imgPinCircle3);
        helper.setBackgroundFilledRedCircle(this, mainBinding.imgPinCircle4);

        helper.shakeAnimation(this,mainBinding.imgPinCircle1);
        helper.shakeAnimation(this,mainBinding.imgPinCircle2);
        helper.shakeAnimation(this,mainBinding.imgPinCircle3);
        helper.shakeAnimation(this,mainBinding.imgPinCircle4);
    }

    private void unFillCircleDrawables(){
        if (pin.length() == 1){
            helper.animateCircle(mainBinding.imgPinCircle2);
            helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle2);
        }if (pin.length() == 2){
            helper.animateCircle(mainBinding.imgPinCircle3);
            helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle3);
        }if (pin.length() == 3){
            helper.animateCircle(mainBinding.imgPinCircle4);
            helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle4);
        }if (pin.length() == 0){
            helper.animateCircle(mainBinding.imgPinCircle1);
            helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle1);
        }
    }

    private void unFillAllCircleDrawables() {

        helper.setImageHollowCircle(mainBinding.imgPinCircle1);
        helper.setImageHollowCircle(mainBinding.imgPinCircle2);
        helper.setImageHollowCircle(mainBinding.imgPinCircle3);
        helper.setImageHollowCircle(mainBinding.imgPinCircle4);

        helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle1);
        helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle2);
        helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle3);
        helper.setBackgroundHollowCircle(this, mainBinding.imgPinCircle4);
    }

    private void checkPinLength() {
        if (pin.length() == 4){
            disableNumbers();
            helper.animateRepeatCircle(mainBinding.imgPinCircle1);
            helper.animateRepeatCircle(mainBinding.imgPinCircle2);
            helper.animateRepeatCircle(mainBinding.imgPinCircle3);
            helper.animateRepeatCircle(mainBinding.imgPinCircle4);
            final Handler pinLengthHandler = new Handler();
            pinLengthHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(realPin.equals(pin)){
                        switchToSecondScreen();
                    }else{
                        fillErrorCircleDrawables();
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
            },3000);

        }
    }

    private void enableNumbers() {
        helper.enableNumber(mainBinding.txtOne);
        helper.enableNumber(mainBinding.txtTwo);
        helper.enableNumber(mainBinding.txtThree);
        helper.enableNumber(mainBinding.txtFour);
        helper.enableNumber(mainBinding.txtFive);
        helper.enableNumber(mainBinding.txtSix);
        helper.enableNumber(mainBinding.txtSeven);
        helper.enableNumber(mainBinding.txtEight);
        helper.enableNumber(mainBinding.txtNine);
        helper.enableNumber(mainBinding.txtZero);

        unFillAllCircleDrawables();
    }

    private void disableNumbers() {
        helper.disableNumber(mainBinding.txtOne);
        helper.disableNumber(mainBinding.txtTwo);
        helper.disableNumber(mainBinding.txtThree);
        helper.disableNumber(mainBinding.txtFour);
        helper.disableNumber(mainBinding.txtFive);
        helper.disableNumber(mainBinding.txtSix);
        helper.disableNumber(mainBinding.txtSeven);
        helper.disableNumber(mainBinding.txtEight);
        helper.disableNumber(mainBinding.txtNine);
        helper.disableNumber(mainBinding.txtZero);
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
            case R.id.imgBackSpace:
                removeCharFromPin();
                break;
        }
    }

    private void switchToSecondScreen() {
        Intent secondScreenIntent = new Intent(this, SecondActivity.class);
        startActivity(secondScreenIntent);
        finish();
    }
}