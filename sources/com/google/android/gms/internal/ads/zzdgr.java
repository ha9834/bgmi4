package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgr extends zzdob<zzdgr, zza> implements zzdpm {
    private static volatile zzdpv<zzdgr> zzdv;
    private static final zzdgr zzguc = new zzdgr();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.zzhcr;
    private int zzgub;

    /* loaded from: classes2.dex */
    public enum zzb implements zzdoe {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);


        /* renamed from: a, reason: collision with root package name */
        private static final zzdof<zzb> f3555a = new adh();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzdoe
        public final int zzac() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        public static zzb zzen(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        zzb(int i) {
            this.value = i;
        }
    }

    private zzdgr() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgr, zza> implements zzdpm {
        private zza() {
            super(zzdgr.zzguc);
        }

        public final zza zzgk(String str) {
            a();
            ((zzdgr) this.f3590a).a(str);
            return this;
        }

        public final zza zzbo(zzdmr zzdmrVar) {
            a();
            ((zzdgr) this.f3590a).a(zzdmrVar);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            a();
            ((zzdgr) this.f3590a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(adg adgVar) {
            this();
        }
    }

    public final String zzart() {
        return this.zzgtz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzgtz = str;
    }

    public final zzdmr zzaru() {
        return this.zzgua;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdmr zzdmrVar) {
        if (zzdmrVar == null) {
            throw new NullPointerException();
        }
        this.zzgua = zzdmrVar;
    }

    public final zzb zzarv() {
        zzb zzen = zzb.zzen(this.zzgub);
        return zzen == null ? zzb.UNRECOGNIZED : zzen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        this.zzgub = zzbVar.zzac();
    }

    public static zza zzarw() {
        return (zza) ((zzdob.zza) zzguc.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adg adgVar = null;
        switch (adg.f1811a[i - 1]) {
            case 1:
                return new zzdgr();
            case 2:
                return new zza(adgVar);
            case 3:
                return a(zzguc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzgub"});
            case 4:
                return zzguc;
            case 5:
                zzdpv<zzdgr> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgr.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzguc);
                            zzdv = zzdpvVar;
                        }
                    }
                }
                return zzdpvVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzdgr zzarx() {
        return zzguc;
    }

    static {
        zzdob.a((Class<zzdgr>) zzdgr.class, zzguc);
    }
}
