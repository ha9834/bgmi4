package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class zzcvj implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3458a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;

    public zzcvj(String str, int i, int i2, int i3, boolean z, int i4) {
        this.f3458a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxz.zza(bundle2, "carrier", this.f3458a, !TextUtils.isEmpty(r1));
        zzcxz.zza(bundle2, "cnt", Integer.valueOf(this.b), this.b != -2);
        bundle2.putInt("gnt", this.c);
        bundle2.putInt("pt", this.d);
        Bundle zza = zzcxz.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzcxz.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.f);
        zza2.putBoolean("active_network_metered", this.e);
    }
}
