package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgh extends zzdob<zzdgh, zza> implements zzdpm {
    private static volatile zzdpv<zzdgh> zzdv;
    private static final zzdgh zzgtm = new zzdgh();

    private zzdgh() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgh, zza> implements zzdpm {
        private zza() {
            super(zzdgh.zzgtm);
        }

        /* synthetic */ zza(adb adbVar) {
            this();
        }
    }

    public static zzdgh zzbj(zzdmr zzdmrVar) throws zzdok {
        return (zzdgh) zzdob.a(zzgtm, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adb adbVar = null;
        switch (adb.f1807a[i - 1]) {
            case 1:
                return new zzdgh();
            case 2:
                return new zza(adbVar);
            case 3:
                return a(zzgtm, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzgtm;
            case 5:
                zzdpv<zzdgh> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgh.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtm);
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
        zzdob.a((Class<zzdgh>) zzdgh.class, zzgtm);
    }
}
