package com.havefun.shortcode.util;


import android.app.Activity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.havefun.base.BaseApplication;
import com.havefun.shortcode.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
*@Author: WinterSweett
*@Date:    
*@Description: 此用于传入协议，有高亮文字，并且可点击
*/
public class SpannableHighLightAndClickUtils {
    
    /**
    *@Description 此方法针对不同页面的业务逻辑，传入不同业务调用不同。
    *@param1 要改变颜色的view 此处暂时只能是TextView
     * @param2 前缀话语
     * @param3  后缀话语
     * @param4  可变长的分段的协议，业务可传多段协议 ，入参数的String 代表 每段协议的文本，ClickableSpan 代表 每段协议文本所对应的可点击可变色事件
    *@return 
    *@author WinterSweett
    *@time  
    */
    public static void setHightLightAndClick(TextView view , String preFix, String endFix, HashMap<String, ClickableSpan>...arrays){
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(preFix) ;
        int startLen = preFix.length() ;
        int endLen = preFix.length() ;
        List<ClickableSpan> list = new ArrayList<>();
        for(int i=0 ;i< arrays.length ;i++){
            HashMap<String ,ClickableSpan> map = arrays[i] ;
            Set set = map.entrySet() ;
            if(set == null) continue;
            Iterator it = set.iterator() ;
            while (it .hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                stringBuilder.append(key) ;
            }
        }
        stringBuilder.append(endFix) ;
        
        for(int i=0 ;i< arrays.length ;i++){
            HashMap<String ,ClickableSpan> map = arrays[i] ;
            Set set = map.entrySet() ;
            if(set == null) continue;
            Iterator it = set.iterator() ;
            while (it .hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                endLen =  startLen + key.length() ;
                ClickableSpan clickableSpan = (ClickableSpan) entry.getValue();
                stringBuilder.setSpan(clickableSpan, startLen, endLen,
                        Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                startLen = endLen ;
            }
        }
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(stringBuilder);
    }

/**
*@Description 适配具体的业务
*@param 
*@return 
*@author WinterSweett
*@time  
*/
    public static void showHighLightAndClickForSpecialWork(TextView view ,final Activity activity){
        String prefix = "我已阅读并同意";
        String userProtocol = "《猎聘用户服务协议》";
        HashMap<String ,ClickableSpan> map = new HashMap<>();
        map.put(userProtocol, new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
            }
        });
        String privateProtocol = "《个人信息保护\n政策》";
        HashMap<String ,ClickableSpan> map1 = new HashMap<>();
        map1.put(privateProtocol, new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
            }
        });
        String endFix ="，未注册的手机号将自动完成账号注册";
        SpannableHighLightAndClickUtils.setHightLightAndClick(view ,prefix,endFix,map,map1);
    }




    public static SpannableString getHighLightText(String str, SpannableStringUtils.OnSpanClickListener listener, String... highLightText) {
        return getHighLightText(str, ContextCompat.getColor(BaseApplication.getGlobalContext(), R.color.base_color_FF6644), listener, highLightText);
    }

    public static SpannableString getHighLightText(String str, final int color, final SpannableStringUtils.OnSpanClickListener listener, String... highLightText) {
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


}
