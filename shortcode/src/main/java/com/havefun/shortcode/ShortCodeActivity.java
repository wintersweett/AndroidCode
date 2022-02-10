package com.havefun.shortcode;

import static com.havefun.common.Constants.PATH_SHORT_CODE_ACTIVITY;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.havefun.shortcode.activity.EventBusActivity;
import com.havefun.shortcode.activity.ViewPagerActivity;
import com.havefun.shortcode.databinding.ShortcodeActivityShortcodeBinding;

import org.greenrobot.eventbus.EventBus;

@Route(path = PATH_SHORT_CODE_ACTIVITY)
public class ShortCodeActivity extends AppCompatActivity {
    private static final String TAG = "ShortCodeActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShortcodeActivityShortcodeBinding binding = ShortcodeActivityShortcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EventBus.getDefault().postSticky(new EventBusActivity.Event1());
        EventBus.getDefault().postSticky(new EventBusActivity.Event2());
        EventBus.getDefault().postSticky(new EventBusActivity.Event3());
        Log.d(TAG, "onCreate: " + TAG);
        binding.tvEventBusPage.setOnClickListener(v -> startActivity(new Intent(this,
                EventBusActivity.class)));

    }

    private void dialog1() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(R.layout.app_dialog).create();
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.app_dialog);
        Button button = dialog.findViewById(R.id.button);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.base_color_00BCD4)));
        dialog.show();
    }

    private void dialog2() {
        Dialog dialog = new Dialog(this, R.style.MyDialog);
        dialog.setContentView(R.layout.app_dialog);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(null);
        View decorView = window.getDecorView();
        decorView.setBackgroundColor(Color.YELLOW);
        dialog.show();
    }

    private void dialog3() {
        AlertDialog dialog1 = new AlertDialog.Builder(this)
                //.setView(R.layout.app_dialog)
                //.setIcon(R.mipmap.ic_launcher_round)
                .setMessage("message")
                .setNegativeButton("negative", (dialog, which) -> {
                    Toast.makeText(this, "negative", Toast.LENGTH_LONG).show();
                })
                .setPositiveButton("positive", (dialog, which) -> {
                    Toast.makeText(this, "positive", Toast.LENGTH_SHORT).show();
                })
                .create();
        dialog1.show();
    }
}
