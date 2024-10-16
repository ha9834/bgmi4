package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class abj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzda f1781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abj(zzda zzdaVar) {
        this.f1781a = zzdaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzdy zzdyVar;
        ConditionVariable conditionVariable2;
        if (this.f1781a.b != null) {
            return;
        }
        conditionVariable = zzda.d;
        synchronized (conditionVariable) {
            if (this.f1781a.b != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrb)).booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzdyVar = this.f1781a.c;
                    zzda.f3522a = new zzwo(zzdyVar.f3628a, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.f1781a.b = Boolean.valueOf(z2);
            conditionVariable2 = zzda.d;
            conditionVariable2.open();
        }
    }
}
