package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdev extends zzdob<zzdev, zza> implements zzdpm {
    private static volatile zzdpv<zzdev> zzdv;
    private static final zzdev zzgrp = new zzdev();
    private int zzgqu;

    private zzdev() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdev, zza> implements zzdpm {
        private zza() {
            super(zzdev.zzgrp);
        }

        /* synthetic */ zza(acr acrVar) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdev zzal(zzdmr zzdmrVar) throws zzdok {
        return (zzdev) zzdob.a(zzgrp, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        acr acrVar = null;
        switch (acr.f1798a[i - 1]) {
            case 1:
                return new zzdev();
            case 2:
                return new zza(acrVar);
            case 3:
                return a(zzgrp, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzgqu"});
            case 4:
                return zzgrp;
            case 5:
                zzdpv<zzdev> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdev.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrp);
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
        zzdob.a((Class<zzdev>) zzdev.class, zzgrp);
    }
}
