package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzwx implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);


    /* renamed from: a, reason: collision with root package name */
    private static final zzdof<zzwx> f3775a = new zzdof<zzwx>() { // from class: com.google.android.gms.internal.ads.apt
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        return this.value;
    }

    public static zzwx zzca(int i) {
        if (i != 1000) {
            switch (i) {
                case 0:
                    return ENUM_FALSE;
                case 1:
                    return ENUM_TRUE;
                default:
                    return null;
            }
        }
        return ENUM_UNKNOWN;
    }

    public static zzdog zzad() {
        return apu.f2039a;
    }

    zzwx(int i) {
        this.value = i;
    }
}
