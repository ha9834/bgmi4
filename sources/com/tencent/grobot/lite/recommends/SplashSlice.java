package com.tencent.grobot.lite.recommends;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.recommends.SplashAdapter;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SplashSlice extends Slice implements Handler.Callback {
    private static final int MSG_SPLASH = 10086;
    private static final String TAG = "SplashSlice";
    private final SplashAdapter adapter;
    private FrameLayout flRoot;
    private final Handler handler;
    private final int horizonPadding;
    private RecyclerView rvList;

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashSlice(Feeds feeds) {
        super(feeds);
        this.adapter = new SplashAdapter(this.context);
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.horizonPadding = ViewUtils.dip2px(this.context, 6.0f);
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public View view() {
        this.rvList = new SplashRecyclerView(this.context);
        this.rvList.setPadding(0, ViewUtils.dip2px(this.context, 11.0f), 0, 0);
        this.rvList.setClipToPadding(false);
        this.rvList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.rvList.addItemDecoration(new DividerDecoration(this.context, 8.0f));
        this.rvList.setAdapter(this.adapter);
        this.flRoot = new FrameLayout(this.context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        this.flRoot.addView(this.rvList, layoutParams);
        FrameLayout frameLayout = this.flRoot;
        int i = this.horizonPadding;
        frameLayout.setPadding(i, 0, i, 0);
        return this.flRoot;
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void fixNotchScreen() {
        if (SystemUtils.hasNotch(this.context)) {
            int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
            boolean z = LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1;
            TLog.d(TAG, "fixNotchScreen, padding=" + SystemUtils.getStatusBarHeight(this.context) + ", rotation=" + rotation + ", rtl=" + z);
            int safeInsetLeft = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetLeft(this.context) : SystemUtils.getStatusBarHeight(this.context);
            if (rotation == 1) {
                if (!z) {
                    FrameLayout frameLayout = this.flRoot;
                    int i = this.horizonPadding;
                    frameLayout.setPadding(safeInsetLeft + i, 0, i, 0);
                    return;
                } else {
                    FrameLayout frameLayout2 = this.flRoot;
                    int i2 = this.horizonPadding;
                    frameLayout2.setPadding(i2, 0, i2, 0);
                    return;
                }
            }
            if (!z) {
                FrameLayout frameLayout3 = this.flRoot;
                int i3 = this.horizonPadding;
                frameLayout3.setPadding(i3, 0, i3, 0);
            } else {
                FrameLayout frameLayout4 = this.flRoot;
                int i4 = this.horizonPadding;
                frameLayout4.setPadding(safeInsetLeft + i4, 0, i4, 0);
            }
        }
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void start(Object... objArr) {
        this.adapter.setDatas((List) objArr[0]);
        this.handler.sendEmptyMessageDelayed(MSG_SPLASH, 5000L);
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void stop(Object... objArr) {
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != MSG_SPLASH) {
            return false;
        }
        this.handler.removeMessages(MSG_SPLASH);
        int childCount = this.rvList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerView = this.rvList;
            RecyclerView.w childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if (childViewHolder instanceof SplashAdapter.NodeA) {
                ((SplashAdapter.NodeA) childViewHolder).next();
            }
        }
        this.handler.sendEmptyMessageDelayed(MSG_SPLASH, 5000L);
        return true;
    }
}
