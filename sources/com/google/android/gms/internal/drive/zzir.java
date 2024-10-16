package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzir;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzir<M extends zzir<M>> extends zzix {

    /* renamed from: a, reason: collision with root package name */
    protected zzit f3996a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzix
    public int a() {
        if (this.f3996a == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f3996a.a(); i2++) {
            i += this.f3996a.b(i2).a();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(zzio zzioVar, int i) throws IOException {
        int position = zzioVar.getPosition();
        if (!zzioVar.zzk(i)) {
            return false;
        }
        int i2 = i >>> 3;
        cs csVar = new cs(i, zzioVar.zza(position, zzioVar.getPosition() - position));
        cr crVar = null;
        zzit zzitVar = this.f3996a;
        if (zzitVar == null) {
            this.f3996a = new zzit();
        } else {
            crVar = zzitVar.a(i2);
        }
        if (crVar == null) {
            crVar = new cr();
            this.f3996a.a(i2, crVar);
        }
        crVar.a(csVar);
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzir zzirVar = (zzir) super.clone();
        zziv.zza(this, zzirVar);
        return zzirVar;
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public void zza(zzip zzipVar) throws IOException {
        if (this.f3996a == null) {
            return;
        }
        for (int i = 0; i < this.f3996a.a(); i++) {
            this.f3996a.b(i).a(zzipVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzix
    /* renamed from: zzbi */
    public final /* synthetic */ zzix clone() throws CloneNotSupportedException {
        return (zzir) clone();
    }
}
