package com.xyc.gugu.photoscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xyc.gugu.picturescanner.PicConfig;
import com.xyc.gugu.picturescanner.PictureActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvGoPic;
    private ImageView ivImage;
    private ArrayList<String> urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGoPic = (TextView) findViewById(R.id.tvGoPic);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        urls = new ArrayList<>();
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526903225728&di=d7a87bf2594a5bfa1d31b36b918f1902&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140402%2F0010023552905350_b.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526885603730&di=f36702adeea1c40b4b75ec659a4870e9&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8c1001e93901213fab66256a58e736d12f2e952a.jpg");
        urls.add("http://img.taopic.com/uploads/allimg/140804/240388-140P40P33417.jpg");
        urls.add("http://pic.58pic.com/58pic/13/60/27/72h58PICgzY_1024.jpg");
        Glide.with(this).load(urls.get(0)).into(ivImage);
        tvGoPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });
    }

    private void goNext(){
        PicConfig picConfig = new PicConfig.Builder()
                .setPosition(0)
                .setIsShowNumber(true)
                .setListData(urls).build();
        startActivity(PictureActivity.makeIntent(this,picConfig));
        overridePendingTransition(R.anim.activity_zoom_open, 0);
    }

}
