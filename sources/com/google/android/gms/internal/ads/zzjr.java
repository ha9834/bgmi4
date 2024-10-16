package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzjr implements zzjl {

    /* renamed from: a, reason: collision with root package name */
    private final int f3664a;
    private int b;
    private int c;
    private zzjk[] d;

    public zzjr(int i) {
        zzkh.checkArgument(true);
        this.f3664a = 262144;
        this.d = new zzjk[100];
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final synchronized zzjk zzfy() {
        this.b++;
        if (this.c <= 0) {
            return new zzjk(new byte[this.f3664a], 0);
        }
        zzjk[] zzjkVarArr = this.d;
        int i = this.c - 1;
        this.c = i;
        return zzjkVarArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final synchronized void zza(zzjk zzjkVar) {
        zzkh.checkArgument(zzjkVar.data.length == this.f3664a);
        this.b--;
        if (this.c == this.d.length) {
            this.d = (zzjk[]) Arrays.copyOf(this.d, this.d.length << 1);
        }
        zzjk[] zzjkVarArr = this.d;
        int i = this.c;
        this.c = i + 1;
        zzjkVarArr[i] = zzjkVar;
        notifyAll();
    }

    public final synchronized void zzz(int i) {
        int max = Math.max(0, zzkq.zzb(0, this.f3664a) - this.b);
        if (max < this.c) {
            Arrays.fill(this.d, max, this.c, (Object) null);
            this.c = max;
        }
    }

    private final synchronized int a() {
        return this.b * this.f3664a;
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final int zzfz() {
        return this.f3664a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zzaa(int i) throws InterruptedException {
        while (a() > i) {
            wait();
        }
    }
}
