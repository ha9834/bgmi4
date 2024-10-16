package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzdhm implements zzdoe {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    private static final zzdof<zzdhm> f3558a = new zzdof<zzdhm>() { // from class: com.google.android.gms.internal.ads.adr
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static zzdhm zzez(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
            case 4:
                return CRUNCHY;
            default:
                return null;
        }
    }

    zzdhm(int i) {
        this.value = i;
    }
}
