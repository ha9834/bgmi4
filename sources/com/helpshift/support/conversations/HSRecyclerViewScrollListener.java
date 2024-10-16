package com.helpshift.support.conversations;

import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class HSRecyclerViewScrollListener extends RecyclerView.n {
    private final RecyclerViewScrollCallback callback;
    private boolean isScrollStateChangeHandled = false;
    private final Handler uiHandler;

    /* loaded from: classes2.dex */
    interface RecyclerViewScrollCallback {
        void onScrolledToBottom();

        void onScrolledToTop();

        void onScrolling();
    }

    public HSRecyclerViewScrollListener(Handler handler, RecyclerViewScrollCallback recyclerViewScrollCallback) {
        this.uiHandler = handler;
        this.callback = recyclerViewScrollCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        this.isScrollStateChangeHandled = false;
        if (i == 0) {
            computeAndNotifyCallback(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (!this.isScrollStateChangeHandled || recyclerView.getScrollState() == 0) {
            this.isScrollStateChangeHandled = true;
            computeAndNotifyCallback(recyclerView);
        }
    }

    private void computeAndNotifyCallback(RecyclerView recyclerView) {
        View i;
        RecyclerView.i layoutManager = recyclerView.getLayoutManager();
        boolean z = true;
        if (layoutManager != null) {
            int I = layoutManager.I();
            int y = layoutManager.y();
            if (y > 0 && (i = layoutManager.i(y - 1)) != null) {
                int d = layoutManager.d(i);
                int i2 = d + 1;
                if (d != -1 && I != i2) {
                    z = false;
                }
            }
        }
        if (!recyclerView.canScrollVertically(-1)) {
            this.uiHandler.post(new Runnable() { // from class: com.helpshift.support.conversations.HSRecyclerViewScrollListener.1
                @Override // java.lang.Runnable
                public void run() {
                    HSRecyclerViewScrollListener.this.callback.onScrolledToTop();
                }
            });
        }
        if (z) {
            this.uiHandler.post(new Runnable() { // from class: com.helpshift.support.conversations.HSRecyclerViewScrollListener.2
                @Override // java.lang.Runnable
                public void run() {
                    HSRecyclerViewScrollListener.this.callback.onScrolledToBottom();
                }
            });
        }
        if (z) {
            return;
        }
        this.uiHandler.post(new Runnable() { // from class: com.helpshift.support.conversations.HSRecyclerViewScrollListener.3
            @Override // java.lang.Runnable
            public void run() {
                HSRecyclerViewScrollListener.this.callback.onScrolling();
            }
        });
    }
}
