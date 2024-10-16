package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcnk implements zzcjz<zzams, zzclb> {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<String, zzcjy<zzams, zzclb>> f3338a = new HashMap();
    private final zzclc b;

    public zzcnk(zzclc zzclcVar) {
        this.b = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzams, zzclb> zzd(String str, JSONObject jSONObject) throws Throwable {
        synchronized (this) {
            zzcjy<zzams, zzclb> zzcjyVar = this.f3338a.get(str);
            if (zzcjyVar == null) {
                zzams zze = this.b.zze(str, jSONObject);
                if (zze == null) {
                    return null;
                }
                zzcjyVar = new zzcjy<>(zze, new zzclb(), str);
                this.f3338a.put(str, zzcjyVar);
            }
            return zzcjyVar;
        }
    }
}
