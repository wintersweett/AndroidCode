package com.havefun.androidstudy;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by hu_jiao on 2022/2/21.
 */

public class TestActivity extends AppCompatActivity {


    private boolean mFlag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ImageView viewById = findViewById(R.id.imageView);

        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mFlag) {
                    viewById.setSelected(true);
                } else {
                    viewById.setSelected(false);
                }
                mFlag = !mFlag;
                viewById.setBackgroundResource(R.mipmap.ic_launcher_round);
            }
        });
    }
}
