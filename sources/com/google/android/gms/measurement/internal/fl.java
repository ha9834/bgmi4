package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4859a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ zzhv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(zzhv zzhvVar, AtomicReference atomicReference, zzn zznVar) {
        this.c = zzhvVar;
        this.f4859a = atomicReference;
        this.b = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        synchronized (this.f4859a) {
            try {
                try {
                    zzdxVar = this.c.b;
                } catch (RemoteException e) {
                    this.c.zzab().zzgk().zza("Failed to get app instance id", e);
                }
                if (zzdxVar == null) {
                    this.c.zzab().zzgk().zzao("Failed to get app instance id");
                    return;
                }
                this.f4859a.set(zzdxVar.zzc(this.b));
                String str = (String) this.f4859a.get();
                if (str != null) {
                    this.c.zzq().a(str);
                    this.c.zzac().j.zzau(str);
                }
                this.c.k();
                this.f4859a.notify();
            } finally {
                this.f4859a.notify();
            }
        }
    }
}
