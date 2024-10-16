package com.google.android.gms.internal.ads;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzdni extends zzdmq {
    private static final Logger b = Logger.getLogger(zzdni.class.getName());
    private static final boolean c = ahs.a();

    /* renamed from: a, reason: collision with root package name */
    afe f3585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b extends a {
        private final ByteBuffer b;
        private int c;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.b = byteBuffer;
            this.c = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzdni.a, com.google.android.gms.internal.ads.zzdni
        public final void flush() {
            this.b.position(this.c + b());
        }
    }

    private static int a(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static long a(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static zzdni zzab(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzbg(boolean z) {
        return 1;
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static int zzfn(long j) {
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

    public static int zzfp(long j) {
        return 8;
    }

    public static int zzfq(long j) {
        return 8;
    }

    public static int zzgf(int i) {
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

    public static int zzgh(int i) {
        return 4;
    }

    public static int zzgi(int i) {
        return 4;
    }

    public static int zzh(float f) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, zzdpk zzdpkVar, agx agxVar) throws IOException;

    abstract void a(zzdpk zzdpkVar, agx agxVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, zzdmr zzdmrVar) throws IOException;

    public abstract void zza(int i, zzdpk zzdpkVar) throws IOException;

    public abstract void zzaa(int i, int i2) throws IOException;

    public abstract int zzawu();

    public abstract void zzb(int i, zzdmr zzdmrVar) throws IOException;

    public abstract void zzb(int i, zzdpk zzdpkVar) throws IOException;

    public abstract void zzcz(zzdmr zzdmrVar) throws IOException;

    public abstract void zzd(byte b2) throws IOException;

    public abstract void zzf(int i, String str) throws IOException;

    public abstract void zzfj(long j) throws IOException;

    public abstract void zzfl(long j) throws IOException;

    public abstract void zzfz(int i) throws IOException;

    public abstract void zzga(int i) throws IOException;

    public abstract void zzgc(int i) throws IOException;

    public abstract void zzgw(String str) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(int i, boolean z) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzj(zzdpk zzdpkVar) throws IOException;

    public abstract void zzw(int i, int i2) throws IOException;

    public abstract void zzx(int i, int i2) throws IOException;

    public abstract void zzy(int i, int i2) throws IOException;

    /* loaded from: classes2.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzc(java.lang.String r3) {
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
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdni.zzc.<init>(java.lang.String):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdni.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public static zzdni zzm(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (ahs.b()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzdni {
        private final ByteBuffer b;
        private final ByteBuffer c;
        private final int d;

        c(ByteBuffer byteBuffer) {
            super();
            this.b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdmr zzdmrVar) throws IOException {
            zzw(i, 2);
            zzcz(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdpk zzdpkVar) throws IOException {
            zzw(i, 2);
            zzj(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(int i, zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzw(i, 2);
            a(zzdpkVar, agxVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdpk zzdpkVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpkVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdmr zzdmrVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmrVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(zzdpk zzdpkVar) throws IOException {
            zzga(zzdpkVar.zzaxj());
            zzdpkVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int b = zzdmiVar.b();
            if (b == -1) {
                b = agxVar.b(zzdmiVar);
                zzdmiVar.a(b);
            }
            zzga(b);
            agxVar.a((agx) zzdpkVar, (aib) this.f3585a);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzd(byte b) throws IOException {
            try {
                this.c.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzcz(zzdmr zzdmrVar) throws IOException {
            zzga(zzdmrVar.size());
            zzdmrVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzga(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.c.put((byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.c.put((byte) i);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgc(int i) throws IOException {
            try {
                this.c.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfj(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.c.put((byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.c.put((byte) j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfl(long j) throws IOException {
            try {
                this.c.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.c.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgw(String str) throws IOException {
            int position = this.c.position();
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int position2 = this.c.position() + zzgf2;
                    this.c.position(position2);
                    a(str);
                    int position3 = this.c.position();
                    this.c.position(position);
                    zzga(position3 - position2);
                    this.c.position(position3);
                    return;
                }
                zzga(ahv.a(str));
                a(str);
            } catch (zzdrf e) {
                this.c.position(position);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void flush() {
            this.b.position(this.c.position());
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int zzawu() {
            return this.c.remaining();
        }

        private final void a(String str) throws IOException {
            try {
                ahv.a(str, this.c);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzdni {
        private final ByteBuffer b;
        private final ByteBuffer c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;
        private long h;

        d(ByteBuffer byteBuffer) {
            super();
            this.b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = ahs.a(byteBuffer);
            this.e = this.d + byteBuffer.position();
            this.f = this.d + byteBuffer.limit();
            this.g = this.f - 10;
            this.h = this.e;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdmr zzdmrVar) throws IOException {
            zzw(i, 2);
            zzcz(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdpk zzdpkVar) throws IOException {
            zzw(i, 2);
            zzj(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(int i, zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzw(i, 2);
            a(zzdpkVar, agxVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdpk zzdpkVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpkVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdmr zzdmrVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmrVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(zzdpk zzdpkVar) throws IOException {
            zzga(zzdpkVar.zzaxj());
            zzdpkVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int b = zzdmiVar.b();
            if (b == -1) {
                b = agxVar.b(zzdmiVar);
                zzdmiVar.a(b);
            }
            zzga(b);
            agxVar.a((agx) zzdpkVar, (aib) this.f3585a);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzd(byte b) throws IOException {
            long j = this.h;
            if (j >= this.f) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f), 1));
            }
            this.h = 1 + j;
            ahs.a(j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzcz(zzdmr zzdmrVar) throws IOException {
            zzga(zzdmrVar.size());
            zzdmrVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzga(int i) throws IOException {
            if (this.h <= this.g) {
                while ((i & (-128)) != 0) {
                    long j = this.h;
                    this.h = j + 1;
                    ahs.a(j, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                long j2 = this.h;
                this.h = 1 + j2;
                ahs.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.h;
                if (j3 >= this.f) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f), 1));
                }
                if ((i & (-128)) == 0) {
                    this.h = 1 + j3;
                    ahs.a(j3, (byte) i);
                    return;
                } else {
                    this.h = j3 + 1;
                    ahs.a(j3, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgc(int i) throws IOException {
            this.c.putInt((int) (this.h - this.d), i);
            this.h += 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfj(long j) throws IOException {
            if (this.h <= this.g) {
                while ((j & (-128)) != 0) {
                    long j2 = this.h;
                    this.h = j2 + 1;
                    ahs.a(j2, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                long j3 = this.h;
                this.h = 1 + j3;
                ahs.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.h;
                if (j4 >= this.f) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f), 1));
                }
                if ((j & (-128)) == 0) {
                    this.h = 1 + j4;
                    ahs.a(j4, (byte) j);
                    return;
                } else {
                    this.h = j4 + 1;
                    ahs.a(j4, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfl(long j) throws IOException {
            this.c.putLong((int) (this.h - this.d), j);
            this.h += 8;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f - j;
                long j3 = this.h;
                if (j2 >= j3) {
                    ahs.a(bArr, i, j3, j);
                    this.h += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgw(String str) throws IOException {
            long j = this.h;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int i = ((int) (this.h - this.d)) + zzgf2;
                    this.c.position(i);
                    ahv.a(str, this.c);
                    int position = this.c.position() - i;
                    zzga(position);
                    this.h += position;
                    return;
                }
                int a2 = ahv.a(str);
                zzga(a2);
                a(this.h);
                ahv.a(str, this.c);
                this.h += a2;
            } catch (zzdrf e) {
                this.h = j;
                a(this.h);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void flush() {
            this.b.position((int) (this.h - this.d));
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int zzawu() {
            return (int) (this.f - this.h);
        }

        private final void a(long j) {
            this.c.position((int) (j - this.d));
        }
    }

    /* loaded from: classes2.dex */
    static class a extends zzdni {
        private final byte[] b;
        private final int c;
        private final int d;
        private int e;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.b = bArr;
            this.c = i;
            this.e = i;
            this.d = i3;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public void flush() {
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdmr zzdmrVar) throws IOException {
            zzw(i, 2);
            zzcz(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzcz(zzdmr zzdmrVar) throws IOException {
            zzga(zzdmrVar.size());
            zzdmrVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zza(int i, zzdpk zzdpkVar) throws IOException {
            zzw(i, 2);
            zzj(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(int i, zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzw(i, 2);
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int b = zzdmiVar.b();
            if (b == -1) {
                b = agxVar.b(zzdmiVar);
                zzdmiVar.a(b);
            }
            zzga(b);
            agxVar.a((agx) zzdpkVar, (aib) this.f3585a);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdpk zzdpkVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpkVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzb(int i, zzdmr zzdmrVar) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmrVar);
            zzw(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzj(zzdpk zzdpkVar) throws IOException {
            zzga(zzdpkVar.zzaxj());
            zzdpkVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void a(zzdpk zzdpkVar, agx agxVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int b = zzdmiVar.b();
            if (b == -1) {
                b = agxVar.b(zzdmiVar);
                zzdmiVar.a(b);
            }
            zzga(b);
            agxVar.a((agx) zzdpkVar, (aib) this.f3585a);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzga(int i) throws IOException {
            if (zzdni.c && zzawu() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i2 = this.e;
                    this.e = i2 + 1;
                    ahs.a(bArr, i2, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                ahs.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.b;
                    int i4 = this.e;
                    this.e = i4 + 1;
                    bArr3[i4] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.b;
            int i5 = this.e;
            this.e = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgc(int i) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfj(long j) throws IOException {
            if (zzdni.c && zzawu() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    ahs.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                ahs.a(bArr2, i2, (byte) j);
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.b;
            int i4 = this.e;
            this.e = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzfl(long j) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void zzgw(String str) throws IOException {
            int i = this.e;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    this.e = i + zzgf2;
                    int a2 = ahv.a(str, this.b, this.e, zzawu());
                    this.e = i;
                    zzga((a2 - i) - zzgf2);
                    this.e = a2;
                    return;
                }
                zzga(ahv.a(str));
                this.e = ahv.a(str, this.b, this.e, zzawu());
            } catch (zzdrf e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int zzawu() {
            return this.d - this.e;
        }

        public final int b() {
            return this.e - this.c;
        }
    }

    private zzdni() {
    }

    public final void zzz(int i, int i2) throws IOException {
        zzy(i, a(i2));
    }

    public final void zzi(int i, long j) throws IOException {
        zzh(i, a(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzaa(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d2) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d2));
    }

    public final void zzgb(int i) throws IOException {
        zzga(a(i));
    }

    public final void zzfk(long j) throws IOException {
        zzfj(a(j));
    }

    public final void zzg(float f) throws IOException {
        zzgc(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d2) throws IOException {
        zzfl(Double.doubleToRawLongBits(d2));
    }

    public final void zzbf(boolean z) throws IOException {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public static int zzab(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzac(int i, int i2) {
        return zzgd(i) + zzgf(i2);
    }

    public static int zzad(int i, int i2) {
        return zzgd(i) + zzgf(a(i2));
    }

    public static int zzae(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzaf(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzk(int i, long j) {
        return zzgd(i) + zzfn(j);
    }

    public static int zzl(int i, long j) {
        return zzgd(i) + zzfn(j);
    }

    public static int zzm(int i, long j) {
        return zzgd(i) + zzfn(a(j));
    }

    public static int zzn(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzgd(i) + 4;
    }

    public static int zzc(int i, double d2) {
        return zzgd(i) + 8;
    }

    public static int zzj(int i, boolean z) {
        return zzgd(i) + 1;
    }

    public static int zzag(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzg(int i, String str) {
        return zzgd(i) + zzgx(str);
    }

    public static int zzc(int i, zzdmr zzdmrVar) {
        int zzgd = zzgd(i);
        int size = zzdmrVar.size();
        return zzgd + zzgf(size) + size;
    }

    public static int zza(int i, zzdor zzdorVar) {
        int zzgd = zzgd(i);
        int zzaxj = zzdorVar.zzaxj();
        return zzgd + zzgf(zzaxj) + zzaxj;
    }

    public static int zzc(int i, zzdpk zzdpkVar) {
        return zzgd(i) + zzk(zzdpkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, zzdpk zzdpkVar, agx agxVar) {
        return zzgd(i) + b(zzdpkVar, agxVar);
    }

    public static int zzd(int i, zzdpk zzdpkVar) {
        return (zzgd(1) << 1) + zzac(2, i) + zzc(3, zzdpkVar);
    }

    public static int zzd(int i, zzdmr zzdmrVar) {
        return (zzgd(1) << 1) + zzac(2, i) + zzc(3, zzdmrVar);
    }

    public static int zzb(int i, zzdor zzdorVar) {
        return (zzgd(1) << 1) + zzac(2, i) + zza(3, zzdorVar);
    }

    public static int zzgd(int i) {
        return zzgf(i << 3);
    }

    public static int zzge(int i) {
        if (i >= 0) {
            return zzgf(i);
        }
        return 10;
    }

    public static int zzgg(int i) {
        return zzgf(a(i));
    }

    public static int zzfm(long j) {
        return zzfn(j);
    }

    public static int zzfo(long j) {
        return zzfn(a(j));
    }

    public static int zzgj(int i) {
        return zzge(i);
    }

    public static int zzgx(String str) {
        int length;
        try {
            length = ahv.a(str);
        } catch (zzdrf unused) {
            length = str.getBytes(zzdod.f3593a).length;
        }
        return zzgf(length) + length;
    }

    public static int zza(zzdor zzdorVar) {
        int zzaxj = zzdorVar.zzaxj();
        return zzgf(zzaxj) + zzaxj;
    }

    public static int zzda(zzdmr zzdmrVar) {
        int size = zzdmrVar.size();
        return zzgf(size) + size;
    }

    public static int zzac(byte[] bArr) {
        int length = bArr.length;
        return zzgf(length) + length;
    }

    public static int zzk(zzdpk zzdpkVar) {
        int zzaxj = zzdpkVar.zzaxj();
        return zzgf(zzaxj) + zzaxj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(zzdpk zzdpkVar, agx agxVar) {
        zzdmi zzdmiVar = (zzdmi) zzdpkVar;
        int b2 = zzdmiVar.b();
        if (b2 == -1) {
            b2 = agxVar.b(zzdmiVar);
            zzdmiVar.a(b2);
        }
        return zzgf(b2) + b2;
    }

    public final void zzawv() {
        if (zzawu() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void a(String str, zzdrf zzdrfVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzdrfVar);
        byte[] bytes = str.getBytes(zzdod.f3593a);
        try {
            zzga(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int c(int i, zzdpk zzdpkVar, agx agxVar) {
        int zzgd = zzgd(i) << 1;
        zzdmi zzdmiVar = (zzdmi) zzdpkVar;
        int b2 = zzdmiVar.b();
        if (b2 == -1) {
            b2 = agxVar.b(zzdmiVar);
            zzdmiVar.a(b2);
        }
        return zzgd + b2;
    }

    @Deprecated
    public static int zzl(zzdpk zzdpkVar) {
        return zzdpkVar.zzaxj();
    }

    @Deprecated
    public static int zzgl(int i) {
        return zzgf(i);
    }
}
