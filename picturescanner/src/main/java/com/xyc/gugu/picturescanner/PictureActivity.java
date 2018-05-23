package com.xyc.gugu.picturescanner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PictureActivity extends FragmentActivity {

    public static final String PIC_CONFIG = "picConfig";
    private ArrayList<String> picList;
    private ViewPager imgViewpager;
    private RelativeLayout rlLayout;
    private TextView tvImgCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 19) {
            this.getWindow().addFlags(67108864);
        }
        setContentView(R.layout.activity_picture);
        initView();
        initData();
    }
    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        picList = intent.getStringArrayListExtra("url_list");
        int pic_position = intent.getIntExtra("pic_position", 0);

        if (picList == null) {
            return;
        }
        ImageAdapter adapter = new ImageAdapter(this, picList);
        imgViewpager.setAdapter(adapter);
        imgViewpager.setCurrentItem(pic_position);
        tvImgCount.setText((pic_position + 1) + "/" + picList.size());

        imgViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvImgCount.setText((position + 1) + "/" + picList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {

        imgViewpager = findViewById(R.id.imgViewpager);
        rlLayout = findViewById(R.id.rlLayout);
        tvImgCount = findViewById(R.id.tvImgCount);

    }
        @Override
        public void onBackPressed () {
            super.onBackPressed();

            //overridePendingTransition(0, R.anim.activity_zoom_close);
        }

    public static Intent makeIntent(Context context, PicConfig picConfig) {
        Intent intent = new Intent(context, PictureActivity.class);
        intent.putExtra("url_list", PicConfig.list);
        intent.putExtra("pic_position", PicConfig.position);
        return intent;

    }
}
