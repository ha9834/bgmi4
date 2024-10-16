package com.helpshift.applifecycle;

import android.content.Context;

/* loaded from: classes2.dex */
public interface HSAppLifeCycleListener {
    void onAppBackground(Context context);

    void onAppForeground(Context context);
}
