package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbss extends zzbts<AdMetadataListener> implements zzagv {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f3036a;

    public zzbss(Set<zzbuz<AdMetadataListener>> set) {
        super(set);
        this.f3036a = new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void zza(String str, Bundle bundle) {
        this.f3036a.putAll(bundle);
        a(op.f2399a);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.f3036a);
    }
}
