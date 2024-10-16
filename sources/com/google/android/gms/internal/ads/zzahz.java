package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.smtt.sdk.TbsListener;

@zzard
/* loaded from: classes2.dex */
public final class zzahz extends com.google.android.gms.ads.internal.zzc<zzaig> {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahz(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzasq.zzw(context), looper, TbsListener.ErrorCode.STARTDOWNLOAD_7, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final zzaig zzrs() throws DeadObjectException {
        return (zzaig) super.getService();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (queryLocalInterface instanceof zzaig) {
            return (zzaig) queryLocalInterface;
        }
        return new zzaih(iBinder);
    }
}
