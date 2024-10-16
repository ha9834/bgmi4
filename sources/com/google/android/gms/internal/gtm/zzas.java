package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzas {

    /* renamed from: a, reason: collision with root package name */
    private final long f4389a;
    private final String b;
    private final String c;
    private final boolean d;
    private long e;
    private final Map<String, String> f;

    public zzas(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.f4389a = 0L;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = j2;
        if (map != null) {
            this.f = new HashMap(map);
        } else {
            this.f = Collections.emptyMap();
        }
    }

    public final long zzdi() {
        return this.f4389a;
    }

    public final String zzbt() {
        return this.b;
    }

    public final String zzdj() {
        return this.c;
    }

    public final boolean zzdk() {
        return this.d;
    }

    public final long zzdl() {
        return this.e;
    }

    public final void zzb(long j) {
        this.e = j;
    }

    public final Map<String, String> zzdm() {
        return this.f;
    }
}
