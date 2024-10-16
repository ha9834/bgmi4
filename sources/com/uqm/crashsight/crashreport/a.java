package com.uqm.crashsight.crashreport;

/* loaded from: classes.dex */
public interface a {
    void gpmProcessInfoGetPerfDataFromNative();

    long gpmProcessInfoGetSmapsMemFromNative();

    void gpmProcessInfoInitFromNative(int i);

    String readAppState();

    int readOomScoreFromNative();

    boolean setNativeIsAppForeground(boolean z);

    void updateAppState(String str);
}
