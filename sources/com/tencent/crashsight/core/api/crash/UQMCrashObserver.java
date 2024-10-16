package com.tencent.crashsight.core.api.crash;

/* loaded from: classes2.dex */
public interface UQMCrashObserver {
    byte[] OnCrashExtraDataNotify();

    String OnCrashExtraMessageNotify();
}
