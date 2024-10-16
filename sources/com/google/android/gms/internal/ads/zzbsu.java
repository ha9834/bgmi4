package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbsu implements zzdti<zzbss> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<AdMetadataListener>>> f3037a;

    private zzbsu(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtuVar) {
        this.f3037a = zzdtuVar;
    }

    public static zzbsu zzr(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtuVar) {
        return new zzbsu(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbss(this.f3037a.get());
    }
}
