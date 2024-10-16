package com.tencent.ieg.gpc.globalization.base.uploader;

/* loaded from: classes2.dex */
public interface GGUploaderListener {
    void onError(int i, Exception exc);

    void onProgressChanged(int i, long j, long j2);

    void onStateChanged(int i, GGUploaderState gGUploaderState, String str);
}
