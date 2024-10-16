package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdap extends zzdob<zzdap, zzb> implements zzdpm {
    private static volatile zzdpv<zzdap> zzdv;
    private static final zzdoi<Integer, zza> zzgof = new abc();
    private static final zzdap zzgoj = new zzdap();
    private int zzdj;
    private zzdoh zzgoe = c();
    private String zzgog = "";
    private String zzgoh = "";
    private String zzgoi = "";

    /* loaded from: classes2.dex */
    public enum zza implements zzdoe {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);

        private static final zzdof<zza> b = new abe();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzdoe
        public final int zzac() {
            return this.value;
        }

        public static zza zzds(int i) {
            switch (i) {
                case 1:
                    return BLOCKED_REASON_UNKNOWN;
                case 2:
                    return BLOCKED_REASON_BACKGROUND;
                default:
                    return null;
            }
        }

        public static zzdog zzad() {
            return abf.f1778a;
        }

        zza(int i) {
            this.value = i;
        }
    }

    private zzdap() {
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob.zza<zzdap, zzb> implements zzdpm {
        private zzb() {
            super(zzdap.zzgoj);
        }

        public final zzb zzb(zza zzaVar) {
            a();
            ((zzdap) this.f3590a).a(zzaVar);
            return this;
        }

        public final zzb zzgd(String str) {
            a();
            ((zzdap) this.f3590a).a(str);
            return this;
        }

        /* synthetic */ zzb(abc abcVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zza zzaVar) {
        if (zzaVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzgoe.zzavi()) {
            zzdoh zzdohVar = this.zzgoe;
            int size = zzdohVar.size();
            this.zzgoe = zzdohVar.zzfl(size == 0 ? 10 : size << 1);
        }
        this.zzgoe.zzgp(zzaVar.zzac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdj |= 1;
        this.zzgog = str;
    }

    public static zzb zzani() {
        return (zzb) ((zzdob.zza) zzgoj.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        abc abcVar = null;
        switch (abd.f1777a[i - 1]) {
            case 1:
                return new zzdap();
            case 2:
                return new zzb(abcVar);
            case 3:
                return a(zzgoj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdj", "zzgoe", zza.zzad(), "zzgog", "zzgoh", "zzgoi"});
            case 4:
                return zzgoj;
            case 5:
                zzdpv<zzdap> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdap.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgoj);
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

    static {
        zzdob.a((Class<zzdap>) zzdap.class, zzgoj);
    }
}
