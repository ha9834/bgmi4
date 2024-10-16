package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbz implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);

    private static final zzdof<zzbz> b = new zzdof<zzbz>() { // from class: com.google.android.gms.internal.ads.qs
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        return this.value;
    }

    public static zzbz zzj(int i) {
        if (i != 1000) {
            switch (i) {
                case 0:
                    return ENUM_FALSE;
                case 1:
                    return ENUM_TRUE;
                case 2:
                    return ENUM_FAILURE;
                default:
                    return null;
            }
        }
        return ENUM_UNKNOWN;
    }

    public static zzdog zzad() {
        return rb.f2457a;
    }

    zzbz(int i) {
        this.value = i;
    }
}
