package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class ay {

    /* renamed from: a, reason: collision with root package name */
    private final zzajt f2062a;

    private ay(zzajt zzajtVar) {
        this.f2062a = zzajtVar;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.f2062a.zzcs(str);
    }
}
