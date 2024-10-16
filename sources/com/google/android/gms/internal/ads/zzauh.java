package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

@zzard
/* loaded from: classes2.dex */
public final class zzauh implements RewardItem {

    /* renamed from: a, reason: collision with root package name */
    private final zzatq f2804a;

    public zzauh(zzatq zzatqVar) {
        this.f2804a = zzatqVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzatq zzatqVar = this.f2804a;
        if (zzatqVar == null) {
            return null;
        }
        try {
            return zzatqVar.getType();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzatq zzatqVar = this.f2804a;
        if (zzatqVar == null) {
            return 0;
        }
        try {
            return zzatqVar.getAmount();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
