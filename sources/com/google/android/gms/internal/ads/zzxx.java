package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzxx extends RemoteCreator<zzzn> {
    @VisibleForTesting
    public zzxx() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzzk zza(Context context, zzyd zzydVar, String str, zzamp zzampVar, int i) {
        try {
            IBinder zza = a(context).zza(ObjectWrapper.wrap(context), zzydVar, str, zzampVar, 15000000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                return (zzzk) queryLocalInterface;
            }
            return new zzzm(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbad.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzzn getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzzn) {
            return (zzzn) queryLocalInterface;
        }
        return new zzzo(iBinder);
    }
}
