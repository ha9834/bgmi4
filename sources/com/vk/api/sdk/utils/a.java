package com.vk.api.sdk.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.api.sdk.exceptions.VKApiException;

/* loaded from: classes3.dex */
public final class a {
    public static final boolean a(String str, int[] iArr) {
        kotlin.jvm.internal.h.b(str, "<this>");
        return com.vk.api.sdk.internal.d.f6884a.a(str, iArr);
    }

    public static final boolean a(String str) {
        kotlin.jvm.internal.h.b(str, "<this>");
        return com.vk.api.sdk.internal.d.f6884a.a(str);
    }

    public static final VKApiException a(String str, String str2, String str3) {
        kotlin.jvm.internal.h.b(str, "<this>");
        return com.vk.api.sdk.internal.d.f6884a.a(str, str2, str3);
    }

    public static final VKApiException a(String str, String str2, int[] iArr) {
        kotlin.jvm.internal.h.b(str, "<this>");
        kotlin.jvm.internal.h.b(str2, FirebaseAnalytics.Param.METHOD);
        return com.vk.api.sdk.internal.d.f6884a.a(str, str2, iArr);
    }
}
