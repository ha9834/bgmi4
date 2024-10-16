package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzqo implements zzql {

    /* renamed from: a, reason: collision with root package name */
    private final zzql[] f3712a;
    private final ArrayList<zzql> b;
    private zzqm d;
    private zzlr e;
    private Object f;
    private zzqq h;
    private final zzlu c = new zzlu();
    private int g = -1;

    public zzqo(zzql... zzqlVarArr) {
        this.f3712a = zzqlVarArr;
        this.b = new ArrayList<>(Arrays.asList(zzqlVarArr));
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zza(zzkv zzkvVar, boolean z, zzqm zzqmVar) {
        this.d = zzqmVar;
        int i = 0;
        while (true) {
            zzql[] zzqlVarArr = this.f3712a;
            if (i >= zzqlVarArr.length) {
                return;
            }
            zzqlVarArr[i].zza(zzkvVar, false, new ann(this, i));
            i++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzjf() throws IOException {
        zzqq zzqqVar = this.h;
        if (zzqqVar != null) {
            throw zzqqVar;
        }
        for (zzql zzqlVar : this.f3712a) {
            zzqlVar.zzjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final zzqj zza(int i, zzrt zzrtVar) {
        zzqj[] zzqjVarArr = new zzqj[this.f3712a.length];
        for (int i2 = 0; i2 < zzqjVarArr.length; i2++) {
            zzqjVarArr[i2] = this.f3712a[i2].zza(i, zzrtVar);
        }
        return new anm(zzqjVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzb(zzqj zzqjVar) {
        anm anmVar = (anm) zzqjVar;
        int i = 0;
        while (true) {
            zzql[] zzqlVarArr = this.f3712a;
            if (i >= zzqlVarArr.length) {
                return;
            }
            zzqlVarArr[i].zzb(anmVar.f1988a[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzjg() {
        for (zzql zzqlVar : this.f3712a) {
            zzqlVar.zzjg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, zzlr zzlrVar, Object obj) {
        zzqq zzqqVar;
        if (this.h == null) {
            int zzhf = zzlrVar.zzhf();
            int i2 = 0;
            while (true) {
                if (i2 < zzhf) {
                    if (zzlrVar.zza(i2, this.c, false).zzaut) {
                        zzqqVar = new zzqq(0);
                        break;
                    }
                    i2++;
                } else {
                    if (this.g == -1) {
                        this.g = zzlrVar.zzhg();
                    } else if (zzlrVar.zzhg() != this.g) {
                        zzqqVar = new zzqq(1);
                    }
                    zzqqVar = null;
                }
            }
            this.h = zzqqVar;
        }
        if (this.h != null) {
            return;
        }
        this.b.remove(this.f3712a[i]);
        if (i == 0) {
            this.e = zzlrVar;
            this.f = obj;
        }
        if (this.b.isEmpty()) {
            this.d.zzb(this.e, this.f);
        }
    }
}
