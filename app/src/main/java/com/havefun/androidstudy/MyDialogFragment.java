package com.havefun.androidstudy;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MyDialogFragment extends DialogFragment {
    private static final String TAG = "MyDialogFragment";
    private EditText editText;
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
        editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d(TAG, "onGlobalLayout: ");
                int[] location = new int[2];
                editText.getLocationInWindow(location);
                int measuredHeight = editText.getMeasuredHeight();
                Log.d(TAG, "onGlobalLayout: " + location[0] + " | " + location[1] + " | " + measuredHeight);
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                /*Toast.makeText(getContext(), "ret: " + hasFocus, Toast.LENGTH_SHORT).show();
                if (hasFocus) {
                    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.RED));
                    getDialog().getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }*/
            }
        });
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View decorView = getDialog().getWindow().getDecorView();
                Window window = getDialog().getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.windowAnimations = R.animator.trans;
                window.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
                decorView.setBackgroundColor(Color.DKGRAY);
                float translationY = decorView.getTranslationY();
                ObjectAnimator anim = ObjectAnimator.ofFloat(decorView, "translationY", translationY, translationY - 300);
                anim.setDuration(1000);
                anim.start();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_dialog_fragment,container,false);
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        super.show(manager, tag);


    }
}
