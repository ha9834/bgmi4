package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdef extends zzdob<zzdef, zza> implements zzdpm {
    private static volatile zzdpv<zzdef> zzdv;
    private static final zzdef zzgrf = new zzdef();
    private int zzgre;

    private zzdef() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdef, zza> implements zzdpm {
        private zza() {
            super(zzdef.zzgrf);
        }

        /* synthetic */ zza(acm acmVar) {
            this();
        }
    }

    public final int zzaoy() {
        return this.zzgre;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acm acmVar = null;
        switch (acm.f1793a[i - 1]) {
            case 1:
                return new zzdef();
            case 2:
                return new zza(acmVar);
            case 3:
                return a(zzgrf, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrf;
            case 5:
                zzdpv<zzdef> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdef.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrf);
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

    public static zzdef zzaoz() {
        return zzgrf;
    }

    static {
        zzdob.a((Class<zzdef>) zzdef.class, zzgrf);
    }
}
