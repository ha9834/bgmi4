package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzuq<M extends zzuq<M>> extends zzuw {

    /* renamed from: a, reason: collision with root package name */
    protected zzus f4457a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuw
    public int a() {
        if (this.f4457a == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f4457a.a(); i2++) {
            i += this.f4457a.b(i2).a();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public void zza(zzuo zzuoVar) throws IOException {
        if (this.f4457a == null) {
            return;
        }
        for (int i = 0; i < this.f4457a.a(); i++) {
            this.f4457a.b(i).a(zzuoVar);
        }
    }

    public final <T> T zza(zzur<M, T> zzurVar) {
        ee a2;
        zzus zzusVar = this.f4457a;
        if (zzusVar == null || (a2 = zzusVar.a(zzurVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) a2.a(zzurVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(zzun zzunVar, int i) throws IOException {
        int position = zzunVar.getPosition();
        if (!zzunVar.zzao(i)) {
            return false;
        }
        int i2 = i >>> 3;
        ef efVar = new ef(i, zzunVar.zzt(position, zzunVar.getPosition() - position));
        ee eeVar = null;
        zzus zzusVar = this.f4457a;
        if (zzusVar == null) {
            this.f4457a = new zzus();
        } else {
            eeVar = zzusVar.a(i2);
        }
        if (eeVar == null) {
            eeVar = new ee();
            this.f4457a.a(i2, eeVar);
        }
        eeVar.a(efVar);
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    /* renamed from: zzry */
    public final /* synthetic */ zzuw clone() throws CloneNotSupportedException {
        return (zzuq) clone();
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuq zzuqVar = (zzuq) super.clone();
        zzuu.zza(this, zzuqVar);
        return zzuqVar;
    }
}
