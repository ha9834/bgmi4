package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpy implements AppEventListener {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzzs f3371a;

    public final synchronized void zzb(zzzs zzzsVar) {
        this.f3371a = zzzsVar;
    }

    public final synchronized zzzs zzale() {
        return this.f3371a;
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.f3371a != null) {
            try {
                this.f3371a.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }
}
