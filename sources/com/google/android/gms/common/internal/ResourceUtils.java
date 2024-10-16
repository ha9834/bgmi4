package com.google.android.gms.common.internal;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class ResourceUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f1461a = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    private ResourceUtils() {
    }
}
