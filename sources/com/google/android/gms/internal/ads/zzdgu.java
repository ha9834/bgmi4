package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzdgu implements zzdoe {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    private static final zzdof<zzdgu> f3556a = new zzdof<zzdgu>() { // from class: com.google.android.gms.internal.ads.adi
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static zzdgu zzeo(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
            default:
                return null;
        }
    }

    zzdgu(int i) {
        this.value = i;
    }
}
