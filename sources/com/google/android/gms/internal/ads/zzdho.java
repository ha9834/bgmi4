package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdho extends zzdob<zzdho, zza> implements zzdpm {
    private static volatile zzdpv<zzdho> zzdv;
    private static final zzdho zzgvz = new zzdho();
    private int zzdj;
    private String zzgvx = "";
    private zzdoj<zzdgy> zzgvy = d();

    private zzdho() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdho, zza> implements zzdpm {
        private zza() {
            super(zzdho.zzgvz);
        }

        public final zza zzgs(String str) {
            a();
            ((zzdho) this.f3590a).a(str);
            return this;
        }

        public final zza zzb(zzdgy zzdgyVar) {
            a();
            ((zzdho) this.f3590a).a(zzdgyVar);
            return this;
        }

        /* synthetic */ zza(ads adsVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzgvx = str;
    }

    public final List<zzdgy> zzatj() {
        return this.zzgvy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzdgy zzdgyVar) {
        if (zzdgyVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzgvy.zzavi()) {
            zzdoj<zzdgy> zzdojVar = this.zzgvy;
            int size = zzdojVar.size();
            this.zzgvy = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
        }
        this.zzgvy.add(zzdgyVar);
    }

    public static zza zzatk() {
        return (zza) ((zzdob.zza) zzgvz.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        ads adsVar = null;
        switch (ads.f1820a[i - 1]) {
            case 1:
                return new zzdho();
            case 2:
                return new zza(adsVar);
            case 3:
                return a(zzgvz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzdj", "zzgvx", "zzgvy", zzdgy.class});
            case 4:
                return zzgvz;
            case 5:
                zzdpv<zzdho> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdho.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvz);
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
        zzdob.a((Class<zzdho>) zzdho.class, zzgvz);
    }
}
