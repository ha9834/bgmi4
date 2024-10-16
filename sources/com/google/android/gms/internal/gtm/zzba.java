package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzba extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private final zzq f4394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzap zzapVar) {
        super(zzapVar);
        this.f4394a = new zzq();
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        h().zzat().zzb(this.f4394a);
        zzda k = k();
        String zzaz = k.zzaz();
        if (zzaz != null) {
            this.f4394a.setAppName(zzaz);
        }
        String zzba = k.zzba();
        if (zzba != null) {
            this.f4394a.setAppVersion(zzba);
        }
    }

    public final zzq zzdv() {
        q();
        return this.f4394a;
    }
}
