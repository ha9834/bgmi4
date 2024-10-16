package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
final /* synthetic */ class ef implements zzbaf {

    /* renamed from: a, reason: collision with root package name */
    static final zzbaf f2144a = new ef();

    private ef() {
    }

    @Override // com.google.android.gms.internal.ads.zzbaf
    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzatz) {
            return (zzatz) queryLocalInterface;
        }
        return new zzaua(iBinder);
    }
}
