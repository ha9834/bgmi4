package com.tencent.ieg.gpc.globalization.base.social;

/* loaded from: classes2.dex */
public interface GGShareListener {
    void onError(int i, Exception exc);

    void onProgressChanged(int i, long j, long j2);

    void onStateChanged(int i, GGShareState gGShareState);
}
