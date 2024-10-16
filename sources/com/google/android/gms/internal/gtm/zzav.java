package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzav implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzat f4391a;
    private volatile zzce b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzav(zzat zzatVar) {
        this.f4391a = zzatVar;
    }

    public final zzce zzdq() {
        zzav zzavVar;
        com.google.android.gms.analytics.zzk.zzav();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context e = this.f4391a.e();
        intent.putExtra("app_package_name", e.getPackageName());
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            this.b = null;
            this.c = true;
            zzavVar = this.f4391a.f4390a;
            boolean bindService = connectionTracker.bindService(e, intent, zzavVar, 129);
            this.f4391a.zza("Bind to service requested", Boolean.valueOf(bindService));
            if (!bindService) {
                this.c = false;
                return null;
            }
            try {
                wait(zzby.zzaak.get().longValue());
            } catch (InterruptedException unused) {
                this.f4391a.zzt("Wait for service connect was interrupted");
            }
            this.c = false;
            zzce zzceVar = this.b;
            this.b = null;
            if (zzceVar == null) {
                this.f4391a.zzu("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzceVar;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzav zzavVar;
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.f4391a.zzu("Service connected with null binder");
                    return;
                }
                zzce zzceVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                            if (queryLocalInterface instanceof zzce) {
                                zzceVar = (zzce) queryLocalInterface;
                            } else {
                                zzceVar = new zzcf(iBinder);
                            }
                        }
                        this.f4391a.zzq("Bound to IAnalyticsService interface");
                    } else {
                        this.f4391a.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.f4391a.zzu("Service connect failed to get IAnalyticsService");
                }
                if (zzceVar == null) {
                    try {
                        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                        Context e = this.f4391a.e();
                        zzavVar = this.f4391a.f4390a;
                        connectionTracker.unbindService(e, zzavVar);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (!this.c) {
                    this.f4391a.zzt("onServiceConnected received after the timeout limit");
                    this.f4391a.h().zza(new j(this, zzceVar));
                } else {
                    this.b = zzceVar;
                }
            } finally {
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.f4391a.h().zza(new k(this, componentName));
    }
}
