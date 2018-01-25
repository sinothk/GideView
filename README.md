# GideView
Gide View 来自：https://github.com/huburt-Hu/NewbieGuide

## 效果

改变高亮view的尺寸，并不用调整显示引导层的代码

![sample](https://github.com/huburt-Hu/NewbieGuide/raw/master/screenshoot/device-2017-08-09-161703.png) ?
![sample](https://github.com/huburt-Hu/NewbieGuide/raw/master/screenshoot/change_size.png)

引导层的xml可以完全自定义，像怎样显示就怎样显示

![sample](https://github.com/huburt-Hu/NewbieGuide/raw/master/screenshoot/device-2017-11-03-151550.png)

## 简单使用

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
