package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbmg {

    /* renamed from: a, reason: collision with root package name */
    private final String f2932a;
    private final zzaly b;
    private final Executor c;
    private zzbmn d;
    private final zzaho<Object> e = new na(this);
    private final zzaho<Object> f = new nc(this);

    public zzbmg(String str, zzaly zzalyVar, Executor executor) {
        this.f2932a = str;
        this.b = zzalyVar;
        this.c = executor;
    }

    public final void zza(zzbmn zzbmnVar) {
        this.b.zzc("/updateActiveView", this.e);
        this.b.zzc("/untrackActiveViewUnit", this.f);
        this.d = zzbmnVar;
    }

    public final void zzd(zzbgz zzbgzVar) {
        zzbgzVar.zza("/updateActiveView", this.e);
        zzbgzVar.zza("/untrackActiveViewUnit", this.f);
    }

    public final void zze(zzbgz zzbgzVar) {
        zzbgzVar.zzb("/updateActiveView", this.e);
        zzbgzVar.zzb("/untrackActiveViewUnit", this.f);
    }

    public final void zzafc() {
        this.b.zzd("/updateActiveView", this.e);
        this.b.zzd("/untrackActiveViewUnit", this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.f2932a);
    }
}
