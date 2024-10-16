package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a2 = androidx.appcompat.a.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b = androidx.appcompat.a.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b;
    }
}
