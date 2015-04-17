package com.lily.huangxingli.testcustomviewanim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;

import android.widget.Checkable;

/**
 * Created by huangxingli on 2015/4/17.
 */
public class MoodChangeIndicator extends View implements Checkable{

    int mod;
    boolean isChecked=true;

   static Property<MoodChangeIndicator,Integer> modProperty= new Property<MoodChangeIndicator, Integer>(Integer.class,"mod")
     {

       @Override
       public Integer get(MoodChangeIndicator object) {
           return object.getMod();
       }

       @Override
       public void set(MoodChangeIndicator object, Integer value) {
           object.setMod(value);
       }
   };

    public void setMod(Integer mod) {
        this.mod = mod;
    }

    public Integer getMod() {
        invalidate();
        return mod;

    }

    public MoodChangeIndicator(Context context) {
        super(context);
    }

    public MoodChangeIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoodChangeIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isChecked){
            canvas.drawColor(Color.RED);
        }else{
            canvas.drawColor(Color.BLUE);
        }

    }


    public Animator getModAnimation(boolean happy){
        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(this, modProperty, happy ? 0 : 1);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        return  objectAnimator;

    }

    @Override
    public void setChecked(boolean checked) {
        Log.v("TAG","---param is ---"+checked);
        Log.v("TAG","----isCheck field is -----"+isChecked);
        if (isChecked!=checked){
            Log.v("TAG", "---SETchecked invoked----");
            getModAnimation(isChecked);

        }else{
            Log.v("TAG","===setchecked no invoke---");
        }
        isChecked=!isChecked;

    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {
        Log.v("TAG","----toggle isChecked is ---"+isChecked);
        setChecked(!isChecked);

        Log.v("TAG","----TOGGLE---");
    }
}
