package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzctk implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxk f3429a;

    public zzctk(zzcxk zzcxkVar) {
        this.f3429a = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxk zzcxkVar = this.f3429a;
        if (zzcxkVar != null) {
            bundle2.putBoolean("render_in_browser", zzcxkVar.zzaml());
            bundle2.putBoolean("disable_ml", this.f3429a.zzamm());
        }
    }
}
