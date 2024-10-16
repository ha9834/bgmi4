package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzxw extends RemoteCreator<zzzi> {
    public zzxw() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzzf zza(Context context, String str, zzamp zzampVar) {
        try {
            IBinder zzc = a(context).zzc(ObjectWrapper.wrap(context), str, zzampVar, 15000000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                return (zzzf) queryLocalInterface;
            }
            return new zzzh(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbad.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzzi getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzzi) {
            return (zzzi) queryLocalInterface;
        }
        return new zzzj(iBinder);
    }
}
