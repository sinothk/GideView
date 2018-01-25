package com.sinothk.guide.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sinothk.android.view.guide.Controller;
import com.sinothk.android.view.guide.HighLight;
import com.sinothk.android.view.guide.NewbieGuide;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) this.findViewById(R.id.button);
        Button button2 = (Button) this.findViewById(R.id.button2);

        final Controller controller = NewbieGuide.with(this)//传入activity
                .setLabel("guide1")//设置引导层标示，用于区分不同引导层，必传！否则报错
                .addHighLight(button, HighLight.Type.RECTANGLE)//添加需要高亮的view
                .setLayoutRes(R.layout.view_guide)//自定义的提示layout，不要添加背景色，引导层背景色通过setBackgroundColor()设置
                .show();//显示引导层

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.resetLabel("guide1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.show();//显示引导层
            }
        });
    }
}
