package com.google.android.gms.internal.ads;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzdob;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.mtt.spcialcall.SpecialCallActivity;

/* loaded from: classes2.dex */
public final class zzbp {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, C0092zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        private static final zza zzhj = new zza();
        private int zzdj;
        private int zzeq;
        private int zzer;
        private long zzet;
        private long zzeu;
        private long zzev;
        private long zzew;
        private long zzex;
        private long zzey;
        private long zzez;
        private long zzfa;
        private long zzfb;
        private long zzfc;
        private long zzfe;
        private long zzff;
        private long zzfg;
        private long zzfh;
        private long zzfi;
        private long zzfj;
        private long zzfk;
        private long zzfl;
        private long zzfm;
        private long zzfo;
        private long zzfp;
        private long zzfq;
        private long zzfr;
        private zzb zzfu;
        private zze zzgj;
        private zzf zzgl;
        private int zzgw;
        private int zzgx;
        private int zzgy;
        private zzf zzgz;
        private long zzhc;
        private boolean zzhf;
        private long zzhh;
        private zze zzhi;
        private String zzes = "";
        private String zzdt = "";
        private String zzfd = "";
        private String zzej = "";
        private String zzfn = "";
        private String zzel = "";
        private long zzfs = -1;
        private long zzft = -1;
        private long zzfv = -1;
        private long zzfw = -1;
        private long zzfx = -1;
        private long zzfy = -1;
        private long zzfz = -1;
        private long zzga = -1;
        private String zzem = "D";
        private String zzen = "D";
        private int zzgb = 1000;
        private int zzgc = 1000;
        private long zzgd = -1;
        private long zzge = -1;
        private long zzgf = -1;
        private long zzgg = -1;
        private long zzgh = -1;
        private int zzgi = 1000;
        private zzdoj<zze> zzgk = d();
        private long zzgm = -1;
        private long zzgn = -1;
        private long zzgo = -1;
        private long zzgp = -1;
        private long zzgq = -1;
        private long zzgr = -1;
        private long zzgs = -1;
        private long zzgt = -1;
        private String zzgu = "D";
        private long zzgv = -1;
        private long zzha = -1;
        private int zzhb = 1000;
        private String zzhd = "";
        private int zzhe = 2;
        private String zzhg = "";

        /* loaded from: classes2.dex */
        public enum zzb implements zzdoe {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3);

            private static final zzdof<zzb> e = new ny();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzb zzg(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return oe.f2388a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        /* loaded from: classes2.dex */
        public enum zzc implements zzdoe {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);

            private static final zzdof<zzc> g = new ou();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            public static zzc zzh(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return pe.f2411a;
            }

            zzc(int i) {
                this.value = i;
            }
        }

        /* loaded from: classes2.dex */
        public enum zzd implements zzdoe {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(ProgressEvent.PART_COMPLETED_EVENT_CODE),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(Connections.MAX_BYTES_DATA_SIZE),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);

