package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzdgj implements zzdoe {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    private static final zzdof<zzdgj> f3554a = new zzdof<zzdgj>() { // from class: com.google.android.gms.internal.ads.adc
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static zzdgj zzel(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
            default:
                return null;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
        }
    }

    zzdgj(int i) {
        this.value = i;
    }
}
