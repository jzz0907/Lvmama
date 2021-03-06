package com.lv.mama.lv.home.bean;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * autor:刘梦欣
 * date：2017/10/15
 * update：10:54
 * 用途：
 */
public class Fragment_Home_Banner_adapter2 implements OnBannerListener {
    private  List<Mysup.DataBean.ActivityInfoBean.ActivityInfoListBean> list;
    private Banner banner;
    private ArrayList<String> list_path;


    public Fragment_Home_Banner_adapter2(Banner banner, List<Mysup.DataBean.ActivityInfoBean.ActivityInfoListBean> list) {
        this.banner = banner;
        this.list = list;

        list_path = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list_path.add(list.get(i).getActivityImg().toString());

        }
    }

    public void setBanner() {
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CENTER);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);



        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();


    }

    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

}
