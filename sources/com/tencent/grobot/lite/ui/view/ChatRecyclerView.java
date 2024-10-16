package com.tencent.grobot.lite.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.ui.adapter.HFWrapper;
import com.tencent.grobot.lite.ui.adapter.RecyclerViewHeader;

/* loaded from: classes2.dex */
public class ChatRecyclerView extends RecyclerView {
    private static final float OFFSET_RADIO = 1.5f;
    private static final int SCROLLBACK_HEADER = 0;
    public static final int SCROLL_DURATION = 100;
    HFWrapper adapterWrapper;
    private RecyclerViewHeader mHeaderView;
    private float mLastY;
    private OnRefreshListener mOnRefreshListener;
    private boolean mPullRefreshing;
    private int mScrollBack;
    private Scroller mScroller;

    /* loaded from: classes2.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public ChatRecyclerView(Context context) {
        this(context, null);
    }

    public ChatRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastY = -1.0f;
        this.mPullRefreshing = false;
        init(context);
    }

    private void init(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        linearLayoutManager.c(true);
        setLayoutManager(linearLayoutManager);
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        this.mHeaderView = new RecyclerViewHeader(context);
        this.mHeaderView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LayoutInflater.from(context);
    }

    public int getHeaderCount() {
        HFWrapper hFWrapper = this.adapterWrapper;
        if (hFWrapper != null) {
            return hFWrapper.getHeadersCount();
        }
        return 0;
    }

    public int getFooterCount() {
        HFWrapper hFWrapper = this.adapterWrapper;
        if (hFWrapper != null) {
            return hFWrapper.getFootersCount();
        }
        return 0;
    }

    public void showFooter(boolean z) {
        HFWrapper hFWrapper;
        RecyclerView.i layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int n = linearLayoutManager.n();
            int p = linearLayoutManager.p();
            int itemCount = this.adapterWrapper.getItemCount() - 1;
            if (itemCount - n <= 0 || itemCount > p || (hFWrapper = this.adapterWrapper) == null) {
                return;
            }
            hFWrapper.showFooter(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.a aVar) {
        if (aVar != null) {
            this.adapterWrapper = new HFWrapper(aVar);
            aVar.registerAdapterDataObserver(new RecyclerView.c() { // from class: com.tencent.grobot.lite.ui.view.ChatRecyclerView.1
                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onChanged() {
                    ChatRecyclerView.this.adapterWrapper.notifyDataSetChanged();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onItemRangeChanged(int i, int i2) {
                    ChatRecyclerView.this.adapterWrapper.notifyItemRangeChanged(i + ChatRecyclerView.this.adapterWrapper.mHeaderViews.size(), i2);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onItemRangeChanged(int i, int i2, Object obj) {
                    ChatRecyclerView.this.adapterWrapper.notifyItemRangeChanged(i + ChatRecyclerView.this.adapterWrapper.mHeaderViews.size(), i2);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onItemRangeInserted(int i, int i2) {
                    ChatRecyclerView.this.adapterWrapper.notifyItemRangeInserted(i + ChatRecyclerView.this.adapterWrapper.mHeaderViews.size(), i2);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onItemRangeRemoved(int i, int i2) {
                    ChatRecyclerView.this.adapterWrapper.notifyItemRangeRemoved(i + ChatRecyclerView.this.adapterWrapper.mHeaderViews.size(), i2);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.c
                public void onItemRangeMoved(int i, int i2, int i3) {
                    ChatRecyclerView.this.adapterWrapper.notifyDataSetChanged();
                }
            });
            super.setAdapter(this.adapterWrapper);
            this.adapterWrapper.addHeaderView(this.mHeaderView);
            this.adapterWrapper.addFooter(R.layout.chat_loading_dot);
            return;
        }
        super.setAdapter(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mLastY == -1.0f) {
            this.mLastY = motionEvent.getRawY();
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getRawY();
                break;
            case 1:
                this.mLastY = -1.0f;
                if (((LinearLayoutManager) getLayoutManager()).o() == 0 || ((LinearLayoutManager) getLayoutManager()).o() == 1) {
                    if (this.mHeaderView.getVisibleHeight() > this.mHeaderView.getRealityHeight()) {
                        this.mPullRefreshing = true;
                        OnRefreshListener onRefreshListener = this.mOnRefreshListener;
                        if (onRefreshListener != null) {
                            onRefreshListener.onRefresh();
                        }
                    }
                    resetHeaderHeight();
                    break;
                } else {
                    resetHeaderHeight();
                    break;
                }
            case 2:
                float rawY = motionEvent.getRawY();
                float f = rawY - this.mLastY;
                this.mLastY = rawY;
                if (isSlideToTop() && f > 0.0f) {
                    updateHeaderHeight(f / OFFSET_RADIO);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean isSlideToTop() {
        RecyclerView.i layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).n() <= 1;
        }
        return !canScrollVertically(1);
    }

    private void updateHeaderHeight(float f) {
        RecyclerViewHeader recyclerViewHeader = this.mHeaderView;
        recyclerViewHeader.setVisibleHeight(((int) f) + recyclerViewHeader.getVisibleHeight());
        smoothScrollBy(0, 0);
    }

    private void resetHeaderHeight() {
        int visibleHeight = this.mHeaderView.getVisibleHeight();
        if (visibleHeight == 0) {
            return;
        }
        if (!this.mPullRefreshing || visibleHeight > this.mHeaderView.getRealityHeight()) {
            int realityHeight = (!this.mPullRefreshing || visibleHeight <= this.mHeaderView.getRealityHeight()) ? 0 : this.mHeaderView.getRealityHeight();
            this.mScrollBack = 0;
            this.mScroller.startScroll(0, visibleHeight, 0, realityHeight - visibleHeight, 100);
            invalidate();
        }
    }

    public void stopRefresh(boolean z) {
        this.mScrollBack = 0;
        int visibleHeight = this.mHeaderView.getVisibleHeight();
        this.mHeaderView.setPullText(z);
        if (this.mPullRefreshing) {
            this.mPullRefreshing = false;
            this.mScroller.startScroll(0, visibleHeight, 0, 0 - visibleHeight, 100);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScrollBack == 0) {
                this.mHeaderView.setVisibleHeight(this.mScroller.getCurrY());
            }
            postInvalidate();
        }
        super.computeScroll();
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    public void onDestory() {
        HFWrapper hFWrapper = this.adapterWrapper;
        if (hFWrapper != null) {
            hFWrapper.mHeaderViews.clear();
            this.adapterWrapper = null;
        }
        this.mHeaderView = null;
    }
}
