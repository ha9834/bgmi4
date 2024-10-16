package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcci implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final zzafo f3180a;
    private final zzccj b;
    private final zzdte<zzccd> c;

    public zzcci(zzbzc zzbzcVar, zzbyt zzbytVar, zzccj zzccjVar, zzdte<zzccd> zzdteVar) {
        this.f3180a = zzbzcVar.zzfo(zzbytVar.getCustomTemplateId());
        this.b = zzccjVar;
        this.c = zzdteVar;
    }

    public final void zzaji() {
        if (this.f3180a == null) {
            return;
        }
        this.b.zza("/nativeAdCustomClick", this);
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.f3180a.zza(this.c.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzawz.zzd(sb.toString(), e);
        }
    }
}
