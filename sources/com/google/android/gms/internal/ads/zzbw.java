package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbw implements zzdoe {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3);

    private static final zzdof<zzbw> d = new zzdof<zzbw>() { // from class: com.google.android.gms.internal.ads.pv
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int zzac() {
        return this.value;
    }

    public static zzbw zzi(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_ENCRYPTION_METHOD;
            case 1:
                return BITSLICER;
            case 2:
                return TINK_HYBRID;
            case 3:
                return UNENCRYPTED;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return qa.f2431a;
    }

    zzbw(int i) {
        this.value = i;
    }
}
