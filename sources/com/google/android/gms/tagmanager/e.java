package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.gtm.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements bc<zzk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzy f5131a;

    private e(zzy zzyVar) {
        this.f5131a = zzyVar;
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a() {
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a(int i) {
        zzai zzaiVar;
        em emVar;
        em emVar2;
        zzai zzaiVar2;
        if (i == zzcz.zzahw) {
            zzaiVar2 = this.f5131a.j;
            zzaiVar2.zzhn();
        }
        synchronized (this.f5131a) {
            if (!this.f5131a.isReady()) {
                emVar = this.f5131a.m;
                if (emVar != null) {
                    zzy zzyVar = this.f5131a;
                    emVar2 = this.f5131a.m;
                    zzyVar.setResult(emVar2);
                } else {
                    this.f5131a.setResult(this.f5131a.createFailedResult(Status.RESULT_TIMEOUT));
                }
            }
        }
        zzaiVar = this.f5131a.j;
        this.f5131a.a(zzaiVar.zzhm());
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final /* synthetic */ void a(zzk zzkVar) {
        zzai zzaiVar;
        Clock clock;
        long j;
        boolean b;
        zzk zzkVar2;
        zzk zzkVar3;
        zzai zzaiVar2;
        zzk zzkVar4 = zzkVar;
        zzaiVar = this.f5131a.j;
        zzaiVar.zzho();
        synchronized (this.f5131a) {
            if (zzkVar4.zzqk == null) {
                zzkVar2 = this.f5131a.o;
                if (zzkVar2.zzqk == null) {
                    zzdi.zzav("Current resource is null; network resource is also null");
                    zzaiVar2 = this.f5131a.j;
                    this.f5131a.a(zzaiVar2.zzhm());
                    return;
                }
                zzkVar3 = this.f5131a.o;
                zzkVar4.zzqk = zzkVar3.zzqk;
            }
            zzy zzyVar = this.f5131a;
            clock = this.f5131a.f5175a;
            zzyVar.a(zzkVar4, clock.currentTimeMillis(), false);
            j = this.f5131a.p;
            StringBuilder sb = new StringBuilder(58);
            sb.append("setting refresh time to current time: ");
            sb.append(j);
            zzdi.zzab(sb.toString());
            b = this.f5131a.b();
            if (!b) {
                this.f5131a.a(zzkVar4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(zzy zzyVar, eo eoVar) {
        this(zzyVar);
    }
}
