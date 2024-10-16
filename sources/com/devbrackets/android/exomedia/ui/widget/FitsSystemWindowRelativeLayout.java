package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class FitsSystemWindowRelativeLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private Rect f1040a;

    public FitsSystemWindowRelativeLayout(Context context) {
        super(context);
        a();
    }

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @TargetApi(21)
    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (b()) {
            a();
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        a(rect);
        return false;
    }

    @Override // android.view.View
    @TargetApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        fitSystemWindows(new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()));
        return windowInsets;
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 14) {
            setFitsSystemWindows(true);
        }
        if (this.f1040a == null) {
            this.f1040a = new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        a(new Rect());
    }

    private void a(Rect rect) {
        setPadding(this.f1040a.left + rect.left, this.f1040a.top + rect.top, this.f1040a.right + rect.right, this.f1040a.bottom + rect.bottom);
    }

    private boolean b() {
        return getResources().getConfiguration().smallestScreenWidthDp <= 600;
    }
}
