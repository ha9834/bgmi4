package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzagk extends RemoteCreator<zzaep> {
    @VisibleForTesting
    public zzagk() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzaem zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = a(context).zza(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 15000000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzaem) {
                return (zzaem) queryLocalInterface;
            }
            return new zzaeo(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbad.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaep getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzaep) {
            return (zzaep) queryLocalInterface;
        }
        return new zzaeq(iBinder);
    }
}
