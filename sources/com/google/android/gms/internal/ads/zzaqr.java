package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public final class zzaqr extends zzfn implements zzaqq {
    public static zzaqq zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (queryLocalInterface instanceof zzaqq) {
            return (zzaqq) queryLocalInterface;
        }
        return new zzaqs(iBinder);
    }
}
