package com.tencent.midas.http.core;

/* loaded from: classes.dex */
public interface ExecutableCall extends Runnable {
    void cancel();

    String getRequestName();
}
