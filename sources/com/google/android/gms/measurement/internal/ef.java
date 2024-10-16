package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ef implements eg {
    protected final zzfj v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(zzfj zzfjVar) {
        Preconditions.checkNotNull(zzfjVar);
        this.v = zzfjVar;
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public zzr zzae() {
        return this.v.zzae();
    }

    public zzs zzad() {
        return this.v.zzad();
    }

    public cz zzac() {
        return this.v.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public zzef zzab() {
        return this.v.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public zzfc zzaa() {
        return this.v.zzaa();
    }

    public zzjs zzz() {
        return this.v.zzz();
    }

    public zzed zzy() {
        return this.v.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public Context getContext() {
        return this.v.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public Clock zzx() {
        return this.v.zzx();
    }

    public zzac zzw() {
        return this.v.zzw();
    }

    public void zzo() {
        this.v.zzaa().zzo();
    }

    public void zzn() {
        this.v.zzaa().zzn();
    }

    public void zzm() {
        this.v.d();
    }

    public void zzl() {
        this.v.e();
    }
}
