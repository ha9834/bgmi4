package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzd;

/* loaded from: classes.dex */
final class z implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f990a;
    private final Object b = new Object();
    private boolean c = false;
    private f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(e eVar, f fVar, bb bbVar) {
        this.f990a = eVar;
        this.d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(h hVar) {
        e.a(this.f990a, new w(this, hVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.b) {
            this.d = null;
            this.c = true;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zza.zza("BillingClient", "Billing service connected.");
        e.a(this.f990a, zzc.zzo(iBinder));
        if (e.a(this.f990a, new x(this), 30000L, new y(this)) == null) {
            a(e.e(this.f990a));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zza.zzb("BillingClient", "Billing service disconnected.");
        e.a(this.f990a, (zzd) null);
        e.a(this.f990a, 0);
        synchronized (this.b) {
            f fVar = this.d;
            if (fVar != null) {
                fVar.onBillingServiceDisconnected();
            }
        }
    }
}
