package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzgo extends zzfu {
    private static final Logger b = Logger.getLogger(zzgo.class.getName());
    private static final boolean c = eh.a();

    /* renamed from: a, reason: collision with root package name */
    bv f4176a;

    private static int a(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static long a(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzas(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzau(int i) {
        return 4;
    }

    public static int zzav(int i) {
        return 4;
    }

    public static int zzc(float f) {
        return 4;
    }

    public static zzgo zzc(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zzf(boolean z) {
        return 1;
    }

    public static int zzl(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzn(long j) {
        return 8;
    }

    public static int zzo(long j) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, zzim zzimVar, dm dmVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfx zzfxVar) throws IOException;

    public abstract void zza(int i, zzim zzimVar) throws IOException;

    public abstract void zzam(int i) throws IOException;

    public abstract void zzan(int i) throws IOException;

    public abstract void zzap(int i) throws IOException;

    public abstract void zzb(int i, zzfx zzfxVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(zzfx zzfxVar) throws IOException;

    public abstract void zzb(zzim zzimVar) throws IOException;

    public abstract void zzbk(String str) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(int i, boolean z) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgb();

    public abstract void zzh(long j) throws IOException;

    public abstract void zzj(long j) throws IOException;

    /* loaded from: classes2.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L15
                java.lang.String r3 = r0.concat(r3)
                goto L1a
            L15:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L1a:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzgo.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzgo() {
    }

    public final void zzf(int i, int i2) throws IOException {
        zze(i, a(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, a(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzao(int i) throws IOException {
        zzan(a(i));
    }

    /* loaded from: classes2.dex */
    static class a extends zzgo {
        private final byte[] b;
        private final int c;
        private final int d;
        private int e;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.b = bArr;
            this.c = 0;
            this.e = 0;
            this.d = i3;
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzc(int i, int i2) throws IOException {
            zzan((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzam(i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzan(i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzap(i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzh(j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzj(j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzc(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzbk(str);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zza(int i, zzfx zzfxVar) throws IOException {
            zzc(i, 2);
            zzb(zzfxVar);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzb(zzfx zzfxVar) throws IOException {
            zzan(zzfxVar.size());
            zzfxVar.a(this);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzan(i2);
            b(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        final void a(int i, zzim zzimVar, dm dmVar) throws IOException {
            zzc(i, 2);
            zzfm zzfmVar = (zzfm) zzimVar;
            int b = zzfmVar.b();
            if (b == -1) {
                b = dmVar.b(zzfmVar);
                zzfmVar.a(b);
            }
            zzan(b);
            dmVar.a((dm) zzimVar, (eo) this.f4176a);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zza(int i, zzim zzimVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zzc(3, 2);
            zzb(zzimVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzb(int i, zzfx zzfxVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzfxVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzb(zzim zzimVar) throws IOException {
            zzan(zzimVar.zzgy());
            zzimVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzam(int i) throws IOException {
            if (i >= 0) {
                zzan(i);
            } else {
                zzh(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzan(int i) throws IOException {
            if (!zzgo.c || bb.a() || zzgb() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.b;
                        int i2 = this.e;
                        this.e = i2 + 1;
                        bArr[i2] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                    }
                }
                byte[] bArr2 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                eh.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.b;
            int i5 = this.e;
            this.e = i5 + 1;
            eh.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                eh.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.b;
            int i8 = this.e;
            this.e = i8 + 1;
            eh.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.b;
                int i10 = this.e;
                this.e = i10 + 1;
                eh.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.b;
            int i11 = this.e;
            this.e = i11 + 1;
            eh.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.b;
                int i13 = this.e;
                this.e = i13 + 1;
                eh.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.b;
            int i14 = this.e;
            this.e = i14 + 1;
            eh.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.b;
            int i15 = this.e;
            this.e = i15 + 1;
            eh.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzap(int i) throws IOException {
            try {
                byte[] bArr = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzh(long j) throws IOException {
            if (zzgo.c && zzgb() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    eh.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                eh.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.b;
                    int i3 = this.e;
                    this.e = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.b;
            int i4 = this.e;
            this.e = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzj(long j) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.b;
                int i6 = this.e;
                this.e = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.b;
                int i8 = this.e;
                this.e = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        private final void b(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzfu
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            b(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final void zzbk(String str) throws IOException {
            int i = this.e;
            try {
                int zzas = zzas(str.length() * 3);
                int zzas2 = zzas(str.length());
                if (zzas2 == zzas) {
                    this.e = i + zzas2;
                    int a2 = ej.a(str, this.b, this.e, zzgb());
                    this.e = i;
                    zzan((a2 - i) - zzas2);
                    this.e = a2;
                    return;
                }
                zzan(ej.a(str));
                this.e = ej.a(str, this.b, this.e, zzgb());
            } catch (zzkj e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzgo
        public final int zzgb() {
            return this.d - this.e;
        }
    }

    public final void zzi(long j) throws IOException {
        zzh(a(j));
    }

    public final void zzb(float f) throws IOException {
        zzap(Float.floatToRawIntBits(f));
    }

    public final void zzc(double d) throws IOException {
        zzj(Double.doubleToRawLongBits(d));
    }

    public final void zze(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public static int zzh(int i, int i2) {
        return zzaq(i) + zzar(i2);
    }

    public static int zzi(int i, int i2) {
        return zzaq(i) + zzas(i2);
    }

    public static int zzj(int i, int i2) {
        return zzaq(i) + zzas(a(i2));
    }

    public static int zzk(int i, int i2) {
        return zzaq(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzaq(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzaq(i) + zzl(j);
    }

    public static int zze(int i, long j) {
        return zzaq(i) + zzl(j);
    }

    public static int zzf(int i, long j) {
        return zzaq(i) + zzl(a(j));
    }

    public static int zzg(int i, long j) {
        return zzaq(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzaq(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzaq(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzaq(i) + 8;
    }

    public static int zzd(int i, boolean z) {
        return zzaq(i) + 1;
    }

    public static int zzm(int i, int i2) {
        return zzaq(i) + zzar(i2);
    }

    public static int zzc(int i, String str) {
        return zzaq(i) + zzbl(str);
    }

    public static int zzc(int i, zzfx zzfxVar) {
        int zzaq = zzaq(i);
        int size = zzfxVar.size();
        return zzaq + zzas(size) + size;
    }

    public static int zza(int i, zzhv zzhvVar) {
        int zzaq = zzaq(i);
        int zzgy = zzhvVar.zzgy();
        return zzaq + zzas(zzgy) + zzgy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, zzim zzimVar, dm dmVar) {
        return zzaq(i) + a(zzimVar, dmVar);
    }

    public static int zzb(int i, zzim zzimVar) {
        return (zzaq(1) << 1) + zzi(2, i) + zzaq(3) + zzc(zzimVar);
    }

    public static int zzd(int i, zzfx zzfxVar) {
        return (zzaq(1) << 1) + zzi(2, i) + zzc(3, zzfxVar);
    }

    public static int zzb(int i, zzhv zzhvVar) {
        return (zzaq(1) << 1) + zzi(2, i) + zza(3, zzhvVar);
    }

    public static int zzaq(int i) {
        return zzas(i << 3);
    }

    public static int zzar(int i) {
        if (i >= 0) {
            return zzas(i);
        }
        return 10;
    }

    public static int zzat(int i) {
        return zzas(a(i));
    }

    public static int zzk(long j) {
        return zzl(j);
    }

    public static int zzm(long j) {
        return zzl(a(j));
    }

    public static int zzaw(int i) {
        return zzar(i);
    }

    public static int zzbl(String str) {
        int length;
        try {
            length = ej.a(str);
        } catch (zzkj unused) {
            length = str.getBytes(zzhi.f4184a).length;
        }
        return zzas(length) + length;
    }

    public static int zza(zzhv zzhvVar) {
        int zzgy = zzhvVar.zzgy();
        return zzas(zzgy) + zzgy;
    }

    public static int zzc(zzfx zzfxVar) {
        int size = zzfxVar.size();
        return zzas(size) + size;
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzas(length) + length;
    }

    public static int zzc(zzim zzimVar) {
        int zzgy = zzimVar.zzgy();
        return zzas(zzgy) + zzgy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzim zzimVar, dm dmVar) {
        zzfm zzfmVar = (zzfm) zzimVar;
        int b2 = zzfmVar.b();
        if (b2 == -1) {
            b2 = dmVar.b(zzfmVar);
            zzfmVar.a(b2);
        }
        return zzas(b2) + b2;
    }

    final void a(String str, zzkj zzkjVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzkjVar);
        byte[] bytes = str.getBytes(zzhi.f4184a);
        try {
            zzan(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int c(int i, zzim zzimVar, dm dmVar) {
        int zzaq = zzaq(i) << 1;
        zzfm zzfmVar = (zzfm) zzimVar;
        int b2 = zzfmVar.b();
        if (b2 == -1) {
            b2 = dmVar.b(zzfmVar);
            zzfmVar.a(b2);
        }
        return zzaq + b2;
    }

    @Deprecated
    public static int zzd(zzim zzimVar) {
        return zzimVar.zzgy();
    }

    @Deprecated
    public static int zzay(int i) {
        return zzas(i);
    }
}
