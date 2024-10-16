package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public class FeedTagUnableDrawable extends Drawable {
    private final int lineHeight;
    private final Paint paint = new Paint();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FeedTagUnableDrawable(Context context) {
        this.paint.setAntiAlias(true);
        this.paint.setColor(a.c(context, R.color.feeds_tag_divider));
        this.lineHeight = ViewUtils.dip2px(context, 1.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawLine(bounds.left, bounds.top, bounds.right, bounds.top + this.lineHeight, this.paint);
        canvas.drawLine(bounds.left, bounds.bottom - this.lineHeight, bounds.right, bounds.bottom, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
