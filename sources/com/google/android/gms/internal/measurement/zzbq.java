package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;

/* loaded from: classes2.dex */
public final class zzbq {

    /* loaded from: classes2.dex */
    public static final class zza extends zzey<zza, C0110zza> implements zzgk {
        private static volatile zzgr<zza> zzuo;
        private static final zza zzwa = new zza();
        private int zzue;
        private String zzvy = "";
        private String zzvz = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbq$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0110zza extends zzey.zza<zza, C0110zza> implements zzgk {
            private C0110zza() {
                super(zza.zzwa);
            }

            /* synthetic */ C0110zza(ao aoVar) {
                this();
            }
        }

        public final String getKey() {
            return this.zzvy;
        }

        public final String getValue() {
            return this.zzvz;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ao aoVar = null;
            switch (ao.f4475a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0110zza(aoVar);
                case 3:
                    return a(zzwa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzue", "zzvy", "zzvz"});
                case 4:
                    return zzwa;
                case 5:
                    zzgr<zza> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zza.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwa);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzgr<zza> zzkj() {
            return (zzgr) zzwa.a(zzey.zzd.zzaij, (Object) null, (Object) null);
        }

        static {
            zzey.a((Class<zza>) zza.class, zzwa);
        }
    }
}
