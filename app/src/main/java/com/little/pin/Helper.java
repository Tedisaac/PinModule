package com.little.pin;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

public class Helper {

    public void enableNumber(TextView textView){
        textView.setEnabled(true);
        textView.setClickable(true);
    }

    public void disableNumber(TextView textView){
        textView.setEnabled(false);
        textView.setClickable(false);
    }

    public void setBackgroundFilledRedCircle(Context context, ImageView view) {
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.red_filled_circle));
    }

    public void setBackgroundFilledCircle(Context context, ImageView view) {
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.filled_circle));
    }

    public void setBackgroundHollowCircle(Context context, ImageView view) {
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.hollow_circle));
    }

    public void setImageHollowCircle(ImageView view) {
        view.setImageResource(R.drawable.hollow_circle);
    }

    public void setImageHollowRedCircle(ImageView view) {
        view.setImageResource(R.drawable.hollow_red_circle);
    }

    public void animateCircle(View view) {
        ObjectAnimator objAnimator = ObjectAnimator.ofFloat(view, "alpha",0f,1f);
        objAnimator.setDuration(1000);
        objAnimator.start();
    }

    public void animateRepeatCircle(View view) {
        ObjectAnimator objAnimator = ObjectAnimator.ofFloat(view, "alpha",0f,1f);
        objAnimator.setDuration(2000);
        objAnimator.setRepeatCount(ValueAnimator.RESTART);
        objAnimator.start();
    }

    public void shakeAnimation(Context context, ImageView view){
        final Animation animShake = AnimationUtils.loadAnimation(context, R.anim.shake);
        view.startAnimation(animShake);
    }
}
