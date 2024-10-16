package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzo extends zzev implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzafVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzafVar);
        zzc(1, zzbc);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzaj(List<Update> list) throws RemoteException {
        Parcel zzbc = zzbc();
        zzbc.writeTypedList(list);
        zzc(4, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzafVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzafVar);
        zzc(2, zzbc);
    }
}
