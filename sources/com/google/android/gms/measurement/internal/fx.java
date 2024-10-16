package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4871a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzn e;
    private final /* synthetic */ zzhv f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(zzhv zzhvVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.f = zzhvVar;
        this.f4871a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        synchronized (this.f4871a) {
            try {
                try {
                    zzdxVar = this.f.b;
                } catch (RemoteException e) {
                    this.f.zzab().zzgk().zza("Failed to get conditional properties", zzef.a(this.b), this.c, e);
                    this.f4871a.set(Collections.emptyList());
                }
                if (zzdxVar == null) {
                    this.f.zzab().zzgk().zza("Failed to get conditional properties", zzef.a(this.b), this.c, this.d);
                    this.f4871a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.b)) {
                    this.f4871a.set(zzdxVar.zza(this.c, this.d, this.e));
                } else {
                    this.f4871a.set(zzdxVar.zzc(this.b, this.c, this.d));
                }
                this.f.k();
                this.f4871a.notify();
            } finally {
                this.f4871a.notify();
            }
        }
    }
}
