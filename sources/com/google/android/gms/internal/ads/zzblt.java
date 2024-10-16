package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblt implements zzbls {

    /* renamed from: a, reason: collision with root package name */
    private zzaxb f2918a;

    public zzblt(zzaxb zzaxbVar) {
        this.f2918a = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzk(Map<String, String> map) {
        this.f2918a.zzai(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
