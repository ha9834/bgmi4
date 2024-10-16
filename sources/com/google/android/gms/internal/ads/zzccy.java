package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzccy implements zzbrx {

    /* renamed from: a, reason: collision with root package name */
    private final zzams f3187a;

    public zzccy(zzams zzamsVar) {
        this.f3187a = zzamsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbp(Context context) {
        try {
            this.f3187a.pause();
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onPause for rewarded video.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbq(Context context) {
        try {
            this.f3187a.resume();
            if (context != null) {
                this.f3187a.zzr(ObjectWrapper.wrap(context));
            }
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onResume for rewarded video.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final void zzbr(Context context) {
        try {
            this.f3187a.destroy();
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onDestroy for rewarded video.", e);
        }
    }
}
