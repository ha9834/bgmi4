package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcf extends zzm implements zzce {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    @Override // com.google.android.gms.internal.gtm.zzce
    public final void zza(Map map, long j, String str, List<zzbk> list) throws RemoteException {
        Parcel a2 = a();
        a2.writeMap(map);
        a2.writeLong(j);
        a2.writeString(str);
        a2.writeTypedList(list);
        a(1, a2);
    }

    @Override // com.google.android.gms.internal.gtm.zzce
    public final void zzch() throws RemoteException {
        a(2, a());
    }
}
