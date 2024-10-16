package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdw extends zzcf<Integer, Object> {
    public Long zzxa;
    public Boolean zzxb;
    public Boolean zzxc;

    public zzdw() {
    }

    public zzdw(String str) {
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzxa = (Long) b.get(0);
            this.zzxb = (Boolean) b.get(1);
            this.zzxc = (Boolean) b.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzxa);
        hashMap.put(1, this.zzxb);
        hashMap.put(2, this.zzxc);
        return hashMap;
    }
}
