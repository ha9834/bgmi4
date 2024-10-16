package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zziq;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zziq<M extends zziq<M>> extends zziw {

    /* renamed from: a, reason: collision with root package name */
    protected zzis f4576a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zziw
    public int a() {
        if (this.f4576a == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f4576a.a(); i2++) {
            i += this.f4576a.b(i2).a();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public void zza(zzio zzioVar) throws IOException {
        if (this.f4576a == null) {
            return;
        }
        for (int i = 0; i < this.f4576a.a(); i++) {
            this.f4576a.b(i).a(zzioVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(zzil zzilVar, int i) throws IOException {
        int position = zzilVar.getPosition();
        if (!zzilVar.zzau(i)) {
            return false;
        }
        int i2 = i >>> 3;
        er erVar = new er(i, zzilVar.zzt(position, zzilVar.getPosition() - position));
        eq eqVar = null;
        zzis zzisVar = this.f4576a;
        if (zzisVar == null) {
            this.f4576a = new zzis();
        } else {
            eqVar = zzisVar.a(i2);
        }
        if (eqVar == null) {
            eqVar = new eq();
            this.f4576a.a(i2, eqVar);
        }
        eqVar.a(erVar);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    /* renamed from: zzxb */
    public final /* synthetic */ zziw clone() throws CloneNotSupportedException {
        return (zziq) clone();
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zziq zziqVar = (zziq) super.clone();
        zziu.zza(this, zziqVar);
        return zziqVar;
    }
}
