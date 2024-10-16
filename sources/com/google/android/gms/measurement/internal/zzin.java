package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzin implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhv f4949a;
    private volatile boolean b;
    private volatile zzec c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzin(zzhv zzhvVar) {
        this.f4949a = zzhvVar;
    }

    public final void zzb(Intent intent) {
        zzin zzinVar;
        this.f4949a.zzo();
        Context context = this.f4949a.getContext();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.b) {
                this.f4949a.zzab().zzgs().zzao("Connection attempt already in progress");
                return;
            }
            this.f4949a.zzab().zzgs().zzao("Using local app measurement service");
            this.b = true;
            zzinVar = this.f4949a.f4948a;
            connectionTracker.bindService(context, intent, zzinVar, 129);
        }
    }

    public final void zziw() {
        if (this.c != null && (this.c.isConnected() || this.c.isConnecting())) {
            this.c.disconnect();
        }
        this.c = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzin zzinVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.b = false;
                this.f4949a.zzab().zzgk().zzao("Service connected with null binder");
                return;
            }
            zzdx zzdxVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzdx) {
                            zzdxVar = (zzdx) queryLocalInterface;
                        } else {
                            zzdxVar = new zzdz(iBinder);
                        }
                    }
                    this.f4949a.zzab().zzgs().zzao("Bound to IMeasurementService interface");
                } else {
                    this.f4949a.zzab().zzgk().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f4949a.zzab().zzgk().zzao("Service connect failed to get IMeasurementService");
            }
            if (zzdxVar == null) {
                this.b = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context context = this.f4949a.getContext();
                    zzinVar = this.f4949a.f4948a;
                    connectionTracker.unbindService(context, zzinVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f4949a.zzaa().zza(new ga(this, zzdxVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.f4949a.zzab().zzgr().zzao("Service disconnected");
        this.f4949a.zzaa().zza(new gc(this, componentName));
    }

    public final void zzix() {
        this.f4949a.zzo();
        Context context = this.f4949a.getContext();
        synchronized (this) {
            if (this.b) {
                this.f4949a.zzab().zzgs().zzao("Connection attempt already in progress");
                return;
            }
            if (this.c != null && (this.c.isConnecting() || this.c.isConnected())) {
                this.f4949a.zzab().zzgs().zzao("Already awaiting connection attempt");
                return;
            }
            this.c = new zzec(context, Looper.getMainLooper(), this, this);
            this.f4949a.zzab().zzgs().zzao("Connecting to remote service");
            this.b = true;
            this.c.checkAvailabilityAndConnect();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f4949a.zzaa().zza(new gb(this, this.c.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.c = null;
                this.b = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.f4949a.zzab().zzgr().zzao("Service connection suspended");
        this.f4949a.zzaa().zza(new ge(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzef zzhs = this.f4949a.v.zzhs();
        if (zzhs != null) {
            zzhs.zzgn().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.b = false;
            this.c = null;
        }
        this.f4949a.zzaa().zza(new gd(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzin zzinVar, boolean z) {
        zzinVar.b = false;
        return false;
    }
}
