package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4873a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzn f;
    private final /* synthetic */ zzhv g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(zzhv zzhvVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zznVar) {
        this.g = zzhvVar;
        this.f4873a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        synchronized (this.f4873a) {
            try {
                try {
                    zzdxVar = this.g.b;
                } catch (RemoteException e) {
                    this.g.zzab().zzgk().zza("Failed to get user properties", zzef.a(this.b), this.c, e);
                    this.f4873a.set(Collections.emptyList());
                }
                if (zzdxVar == null) {
                    this.g.zzab().zzgk().zza("Failed to get user properties", zzef.a(this.b), this.c, this.d);
                    this.f4873a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.b)) {
                    this.f4873a.set(zzdxVar.zza(this.c, this.d, this.e, this.f));
                } else {
                    this.f4873a.set(zzdxVar.zza(this.b, this.c, this.d, this.e));
                }
                this.g.k();
                this.f4873a.notify();
            } finally {
                this.f4873a.notify();
            }
        }
    }
}
