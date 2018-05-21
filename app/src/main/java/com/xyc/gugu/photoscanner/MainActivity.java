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
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526885603730&di=f36702adeea1c40b4b75ec659a4870e9&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8c1001e93901213fab66256a58e736d12f2e952a.jpg");
        PicConfig picConfig = new PicConfig.Builder()
                .setPosition(0)
                .setIsShowNumber(true)
                .setListData(urls).build();
        startActivity(PictureActivity.makeIntent(this,picConfig));
    }

}
