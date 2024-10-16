package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TypedValue f282a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;
    private a h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.h = aVar;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        if (androidx.core.f.v.x(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c2  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.f282a == null) {
            this.f282a = new TypedValue();
        }
        return this.f282a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }
}
