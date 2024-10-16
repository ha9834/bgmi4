package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0029b f203a;
    private Rect b;
    private Drawable c;
    private Drawable d;
    private boolean f;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;
    private int e = 255;
    private int g = -1;
    private int h = -1;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f203a.getChangingConfigurations();
    }

    private boolean a() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.h(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect e = this.f203a.e();
        if (e != null) {
            rect.set(e);
            padding = (e.right | ((e.left | e.top) | e.bottom)) != 0;
        } else {
            Drawable drawable = this.c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f && this.e == i) {
            return;
        }
        this.f = true;
        this.e = i;
        Drawable drawable = this.c;
        if (drawable != null) {
            if (this.k == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f203a.z != z) {
            AbstractC0029b abstractC0029b = this.f203a;
            abstractC0029b.z = z;
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setDither(abstractC0029b.z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0029b abstractC0029b = this.f203a;
        abstractC0029b.G = true;
        if (abstractC0029b.F != colorFilter) {
            this.f203a.F = colorFilter;
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        AbstractC0029b abstractC0029b = this.f203a;
        abstractC0029b.J = true;
        if (abstractC0029b.H != colorStateList) {
            this.f203a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        AbstractC0029b abstractC0029b = this.f203a;
        abstractC0029b.K = true;
        if (abstractC0029b.I != mode) {
            this.f203a.I = mode;
            androidx.core.graphics.drawable.a.a(this.c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f203a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f203a.E != z) {
            AbstractC0029b abstractC0029b = this.f203a;
            abstractC0029b.E = z;
            Drawable drawable = this.c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, abstractC0029b.E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f203a.E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.d = null;
            this.h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f) {
                this.c.setAlpha(this.e);
            }
        }
        if (this.l != 0) {
            this.l = 0L;
            z = true;
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.b;
        if (rect == null) {
            this.b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f203a.d(i, d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f203a.f()) {
            return this.f203a.g();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f203a.f()) {
            return this.f203a.h();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f203a.f()) {
            return this.f203a.i();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f203a.f()) {
            return this.f203a.j();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        AbstractC0029b abstractC0029b = this.f203a;
        if (abstractC0029b != null) {
            abstractC0029b.b();
        }
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f203a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        if (i == this.g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f203a.D > 0) {
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.c;
            if (drawable2 != null) {
                this.d = drawable2;
                this.h = this.g;
                this.l = this.f203a.D + uptimeMillis;
            } else {
                this.d = null;
                this.h = -1;
                this.l = 0L;
            }
        } else {
            Drawable drawable3 = this.c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0 && i < this.f203a.j) {
            Drawable b = this.f203a.b(i);
            this.c = b;
            this.g = i;
            if (b != null) {
                if (this.f203a.C > 0) {
                    this.k = uptimeMillis + this.f203a.C;
                }
                a(b);
            }
        } else {
            this.c = null;
            this.g = -1;
        }
        if (this.k != 0 || this.l != 0) {
            Runnable runnable = this.j;
            if (runnable == null) {
                this.j = new Runnable() { // from class: androidx.appcompat.b.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        drawable.setCallback(this.m.a(drawable.getCallback()));
        try {
            if (this.f203a.C <= 0 && this.f) {
                drawable.setAlpha(this.e);
            }
            if (this.f203a.G) {
                drawable.setColorFilter(this.f203a.F);
            } else {
                if (this.f203a.J) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f203a.H);
                }
                if (this.f203a.K) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f203a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f203a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f203a.E);
            }
            Rect rect = this.b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L3a
            long r9 = r13.k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3c
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.e
            r3.setAlpha(r9)
            r13.k = r7
            goto L3c
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b.a.b$b r9 = r13.f203a
            int r9 = r9.C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.c
            int r3 = 255 - r3
            int r10 = r13.e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L3d
        L3a:
            r13.k = r7
        L3c:
            r3 = 0
        L3d:
            android.graphics.drawable.Drawable r9 = r13.d
            if (r9 == 0) goto L6c
            long r10 = r13.l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6e
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L57
            r9.setVisible(r6, r6)
            r0 = 0
            r13.d = r0
            r0 = -1
            r13.h = r0
            r13.l = r7
            goto L6e
        L57:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.b$b r4 = r13.f203a
            int r4 = r4.D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.d
            int r5 = r13.e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L6f
        L6c:
            r13.l = r7
        L6e:
            r0 = r3
        L6f:
            if (r14 == 0) goto L7b
            if (r0 == 0) goto L7b
            java.lang.Runnable r14 = r13.j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Resources resources) {
        this.f203a.a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f203a.a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f203a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f203a.n()) {
            return null;
        }
        this.f203a.f = getChangingConfigurations();
        return this.f203a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            AbstractC0029b c = c();
            c.a();
            a(c);
            this.i = true;
        }
        return this;
    }

    AbstractC0029b c() {
        return this.f203a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.b.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0029b extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;
        final b c;
        Resources d;
        int e;
        int f;
        int g;
        SparseArray<Drawable.ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0029b(AbstractC0029b abstractC0029b, b bVar, Resources resources) {
            Resources resources2;
            this.e = TbsListener.ErrorCode.STARTDOWNLOAD_1;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.c = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0029b != null ? abstractC0029b.d : null;
            }
            this.d = resources2;
            this.e = b.a(resources, abstractC0029b != null ? abstractC0029b.e : 0);
            if (abstractC0029b != null) {
                this.f = abstractC0029b.f;
                this.g = abstractC0029b.g;
                this.x = true;
                this.y = true;
                this.k = abstractC0029b.k;
                this.n = abstractC0029b.n;
                this.z = abstractC0029b.z;
                this.A = abstractC0029b.A;
                this.B = abstractC0029b.B;
                this.C = abstractC0029b.C;
                this.D = abstractC0029b.D;
                this.E = abstractC0029b.E;
                this.F = abstractC0029b.F;
                this.G = abstractC0029b.G;
                this.H = abstractC0029b.H;
                this.I = abstractC0029b.I;
                this.J = abstractC0029b.J;
                this.K = abstractC0029b.K;
                if (abstractC0029b.e == this.e) {
                    if (abstractC0029b.l) {
                        this.m = new Rect(abstractC0029b.m);
                        this.l = true;
                    }
                    if (abstractC0029b.o) {
                        this.p = abstractC0029b.p;
                        this.q = abstractC0029b.q;
                        this.r = abstractC0029b.r;
                        this.s = abstractC0029b.s;
                        this.o = true;
                    }
                }
                if (abstractC0029b.t) {
                    this.u = abstractC0029b.u;
                    this.t = true;
                }
                if (abstractC0029b.v) {
                    this.w = abstractC0029b.w;
                    this.v = true;
                }
                Drawable[] drawableArr = abstractC0029b.i;
                this.i = new Drawable[drawableArr.length];
                this.j = abstractC0029b.j;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0029b.h;
                if (sparseArray != null) {
                    this.h = sparseArray.clone();
                } else {
                    this.h = new SparseArray<>(this.j);
                }
                int i = this.j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.h.put(i2, constantState);
                        } else {
                            this.i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.i = new Drawable[10];
            this.j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f | this.g;
        }

        public final int a(Drawable drawable) {
            int i = this.j;
            if (i >= this.i.length) {
                e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.c);
            this.i[i] = drawable;
            this.j++;
            this.g = drawable.getChangingConfigurations() | this.g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int c() {
            return this.i.length;
        }

        private void o() {
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.i[this.h.keyAt(i)] = b(this.h.valueAt(i).newDrawable(this.d));
                }
                this.h = null;
            }
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.c);
            return mutate;
        }

        public final int d() {
            return this.j;
        }

        public final Drawable b(int i) {
            int indexOfKey;
            Drawable drawable = this.i[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable b = b(this.h.valueAt(indexOfKey).newDrawable(this.d));
            this.i[i] = b;
            this.h.removeAt(indexOfKey);
            if (this.h.size() == 0) {
                this.h = null;
            }
            return b;
        }

        final boolean d(int i, int i2) {
            int i3 = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.B = i;
            return z;
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.d = resources;
                int a2 = b.a(resources, this.e);
                int i = this.e;
                this.e = a2;
                if (i != a2) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                o();
                int i = this.j;
                Drawable[] drawableArr = this.i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.A = true;
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final Rect e() {
            if (this.k) {
                return null;
            }
            if (this.m != null || this.l) {
                return this.m;
            }
            o();
            Rect rect = new Rect();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.l = true;
            this.m = rect2;
            return rect2;
        }

        public final void b(boolean z) {
            this.n = z;
        }

        public final boolean f() {
            return this.n;
        }

        public final int g() {
            if (!this.o) {
                k();
            }
            return this.p;
        }

        public final int h() {
            if (!this.o) {
                k();
            }
            return this.q;
        }

        public final int i() {
            if (!this.o) {
                k();
            }
            return this.r;
        }

        public final int j() {
            if (!this.o) {
                k();
            }
            return this.s;
        }

        protected void k() {
            this.o = true;
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            this.q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.q) {
                    this.q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r) {
                    this.r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
            }
        }

        public final void c(int i) {
            this.C = i;
        }

        public final void d(int i) {
            this.D = i;
        }

        public final int l() {
            if (this.t) {
                return this.u;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.u = opacity;
            this.t = true;
            return opacity;
        }

        public final boolean m() {
            if (this.v) {
                return this.w;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.w = z;
            this.v = true;
            return z;
        }

        public void e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.i, 0, drawableArr, 0, i);
            this.i = drawableArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized boolean n() {
            if (this.x) {
                return this.y;
            }
            o();
            this.x = true;
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.y = false;
                    return false;
                }
            }
            this.y = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0029b abstractC0029b) {
        this.f203a = abstractC0029b;
        int i = this.g;
        if (i >= 0) {
            this.c = abstractC0029b.b(i);
            Drawable drawable = this.c;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.h = -1;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f205a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        public a a(Drawable.Callback callback) {
            this.f205a = callback;
            return this;
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f205a;
            this.f205a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f205a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f205a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        return i == 0 ? TbsListener.ErrorCode.STARTDOWNLOAD_1 : i;
    }
}
