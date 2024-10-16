package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zze;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends GmsClientSupervisor implements Handler.Callback {
    private final Context b;
    private final Handler c;

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("mConnectionStatus")
    private final HashMap<GmsClientSupervisor.zza, l> f1472a = new HashMap<>();
    private final ConnectionTracker d = ConnectionTracker.getInstance();
    private final long e = 5000;
    private final long f = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.b = context.getApplicationContext();
        this.c = new zze(context.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean a(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean a2;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1472a) {
            l lVar = this.f1472a.get(zzaVar);
            if (lVar == null) {
                lVar = new l(this, zzaVar);
                lVar.a(serviceConnection, str);
                lVar.a(str);
                this.f1472a.put(zzaVar, lVar);
            } else {
                this.c.removeMessages(0, zzaVar);
                if (lVar.a(serviceConnection)) {
                    String valueOf = String.valueOf(zzaVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                lVar.a(serviceConnection, str);
                switch (lVar.b()) {
                    case 1:
                        serviceConnection.onServiceConnected(lVar.e(), lVar.d());
                        break;
                    case 2:
                        lVar.a(str);
                        break;
                }
            }
            a2 = lVar.a();
        }
        return a2;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void b(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1472a) {
            l lVar = this.f1472a.get(zzaVar);
            if (lVar == null) {
                String valueOf = String.valueOf(zzaVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!lVar.a(serviceConnection)) {
                String valueOf2 = String.valueOf(zzaVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            lVar.b(serviceConnection, str);
            if (lVar.c()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(0, zzaVar), this.e);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.f1472a) {
                    GmsClientSupervisor.zza zzaVar = (GmsClientSupervisor.zza) message.obj;
                    l lVar = this.f1472a.get(zzaVar);
                    if (lVar != null && lVar.c()) {
                        if (lVar.a()) {
                            lVar.b("GmsClientSupervisor");
                        }
                        this.f1472a.remove(zzaVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.f1472a) {
                    GmsClientSupervisor.zza zzaVar2 = (GmsClientSupervisor.zza) message.obj;
                    l lVar2 = this.f1472a.get(zzaVar2);
                    if (lVar2 != null && lVar2.b() == 3) {
                        String valueOf = String.valueOf(zzaVar2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName e = lVar2.e();
                        if (e == null) {
                            e = zzaVar2.getComponentName();
                        }
                        if (e == null) {
                            e = new ComponentName(zzaVar2.getPackage(), "unknown");
                        }
                        lVar2.onServiceDisconnected(e);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
