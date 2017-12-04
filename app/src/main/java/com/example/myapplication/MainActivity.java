package com.example.myapplication;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;
import com.seachal.util.UiUtil;


public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "TestAnimation";

    Button btn_start_anim;
    Button btn_reset_pos;
    Button btn_start_anim2;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initUI();
    }

    private void initData() {
        UiUtil.initialize(getApplicationContext());
    }

    private void initUI() {
        btn_start_anim = (Button) findViewById(R.id.btn_start_anim);
        btn_start_anim.setOnClickListener(this);
        btn_start_anim2 = (Button) findViewById(R.id.btn_start_anim2);
        btn_start_anim2.setOnClickListener(this);
        btn_reset_pos = (Button) findViewById(R.id.btn_reset_pos);
        btn_reset_pos.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text);
        text.setOnClickListener(this);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        params.setMargins(0, 0, 0, 0);
        text.setLayoutParams(params);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_anim:
                playAnim1();
                break;
            case R.id.btn_start_anim2:
                playAnim2();
                break;
            case R.id.btn_reset_pos:
                resetPos();
                break;
            case R.id.text:
                printParams();
                break;
            default:
                break;
        }
    }

    public void printParams() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
        if (params != null) {
            String s = "leftMargin = " + params.leftMargin + " rightMargin = " + params.rightMargin
                    + " getLeft = " + text.getLeft() + " getRight = " + text.getRight() + " getWidth = " + text.getWidth();
            Log.i(TAG, s);
            int[] pos = new int[2];
            text.getLocationInWindow(pos);
            Log.i(TAG, "location, x = " + pos[0] + " y = " + pos[1]);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
    }

    private void playAnim1() {
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        int transX = screenW - w;
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(text, "translationX", 0, transX);
        transAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        transAnim.setDuration(300);
        transAnim.start();
    }

    private void resetPos() {
        ViewHelper.setTranslationX(text, 0);
    }

    private void playAnim2() {
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        int transX = (screenW - w) / 2;
        TranslateAnimation transAnim = new TranslateAnimation(0, transX, 0, 0);
        transAnim.setDuration(300);
        // transAnim.setFillAfter(true);
        transAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                updateParams();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(transAnim);
    }


    private void updateParams() {
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
        params.leftMargin = screenW - w;
        text.setLayoutParams(params);
    }
}
