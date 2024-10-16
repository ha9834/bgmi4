package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4857a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ zzhv d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(zzhv zzhvVar, AtomicReference atomicReference, zzn zznVar, boolean z) {
        this.d = zzhvVar;
        this.f4857a = atomicReference;
        this.b = zznVar;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        synchronized (this.f4857a) {
            try {
                try {
                    zzdxVar = this.d.b;
                } catch (RemoteException e) {
                    this.d.zzab().zzgk().zza("Failed to get user properties", e);
                }
                if (zzdxVar == null) {
                    this.d.zzab().zzgk().zzao("Failed to get user properties");
                    return;
                }
                this.f4857a.set(zzdxVar.zza(this.b, this.c));
                this.d.k();
                this.f4857a.notify();
            } finally {
                this.f4857a.notify();
            }
        }
    }
}
