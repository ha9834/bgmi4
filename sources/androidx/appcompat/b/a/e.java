package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.c.a;
import androidx.core.content.a.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    private a f208a;
    private boolean b;

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    e() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.f208a.b(iArr);
        if (b < 0) {
            b = this.f208a.b(StateSet.WILD_CARD);
        }
        return a(b) || onStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.b.StateListDrawable);
        setVisible(a2.getBoolean(a.b.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.f208a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(a.b.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(a.b.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(a.b.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(a.b.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(a.b.StateListDrawable_android_dither, aVar.z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r4 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r4 = r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        if (r4 != 4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r4 != 2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r11.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        r0.a(r3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r9, android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            androidx.appcompat.b.a.e$a r0 = r8.f208a
            int r1 = r11.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L8:
            int r3 = r11.next()
            if (r3 == r2) goto L84
            int r4 = r11.getDepth()
            if (r4 >= r1) goto L17
            r5 = 3
            if (r3 == r5) goto L84
        L17:
            r5 = 2
            if (r3 == r5) goto L1b
            goto L8
        L1b:
            if (r4 > r1) goto L8
            java.lang.String r3 = r11.getName()
            java.lang.String r4 = "item"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L2a
            goto L8
        L2a:
            int[] r3 = androidx.appcompat.c.a.b.StateListDrawableItem
            android.content.res.TypedArray r3 = androidx.core.content.a.g.a(r10, r13, r12, r3)
            r4 = 0
            int r6 = androidx.appcompat.c.a.b.StateListDrawableItem_android_drawable
            r7 = -1
            int r6 = r3.getResourceId(r6, r7)
            if (r6 <= 0) goto L42
            androidx.appcompat.widget.ak r4 = androidx.appcompat.widget.ak.a()
            android.graphics.drawable.Drawable r4 = r4.a(r9, r6)
        L42:
            r3.recycle()
            int[] r3 = r8.a(r12)
            if (r4 != 0) goto L80
        L4b:
            int r4 = r11.next()
            r6 = 4
            if (r4 != r6) goto L53
            goto L4b
        L53:
            if (r4 != r5) goto L65
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r4 < r5) goto L60
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12, r13)
            goto L80
        L60:
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12)
            goto L80
        L65:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r11.getPositionDescription()
            r10.append(r11)
            java.lang.String r11 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L80:
            r0.a(r3, r4)
            goto L8
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.e.a(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.f208a.a();
            this.b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.b
    /* renamed from: b */
    public a c() {
        return new a(this.f208a, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends b.AbstractC0029b {
        int[][] L;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()];
            }
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0029b
        void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.L[a2] = iArr;
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d = d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0029b
        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.b
    public void a(b.AbstractC0029b abstractC0029b) {
        super.a(abstractC0029b);
        if (abstractC0029b instanceof a) {
            this.f208a = (a) abstractC0029b;
        }
    }

    e(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
