package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdl extends zzcf<Integer, Long> {
    public long zzwu;
    public long zzwv;

    public zzdl() {
        this.zzwu = -1L;
        this.zzwv = -1L;
    }

    public zzdl(String str) {
        this();
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzwu));
        hashMap.put(1, Long.valueOf(this.zzwv));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzwu = ((Long) b.get(0)).longValue();
            this.zzwv = ((Long) b.get(1)).longValue();
        }
    }
}
