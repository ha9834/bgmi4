package com.devbrackets.android.exomedia.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.devbrackets.android.exomedia.core.video.scale.ScaleType;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class b extends SurfaceView implements com.devbrackets.android.exomedia.core.video.a {
    private static final int[] k = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};
    private static final int[] l = {12440, 2, 12344};

    /* renamed from: a, reason: collision with root package name */
    protected c f1018a;
    protected Point b;
    protected Point c;
    protected com.devbrackets.android.exomedia.core.video.scale.a d;
    protected a e;
    protected ViewTreeObserverOnGlobalLayoutListenerC0075b f;
    protected final ReentrantLock g;
    protected int h;
    protected int i;
    protected boolean j;

    /* loaded from: classes.dex */
    public interface c {
        void a(int i, int i2);
    }

    public b(Context context) {
        super(context);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.d = new com.devbrackets.android.exomedia.core.video.scale.a();
        this.e = new a();
        this.f = new ViewTreeObserverOnGlobalLayoutListenerC0075b();
        this.g = new ReentrantLock(true);
        this.h = 0;
        this.i = 0;
        this.j = true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.d = new com.devbrackets.android.exomedia.core.video.scale.a();
        this.e = new a();
        this.f = new ViewTreeObserverOnGlobalLayoutListenerC0075b();
        this.g = new ReentrantLock(true);
        this.h = 0;
        this.i = 0;
        this.j = true;
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.d = new com.devbrackets.android.exomedia.core.video.scale.a();
        this.e = new a();
        this.f = new ViewTreeObserverOnGlobalLayoutListenerC0075b();
        this.g = new ReentrantLock(true);
        this.h = 0;
        this.i = 0;
        this.j = true;
    }

    @TargetApi(21)
    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.d = new com.devbrackets.android.exomedia.core.video.scale.a();
        this.e = new a();
        this.f = new ViewTreeObserverOnGlobalLayoutListenerC0075b();
        this.g = new ReentrantLock(true);
        this.h = 0;
        this.i = 0;
        this.j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        if (r1 > r6) goto L41;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devbrackets.android.exomedia.core.video.b.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        e();
        super.onConfigurationChanged(configuration);
    }

    public void setOnSizeChangeListener(c cVar) {
        this.f1018a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, int i2) {
        this.d.a(i, i2);
        e();
        Point point = this.c;
        point.x = i;
        point.y = i2;
        return (i == 0 || i2 == 0) ? false : true;
    }

    public void setScaleType(ScaleType scaleType) {
        this.d.a(this, scaleType);
    }

    public ScaleType getScaleType() {
        return this.d.b();
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.j = z;
        requestLayout();
    }

    public void a(int i, boolean z) {
        int i2 = z ? i : this.h;
        if (z) {
            i = this.i;
        }
        b(i2, i);
    }

    public void b(int i, int i2) {
        this.h = i;
        this.i = i2;
        this.d.a(this, (i + i2) % 360);
    }

    protected void e() {
        this.g.lock();
        if (getWindowToken() == null) {
            addOnAttachStateChangeListener(this.e);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
        this.g.unlock();
    }

    protected void c(int i, int i2) {
        if (this.b.x == i && this.b.y == i2) {
            return;
        }
        Point point = this.b;
        point.x = i;
        point.y = i2;
        e();
        c cVar = this.f1018a;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        private a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.g.lock();
            b.this.getViewTreeObserver().addOnGlobalLayoutListener(b.this.f);
            b.this.removeOnAttachStateChangeListener(this);
            b.this.g.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.devbrackets.android.exomedia.core.video.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC0075b implements ViewTreeObserver.OnGlobalLayoutListener {
        private ViewTreeObserverOnGlobalLayoutListenerC0075b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b bVar = b.this;
            bVar.setScaleType(bVar.d.b());
            if (Build.VERSION.SDK_INT >= 16) {
                b.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                b.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }
}
