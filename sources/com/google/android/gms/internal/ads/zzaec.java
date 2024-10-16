package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzaec extends zzfm implements zzaea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaec(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final String getText() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final List<zzaei> zzra() throws RemoteException {
        Parcel a2 = a(3, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }
}
