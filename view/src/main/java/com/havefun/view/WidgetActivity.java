package com.havefun.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.havefun.common.Constants;

@Route(path = Constants.PATH_WIDGET_ACTIVITY)
public class WidgetActivity extends AppCompatActivity {

    private Button btnChangeSize;
    private MyViewGroup myViewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_show);

        myViewGroup = findViewById(R.id.viewGroup);

        btnChangeSize = findViewById(R.id.btnChangeSize);
        btnChangeSize.setOnClickListener(v -> {
            ViewGroup.LayoutParams layoutParams = myViewGroup.getLayoutParams();
            layoutParams.width = 300;
            layoutParams.height = 600;
            myViewGroup.setLayoutParams(layoutParams);
        });
    }
}
