package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f356a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CompoundButton compoundButton) {
        this.f356a = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001d, B:11:0x0031, B:13:0x0039, B:15:0x0041, B:16:0x0050, B:18:0x0058, B:19:0x0063, B:21:0x006b), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001d, B:11:0x0031, B:13:0x0039, B:15:0x0041, B:16:0x0050, B:18:0x0058, B:19:0x0063, B:21:0x006b), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f356a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.a.j.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L2e
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L80
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L2e
            android.widget.CompoundButton r0 = r3.f356a     // Catch: android.content.res.Resources.NotFoundException -> L2e java.lang.Throwable -> L80
            android.widget.CompoundButton r1 = r3.f356a     // Catch: android.content.res.Resources.NotFoundException -> L2e java.lang.Throwable -> L80
            android.content.Context r1 = r1.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L2e java.lang.Throwable -> L80
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r1, r5)     // Catch: android.content.res.Resources.NotFoundException -> L2e java.lang.Throwable -> L80
            r0.setButtonDrawable(r5)     // Catch: android.content.res.Resources.NotFoundException -> L2e java.lang.Throwable -> L80
            r5 = 1
            goto L2f
        L2e:
            r5 = 0
        L2f:
            if (r5 != 0) goto L50
            int r5 = androidx.appcompat.a.j.CompoundButton_android_button     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L50
            int r5 = androidx.appcompat.a.j.CompoundButton_android_button     // Catch: java.lang.Throwable -> L80
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L50
            android.widget.CompoundButton r0 = r3.f356a     // Catch: java.lang.Throwable -> L80
            android.widget.CompoundButton r1 = r3.f356a     // Catch: java.lang.Throwable -> L80
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L80
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r1, r5)     // Catch: java.lang.Throwable -> L80
            r0.setButtonDrawable(r5)     // Catch: java.lang.Throwable -> L80
        L50:
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L63
            android.widget.CompoundButton r5 = r3.f356a     // Catch: java.lang.Throwable -> L80
            int r0 = androidx.appcompat.a.j.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L80
            android.content.res.ColorStateList r0 = r4.getColorStateList(r0)     // Catch: java.lang.Throwable -> L80
            androidx.core.widget.c.a(r5, r0)     // Catch: java.lang.Throwable -> L80
        L63:
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L7c
            android.widget.CompoundButton r5 = r3.f356a     // Catch: java.lang.Throwable -> L80
            int r0 = androidx.appcompat.a.j.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L80
            r1 = -1
            int r0 = r4.getInt(r0, r1)     // Catch: java.lang.Throwable -> L80
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.ac.a(r0, r1)     // Catch: java.lang.Throwable -> L80
            androidx.core.widget.c.a(r5, r0)     // Catch: java.lang.Throwable -> L80
        L7c:
            r4.recycle()
            return
        L80:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.a(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            d();
        }
    }

    void d() {
        Drawable a2 = androidx.core.widget.c.a(this.f356a);
        if (a2 != null) {
            if (this.d || this.e) {
                Drawable mutate = androidx.core.graphics.drawable.a.g(a2).mutate();
                if (this.d) {
                    androidx.core.graphics.drawable.a.a(mutate, this.b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(mutate, this.c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f356a.getDrawableState());
                }
                this.f356a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = androidx.core.widget.c.a(this.f356a)) == null) ? i : i + a2.getIntrinsicWidth();
    }
}
