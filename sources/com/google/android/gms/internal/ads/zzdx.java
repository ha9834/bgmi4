package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdx extends zzcf<Integer, Long> {
    public Long zzxd;
    public Long zzxe;

    public zzdx() {
    }

    public zzdx(String str) {
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzxd = (Long) b.get(0);
            this.zzxe = (Long) b.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzxd);
        hashMap.put(1, this.zzxe);
        return hashMap;
    }
}
