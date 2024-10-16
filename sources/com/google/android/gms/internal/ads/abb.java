package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class abb implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final zzdba f1776a;
    private final zzdau b;
    private final Object c = new Object();
    private boolean d = false;
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abb(Context context, Looper looper, zzdau zzdauVar) {
        this.b = zzdauVar;
        this.f1776a = new zzdba(context, looper, this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.c) {
            if (!this.d) {
                this.d = true;
                this.f1776a.checkAvailabilityAndConnect();
            }
        }
    }

    private final void b() {
        synchronized (this.c) {
            if (this.f1776a.isConnected() || this.f1776a.isConnecting()) {
                this.f1776a.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.c) {
            if (this.e) {
                return;
            }
            this.e = true;
            try {
                this.f1776a.zzanm().zza(new zzday(this.b.toByteArray()));
                b();
            } catch (Exception unused) {
                b();
            } catch (Throwable th) {
                b();
                throw th;
            }
        }
    }
}
