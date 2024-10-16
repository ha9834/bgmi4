package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tencent.midas.oversea.comm.MConstants;

/* loaded from: classes2.dex */
public final class zzcuv implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3451a;
    private final boolean b;
    private final String c;
    private final boolean d;
    private final int e;
    private final int f;

    public zzcuv(boolean z, boolean z2, String str, boolean z3, int i, int i2) {
        this.f3451a = z;
        this.b = z2;
        this.c = str;
        this.d = z3;
        this.e = i;
        this.f = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.c);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzyt.zzpe().zzd(zzacu.zzcrv));
        bundle2.putInt("target_api", this.e);
        bundle2.putInt("dv", this.f);
        Bundle zza = zzcxz.zza(bundle2, "sdk_env");
        zza.putBoolean("mf", ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrx)).booleanValue());
        zza.putBoolean("instant_app", this.f3451a);
        zza.putBoolean("lite", this.b);
        zza.putBoolean("is_privileged_process", this.d);
        bundle2.putBundle("sdk_env", zza);
        Bundle zza2 = zzcxz.zza(zza, "build_meta");
        zza2.putString("cl", "248613007");
        zza2.putString("rapid_rc", MConstants.DevEnv);
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
