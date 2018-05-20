package com.xyc.gugu.picturescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PictureActivity extends FragmentActivity {

    private ImageView ivPic;
    public static final String PIC_CONFIG = "picConfig";
    private ArrayList<String> picList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 19) {
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
        if (picList == null) {
            return;
        }
        Glide.with(this).load(picList.get(0)).into(ivPic);
    }

    private void initView() {
        ivPic = (ImageView) findViewById(R.id.ivPic);
        ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context, PicConfig picConfig) {
        Intent intent = new Intent(context, PictureActivity.class);
        intent.putExtra("url_list", PicConfig.list);
        intent.putExtra("pic_position", PicConfig.position);
        return intent;

    }
}
