package com.tencent.imsdk.android.webview.qq;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.f.i;
import androidx.core.f.j;
import androidx.core.f.m;
import com.tencent.imsdk.android.webview.qq.notch.IMSDKNotch;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes.dex */
public class NestedWebView extends WebView implements View.OnTouchListener, j {
    private m mChildHelper;
    private int mLastY;
    private int mNestedOffsetY;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;

    public NestedWebView(Context context) {
        this(context, null);
    }

    public NestedWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.webViewStyle);
    }

    public NestedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mChildHelper = new m(this);
        setNestedScrollingEnabled(true);
        setOnTouchListener(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a2 = i.a(obtain);
        boolean z = false;
        if (a2 == 0) {
            this.mNestedOffsetY = 0;
        }
        int y = (int) obtain.getY();
        obtain.offsetLocation(0.0f, this.mNestedOffsetY);
        switch (a2) {
            case 0:
                z = super.onTouchEvent(obtain);
                this.mLastY = y;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                z = super.onTouchEvent(obtain);
                stopNestedScroll();
                break;
            case 2:
                int i2 = this.mLastY - y;
                if (dispatchNestedPreScroll(0, i2, this.mScrollConsumed, this.mScrollOffset)) {
                    int i3 = i2 - this.mScrollConsumed[1];
                    this.mLastY = y - this.mScrollOffset[1];
                    obtain.offsetLocation(0.0f, -r1[1]);
                    this.mNestedOffsetY += this.mScrollOffset[1];
                    i = i3;
                } else {
                    i = i2;
                }
                z = super.onTouchEvent(obtain);
                int[] iArr = this.mScrollOffset;
                if (dispatchNestedScroll(0, iArr[1], 0, i, iArr)) {
                    obtain.offsetLocation(0.0f, this.mScrollOffset[1]);
                    int i4 = this.mNestedOffsetY;
                    int[] iArr2 = this.mScrollOffset;
                    this.mNestedOffsetY = i4 + iArr2[1];
                    this.mLastY -= iArr2[1];
                    break;
                }
                break;
        }
        obtain.recycle();
        return z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.a(z);
    }

    @Override // android.view.View, androidx.core.f.j
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.b(i);
    }

    @Override // android.view.View, androidx.core.f.j
    public void stopNestedScroll() {
        this.mChildHelper.c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.a(f, f2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 28) {
            IMSDKNotch.setDisplayCutout(windowInsets.getDisplayCutout());
        }
        return super.onApplyWindowInsets(windowInsets);
    }
}
