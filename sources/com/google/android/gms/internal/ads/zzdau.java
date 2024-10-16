package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdap;
import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdau extends zzdob<zzdau, zza> implements zzdpm {
    private static volatile zzdpv<zzdau> zzdv;
    private static final zzdau zzgoq = new zzdau();
    private int zzdj;
    private int zzgon;
    private zzdap zzgop;
    private String zzdk = "";
    private String zzgoo = "";

    /* loaded from: classes2.dex */
    public enum zzb implements zzdoe {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);

        private static final zzdof<zzb> b = new abh();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzdoe
        public final int zzac() {
            return this.value;
        }

        public static zzb zzdt(int i) {
            switch (i) {
                case 0:
                    return EVENT_TYPE_UNKNOWN;
                case 1:
                    return BLOCKED_IMPRESSION;
                default:
                    return null;
            }
        }

        public static zzdog zzad() {
            return abi.f1780a;
        }

        zzb(int i) {
            this.value = i;
        }
    }

    private zzdau() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdau, zza> implements zzdpm {
        private zza() {
            super(zzdau.zzgoq);
        }

        public final zza zzb(zzb zzbVar) {
            a();
            ((zzdau) this.f3590a).a(zzbVar);
            return this;
        }

        public final zza zzge(String str) {
            a();
            ((zzdau) this.f3590a).a(str);
            return this;
        }

        public final zza zzb(zzdap.zzb zzbVar) {
            a();
            ((zzdau) this.f3590a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(abg abgVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        this.zzdj |= 1;
        this.zzgon = zzbVar.zzac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdj |= 2;
        this.zzdk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdap.zzb zzbVar) {
        this.zzgop = (zzdap) ((zzdob) zzbVar.zzaya());
        this.zzdj |= 8;
    }

    public static zza zzank() {
        return (zza) ((zzdob.zza) zzgoq.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        abg abgVar = null;
        switch (abg.f1779a[i - 1]) {
            case 1:
                return new zzdau();
            case 2:
                return new zza(abgVar);
            case 3:
                return a(zzgoq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdj", "zzgon", zzb.zzad(), "zzdk", "zzgoo", "zzgop"});
            case 4:
                return zzgoq;
            case 5:
                zzdpv<zzdau> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdau.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgoq);
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
        zzdob.a((Class<zzdau>) zzdau.class, zzgoq);
    }
}
