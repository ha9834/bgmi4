package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;

/* loaded from: classes2.dex */
public final class zzkt {

    /* loaded from: classes2.dex */
    public static final class zza extends zzhh<zza, C0106zza> implements zzio {
        private static volatile zziz<zza> zzmk;
        private static final zza zzzp = new zza();
        private String zzzo = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_remote_config.zzkt$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0106zza extends zzhh.zza<zza, C0106zza> implements zzio {
            private C0106zza() {
                super(zza.zzzp);
            }

            /* synthetic */ C0106zza(ep epVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zza>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zza> zzizVar;
            ep epVar = null;
            switch (ep.f4094a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0106zza(epVar);
                case 3:
                    return a(zzzp, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzzo"});
                case 4:
                    return zzzp;
                case 5:
                    zziz<zza> zzizVar2 = zzmk;
                    zziz<zza> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zza.class) {
                            zziz<zza> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzzp);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zza>) zza.class, zzzp);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzhh<zzb, zza> implements zzio {
        private static final zzb zzaac = new zzb();
        private static volatile zziz<zzb> zzmk;
        private int zzaaa;
        private long zzzr;
        private long zzzt;
        private long zzzu;
        private String zzzo = "";
        private String zzzq = "";
        private String zzzs = "";
        private String zzzv = "";
        private String zzzw = "";
        private String zzzx = "";
        private String zzzy = "";
        private String zzzz = "";
        private zzhn<zza> zzaab = d();

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zzb, zza> implements zzio {
            private zza() {
                super(zzb.zzaac);
            }

            /* synthetic */ zza(ep epVar) {
                this();
            }
        }

        public final String zzjm() {
            return this.zzzo;
        }

        public final String zzjn() {
            return this.zzzq;
        }

        public final long zzjo() {
            return this.zzzr;
        }

        public final String zzjp() {
            return this.zzzs;
        }

        public final long zzjq() {
            return this.zzzt;
        }

        public final long zzjr() {
            return this.zzzu;
        }

        public static zzb zzg(byte[] bArr) throws zzhm {
            return (zzb) zzhh.a(zzaac, bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zzb> zzizVar;
            ep epVar = null;
            switch (ep.f4094a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(epVar);
                case 3:
                    return a(zzaac, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"zzzo", "zzzq", "zzzr", "zzzs", "zzzt", "zzzu", "zzzv", "zzzw", "zzzx", "zzzy", "zzzz", "zzaaa", "zzaab", zza.class});
                case 4:
                    return zzaac;
                case 5:
                    zziz<zzb> zzizVar2 = zzmk;
                    zziz<zzb> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zzb.class) {
                            zziz<zzb> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzaac);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zzb>) zzb.class, zzaac);
        }
    }
}
