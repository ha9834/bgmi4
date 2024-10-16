package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzarf extends com.google.android.gms.ads.internal.zzc<zzarm> {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public zzarf(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzasq.zzw(context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final zzarm zztr() throws DeadObjectException {
        return (zzarm) super.getService();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzarm) {
            return (zzarm) queryLocalInterface;
        }
        return new zzaro(iBinder);
    }
}
