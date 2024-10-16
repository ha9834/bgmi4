package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzvn {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f3762a = new apb(this);
    private final Object b = new Object();

    @GuardedBy("lock")
    private zzvu c;

    @GuardedBy("lock")
    private Context d;

    @GuardedBy("lock")
    private zzvy e;

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.b) {
            if (this.d != null) {
                return;
            }
            this.d = context.getApplicationContext();
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcto)).booleanValue()) {
                a();
            } else {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctn)).booleanValue()) {
                    zzk.zzlj().zza(new apc(this));
                }
            }
        }
    }

    public final void zzng() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctp)).booleanValue()) {
            synchronized (this.b) {
                a();
                zzk.zzlg();
                zzaxi.zzdvv.removeCallbacks(this.f3762a);
                zzk.zzlg();
                zzaxi.zzdvv.postDelayed(this.f3762a, ((Long) zzyt.zzpe().zzd(zzacu.zzctq)).longValue());
            }
        }
    }

    public final zzvs zza(zzvv zzvvVar) {
        synchronized (this.b) {
            if (this.e == null) {
                return new zzvs();
            }
            try {
                return this.e.zza(zzvvVar);
            } catch (RemoteException e) {
                zzawz.zzc("Unable to call into cache service.", e);
                return new zzvs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.b) {
            if (this.d != null && this.c == null) {
                this.c = a(new apd(this), new ape(this));
                this.c.checkAvailabilityAndConnect();
            }
        }
    }

    @VisibleForTesting
    private final synchronized zzvu a(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzvu(this.d, zzk.zzlu().zzwr(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            if (this.c.isConnected() || this.c.isConnecting()) {
                this.c.disconnect();
            }
            this.c = null;
            this.e = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzvu a(zzvn zzvnVar, zzvu zzvuVar) {
        zzvnVar.c = null;
        return null;
    }
}
