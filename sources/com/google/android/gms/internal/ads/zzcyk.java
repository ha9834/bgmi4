package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcyk {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, zzcym> f3501a = new HashMap();
    private final Context b;
    private final zzawm c;
    private final zzbai d;
    private final zzdh e;

    public zzcyk(Context context, zzbai zzbaiVar, zzawm zzawmVar) {
        this.b = context;
        this.d = zzbaiVar;
        this.c = zzawmVar;
        this.e = new zzdh(new com.google.android.gms.ads.internal.zzg(context, zzbaiVar));
    }

    public final zzcym zzfw(String str) {
        if (str == null) {
            return a();
        }
        if (this.f3501a.containsKey(str)) {
            return this.f3501a.get(str);
        }
        zzcym a2 = a(str);
        this.f3501a.put(str, a2);
        return a2;
    }

    private final zzcym a() {
        return new zzcym(this.b, this.c.zzvc(), this.c.zzve(), this.e);
    }

    private final zzcym a(String str) {
        zzasq zzv = zzasq.zzv(this.b);
        try {
            zzv.setAppPackageName(str);
            zzaxc zzaxcVar = new zzaxc();
            zzaxcVar.zza(this.b, str, false);
            zzaxf zzaxfVar = new zzaxf(this.c.zzvc(), zzaxcVar);
            return new zzcym(zzv, zzaxfVar, new zzawu(zzazt.zzwz(), zzaxfVar), new zzdh(new com.google.android.gms.ads.internal.zzg(this.b, this.d)));
        } catch (PackageManager.NameNotFoundException unused) {
            return a();
        }
    }
}
