package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgy extends zzdob<zzdgy, zza> implements zzdpm {
    private static volatile zzdpv<zzdgy> zzdv;
    private static final zzdgy zzguw = new zzdgy();
    private int zzgut;
    private boolean zzguu;
    private String zzgus = "";
    private String zzgtz = "";
    private String zzguv = "";

    private zzdgy() {
    }

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgy, zza> implements zzdpm {
        private zza() {
            super(zzdgy.zzguw);
        }

        public final zza zzgn(String str) {
            a();
            ((zzdgy) this.f3590a).a(str);
            return this;
        }

        public final zza zzgo(String str) {
            a();
            ((zzdgy) this.f3590a).b(str);
            return this;
        }

        public final zza zzeq(int i) {
            a();
            ((zzdgy) this.f3590a).b(0);
            return this;
        }

        public final zza zzbe(boolean z) {
            a();
            ((zzdgy) this.f3590a).a(true);
            return this;
        }

        public final zza zzgp(String str) {
            a();
            ((zzdgy) this.f3590a).c(str);
            return this;
        }

        /* synthetic */ zza(adk adkVar) {
            this();
        }
    }

    public final String zzasb() {
        return this.zzgus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzgus = str;
    }

    public final String zzart() {
        return this.zzgtz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzgtz = str;
    }

    public final int zzasc() {
        return this.zzgut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzgut = i;
    }

    public final boolean zzasd() {
        return this.zzguu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        this.zzguu = z;
    }

    public final String zzase() {
        return this.zzguv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzguv = str;
    }

    public static zza zzasf() {
        return (zza) ((zzdob.zza) zzguw.a(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object a(int i, Object obj, Object obj2) {
        adk adkVar = null;
        switch (adk.f1813a[i - 1]) {
            case 1:
                return new zzdgy();
            case 2:
                return new zza(adkVar);
            case 3:
                return a(zzguw, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzgus", "zzgtz", "zzgut", "zzguu", "zzguv"});
            case 4:
                return zzguw;
            case 5:
                zzdpv<zzdgy> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgy.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzguw);
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
        zzdob.a((Class<zzdgy>) zzdgy.class, zzguw);
    }
}