            private static final zzdof<zzd> x = new pi();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            zzd(int i) {
                this.value = i;
            }
        }

        /* loaded from: classes2.dex */
        public static final class zze extends zzdob<zze, C0093zza> implements zzdpm {
            private static volatile zzdpv<zze> zzdv;
            private static final zze zzjq = new zze();
            private int zzdj;
            private long zzjk;
            private long zzjl;
            private long zzfe = -1;
            private long zzff = -1;
            private long zzix = -1;
            private long zziy = -1;
            private long zziz = -1;
            private long zzja = -1;
            private int zzjb = 1000;
            private long zzjc = -1;
            private long zzjd = -1;
            private long zzje = -1;
            private int zzjf = 1000;
            private long zzjg = -1;
            private long zzjh = -1;
            private long zzji = -1;
            private long zzjj = -1;
            private long zzjm = -1;
            private long zzjn = -1;
            private long zzjo = -1;
            private long zzjp = -1;

            private zze() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbp$zza$zze$zza, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0093zza extends zzdob.zza<zze, C0093zza> implements zzdpm {
                private C0093zza() {
                    super(zze.zzjq);
                }

                public final C0093zza zzch(long j) {
                    a();
                    ((zze) this.f3590a).a(j);
                    return this;
                }

                public final C0093zza zzci(long j) {
                    a();
                    ((zze) this.f3590a).b(j);
                    return this;
                }

                public final C0093zza zzcj(long j) {
                    a();
                    ((zze) this.f3590a).c(j);
                    return this;
                }

                public final C0093zza zzck(long j) {
                    a();
                    ((zze) this.f3590a).d(j);
                    return this;
                }

                public final C0093zza zzas() {
                    a();
                    ((zze) this.f3590a).e();
                    return this;
                }

                public final C0093zza zzcl(long j) {
                    a();
                    ((zze) this.f3590a).e(j);
                    return this;
                }

                public final C0093zza zzcm(long j) {
                    a();
                    ((zze) this.f3590a).f(j);
                    return this;
                }

                public final C0093zza zzk(zzbz zzbzVar) {
                    a();
                    ((zze) this.f3590a).a(zzbzVar);
                    return this;
                }

                public final C0093zza zzcn(long j) {
                    a();
                    ((zze) this.f3590a).g(j);
                    return this;
                }

                public final C0093zza zzco(long j) {
                    a();
                    ((zze) this.f3590a).h(j);
                    return this;
                }

                public final C0093zza zzcp(long j) {
                    a();
                    ((zze) this.f3590a).i(j);
                    return this;
                }

                public final C0093zza zzl(zzbz zzbzVar) {
                    a();
                    ((zze) this.f3590a).b(zzbzVar);
                    return this;
                }

                public final C0093zza zzcq(long j) {
                    a();
                    ((zze) this.f3590a).j(j);
                    return this;
                }

                public final C0093zza zzcr(long j) {
                    a();
                    ((zze) this.f3590a).k(j);
                    return this;
                }

                public final C0093zza zzcs(long j) {
                    a();
                    ((zze) this.f3590a).l(j);
                    return this;
                }

                public final C0093zza zzct(long j) {
                    a();
                    ((zze) this.f3590a).m(j);
                    return this;
                }

                public final C0093zza zzcu(long j) {
                    a();
                    ((zze) this.f3590a).n(j);
                    return this;
                }

                public final C0093zza zzcv(long j) {
                    a();
                    ((zze) this.f3590a).o(j);
                    return this;
                }

                public final C0093zza zzcw(long j) {
                    a();
                    ((zze) this.f3590a).p(j);
                    return this;
                }

                public final C0093zza zzcx(long j) {
                    a();
                    ((zze) this.f3590a).q(j);
                    return this;
                }

                /* synthetic */ C0093zza(nv nvVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(long j) {
                this.zzdj |= 1;
                this.zzfe = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(long j) {
                this.zzdj |= 2;
                this.zzff = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void c(long j) {
                this.zzdj |= 4;
                this.zzix = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void d(long j) {
                this.zzdj |= 8;
                this.zziy = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void e() {
                this.zzdj &= -9;
                this.zziy = -1L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void e(long j) {
                this.zzdj |= 16;
                this.zziz = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void f(long j) {
                this.zzdj |= 32;
                this.zzja = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(zzbz zzbzVar) {
                if (zzbzVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 64;
                this.zzjb = zzbzVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void g(long j) {
                this.zzdj |= 128;
                this.zzjc = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void h(long j) {
                this.zzdj |= 256;
                this.zzjd = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void i(long j) {
                this.zzdj |= 512;
                this.zzje = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(zzbz zzbzVar) {
                if (zzbzVar == null) {
                    throw new NullPointerException();
                }
                this.zzdj |= 1024;
                this.zzjf = zzbzVar.zzac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void j(long j) {
                this.zzdj |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
                this.zzjg = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void k(long j) {
                this.zzdj |= 4096;
                this.zzjh = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void l(long j) {
                this.zzdj |= 8192;
                this.zzji = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void m(long j) {
                this.zzdj |= 16384;
                this.zzjj = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void n(long j) {
                this.zzdj |= Connections.MAX_BYTES_DATA_SIZE;
                this.zzjk = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void o(long j) {
                this.zzdj |= 65536;
                this.zzjl = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void p(long j) {
                this.zzdj |= 131072;
                this.zzjm = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void q(long j) {
                this.zzdj |= 262144;
                this.zzjn = j;
            }

            public static C0093zza zzaq() {
                return (C0093zza) ((zzdob.zza) zzjq.a(zzdob.zze.zzhho, (Object) null, (Object) null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                nv nvVar = null;
                switch (nv.f2381a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0093zza(nvVar);
                    case 3:
                        return a(zzjq, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\f\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\f\n\f\u0002\u000b\r\u0002\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002\u0014", new Object[]{"zzdj", "zzfe", "zzff", "zzix", "zziy", "zziz", "zzja", "zzjb", zzbz.zzad(), "zzjc", "zzjd", "zzje", "zzjf", zzbz.zzad(), "zzjg", "zzjh", "zzji", "zzjj", "zzjk", "zzjl", "zzjm", "zzjn", "zzjo", "zzjp"});
                    case 4:
                        return zzjq;
                    case 5:
                        zzdpv<zze> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zze.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzjq);
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
                zzdob.a((Class<zze>) zze.class, zzjq);
            }
        }

        /* loaded from: classes2.dex */
        public static final class zzf extends zzdob<zzf, C0094zza> implements zzdpm {
            private static volatile zzdpv<zzf> zzdv;
            private static final zzf zzjv = new zzf();
            private int zzdj;
            private long zzgg = -1;
            private long zzgh = -1;
            private long zzjr = -1;
            private long zzjs = -1;
            private long zzjt = -1;
            private long zzju = -1;

            private zzf() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbp$zza$zzf$zza, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0094zza extends zzdob.zza<zzf, C0094zza> implements zzdpm {
                private C0094zza() {
                    super(zzf.zzjv);
                }

                public final C0094zza zzdc(long j) {
                    a();
                    ((zzf) this.f3590a).a(j);
                    return this;
                }

                public final C0094zza zzdd(long j) {
                    a();
                    ((zzf) this.f3590a).b(j);
                    return this;
                }

                public final C0094zza zzde(long j) {
                    a();
                    ((zzf) this.f3590a).c(j);
                    return this;
                }

                public final C0094zza zzdf(long j) {
                    a();
                    ((zzf) this.f3590a).d(j);
                    return this;
                }

                /* synthetic */ C0094zza(nv nvVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void a(long j) {
                this.zzdj |= 4;
                this.zzjr = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void b(long j) {
                this.zzdj |= 8;
                this.zzjs = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void c(long j) {
                this.zzdj |= 16;
                this.zzjt = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void d(long j) {
                this.zzdj |= 32;
                this.zzju = j;
            }

            public static C0094zza zzat() {
                return (C0094zza) ((zzdob.zza) zzjv.a(zzdob.zze.zzhho, (Object) null, (Object) null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdob
            public final Object a(int i, Object obj, Object obj2) {
                nv nvVar = null;
                switch (nv.f2381a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0094zza(nvVar);
                    case 3:
                        return a(zzjv, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005", new Object[]{"zzdj", "zzgg", "zzgh", "zzjr", "zzjs", "zzjt", "zzju"});
                    case 4:
                        return zzjv;
                    case 5:
                        zzdpv<zzf> zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            synchronized (zzf.class) {
                                zzdpvVar = zzdv;
                                if (zzdpvVar == null) {
                                    zzdpvVar = new zzdob.zzb<>(zzjv);
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
                zzdob.a((Class<zzf>) zzf.class, zzjv);
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbp$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0092zza extends zzdob.zza<zza, C0092zza> implements zzdpm {
            private C0092zza() {
                super(zza.zzhj);
            }

            public final C0092zza zzx(String str) {
                a();
                ((zza) this.f3590a).a(str);
                return this;
            }

            public final C0092zza zzy(String str) {
                a();
                ((zza) this.f3590a).b(str);
                return this;
            }

            public final C0092zza zzal(long j) {
                a();
                ((zza) this.f3590a).a(j);
                return this;
            }

            public final C0092zza zzam(long j) {
                a();
                ((zza) this.f3590a).b(j);
                return this;
            }

            public final C0092zza zzan(long j) {
                a();
                ((zza) this.f3590a).c(j);
                return this;
            }

            public final C0092zza zzao(long j) {
                a();
                ((zza) this.f3590a).d(j);
                return this;
            }

            public final C0092zza zzap(long j) {
                a();
                ((zza) this.f3590a).e(j);
                return this;
            }

            public final C0092zza zzaq(long j) {
                a();
                ((zza) this.f3590a).f(j);
                return this;
            }

            public final C0092zza zzar(long j) {
                a();
                ((zza) this.f3590a).g(j);
                return this;
            }

            public final C0092zza zzas(long j) {
                a();
                ((zza) this.f3590a).h(j);
                return this;
            }

            public final C0092zza zzat(long j) {
                a();
                ((zza) this.f3590a).i(j);
                return this;
            }

            public final C0092zza zzau(long j) {
                a();
                ((zza) this.f3590a).j(j);
                return this;
            }

            public final C0092zza zzav(long j) {
                a();
                ((zza) this.f3590a).k(j);
                return this;
            }

            public final C0092zza zzaw(long j) {
                a();
                ((zza) this.f3590a).l(j);
                return this;
            }

            public final C0092zza zzz(String str) {
                a();
                ((zza) this.f3590a).c(str);
                return this;
            }

            public final C0092zza zzaa(String str) {
                a();
                ((zza) this.f3590a).d(str);
                return this;
            }

            public final C0092zza zzax(long j) {
                a();
                ((zza) this.f3590a).m(j);
                return this;
            }

            public final C0092zza zzay(long j) {
                a();
                ((zza) this.f3590a).n(j);
                return this;
            }

            public final C0092zza zzaz(long j) {
                a();
                ((zza) this.f3590a).o(j);
                return this;
            }

            public final C0092zza zzab(String str) {
                a();
                ((zza) this.f3590a).e(str);
                return this;
            }

            public final C0092zza zzba(long j) {
                a();
                ((zza) this.f3590a).p(j);
                return this;
            }

            @Deprecated
            public final C0092zza zzbb(long j) {
                a();
                ((zza) this.f3590a).q(j);
                return this;
            }

            public final C0092zza zzbc(long j) {
                a();
                ((zza) this.f3590a).r(j);
                return this;
            }

            public final C0092zza zzbd(long j) {
                a();
                ((zza) this.f3590a).s(j);
                return this;
            }

            public final C0092zza zzbe(long j) {
                a();
                ((zza) this.f3590a).t(j);
                return this;
            }

            public final C0092zza zzbf(long j) {
                a();
                ((zza) this.f3590a).u(j);
                return this;
            }

            public final C0092zza zzbg(long j) {
                a();
                ((zza) this.f3590a).v(j);
                return this;
            }

            public final C0092zza zzbh(long j) {
                a();
                ((zza) this.f3590a).w(j);
                return this;
            }

            public final C0092zza zzbi(long j) {
                a();
                ((zza) this.f3590a).x(j);
                return this;
            }

            public final C0092zza zzac(String str) {
                a();
                ((zza) this.f3590a).f(str);
                return this;
            }

            public final C0092zza zzad(String str) {
                a();
                ((zza) this.f3590a).g(str);
                return this;
            }

            public final C0092zza zze(zzbz zzbzVar) {
                a();
                ((zza) this.f3590a).a(zzbzVar);
                return this;
            }

            public final C0092zza zzf(zzbz zzbzVar) {
                a();
                ((zza) this.f3590a).b(zzbzVar);
                return this;
            }

            public final C0092zza zzbj(long j) {
                a();
                ((zza) this.f3590a).y(j);
                return this;
            }

            public final C0092zza zzbk(long j) {
                a();
                ((zza) this.f3590a).z(j);
                return this;
            }

            public final C0092zza zzbl(long j) {
                a();
                ((zza) this.f3590a).A(j);
                return this;
            }

            public final C0092zza zzg(zzbz zzbzVar) {
                a();
                ((zza) this.f3590a).c(zzbzVar);
                return this;
            }

            public final C0092zza zzc(zze zzeVar) {
                a();
                ((zza) this.f3590a).a(zzeVar);
                return this;
            }

            public final C0092zza zzd(zze zzeVar) {
                a();
                ((zza) this.f3590a).b(zzeVar);
                return this;
            }

            public final C0092zza zzao() {
                a();
                ((zza) this.f3590a).e();
                return this;
            }

            public final C0092zza zzb(zzf zzfVar) {
                a();
                ((zza) this.f3590a).a(zzfVar);
                return this;
            }

            public final C0092zza zzbm(long j) {
                a();
                ((zza) this.f3590a).B(j);
                return this;
            }

            public final C0092zza zzbn(long j) {
                a();
                ((zza) this.f3590a).C(j);
                return this;
            }

            public final C0092zza zzbo(long j) {
                a();
                ((zza) this.f3590a).D(j);
                return this;
            }

            public final C0092zza zzbp(long j) {
                a();
                ((zza) this.f3590a).E(j);
                return this;
            }

            public final C0092zza zzbq(long j) {
                a();
                ((zza) this.f3590a).F(j);
                return this;
            }

            public final C0092zza zzae(String str) {
                a();
                ((zza) this.f3590a).h(str);
                return this;
            }

            public final C0092zza zzb(zzf zzfVar) {
                a();
                ((zza) this.f3590a).a(zzfVar);
                return this;
            }

            public final C0092zza zzh(zzbz zzbzVar) {
                a();
                ((zza) this.f3590a).d(zzbzVar);
                return this;
            }

            public final C0092zza zzaf(String str) {
                a();
                ((zza) this.f3590a).i(str);
                return this;
            }

            public final C0092zza zzb(zzc zzcVar) {
                a();
                ((zza) this.f3590a).a(zzcVar);
                return this;
            }

            public final C0092zza zzb(boolean z) {
                a();
                ((zza) this.f3590a).a(z);
                return this;
            }

            public final C0092zza zzbr(long j) {
                a();
                ((zza) this.f3590a).G(j);
                return this;
            }

            /* synthetic */ C0092zza(nv nvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzes = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 2;
            this.zzdt = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzdj |= 4;
            this.zzet = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(long j) {
            this.zzdj |= 16;
            this.zzev = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(long j) {
            this.zzdj |= 32;
            this.zzew = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(long j) {
            this.zzdj |= 1024;
            this.zzfb = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(long j) {
            this.zzdj |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
            this.zzfc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(long j) {
            this.zzdj |= 8192;
            this.zzfe = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(long j) {
            this.zzdj |= 16384;
            this.zzff = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(long j) {
            this.zzdj |= Connections.MAX_BYTES_DATA_SIZE;
            this.zzfg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(long j) {
            this.zzdj |= 65536;
            this.zzfh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(long j) {
            this.zzdj |= 524288;
            this.zzfk = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(long j) {
            this.zzdj |= Constants.MB;
            this.zzfl = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(long j) {
            this.zzdj |= 2097152;
            this.zzfm = j;
        }

        public final boolean zzai() {
            return (this.zzdj & 4194304) == 4194304;
        }

        public final String zzae() {
            return this.zzej;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 4194304;
            this.zzej = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 8388608;
            this.zzfn = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m(long j) {
            this.zzdj |= SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            this.zzfo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n(long j) {
            this.zzdj |= 33554432;
            this.zzfp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o(long j) {
            this.zzdj |= 67108864;
            this.zzfq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 134217728;
            this.zzel = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void p(long j) {
            this.zzdj |= DriveFile.MODE_READ_ONLY;
            this.zzfr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(long j) {
            this.zzdj |= DriveFile.MODE_WRITE_ONLY;
            this.zzfs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(long j) {
            this.zzdj |= 1073741824;
            this.zzft = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void s(long j) {
            this.zzeq |= 1;
            this.zzfv = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t(long j) {
            this.zzeq |= 2;
            this.zzfw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u(long j) {
            this.zzeq |= 4;
            this.zzfx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void v(long j) {
            this.zzeq |= 8;
            this.zzfy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void w(long j) {
            this.zzeq |= 16;
            this.zzfz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void x(long j) {
            this.zzeq |= 32;
            this.zzga = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzeq |= 64;
            this.zzem = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzeq |= 128;
            this.zzen = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzbz zzbzVar) {
            if (zzbzVar == null) {
                throw new NullPointerException();
            }
            this.zzeq |= 256;
            this.zzgb = zzbzVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(zzbz zzbzVar) {
            if (zzbzVar == null) {
                throw new NullPointerException();
            }
            this.zzeq |= 512;
            this.zzgc = zzbzVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void y(long j) {
            this.zzeq |= 1024;
            this.zzgd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void z(long j) {
            this.zzeq |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
            this.zzge = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void A(long j) {
            this.zzeq |= 4096;
            this.zzgf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(zzbz zzbzVar) {
            if (zzbzVar == null) {
                throw new NullPointerException();
            }
            this.zzeq |= Connections.MAX_BYTES_DATA_SIZE;
            this.zzgi = zzbzVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zze zzeVar) {
            if (zzeVar == null) {
                throw new NullPointerException();
            }
            this.zzgj = zzeVar;
            this.zzeq |= 65536;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(zze zzeVar) {
            if (zzeVar == null) {
                throw new NullPointerException();
            }
            if (!this.zzgk.zzavi()) {
                zzdoj<zze> zzdojVar = this.zzgk;
                int size = zzdojVar.size();
                this.zzgk = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
            }
            this.zzgk.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e() {
            this.zzgk = d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzf zzfVar) {
            if (zzfVar == null) {
                throw new NullPointerException();
            }
            this.zzgl = zzfVar;
            this.zzeq |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(long j) {
            this.zzeq |= 524288;
            this.zzgn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j) {
            this.zzeq |= Constants.MB;
            this.zzgo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(long j) {
            this.zzeq |= 2097152;
            this.zzgp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(long j) {
            this.zzeq |= SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            this.zzgs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(long j) {
            this.zzeq |= 33554432;
            this.zzgt = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzeq |= 67108864;
            this.zzgu = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzf zzfVar) {
            if (zzfVar == null) {
                throw new NullPointerException();
            }
            this.zzgz = zzfVar;
            this.zzeq |= BleSignal.UNKNOWN_TX_POWER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(zzbz zzbzVar) {
            if (zzbzVar == null) {
                throw new NullPointerException();
            }
            this.zzer |= 2;
            this.zzhb = zzbzVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzer |= 8;
            this.zzhd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzc zzcVar) {
            if (zzcVar == null) {
                throw new NullPointerException();
            }
            this.zzer |= 16;
            this.zzhe = zzcVar.zzac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(boolean z) {
            this.zzer |= 32;
            this.zzhf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void G(long j) {
            this.zzer |= 128;
            this.zzhh = j;
        }

        public final boolean zzak() {
            return (this.zzer & 256) == 256;
        }

        public final zze zzal() {
            zze zzeVar = this.zzhi;
            return zzeVar == null ? zze.zzbg() : zzeVar;
        }

        public static zza zzb(byte[] bArr, zzdno zzdnoVar) throws zzdok {
            return (zza) zzdob.a(zzhj, bArr, zzdnoVar);
        }

        public static C0092zza zzam() {
            return (C0092zza) ((zzdob.zza) zzhj.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0092zza(nvVar);
                case 3:
                    return a(zzhj, "\u0001J\u0000\u0003\u0001ÉJ\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\u0002\n\f\u0002\u000b\r\b\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002B\u0016\u0002\u0014\u0017\u0002\u0015\u0018\bC\u0019\u0002G\u001a\fD\u001b\b\u0016\u001c\u0007E\u001d\b\u0017\u001e\bF\u001f\u0002\u0018 \u0002\u0019!\u0002\u001a\"\b\u001b#\u0002\u001c$\u0002\u001d%\u0002\u001e&\t\u001f'\u0002 (\u0002!)\u0002\"*\u0002#+\u001b,\u0002$-\u0002%.\b&/\b'0\f(1\f)2\t03\u0002*4\u0002+5\u0002,6\u0002-7\u0002.8\f/9\t1:\u00022;\u00023<\u00024=\u00025>\u00028?\u00029@\u0002;A\f<B\f=C\b:D\f>E\t?F\u0002@G\u00026H\u00027I\fAÉ\tH", new Object[]{"zzdj", "zzeq", "zzer", "zzes", "zzdt", "zzet", "zzeu", "zzev", "zzew", "zzex", "zzey", "zzez", "zzfa", "zzfb", "zzfc", "zzfd", "zzfe", "zzff", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzhc", "zzfl", "zzfm", "zzhd", "zzhh", "zzhe", zzc.zzad(), "zzej", "zzhf", "zzfn", "zzhg", "zzfo", "zzfp", "zzfq", "zzel", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzgk", zze.class, "zzfz", "zzga", "zzem", "zzen", "zzgb", zzbz.zzad(), "zzgc", zzbz.zzad(), "zzgj", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzgi", zzbz.zzad(), "zzgl", "zzgm", "zzgn", "zzgo", "zzgp", "zzgs", "zzgt", "zzgv", "zzgw", zzbw.zzad(), "zzgx", zzcc.zzad(), "zzgu", "zzgy", zzb.zzad(), "zzgz", "zzha", "zzgq", "zzgr", "zzhb", zzbz.zzad(), "zzhi"});
                case 4:
                    return zzhj;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzhj);
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
            zzdob.a((Class<zza>) zza.class, zzhj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzkb = new zzb();
        private int zzdj;
        private long zzjw;
        private int zzjx;
        private boolean zzjy;
        private zzdoh zzjz = c();
        private long zzka;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzkb);
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzkb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0007\u0002\u0004\u0016\u0005\u0003\u0003", new Object[]{"zzdj", "zzjw", "zzjx", "zzjy", "zzjz", "zzka"});
                case 4:
                    return zzkb;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzkb);
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
            zzdob.a((Class<zzb>) zzb.class, zzkb);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static volatile zzdpv<zzc> zzdv;
        private static final zzc zzke = new zzc();
        private int zzdj;
        private zzdmr zzkc = zzdmr.zzhcr;
        private zzdmr zzkd = zzdmr.zzhcr;

        private zzc() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzke);
            }

            public final zza zzc(zzdmr zzdmrVar) {
                a();
                ((zzc) this.f3590a).a(zzdmrVar);
                return this;
            }

            public final zza zzd(zzdmr zzdmrVar) {
                a();
                ((zzc) this.f3590a).b(zzdmrVar);
                return this;
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzkc = zzdmrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 2;
            this.zzkd = zzdmrVar;
        }

        public static zza zzaw() {
            return (zza) ((zzdob.zza) zzke.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzke, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzkc", "zzkd"});
                case 4:
                    return zzke;
                case 5:
                    zzdpv<zzc> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzc.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzke);
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
            zzdob.a((Class<zzc>) zzc.class, zzke);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
        private static volatile zzdpv<zzd> zzdv;
        private static final zzd zzkj = new zzd();
        private int zzdj;
        private zzdmr zzkf = zzdmr.zzhcr;
        private zzdmr zzkg = zzdmr.zzhcr;
        private zzdmr zzkh = zzdmr.zzhcr;
        private zzdmr zzki = zzdmr.zzhcr;

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
            private zza() {
                super(zzd.zzkj);
            }

            public final zza zzi(zzdmr zzdmrVar) {
                a();
                ((zzd) this.f3590a).a(zzdmrVar);
                return this;
            }

            public final zza zzj(zzdmr zzdmrVar) {
                a();
                ((zzd) this.f3590a).b(zzdmrVar);
                return this;
            }

            public final zza zzk(zzdmr zzdmrVar) {
                a();
                ((zzd) this.f3590a).c(zzdmrVar);
                return this;
            }

            public final zza zzl(zzdmr zzdmrVar) {
                a();
                ((zzd) this.f3590a).d(zzdmrVar);
                return this;
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        public final zzdmr zzay() {
            return this.zzkf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzkf = zzdmrVar;
        }

        public final zzdmr zzaz() {
            return this.zzkg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 2;
            this.zzkg = zzdmrVar;
        }

        public final zzdmr zzba() {
            return this.zzkh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 4;
            this.zzkh = zzdmrVar;
        }

        public final zzdmr zzbb() {
            return this.zzki;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 8;
            this.zzki = zzdmrVar;
        }

        public static zzd zzc(byte[] bArr, zzdno zzdnoVar) throws zzdok {
            return (zzd) zzdob.a(zzkj, bArr, zzdnoVar);
        }

        public static zza zzbc() {
            return (zza) ((zzdob.zza) zzkj.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzkj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\n\u0003", new Object[]{"zzdj", "zzkf", "zzkg", "zzkh", "zzki"});
                case 4:
                    return zzkj;
                case 5:
                    zzdpv<zzd> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzd.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzkj);
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
            zzdob.a((Class<zzd>) zzd.class, zzkj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzdob<zze, zza> implements zzdpm {
        private static volatile zzdpv<zze> zzdv;
        private static final zze zzlb = new zze();
        private int zzdj;
        private long zzjw;
        private String zzkz = "";
        private zzdmr zzla = zzdmr.zzhcr;

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
            private zza() {
                super(zze.zzlb);
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        public final boolean zzbe() {
            return (this.zzdj & 1) == 1;
        }

        public final long zzbf() {
            return this.zzjw;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzlb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0003\b\u0001\u0004\n\u0002", new Object[]{"zzdj", "zzjw", "zzkz", "zzla"});
                case 4:
                    return zzlb;
                case 5:
                    zzdpv<zze> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zze.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzlb);
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

        public static zze zzbg() {
            return zzlb;
        }

        static {
            zzdob.a((Class<zze>) zze.class, zzlb);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
        private static volatile zzdpv<zzf> zzdv;
        private static final zzf zzlc = new zzf();
        private int zzdj;
        private String zzeo = "";

        private zzf() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
            private zza() {
                super(zzf.zzlc);
            }

            public final zza zzah(String str) {
                a();
                ((zzf) this.f3590a).a(str);
                return this;
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzeo = str;
        }

        public static zza zzbi() {
            return (zza) ((zzdob.zza) zzlc.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzlc, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzeo"});
                case 4:
                    return zzlc;
                case 5:
                    zzdpv<zzf> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzf.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzlc);
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
            zzdob.a((Class<zzf>) zzf.class, zzlc);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzg extends zzdob<zzg, zza> implements zzdpm {
        private static volatile zzdpv<zzg> zzdv;
        private static final zzg zzle = new zzg();
        private int zzdj;
        private zzdoj<zzdmr> zzld = d();
        private zzdmr zzkg = zzdmr.zzhcr;
        private int zzgx = 1;
        private int zzgw = 1;

        private zzg() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzg, zza> implements zzdpm {
            private zza() {
                super(zzg.zzle);
            }

            public final zza zzn(zzdmr zzdmrVar) {
                a();
                ((zzg) this.f3590a).a(zzdmrVar);
                return this;
            }

            public final zza zzo(zzdmr zzdmrVar) {
                a();
                ((zzg) this.f3590a).b(zzdmrVar);
                return this;
            }

            public final zza zzb(zzbw zzbwVar) {
                a();
                ((zzg) this.f3590a).a(zzbwVar);
                return this;
            }

            /* synthetic */ zza(nv nvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            if (!this.zzld.zzavi()) {
                zzdoj<zzdmr> zzdojVar = this.zzld;
                int size = zzdojVar.size();
                this.zzld = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
            }
            this.zzld.add(zzdmrVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(zzdmr zzdmrVar) {
            if (zzdmrVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 1;
            this.zzkg = zzdmrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzbw zzbwVar) {
            if (zzbwVar == null) {
                throw new NullPointerException();
            }
            this.zzdj |= 4;
            this.zzgw = zzbwVar.zzac();
        }

        public static zza zzbk() {
            return (zza) ((zzdob.zza) zzle.a(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            nv nvVar = null;
            switch (nv.f2381a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(nvVar);
                case 3:
                    return a(zzle, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002\n\u0000\u0003\f\u0001\u0004\f\u0002", new Object[]{"zzdj", "zzld", "zzkg", "zzgx", zzcc.zzad(), "zzgw", zzbw.zzad()});
                case 4:
                    return zzle;
                case 5:
                    zzdpv<zzg> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzg.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzle);
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
            zzdob.a((Class<zzg>) zzg.class, zzle);
        }
    }
}
