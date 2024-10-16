package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzee extends zzcf<Integer, Long> {
    public Long zzyb;
    public Long zzyc;
    public Long zzyd;
    public Long zzye;
    public Long zzyf;
    public Long zzyg;
    public Long zzyh;
    public Long zzyi;
    public Long zzyj;
    public Long zzyk;
    public Long zzyl;

    public zzee() {
    }

    public zzee(String str) {
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzyb = (Long) b.get(0);
            this.zzyc = (Long) b.get(1);
            this.zzyd = (Long) b.get(2);
            this.zzye = (Long) b.get(3);
            this.zzyf = (Long) b.get(4);
            this.zzyg = (Long) b.get(5);
            this.zzyh = (Long) b.get(6);
            this.zzyi = (Long) b.get(7);
            this.zzyj = (Long) b.get(8);
            this.zzyk = (Long) b.get(9);
            this.zzyl = (Long) b.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyb);
        hashMap.put(1, this.zzyc);
        hashMap.put(2, this.zzyd);
        hashMap.put(3, this.zzye);
        hashMap.put(4, this.zzyf);
        hashMap.put(5, this.zzyg);
        hashMap.put(6, this.zzyh);
        hashMap.put(7, this.zzyi);
        hashMap.put(8, this.zzyj);
        hashMap.put(9, this.zzyk);
        hashMap.put(10, this.zzyl);
        return hashMap;
    }
}
