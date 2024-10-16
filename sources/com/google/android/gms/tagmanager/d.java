package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzop;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements bc<zzop> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzy f5112a;

    private d(zzy zzyVar) {
        this.f5112a = zzyVar;
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a() {
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a(int i) {
        boolean z;
        z = this.f5112a.n;
        if (z) {
            return;
        }
        this.f5112a.a(0L);
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final /* synthetic */ void a(zzop zzopVar) {
        zzk zzkVar;
        zzop zzopVar2 = zzopVar;
        if (zzopVar2.zzauy != null) {
            zzkVar = zzopVar2.zzauy;
        } else {
            zzi zziVar = zzopVar2.zzqk;
            zzk zzkVar2 = new zzk();
            zzkVar2.zzqk = zziVar;
            zzkVar2.zzqj = null;
            zzkVar2.zzql = zziVar.version;
            zzkVar = zzkVar2;
        }
        this.f5112a.a(zzkVar, zzopVar2.zzaux, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(zzy zzyVar, eo eoVar) {
        this(zzyVar);
    }
}
