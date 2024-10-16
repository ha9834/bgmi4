package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaqi extends zzfm implements zzaqg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onRestart() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStart() throws RemoteException {
        b(3, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onResume() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onPause() throws RemoteException {
        b(5, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        Parcel a3 = a(6, a2);
        if (a3.readInt() != 0) {
            bundle.readFromParcel(a3);
        }
        a3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStop() throws RemoteException {
        b(7, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onDestroy() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzdd() throws RemoteException {
        b(9, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onBackPressed() throws RemoteException {
        b(10, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final boolean zztg() throws RemoteException {
        Parcel a2 = a(11, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeInt(i2);
        zzfo.zza(a2, intent);
        b(12, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(13, a2);
    }
}
