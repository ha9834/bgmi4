package com.nostra13.universalimageloader.core.d;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

/* loaded from: classes2.dex */
public interface a {
    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingFailed(String str, View view, FailReason failReason);

    void onLoadingStarted(String str, View view);
}
