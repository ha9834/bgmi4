package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class zzdai extends zzfn implements zzdah {
    public static zzdah zzam(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (queryLocalInterface instanceof zzdah) {
            return (zzdah) queryLocalInterface;
        }
        return new zzdaj(iBinder);
    }
}
