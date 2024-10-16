package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.nearby.messages.internal.zzq;

/* loaded from: classes.dex */
public final class zzcvd extends zzq {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<zzn<Status>> f4710a;
    private boolean b = false;

    public zzcvd(zzci<zzn<Status>> zzciVar) {
        this.f4710a = zzciVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzp
    public final synchronized void zzap(Status status) throws RemoteException {
        if (!this.b) {
            this.f4710a.zza(new bp(this, status));
            this.b = true;
            return;
        }
        String valueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(valueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
