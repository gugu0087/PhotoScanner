package com.xyc.gugu.picturescanner;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hasee on 2018/5/21.
 */

public class ImageAdapter extends PagerAdapter {
    private List<String> imgs;

    private Activity mContext;

    public ImageAdapter(Activity context, List<String> imgs) {

        this.mContext = context;
        this.imgs = imgs;

    }

    @Override
    public int getCount() { // 获得size
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        String imgUrl = imgs.get(position);
        View view = (View) LayoutInflater.from(mContext).inflate(R.layout.img_browse, null);
        PhotoView img = (PhotoView) view.findViewById(R.id.img_plan);
        img.enable();
        Glide.with(mContext).load(imgUrl).into(img);
        ((ViewPager) container).addView(view);

        return view;
    }

}
