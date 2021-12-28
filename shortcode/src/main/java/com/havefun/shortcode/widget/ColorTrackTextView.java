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
    Paint mOriginPaint;
    Paint mChangePaint;
    private float mCurrentProgress = 0.0f;


    public ColorTrackTextView(Context context) {
        this(context, null);
    }

    public ColorTrackTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorTrackTextView);
        int changeColor = typedArray.getColor(R.styleable.ColorTrackTextView_changeColor,
                getTextColors().getDefaultColor());
        int originColor = typedArray.getColor(R.styleable.ColorTrackTextView_originColor,
                getTextColors().getDefaultColor());

        typedArray.recycle();
        // 初始化文字矩形区域
        bounds = new Rect();
        // 初始化原始颜色画笔
        mOriginPaint = getPaintByColor(originColor);
        // 初始化改变颜色画笔
        mChangePaint = getPaintByColor(changeColor);
    }


    private Paint getPaintByColor(int color) {
        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // 防抖动
        paint.setDither(true);
        // 设置颜色
        paint.setColor(color);
        // 设置字体大小
        paint.setTextSize(getTextSize());
        return paint;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int currentPoint = (int) (mCurrentProgress * getWidth());
        drawText(canvas, mOriginPaint, 0, currentPoint);
        drawText(canvas, mChangePaint, currentPoint, getWidth());
    }

    private void drawText(Canvas canvas, Paint paint, int start, int end) {
        // 保存状态
        canvas.save();
        Rect rect = new Rect(start, 0, end, getHeight());
        canvas.clipRect(rect);

        String text = getText().toString();
        if (TextUtils.isEmpty(text)) return;

        // 获取文字范围
        paint.getTextBounds(text, 0, text.length(), bounds);

        // 文字起始位置
        int dx = (getWidth() - bounds.width()) / 2;
        // 获取基线
        Paint.FontMetricsInt fontMetricsInt = mChangePaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        int baseline = getHeight() / 2 + dy;

        // 绘制文字
        canvas.drawText(text, dx, baseline, paint);
        // 恢复画布
        canvas.restore();
    }

    /**
     * 更新当前进度
     * @param progress 0.0f - 1.0f 进度
     */
    public void setCurrentProgress(float progress) {
        mCurrentProgress = progress;
        postInvalidate();
    }
}
