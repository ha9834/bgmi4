package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
class SplashRecyclerView extends RecyclerView {
    private static final int INVALID_POINTER = -1;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mScrollPointerId;
    private int mTouchSlop;

    public SplashRecyclerView(Context context) {
        this(context, null);
    }

    public SplashRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollPointerId = -1;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i) {
        super.setScrollingTouchSlop(i);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                return;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            this.mInitialTouchX = (int) (motionEvent.getX() + 0.5f);
            this.mInitialTouchY = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                this.mInitialTouchX = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mInitialTouchY = (int) (motionEvent.getY(actionIndex) + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
        if (findPointerIndex < 0) {
            return false;
        }
        int x = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
        int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
        if (getScrollState() != 1) {
            int i = x - this.mInitialTouchX;
            int i2 = y - this.mInitialTouchY;
            boolean f = getLayoutManager().f();
            boolean g = getLayoutManager().g();
            boolean z = f && Math.abs(i) > this.mTouchSlop && (Math.abs(i) >= Math.abs(i2) || g);
            if (g && Math.abs(i2) > this.mTouchSlop && (Math.abs(i2) >= Math.abs(i) || f)) {
                z = true;
            }
            return z && super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
