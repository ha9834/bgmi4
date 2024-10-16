package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblv implements zzbls {

    /* renamed from: a, reason: collision with root package name */
    private zzaxb f2920a;

    public zzblv(zzaxb zzaxbVar) {
        this.f2920a = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzk(Map<String, String> map) {
        this.f2920a.zzaj(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
