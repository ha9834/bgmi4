package com.tencent.imsdk.android.webview.qq;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class BottomBehaviorPortrait extends CoordinatorLayout.b<LinearLayout> {
    public BottomBehaviorPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view) {
        return view instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view) {
        linearLayout.setTranslationY(-view.getTop());
        return true;
    }
}
