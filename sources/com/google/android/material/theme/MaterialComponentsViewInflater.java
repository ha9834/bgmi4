package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.f;
import com.google.android.material.b.a;

@Keep
/* loaded from: classes2.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected f createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
