package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class zzc extends zzf implements zzd {
    public static zzd zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        if (queryLocalInterface instanceof zzd) {
            return (zzd) queryLocalInterface;
        }
        return new zzb(iBinder);
    }
}
