package com.facebook.internal;

import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class InternalSettings {
    public static final InternalSettings INSTANCE = new InternalSettings();
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String customUserAgent;

    public static /* synthetic */ void isUnityApp$annotations() {
    }

    private InternalSettings() {
    }

    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final void setCustomUserAgent(String str) {
        h.b(str, "value");
        customUserAgent = str;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return str != null && l.a(str, UNITY_PREFIX, false, 2, (Object) null);
    }
}
