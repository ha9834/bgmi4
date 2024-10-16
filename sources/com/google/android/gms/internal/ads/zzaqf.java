package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzaqf extends RemoteCreator<zzaqj> {
    public zzaqf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzaqg zzc(Activity activity) {
        try {
            IBinder zzad = a(activity).zzad(ObjectWrapper.wrap(activity));
            if (zzad == null) {
                return null;
            }
            IInterface queryLocalInterface = zzad.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaqg) {
                return (zzaqg) queryLocalInterface;
            }
            return new zzaqi(zzad);
        } catch (RemoteException e) {
            zzbad.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzbad.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaqj getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaqj) {
            return (zzaqj) queryLocalInterface;
        }
        return new zzaqk(iBinder);
    }
}
