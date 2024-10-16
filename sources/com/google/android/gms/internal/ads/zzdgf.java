package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzdgf implements zzdoe {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);

    private static final zzdof<zzdgf> b = new zzdof<zzdgf>() { // from class: com.google.android.gms.internal.ads.ada
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static zzdgf zzek(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        switch (i) {
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            default:
                return null;
        }
    }

    zzdgf(int i) {
        this.value = i;
    }
}
