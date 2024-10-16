package com.vk.api.sdk.exceptions;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class IgnoredAccessTokenException extends VKApiExecutionException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoredAccessTokenException(String str) {
        super(-2, str, false, "Ignored Access Token", null, null, null, null, 0, 496, null);
        h.b(str, FirebaseAnalytics.Param.METHOD);
    }
}
