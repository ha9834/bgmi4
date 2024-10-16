package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzch extends zzcf<Integer, Object> {
    public String zzne;
    public long zznf;
    public String zzng;
    public String zznh;
    public String zzni;

    public zzch(String str) {
        this();
        a(str);
    }

    public zzch() {
        this.zzne = "E";
        this.zznf = -1L;
        this.zzng = "E";
        this.zznh = "E";
        this.zzni = "E";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.zzne = b.get(0) == null ? "E" : (String) b.get(0);
            this.zznf = b.get(1) == null ? -1L : ((Long) b.get(1)).longValue();
            this.zzng = b.get(2) == null ? "E" : (String) b.get(2);
            this.zznh = b.get(3) == null ? "E" : (String) b.get(3);
            this.zzni = b.get(4) == null ? "E" : (String) b.get(4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzne);
        hashMap.put(4, this.zzni);
        hashMap.put(3, this.zznh);
        hashMap.put(2, this.zzng);
        hashMap.put(1, Long.valueOf(this.zznf));
        return hashMap;
    }
}
