package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public class IconSpan extends ReplacementSpan {
    private final float baseLineOffset;
    private int drawSize;
    private final Drawable iconDrawable;
    private final boolean isRtl;
    private final int startPadding;
    private final int textColor;
    private final float textSize;

    public IconSpan(Context context, Drawable drawable, int i, int i2) {
        this.iconDrawable = drawable;
        this.startPadding = ViewUtils.dip2px(context, 2.0f);
        this.textColor = i;
        this.textSize = TypedValue.applyDimension(2, i2, context.getResources().getDisplayMetrics());
        this.baseLineOffset = ViewUtils.dip2px(context, 3.0f);
        this.isRtl = LangUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.textSize);
        this.drawSize = (int) (paint.measureText(charSequence, i, i2) + (this.startPadding * 2));
        paint.setTextSize(textSize);
        return this.drawSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        if (this.isRtl) {
            int i6 = (int) f;
            this.iconDrawable.setBounds(i6, i3, this.drawSize + i6, i5);
        } else {
            this.iconDrawable.setBounds((int) f, i3, this.drawSize, i5);
        }
        this.iconDrawable.draw(canvas);
        paint.setColor(this.textColor);
        paint.setTextSize(this.textSize);
        canvas.drawText(charSequence, i, i2, f + this.startPadding, i4 - this.baseLineOffset, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }
}
