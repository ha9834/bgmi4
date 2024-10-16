package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbmb implements zzbls {

    /* renamed from: a, reason: collision with root package name */
    private final zzaxb f2927a;

    public zzbmb(zzaxb zzaxbVar) {
        this.f2927a = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzk(Map<String, String> map) {
        String str = map.get("key");
        String str2 = map.get("value");
        if ("auto_collect_location".equals(str)) {
            this.f2927a.zzak(Boolean.parseBoolean(str2));
        }
    }
}
