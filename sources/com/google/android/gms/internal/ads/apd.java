package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apd implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzvn f2026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apd(zzvn zzvnVar) {
        this.f2026a = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        Object obj2;
        zzvu zzvuVar;
        zzvu zzvuVar2;
        obj = this.f2026a.b;
        synchronized (obj) {
            try {
                zzvuVar = this.f2026a.c;
                if (zzvuVar != null) {
                    zzvn zzvnVar = this.f2026a;
                    zzvuVar2 = this.f2026a.c;
                    zzvnVar.e = zzvuVar2.zznk();
                }
            } catch (DeadObjectException e) {
                zzawz.zzc("Unable to obtain a cache service instance.", e);
                this.f2026a.b();
            }
            obj2 = this.f2026a.b;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.f2026a.b;
        synchronized (obj) {
            this.f2026a.e = null;
            obj2 = this.f2026a.b;
            obj2.notifyAll();
        }
    }
}
