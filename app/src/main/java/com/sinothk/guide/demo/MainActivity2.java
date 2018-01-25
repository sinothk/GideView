package com.sinothk.guide.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.sinothk.android.view.guide.Controller;
import com.sinothk.android.view.guide.HighLight;
import com.sinothk.android.view.guide.NewbieGuide;
import com.sinothk.android.view.guide.OnGuideChangedListener;

// 来自：https://github.com/huburt-Hu/NewbieGuide
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button) this.findViewById(R.id.button);
//        Button button2 = (Button) this.findViewById(R.id.button2);

        Controller controller = NewbieGuide.with(this)
                .setLabel("guide1")//设置引导层标示，用于区分不同引导层，必传！否则报错
                .addHighLight(button, HighLight.Type.RECTANGLE)//添加需要高亮的view
                .setOnGuideChangedListener(new OnGuideChangedListener() {//设置监听
                    @Override
                    public void onShowed(Controller controller) {
                        //引导层显示
                    }

                    @Override
                    public void onRemoved(Controller controller) {
                        //引导层消失
                        show2();
                    }
                })
                .setBackgroundColor(0xb2000000)//设置引导层背景色，建议有透明度，默认背景色为：0xb2000000
                .setEveryWhereCancelable(false)//设置点击任何区域消失，默认为true
                .setLayoutRes(R.layout.view_guide, R.id.imageView)//自定义的提示layout,第二个可变参数为点击隐藏引导层view的id
                .alwaysShow(true)//是否每次都显示引导层，默认false
                .build();//构建引导层的控制器

        controller.resetLabel("guide1");
        controller.remove();//移除引导层
        controller.show();//显示引导层
    }

    private void show2() {
        Button button2 = (Button) this.findViewById(R.id.button2);

        Controller controller2 = NewbieGuide.with(this)//传入activity
                .setLabel("guide2")//设置引导层标示，用于区分不同引导层，必传！否则报错
                .addHighLight(button2, HighLight.Type.RECTANGLE)//添加需要高亮的view
                .setEveryWhereCancelable(false)//设置点击任何区域消失，默认为true
                .alwaysShow(true)//是否每次都显示引导层，默认false
                .setLayoutRes(R.layout.view_guide2, R.id.imageView2)//自定义的提示layout，不要添加背景色，引导层背景色通过setBackgroundColor()设置
                .show();//显示引导层
        controller2.resetLabel("guide2");
        controller2.remove();//移除引导层
        controller2.show();//显示引导层
    }
}
