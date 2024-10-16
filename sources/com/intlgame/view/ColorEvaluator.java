package com.intlgame.view;

import android.animation.TypeEvaluator;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes2.dex */
public class ColorEvaluator implements TypeEvaluator<Integer> {
    private int getCurrentColor(int i, int i2, float f) {
        return i < i2 ? (int) (i + (f * (i2 - i))) : (int) (i - (f * (i - i2)));
    }

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = (num.intValue() & WebView.NIGHT_MODE_COLOR) >>> 24;
        int intValue2 = (num.intValue() & 16711680) >> 16;
        int intValue3 = (num.intValue() & 65280) >> 8;
        int intValue4 = num.intValue() & 255;
        int intValue5 = ((-16777216) & num2.intValue()) >>> 24;
        int intValue6 = (16711680 & num2.intValue()) >> 16;
        int intValue7 = (65280 & num2.intValue()) >> 8;
        int intValue8 = num2.intValue() & 255;
        int currentColor = getCurrentColor(intValue, intValue5, f);
        int currentColor2 = getCurrentColor(intValue2, intValue6, f);
        int currentColor3 = getCurrentColor(intValue3, intValue7, f);
        return Integer.valueOf((currentColor << 24) + (currentColor2 << 16) + (currentColor3 << 8) + getCurrentColor(intValue4, intValue8, f));
    }
}
