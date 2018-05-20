package com.xyc.gugu.photoscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xyc.gugu.picturescanner.PicConfig;
import com.xyc.gugu.picturescanner.PictureActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvGoPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGoPic = (TextView) findViewById(R.id.tvGoPic);
        tvGoPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goNext();
            }
        });
    }

    private void goNext(){
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526837081437&di=2ee01e1ac10db54d71eeb24a19d1efed&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201805%2F11%2F190553u33dozvebjtog245.jpg");
        PicConfig picConfig = new PicConfig.Builder()
                .setPosition(0)
                .setIsShowNumber(true)
                .setListData(urls).build();
        startActivity(PictureActivity.makeIntent(this,picConfig));
    }

}
