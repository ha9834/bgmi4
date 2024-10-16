package com.helpshift.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.j.b;

/* loaded from: classes2.dex */
public class HSTabLayout extends b {
    public HSTabLayout(Context context) {
        super(context);
        init();
    }

    public HSTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HSTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        FontApplier.apply(this);
    }
}
