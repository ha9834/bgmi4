package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public final class zzaqo extends zzfn implements zzaqn {
    public static zzaqn zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzaqn) {
            return (zzaqn) queryLocalInterface;
        }
        return new zzaqp(iBinder);
    }
}
