package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzaup extends zzatr {

    /* renamed from: a, reason: collision with root package name */
    private final String f2808a;
    private final int b;

    public zzaup(@Nullable zzato zzatoVar) {
        this(zzatoVar != null ? zzatoVar.type : "", zzatoVar != null ? zzatoVar.zzdqm : 1);
    }

    public zzaup(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaup(String str, int i) {
        this.f2808a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzatq
    public final String getType() throws RemoteException {
        return this.f2808a;
    }

    @Override // com.google.android.gms.internal.ads.zzatq
    public final int getAmount() throws RemoteException {
        return this.b;
    }
}
