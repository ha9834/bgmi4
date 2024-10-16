package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzct {

    /* renamed from: a, reason: collision with root package name */
    private final String f4547a;
    private final Uri b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;

    @Nullable
    private final zzcx<Context, Boolean> i;

    public zzct(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzct(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcx<Context, Boolean> zzcxVar) {
        this.f4547a = null;
        this.b = uri;
        this.c = str2;
        this.d = str3;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
    }

    public final zzcm<Long> zze(String str, long j) {
        return zzcm.a(this, str, j);
    }

    public final zzcm<Boolean> zzb(String str, boolean z) {
        return zzcm.a(this, str, z);
    }

    public final zzcm<Double> zza(String str, double d) {
        return zzcm.a(this, str, -3.0d);
    }

    public final zzcm<String> zzt(String str, String str2) {
        return zzcm.a(this, str, str2);
    }
}
