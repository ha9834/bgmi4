package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.e;
import androidx.appcompat.c.a;
import androidx.b.h;
import androidx.core.content.a.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends androidx.appcompat.b.a.e implements androidx.core.graphics.drawable.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f197a = "a";
    private b b;
    private f c;
    private int d;
    private int e;
    private boolean f;

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super(null);
        this.d = -1;
        this.e = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a aVar = new a();
        aVar.b(context, resources, xmlPullParser, attributeSet, theme);
        return aVar;
    }

    @Override // androidx.appcompat.b.a.e
    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.b.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(a.b.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.c != null && (visible || z2)) {
            if (z) {
                this.c.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.c;
        if (fVar != null) {
            fVar.b();
            this.c = null;
            a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int a2 = this.b.a(iArr);
        boolean z = a2 != d() && (b(a2) || a(a2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean b(int i) {
        int d2;
        int a2;
        f c0028a;
        f fVar = this.c;
        if (fVar != null) {
            if (i == this.d) {
                return true;
            }
            if (i == this.e && fVar.c()) {
                fVar.d();
                this.d = this.e;
                this.e = i;
                return true;
            }
            d2 = this.d;
            fVar.b();
        } else {
            d2 = d();
        }
        this.c = null;
        this.e = -1;
        this.d = -1;
        b bVar = this.b;
        int a3 = bVar.a(d2);
        int a4 = bVar.a(i);
        if (a4 == 0 || a3 == 0 || (a2 = bVar.a(a3, a4)) < 0) {
            return false;
        }
        boolean c2 = bVar.c(a3, a4);
        a(a2);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0028a = new d((AnimationDrawable) current, bVar.b(a3, a4), c2);
        } else if (current instanceof androidx.h.a.a.c) {
            c0028a = new c((androidx.h.a.a.c) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            c0028a = new C0028a((Animatable) current);
        }
        c0028a.a();
        this.c = c0028a;
        this.e = d2;
        this.d = i;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0028a extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f198a;

        C0028a(Animatable animatable) {
            super();
            this.f198a = animatable;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f198a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f198a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f201a;
        private final boolean b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(eVar.a());
            ofInt.setInterpolator(eVar);
            this.b = z2;
            this.f201a = ofInt;
        }

        @Override // androidx.appcompat.b.a.a.f
        public boolean c() {
            return this.b;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f201a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void d() {
            this.f201a.reverse();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f201a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.h.a.a.c f200a;

        c(androidx.h.a.a.c cVar) {
            super();
            this.f200a = cVar;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f200a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f200a.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(a.b.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(a.b.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(a.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(a.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(a.b.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void e() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r0 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r10.getName().equals("animated-vector") == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        r4 = androidx.h.a.a.c.a(r8, r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r4 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        if (r1 == (-1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
    
        if (r3 == (-1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        return r7.b.a(r1, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ba, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
    
        if (r4 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        r0 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        if (r0 != 4) goto L32;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int d(android.content.Context r8, android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r7 = this;
            int[] r0 = androidx.appcompat.c.a.b.AnimatedStateListDrawableTransition
            android.content.res.TypedArray r0 = androidx.core.content.a.g.a(r9, r12, r11, r0)
            int r1 = androidx.appcompat.c.a.b.AnimatedStateListDrawableTransition_android_fromId
            r2 = -1
            int r1 = r0.getResourceId(r1, r2)
            int r3 = androidx.appcompat.c.a.b.AnimatedStateListDrawableTransition_android_toId
            int r3 = r0.getResourceId(r3, r2)
            int r4 = androidx.appcompat.c.a.b.AnimatedStateListDrawableTransition_android_drawable
            int r4 = r0.getResourceId(r4, r2)
            if (r4 <= 0) goto L24
            androidx.appcompat.widget.ak r5 = androidx.appcompat.widget.ak.a()
            android.graphics.drawable.Drawable r4 = r5.a(r8, r4)
            goto L25
        L24:
            r4 = 0
        L25:
            int r5 = androidx.appcompat.c.a.b.AnimatedStateListDrawableTransition_android_reversible
            r6 = 0
            boolean r5 = r0.getBoolean(r5, r6)
            r0.recycle()
            if (r4 != 0) goto L78
        L31:
            int r0 = r10.next()
            r4 = 4
            if (r0 != r4) goto L39
            goto L31
        L39:
            r4 = 2
            if (r0 != r4) goto L5d
            java.lang.String r0 = r10.getName()
            java.lang.String r4 = "animated-vector"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L4d
            androidx.h.a.a.c r4 = androidx.h.a.a.c.a(r8, r9, r10, r11, r12)
            goto L78
        L4d:
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r8 < r0) goto L58
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11, r12)
            goto L78
        L58:
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11)
            goto L78
        L5d:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            java.lang.String r10 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L78:
            if (r4 == 0) goto La0
            if (r1 == r2) goto L85
            if (r3 == r2) goto L85
            androidx.appcompat.b.a.a$b r8 = r7.b
            int r8 = r8.a(r1, r3, r4, r5)
            return r8
        L85:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            java.lang.String r10 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        La0:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r9.append(r10)
            java.lang.String r10 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.a.d(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if (r5 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        if (r7.getName().equals("vector") == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r5 = androidx.h.a.a.i.a(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (r5 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        return r4.b.a(r0, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        if (r5 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        r5 = r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (r5 != 4) goto L28;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int e(android.content.Context r5, android.content.res.Resources r6, org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, android.content.res.Resources.Theme r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int[] r0 = androidx.appcompat.c.a.b.AnimatedStateListDrawableItem
            android.content.res.TypedArray r0 = androidx.core.content.a.g.a(r6, r9, r8, r0)
            int r1 = androidx.appcompat.c.a.b.AnimatedStateListDrawableItem_android_id
            r2 = 0
            int r1 = r0.getResourceId(r1, r2)
            int r2 = androidx.appcompat.c.a.b.AnimatedStateListDrawableItem_android_drawable
            r3 = -1
            int r2 = r0.getResourceId(r2, r3)
            if (r2 <= 0) goto L1f
            androidx.appcompat.widget.ak r3 = androidx.appcompat.widget.ak.a()
            android.graphics.drawable.Drawable r5 = r3.a(r5, r2)
            goto L20
        L1f:
            r5 = 0
        L20:
            r0.recycle()
            int[] r0 = r4.a(r8)
            if (r5 != 0) goto L70
        L29:
            int r5 = r7.next()
            r2 = 4
            if (r5 != r2) goto L31
            goto L29
        L31:
            r2 = 2
            if (r5 != r2) goto L55
            java.lang.String r5 = r7.getName()
            java.lang.String r2 = "vector"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L45
            androidx.h.a.a.i r5 = androidx.h.a.a.i.a(r6, r7, r8, r9)
            goto L70
        L45:
            int r5 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r5 < r2) goto L50
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8, r9)
            goto L70
        L50:
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8)
            goto L70
        L55:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r6.append(r7)
            java.lang.String r7 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L70:
            if (r5 == 0) goto L79
            androidx.appcompat.b.a.a$b r6 = r4.b
            int r5 = r6.a(r0, r5, r1)
            return r5
        L79:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r6.append(r7)
            java.lang.String r7 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.a.e(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.b.a();
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b c() {
        return new b(this.b, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        androidx.b.d<Long> f199a;
        h<Integer> b;

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f199a = bVar.f199a;
                this.b = bVar.b;
            } else {
                this.f199a = new androidx.b.d<>();
                this.b = new h<>();
            }
        }

        @Override // androidx.appcompat.b.a.e.a, androidx.appcompat.b.a.b.AbstractC0029b
        void a() {
            this.f199a = this.f199a.clone();
            this.b = this.b.clone();
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a2;
            this.f199a.c(f, Long.valueOf(j2 | j));
            if (z) {
                this.f199a.c(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a2 = super.a(iArr, drawable);
            this.b.b(a2, Integer.valueOf(i));
            return a2;
        }

        int a(int[] iArr) {
            int b = super.b(iArr);
            return b >= 0 ? b : super.b(StateSet.WILD_CARD);
        }

        int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.b.a(i, 0).intValue();
        }

        int a(int i, int i2) {
            return (int) this.f199a.a(f(i, i2), -1L).longValue();
        }

        boolean b(int i, int i2) {
            return (this.f199a.a(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean c(int i, int i2) {
            return (this.f199a.a(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.b.a.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.b.a.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b
    void a(b.AbstractC0029b abstractC0029b) {
        super.a(abstractC0029b);
        if (abstractC0029b instanceof b) {
            this.b = (b) abstractC0029b;
        }
    }

    /* loaded from: classes.dex */
    private static class e implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f202a;
        private int b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.f202a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f202a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f202a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.f202a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }
}
