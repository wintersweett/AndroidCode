package com.havefun.shortcode.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.havefun.shortcode.R;

public class ColorTrackTextView extends androidx.appcompat.widget.AppCompatTextView {
    Rect bounds;
    Paint originPaint;
    Paint changePaint;
    private int changeColor;
    private int originColor;

    public ColorTrackTextView(Context context) {
        this(context, null);
    }

    public ColorTrackTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTrackTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorTrackTextView);
        changeColor = typedArray.getColor(R.styleable.ColorTrackTextView_changeColor,
                getTextColors().getDefaultColor());
        originColor = typedArray.getColor(R.styleable.ColorTrackTextView_originColor,
                getTextColors().getDefaultColor());

        typedArray.recycle();
        init();
    }

    private void init() {
        bounds = new Rect();
        originPaint = new Paint();
        // 设置填充
        originPaint.setStyle(Paint.Style.FILL);
        // 抗锯齿
        originPaint.setAntiAlias(true);
        // 防抖动
        originPaint.setDither(true);
        // 设置颜色
        originPaint.setColor(originColor);
        // 设置字体大小
        originPaint.setTextSize(50);

        changePaint = new Paint();
        // 设置填充
        changePaint.setStyle(Paint.Style.FILL);
        // 抗锯齿
        changePaint.setAntiAlias(true);
        // 防抖动
        changePaint.setDither(true);
        // 设置颜色
        changePaint.setColor(changeColor);
        // 设置字体大小
        changePaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        if (TextUtils.isEmpty(text)) return;

        // 获取文字范围
        originPaint.getTextBounds(text, 0, text.length(), bounds);

        // 文字起始位置
        int dx = (getWidth() - bounds.width()) / 2;
        // 获取基线
        Paint.FontMetricsInt fontMetricsInt = originPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        int baseline = getHeight() / 2 + dy;

        // 绘制文字
        canvas.drawText(text, dx, baseline, originPaint);
    }
}
