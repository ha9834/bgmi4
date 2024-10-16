package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdhe extends zzdob<zzdhe, zza> implements zzdpm {
    private static volatile zzdpv<zzdhe> zzdv;
    private static final zzdhe zzgvi = new zzdhe();
    private int zzgqk;
    private zzdhg zzgvh;

    private zzdhe() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhe, zza> implements zzdpm {
        private zza() {
            super(zzdhe.zzgvi);
        }

        public final zza zzex(int i) {
            a();
            ((zzdhe) this.f3590a).b(0);
            return this;
        }

        public final zza zzb(zzdhg zzdhgVar) {
            a();
            ((zzdhe) this.f3590a).a(zzdhgVar);
            return this;
        }

        /* synthetic */ zza(adn adnVar) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzgqk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzgqk = i;
    }

    public final zzdhg zzasw() {
        zzdhg zzdhgVar = this.zzgvh;
        return zzdhgVar == null ? zzdhg.zzata() : zzdhgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdhg zzdhgVar) {
        if (zzdhgVar == null) {
            throw new NullPointerException();
        }
        this.zzgvh = zzdhgVar;
    }

    public static zzdhe zzbp(zzdmr zzdmrVar) throws zzdok {
        return (zzdhe) zzdob.a(zzgvi, zzdmrVar);
    }

    public static zza zzasx() {
        return (zza) ((zzdob.zza) zzgvi.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adn adnVar = null;
        switch (adn.f1816a[i - 1]) {
            case 1:
                return new zzdhe();
            case 2:
                return new zza(adnVar);
            case 3:
                return a(zzgvi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvh"});
            case 4:
                return zzgvi;
            case 5:
                zzdpv<zzdhe> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhe.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvi);
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
        zzdob.a((Class<zzdhe>) zzdhe.class, zzgvi);
    }
}
