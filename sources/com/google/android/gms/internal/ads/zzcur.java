package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcur implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3448a;
    private final String b;
    private final String c;
    private final String d;
    private final Long e;

    public zzcur(String str, String str2, String str3, String str4, Long l) {
        this.f3448a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = l;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxz.zza(bundle2, "gmp_app_id", this.f3448a);
        zzcxz.zza(bundle2, "fbs_aiid", this.b);
        zzcxz.zza(bundle2, "fbs_aeid", this.c);
        zzcxz.zza(bundle2, "apm_id_origin", this.d);
        Long l = this.e;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
