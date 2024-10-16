package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzrz implements zzrt {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3727a;
    private final int b;
    private final byte[] c;
    private final zzrs[] d;
    private int e;
    private int f;
    private int g;
    private zzrs[] h;

    public zzrz(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzrz(boolean z, int i, int i2) {
        zzsk.checkArgument(true);
        zzsk.checkArgument(true);
        this.f3727a = true;
        this.b = 65536;
        this.g = 0;
        this.h = new zzrs[100];
        this.c = null;
        this.d = new zzrs[1];
    }

    public final synchronized void reset() {
        if (this.f3727a) {
            zzbl(0);
        }
    }

    public final synchronized void zzbl(int i) {
        boolean z = i < this.e;
        this.e = i;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized zzrs zzjt() {
        zzrs zzrsVar;
        this.f++;
        if (this.g > 0) {
            zzrs[] zzrsVarArr = this.h;
            int i = this.g - 1;
            this.g = i;
            zzrsVar = zzrsVarArr[i];
            this.h[this.g] = null;
        } else {
            zzrsVar = new zzrs(new byte[this.b], 0);
        }
        return zzrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void zza(zzrs zzrsVar) {
        this.d[0] = zzrsVar;
        zza(this.d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void zza(zzrs[] zzrsVarArr) {
        boolean z;
        if (this.g + zzrsVarArr.length >= this.h.length) {
            this.h = (zzrs[]) Arrays.copyOf(this.h, Math.max(this.h.length << 1, this.g + zzrsVarArr.length));
        }
        for (zzrs zzrsVar : zzrsVarArr) {
            if (zzrsVar.data != null && zzrsVar.data.length != this.b) {
                z = false;
                zzsk.checkArgument(z);
                zzrs[] zzrsVarArr2 = this.h;
                int i = this.g;
                this.g = i + 1;
                zzrsVarArr2[i] = zzrsVar;
            }
            z = true;
            zzsk.checkArgument(z);
            zzrs[] zzrsVarArr22 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            zzrsVarArr22[i2] = zzrsVar;
        }
        this.f -= zzrsVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void zzn() {
        int max = Math.max(0, zzsy.zzb(this.e, this.b) - this.f);
        if (max >= this.g) {
            return;
        }
        Arrays.fill(this.h, max, this.g, (Object) null);
        this.g = max;
    }

    public final synchronized int zzga() {
        return this.f * this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final int zzfz() {
        return this.b;
    }
}
