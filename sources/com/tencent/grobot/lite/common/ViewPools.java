package com.tencent.grobot.lite.common;

import android.util.SparseArray;
import android.view.View;
import androidx.core.e.d;

/* loaded from: classes2.dex */
public final class ViewPools implements ComponentRef {
    public static final int TYPE_COUNT = 3;
    public static final int TYPE_LIKE_AND_UNLIKE = 0;
    public static final int TYPE_RECOMMEND_ITEM = 2;
    public static final int TYPE_RECOMMEND_SUB = 1;
    private SparseArray<d.a<View>> pools = new SparseArray<>(3);
    private static final Object sLock = new Object();
    private static ViewPools sInstance = null;

    public static ViewPools getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new ViewPools();
                }
            }
        }
        return sInstance;
    }

    public static void destory() {
        ViewPools viewPools = sInstance;
        if (viewPools != null) {
            viewPools.onDestroy();
        }
        sInstance = null;
    }

    private ViewPools() {
        this.pools.append(0, new d.b(100));
        this.pools.append(1, new d.b(100));
        this.pools.append(2, new d.b(20));
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        this.pools.clear();
    }

    public View acquire(int i) {
        d.a<View> aVar = this.pools.get(i);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public boolean release(int i, View view) {
        return this.pools.get(i).a(view);
    }
}
