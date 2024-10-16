package com.vk.api.sdk.exceptions;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class RateLimitReachedException extends VKApiExecutionException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RateLimitReachedException(String str, String str2) {
        super(29, str, false, str2, null, null, null, null, 0, 496, null);
        h.b(str, FirebaseAnalytics.Param.METHOD);
        h.b(str2, "message");
    }
}
