package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.ListenerToken;

/* loaded from: classes2.dex */
public final class zzg implements ListenerToken {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerHolder.ListenerKey f3978a;
    private ICancelToken b = null;

    public zzg(ListenerHolder.ListenerKey listenerKey) {
        this.f3978a = listenerKey;
    }

    public final boolean cancel() {
        ICancelToken iCancelToken = this.b;
        if (iCancelToken == null) {
            return false;
        }
        try {
            iCancelToken.cancel();
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final void setCancelToken(ICancelToken iCancelToken) {
        this.b = iCancelToken;
    }

    public final ListenerHolder.ListenerKey zzac() {
        return this.f3978a;
    }
}
