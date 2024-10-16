package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ape implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzvn f2027a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ape(zzvn zzvnVar) {
        this.f2027a = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        zzvu zzvuVar;
        Object obj2;
        obj = this.f2027a.b;
        synchronized (obj) {
            this.f2027a.e = null;
            zzvuVar = this.f2027a.c;
            if (zzvuVar != null) {
                zzvn.a(this.f2027a, (zzvu) null);
            }
            obj2 = this.f2027a.b;
            obj2.notifyAll();
        }
    }
}
