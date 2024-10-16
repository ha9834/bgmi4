package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzdfd implements zzdoe {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    private static final zzdof<zzdfd> f3552a = new zzdof<zzdfd>() { // from class: com.google.android.gms.internal.ads.act
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static zzdfd zzec(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
            case 3:
                return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            default:
                return null;
        }
    }

    zzdfd(int i) {
        this.value = i;
    }
}
