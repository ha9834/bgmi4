package com.google.android.gms.internal.gtm;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzqj extends zzpr {
    private static final Logger b = Logger.getLogger(zzqj.class.getName());
    private static final boolean c = dv.a();

    /* renamed from: a, reason: collision with root package name */
    bm f4434a;

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

        @Override // com.google.android.gms.internal.gtm.zzqj.a, com.google.android.gms.internal.gtm.zzqj
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

    public static int zzb(float f) {
        return 4;
    }

    public static int zzbd(int i) {
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

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static zzqj zzg(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzj(boolean z) {
        return 1;
    }

    public static int zzt(long j) {
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

    public static int zzv(long j) {
        return 8;
    }

    public static int zzw(long j) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, zzsk zzskVar, da daVar) throws IOException;

    abstract void a(zzsk zzskVar, da daVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzps zzpsVar) throws IOException;

    public abstract void zza(int i, zzsk zzskVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzps zzpsVar) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public abstract void zzb(int i, zzps zzpsVar) throws IOException;

    public abstract void zzb(int i, zzsk zzskVar) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzsk zzskVar) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzcz(String str) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract int zzoi();

    public abstract void zzp(long j) throws IOException;

    public abstract void zzr(long j) throws IOException;

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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public static zzqj zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (dv.b()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzqj {
        private final ByteBuffer b;
        private final ByteBuffer c;
        private final int d;

        c(ByteBuffer byteBuffer) {
            super();
            this.b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(int i, zzsk zzskVar, da daVar) throws IOException {
            zzd(i, 2);
            a(zzskVar, daVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(zzsk zzskVar, da daVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int b = zzplVar.b();
            if (b == -1) {
                b = daVar.b(zzplVar);
                zzplVar.a(b);
            }
            zzay(b);
            daVar.a((da) zzskVar, (ed) this.f4434a);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            try {
                this.c.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.a(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
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

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            try {
                this.c.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
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

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            try {
                this.c.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.c.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int position = this.c.position();
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int position2 = this.c.position() + zzbd2;
                    this.c.position(position2);
                    a(str);
                    int position3 = this.c.position();
                    this.c.position(position);
                    zzay(position3 - position2);
                    this.c.position(position3);
                    return;
                }
                zzay(dx.a(str));
                a(str);
            } catch (zzud e) {
                this.c.position(position);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.b.position(this.c.position());
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.c.remaining();
        }

        private final void a(String str) throws IOException {
            try {
                dx.a(str, this.c);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzqj {
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
            this.d = dv.a(byteBuffer);
            this.e = this.d + byteBuffer.position();
            this.f = this.d + byteBuffer.limit();
            this.g = this.f - 10;
            this.h = this.e;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(int i, zzsk zzskVar, da daVar) throws IOException {
            zzd(i, 2);
            a(zzskVar, daVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(zzsk zzskVar, da daVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int b = zzplVar.b();
            if (b == -1) {
                b = daVar.b(zzplVar);
                zzplVar.a(b);
            }
            zzay(b);
            daVar.a((da) zzskVar, (ed) this.f4434a);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            long j = this.h;
            if (j >= this.f) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f), 1));
            }
            this.h = 1 + j;
            dv.a(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.a(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (this.h <= this.g) {
                while ((i & (-128)) != 0) {
                    long j = this.h;
                    this.h = j + 1;
                    dv.a(j, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                long j2 = this.h;
                this.h = 1 + j2;
                dv.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.h;
                if (j3 >= this.f) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f), 1));
                }
                if ((i & (-128)) == 0) {
                    this.h = 1 + j3;
                    dv.a(j3, (byte) i);
                    return;
                } else {
                    this.h = j3 + 1;
                    dv.a(j3, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            this.c.putInt((int) (this.h - this.d), i);
            this.h += 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (this.h <= this.g) {
                while ((j & (-128)) != 0) {
                    long j2 = this.h;
                    this.h = j2 + 1;
                    dv.a(j2, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                long j3 = this.h;
                this.h = 1 + j3;
                dv.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.h;
                if (j4 >= this.f) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f), 1));
                }
                if ((j & (-128)) == 0) {
                    this.h = 1 + j4;
                    dv.a(j4, (byte) j);
                    return;
                } else {
                    this.h = j4 + 1;
                    dv.a(j4, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            this.c.putLong((int) (this.h - this.d), j);
            this.h += 8;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f - j;
                long j3 = this.h;
                if (j2 >= j3) {
                    dv.a(bArr, i, j3, j);
                    this.h += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            long j = this.h;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i = ((int) (this.h - this.d)) + zzbd2;
                    this.c.position(i);
                    dx.a(str, this.c);
                    int position = this.c.position() - i;
                    zzay(position);
                    this.h += position;
                    return;
                }
                int a2 = dx.a(str);
                zzay(a2);
                a(this.h);
                dx.a(str, this.c);
                this.h += a2;
            } catch (zzud e) {
                this.h = j;
                a(this.h);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.b.position((int) (this.h - this.d));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return (int) (this.f - this.h);
        }

        private final void a(long j) {
            this.c.position((int) (j - this.d));
        }
    }

    /* loaded from: classes2.dex */
    static class a extends zzqj {
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

        @Override // com.google.android.gms.internal.gtm.zzqj
        public void flush() {
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.a(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(int i, zzsk zzskVar, da daVar) throws IOException {
            zzd(i, 2);
            zzpl zzplVar = (zzpl) zzskVar;
            int b = zzplVar.b();
            if (b == -1) {
                b = daVar.b(zzplVar);
                zzplVar.a(b);
            }
            zzay(b);
            daVar.a((da) zzskVar, (ed) this.f4434a);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void a(zzsk zzskVar, da daVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int b = zzplVar.b();
            if (b == -1) {
                b = daVar.b(zzplVar);
                zzplVar.a(b);
            }
            zzay(b);
            daVar.a((da) zzskVar, (ed) this.f4434a);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (!zzqj.c || ay.a() || zzoi() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.b;
                        int i2 = this.e;
                        this.e = i2 + 1;
                        bArr[i2] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
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
                dv.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.b;
            int i5 = this.e;
            this.e = i5 + 1;
            dv.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                dv.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.b;
            int i8 = this.e;
            this.e = i8 + 1;
            dv.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.b;
                int i10 = this.e;
                this.e = i10 + 1;
                dv.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.b;
            int i11 = this.e;
            this.e = i11 + 1;
            dv.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.b;
                int i13 = this.e;
                this.e = i13 + 1;
                dv.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.b;
            int i14 = this.e;
            this.e = i14 + 1;
            dv.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.b;
            int i15 = this.e;
            this.e = i15 + 1;
            dv.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
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
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (zzqj.c && zzoi() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    dv.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                dv.a(bArr2, i2, (byte) j);
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

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
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

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int i = this.e;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    this.e = i + zzbd2;
                    int a2 = dx.a(str, this.b, this.e, zzoi());
                    this.e = i;
                    zzay((a2 - i) - zzbd2);
                    this.e = a2;
                    return;
                }
                zzay(dx.a(str));
                this.e = dx.a(str, this.b, this.e, zzoi());
            } catch (zzud e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.d - this.e;
        }

        public final int b() {
            return this.e - this.c;
        }
    }

    private zzqj() {
    }

    public final void zzg(int i, int i2) throws IOException {
        zzf(i, a(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, a(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public final void zzaz(int i) throws IOException {
        zzay(a(i));
    }

    public final void zzq(long j) throws IOException {
        zzp(a(j));
    }

    public final void zza(float f) throws IOException {
        zzba(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d2) throws IOException {
        zzr(Double.doubleToRawLongBits(d2));
    }

    public final void zzi(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public static int zzi(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzj(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzk(int i, int i2) {
        return zzbb(i) + zzbd(a(i2));
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzt(a(j));
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbb(i) + 4;
    }

    public static int zzb(int i, double d2) {
        return zzbb(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzn(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzda(str);
    }

    public static int zzc(int i, zzps zzpsVar) {
        int zzbb = zzbb(i);
        int size = zzpsVar.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zza(int i, zzrr zzrrVar) {
        int zzbb = zzbb(i);
        int zzpe = zzrrVar.zzpe();
        return zzbb + zzbd(zzpe) + zzpe;
    }

    public static int zzc(int i, zzsk zzskVar) {
        return zzbb(i) + zzc(zzskVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, zzsk zzskVar, da daVar) {
        return zzbb(i) + b(zzskVar, daVar);
    }

    public static int zzd(int i, zzsk zzskVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzskVar);
    }

    public static int zzd(int i, zzps zzpsVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzpsVar);
    }

    public static int zzb(int i, zzrr zzrrVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zza(3, zzrrVar);
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbe(int i) {
        return zzbd(a(i));
    }

    public static int zzs(long j) {
        return zzt(j);
    }

    public static int zzu(long j) {
        return zzt(a(j));
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    public static int zzda(String str) {
        int length;
        try {
            length = dx.a(str);
        } catch (zzud unused) {
            length = str.getBytes(zzre.f4443a).length;
        }
        return zzbd(length) + length;
    }

    public static int zza(zzrr zzrrVar) {
        int zzpe = zzrrVar.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    public static int zzb(zzps zzpsVar) {
        int size = zzpsVar.size();
        return zzbd(size) + size;
    }

    public static int zzh(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzc(zzsk zzskVar) {
        int zzpe = zzskVar.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(zzsk zzskVar, da daVar) {
        zzpl zzplVar = (zzpl) zzskVar;
        int b2 = zzplVar.b();
        if (b2 == -1) {
            b2 = daVar.b(zzplVar);
            zzplVar.a(b2);
        }
        return zzbd(b2) + b2;
    }

    final void a(String str, zzud zzudVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzudVar);
        byte[] bytes = str.getBytes(zzre.f4443a);
        try {
            zzay(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int c(int i, zzsk zzskVar, da daVar) {
        int zzbb = zzbb(i) << 1;
        zzpl zzplVar = (zzpl) zzskVar;
        int b2 = zzplVar.b();
        if (b2 == -1) {
            b2 = daVar.b(zzplVar);
            zzplVar.a(b2);
        }
        return zzbb + b2;
    }

    @Deprecated
    public static int zzd(zzsk zzskVar) {
        return zzskVar.zzpe();
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }
}
