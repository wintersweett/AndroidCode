package com.havefun.androidstudy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/app/Activity2")
public class MainActivity2 extends AppCompatActivity {

    @Autowired
    public String name;
    @Autowired
    public int age;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_dialog_fragment);
    }
}
