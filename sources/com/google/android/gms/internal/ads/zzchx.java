package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class zzchx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    protected final zzbbr<InputStream> f3266a = new zzbbr<>();
    protected final Object b = new Object();
    protected boolean c = false;
    protected boolean d = false;
    protected zzarx e;
    protected zzarf f;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        synchronized (this.b) {
            this.d = true;
            if (this.f.isConnected() || this.f.isConnecting()) {
                this.f.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzawz.zzdp("Cannot connect to remote service, fallback to local instance.");
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzawz.zzdp("Disconnected from remote ad request service.");
        this.f3266a.setException(new zzcie(0));
    }
}
