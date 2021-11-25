package com.havefun.shortcode.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;

import com.havefun.base.BaseApplication;
import com.havefun.shortcode.R;


/**
 * Created by peiqi on 2017/11/6.
 * Spannable 工具类
 */

public class SpannableStringUtils {


    public static SpannableString getHighLightTextWithBold(String string) {
        SpannableString spannableString = getHighLightText(string);
        if (spannableString != null) {
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }

    public static SpannableString getHighLightText(String str) {
        return getHighLightText(str, ContextCompat.getColor(BaseApplication.getGlobalContext(), R.color.base_color_FF6644));
    }

    public static SpannableString getHighLightText(String string, @ColorInt int color) {

        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color),
                0, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getHighLightTextWithBold(String str, String highLightText) {
        SpannableString spannableString = getHighLightText(str, highLightText);
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(highLightText) && str.contains(highLightText)) {
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf(highLightText), (str.indexOf(highLightText) + highLightText.length()), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }

    public static SpannableString getHighLightTextWithBold(String str, String highLightText, @ColorInt int color) {
        SpannableString spannableString = getHighLightText(BaseApplication.getGlobalContext(), str, highLightText, color);
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(highLightText) && str.contains(highLightText)) {
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf(highLightText), (str.indexOf(highLightText) + highLightText.length()), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }

    /**
     * 高亮文字
     *
     * @param str   整体文案
     * @param start 高亮起始位置
     * @param end   结束位置
     */
    public static SpannableString getHighLightText(String str, int start, int end) {
        if (TextUtils.isEmpty(str) || str.length() < start || str.length() < end || start > end) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        int colorSource = BaseApplication.getGlobalContext().getResources().getColor(R.color.base_color_FF6644);
        spannableString.setSpan(new ForegroundColorSpan(colorSource),
                start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        return spannableString;
    }

    /**
     * 高亮文字
     *
     * @param str   整体文案
     * @param start 高亮起始位置
     * @param end   结束位置
     */
    public static SpannableString getHighLightText(SpannableString str, int start, int end) {
        if (TextUtils.isEmpty(str) || str.length() < start || str.length() < end || start > end) {
            return new SpannableString("");
        }
        int colorSource = BaseApplication.getGlobalContext().getResources().getColor(R.color.base_color_FF6644);
        str.setSpan(new ForegroundColorSpan(colorSource),
                start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return str;
    }


    public static SpannableString getHighLightText(String str, String highLightText) {
        return getHighLightText(BaseApplication.getGlobalContext(), str, highLightText);
    }

    public static SpannableString getHighLightText(Context context, String str, String highLightText) {
        if (TextUtils.isEmpty(str) || context == null) {
            return new SpannableString("");
        }
        if (TextUtils.isEmpty(highLightText)) {
            return new SpannableString(str);
        }
        return getHighLightText(context, str, highLightText, context.getResources().getColor(R.color.color_FF6400));
    }

    public static SpannableString getHighLightText(Context context, String str, String highLightText, String color) {
        int colorSource = context.getResources().getColor(R.color.color_4696E0);
        try {
            colorSource = Color.parseColor(color);
            getHighLightText(context, str, highLightText, colorSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getHighLightText(context, str, highLightText, colorSource);
    }

    public static SpannableString getHighLightText(Context context, String str, String highLightText, int color) {
        if (str == null || context == null) {
            return null;
        }

        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(highLightText) && str.contains(highLightText)) {
            spannableString.setSpan(new ForegroundColorSpan(color),
                    str.indexOf(highLightText), (str.indexOf(highLightText) + highLightText.length()),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
        return spannableString;
    }

    public interface OnSpanClickListener {
        void onSpanClick(String highLight);
    }

    public static SpannableString getHighLightText(String str, OnSpanClickListener listener, String... highLightText) {
        return getHighLightText(str, ContextCompat.getColor(BaseApplication.getGlobalContext(), R.color.base_color_FF6644), listener, highLightText);
    }

    public static SpannableString getHighLightText(String str, final String color, final OnSpanClickListener listener, String... highLightText) {
        int colorSource;
        try {
            colorSource = Color.parseColor(color);
        } catch (Exception e) {
            e.printStackTrace();
            colorSource = BaseApplication.getGlobalContext().getResources().getColor(R.color.base_color_FF6644);
        }
        return getHighLightText(str, colorSource, listener, highLightText);
    }

    public static SpannableString getHighLightText(String str, final int color, final OnSpanClickListener listener, String... highLightText) {
        if (str == null) {
            return null;
        }

        final SpannableString spannableString = new SpannableString(str);
        for (final String highLight : highLightText) {
            if (str.contains(highLight)) {
                spannableString.setSpan(new ClickableSpan() {

                                            @Override
                                            public void updateDrawState(TextPaint ds) {
                                                ds.setColor(color);
                                                ds.setUnderlineText(false);
                                                ds.clearShadowLayer();
                                            }

                                            @Override
                                            public void onClick(View arg0) {
                                                if (listener != null) {
                                                    listener.onSpanClick(highLight);
                                                }
                                            }
                                        }, str.indexOf(highLight), (str.indexOf(highLight) + highLight.length()),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
        }
        return spannableString;
    }


    public static SpannableString getHighLightText(String handleString, String friString, ClickableSpan clickableSpan) {
        return getHighLightText(handleString, friString, ContextCompat.getColor(BaseApplication.getGlobalContext(), R.color.base_color_FF6644), clickableSpan);
    }

    /**
     * 用于文本中有变色的字符串处理
     *
     * @param handleString  要处理的字符串
     * @param friString     变色的部分
     * @param color         变色的部分的颜色
     * @param clickableSpan 点击事件
     * @return 返回 SpannableStringBuilder
     */
    public static SpannableString getHighLightText(String handleString, String friString, final int color, ClickableSpan clickableSpan) {
        if (TextUtils.isEmpty(handleString) || TextUtils.isEmpty(friString)) {
            return null;
        }

        int companyIndex = handleString.indexOf(friString);
        if (-1 == companyIndex) {
            return null;
        }

        SpannableString protocol = new SpannableString(handleString);
        if (clickableSpan != null) {
            protocol.setSpan(clickableSpan, companyIndex, companyIndex + friString.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        protocol.setSpan(new UnderlineSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(color);//设置颜色
                ds.setUnderlineText(false);//去掉下划线
            }
        }, companyIndex, companyIndex + friString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return protocol;
    }

    /**
     * 设置高亮文字 且重复
     *
     * @param str           全部文字
     * @param highLightText 高亮文字
     * @param color         颜色
     */
    public static SpannableString getHighLightTextRepeat(String str, String highLightText, int color) {
        SpannableString spannableString = new SpannableString(str);
        for (int i = 0; i < str.length(); i++) {
            if (i <= str.length() - highLightText.length()) {
                if (str.indexOf(highLightText, i) > 0) {
                    i = str.indexOf(highLightText, i);
                    spannableString.setSpan(new ForegroundColorSpan(color),
                            i, i + highLightText.length(),
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
        return spannableString;
    }

    public static SpannableString getHighLightTextV1(String str, String... highLightTexts) {
        if (TextUtils.isEmpty(str) || highLightTexts == null || highLightTexts.length == 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        int colorSource = BaseApplication.getGlobalContext().getResources().getColor(R.color.color_333333);
        for (String highLightText : highLightTexts) {
            int i = str.indexOf(highLightText) + highLightText.length();
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf(highLightText), i, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(colorSource),
                    str.indexOf(highLightText), i,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }
}
