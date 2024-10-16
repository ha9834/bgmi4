package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.a.f;

/* loaded from: classes.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private final Context f337a;
    private final TypedArray b;
    private TypedValue c;

    public static au a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new au(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static au a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new au(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static au a(Context context, int i, int[] iArr) {
        return new au(context, context.obtainStyledAttributes(i, iArr));
    }

    private au(Context context, TypedArray typedArray) {
        this.f337a = context;
        this.b = typedArray;
    }

    public Drawable a(int i) {
        int resourceId;
        if (this.b.hasValue(i) && (resourceId = this.b.getResourceId(i, 0)) != 0) {
            return androidx.appcompat.a.a.a.b(this.f337a, resourceId);
        }
        return this.b.getDrawable(i);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.b().a(this.f337a, resourceId, true);
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return androidx.core.content.a.f.a(this.f337a, resourceId, this.c, i2, aVar);
    }

    public CharSequence c(int i) {
        return this.b.getText(i);
    }

    public String d(int i) {
        return this.b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        int resourceId;
        ColorStateList a2;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0 || (a2 = androidx.appcompat.a.a.a.a(this.f337a, resourceId)) == null) ? this.b.getColorStateList(i) : a2;
    }

    public int c(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public float b(int i, float f) {
        return this.b.getDimension(i, f);
    }

    public int d(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.b.hasValue(i);
    }

    public void a() {
        this.b.recycle();
    }
}
