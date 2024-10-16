package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzeg extends zzcf<Integer, Long> {
    public Long zzyn;
    public Long zzyo;
    public Long zzyp;
    public Long zzyq;

    public zzeg() {
    }

    public zzeg(String str) {
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzyn = (Long) b.get(0);
            this.zzyo = (Long) b.get(1);
            this.zzyp = (Long) b.get(2);
            this.zzyq = (Long) b.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyn);
        hashMap.put(1, this.zzyo);
        hashMap.put(2, this.zzyp);
        hashMap.put(3, this.zzyq);
        return hashMap;
    }
}
