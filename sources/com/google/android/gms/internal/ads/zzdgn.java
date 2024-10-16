package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgn extends zzdob<zzdgn, zza> implements zzdpm {
    private static volatile zzdpv<zzdgn> zzdv;
    private static final zzdgn zzgtv = new zzdgn();
    private int zzgqu;
    private zzdgp zzgtt;

    private zzdgn() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgn, zza> implements zzdpm {
        private zza() {
            super(zzdgn.zzgtv);
        }

        /* synthetic */ zza(ade adeVar) {
            this();
        }
    }

    public final zzdgp zzarj() {
        zzdgp zzdgpVar = this.zzgtt;
        return zzdgpVar == null ? zzdgp.zzarr() : zzdgpVar;
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdgn zzbm(zzdmr zzdmrVar) throws zzdok {
        return (zzdgn) zzdob.a(zzgtv, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        ade adeVar = null;
        switch (ade.f1809a[i - 1]) {
            case 1:
                return new zzdgn();
            case 2:
                return new zza(adeVar);
            case 3:
                return a(zzgtv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgtt", "zzgqu"});
            case 4:
                return zzgtv;
            case 5:
                zzdpv<zzdgn> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgn.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtv);
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

    public static zzdgn zzarn() {
        return zzgtv;
    }

    static {
        zzdob.a((Class<zzdgn>) zzdgn.class, zzgtv);
    }
}
