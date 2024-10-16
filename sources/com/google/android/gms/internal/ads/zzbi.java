package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzbi {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, C0090zza> implements zzdpm {
        private static final zza zzdu = new zza();
        private static volatile zzdpv<zza> zzdv;
        private int zzdj;
        private long zzdl;
        private long zzdp;
        private long zzdq;
        private long zzds;
        private String zzdk = "";
        private String zzdm = "";
        private String zzdn = "";
        private String zzdo = "";
        private String zzdr = "";
        private String zzdt = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbi$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0090zza extends zzdob.zza<zza, C0090zza> implements zzdpm {
            private C0090zza() {
                super(zza.zzdu);
            }

            public final C0090zza zzl(String str) {
                a();
                ((zza) this.f3590a).a(str);
                return this;
            }

            public final C0090zza zzd(long j) {
                a();
                ((zza) this.f3590a).a(j);
                return this;
            }

            public final C0090zza zzm(String str) {
                a();
                ((zza) this.f3590a).b(str);
                return this;
            }

            public final C0090zza zzn(String str) {
                a();
                ((zza) this.f3590a).c(str);
                return this;
            }

            /* synthetic */ C0090zza(mb mbVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzdk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzdj |= 2;
            this.zzdl = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 4;
            this.zzdm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 8;
            this.zzdn = str;
        }

        public static C0090zza zzs() {
            return (C0090zza) ((zzdob.zza) zzdu.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            mb mbVar = null;
            switch (mb.f2334a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0090zza(mbVar);
                case 3:
                    return a(zzdu, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t", new Object[]{"zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt"});
                case 4:
                    return zzdu;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzdu);
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
            zzdob.a((Class<zza>) zza.class, zzdu);
        }
    }
}
