package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzddt extends zzdob<zzddt, zza> implements zzdpm {
    private static volatile zzdpv<zzddt> zzdv;
    private static final zzddt zzgqq = new zzddt();
    private zzded zzgqo;
    private zzdgn zzgqp;

    private zzddt() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzddt, zza> implements zzdpm {
        private zza() {
            super(zzddt.zzgqq);
        }

        /* synthetic */ zza(acj acjVar) {
            this();
        }
    }

    public final zzded zzaoe() {
        zzded zzdedVar = this.zzgqo;
        return zzdedVar == null ? zzded.zzaow() : zzdedVar;
    }

    public final zzdgn zzaof() {
        zzdgn zzdgnVar = this.zzgqp;
        return zzdgnVar == null ? zzdgn.zzarn() : zzdgnVar;
    }

    public static zzddt zzv(zzdmr zzdmrVar) throws zzdok {
        return (zzddt) zzdob.a(zzgqq, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acj acjVar = null;
        switch (acj.f1790a[i - 1]) {
            case 1:
                return new zzddt();
            case 2:
                return new zza(acjVar);
            case 3:
                return a(zzgqq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzgqo", "zzgqp"});
            case 4:
                return zzgqq;
            case 5:
                zzdpv<zzddt> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzddt.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgqq);
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
        zzdob.a((Class<zzddt>) zzddt.class, zzgqq);
    }
}
