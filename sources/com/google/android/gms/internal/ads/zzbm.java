package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbm implements zzdoe {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);

    private static final zzdof<zzbm> c = new zzdof<zzbm>() { // from class: com.google.android.gms.internal.ads.ng
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        return this.value;
    }

    public static zzbm zze(int i) {
        switch (i) {
            case 0:
                return ENUM_SIGNAL_SOURCE_UNKNOWN;
            case 1:
                return ENUM_SIGNAL_SOURCE_DISABLE;
            case 2:
                return ENUM_SIGNAL_SOURCE_ADSHIELD;
            case 3:
                return ENUM_SIGNAL_SOURCE_GASS;
            case 4:
                return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return nl.f2371a;
    }

    zzbm(int i) {
        this.value = i;
    }
}
