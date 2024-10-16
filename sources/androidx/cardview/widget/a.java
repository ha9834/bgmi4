package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.g;

/* loaded from: classes.dex */
class a extends c {
    @Override // androidx.cardview.widget.c, androidx.cardview.widget.e
    public void a() {
        g.f416a = new g.a() { // from class: androidx.cardview.widget.a.1
            @Override // androidx.cardview.widget.g.a
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
