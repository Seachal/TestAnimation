package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * *
 * *
 * Project_Name:TestAnimation
 *
 * @author zhangxc
 * @date 2017/12/2 下午5:29
 * *
 */

public class TestGetLeftRightActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout1, mFrameLayout2, mFrameLayout3;
    private TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testgetleftright);
        initView();
    }

    private void initView() {
        mFrameLayout1 = (FrameLayout) findViewById(R.id.activity_main1);
        mFrameLayout2 = (FrameLayout) findViewById(R.id.activity_main2);
        mFrameLayout3 = (FrameLayout) findViewById(R.id.activity_main3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        mFrameLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("蓝色区域的坐标\n" + "getLeft():  " + mFrameLayout1.getLeft()
                        + "\n" + "getTop(): " + mFrameLayout1.getTop() +
                        "\n" + "getRight():" + mFrameLayout1.getRight()
                        +
                        "\n" + "getBottom():" + mFrameLayout1.getBottom()
                );
                tv2.setText("绿色区域的坐标\n" + "getLeft():  " + mFrameLayout2.getLeft()
                        + "\n" + "getTop(): " + mFrameLayout2.getTop() +
                        "\n" + "getRight():" + mFrameLayout2.getRight() +
                        "\n" + "getBottom():" + mFrameLayout2.getBottom()
                );
                tv3.setText("红色区域的坐标\n" + "getLeft():  " + mFrameLayout3.getLeft()
                        + "\n" + "getTop(): " + mFrameLayout3.getTop() +
                        "\n" + "getRight():" + mFrameLayout3.getRight()
                        + "\n" + "getBottom():" + mFrameLayout3.getBottom()
                );
            }
        });

    }
}