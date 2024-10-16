package com.google.android.gms.internal.measurement;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzee extends zzdm {
    private static final Logger b = Logger.getLogger(zzee.class.getName());
    private static final boolean c = eg.a();

    /* renamed from: a, reason: collision with root package name */
    bx f4554a;

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

        @Override // com.google.android.gms.internal.measurement.zzee.a, com.google.android.gms.internal.measurement.zzee
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

    public static int zzbk(int i) {
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

    public static int zzbm(int i) {
        return 4;
    }

    public static int zzbn(int i) {
        return 4;
    }

    public static int zzbr(long j) {
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

    public static int zzbt(long j) {
        return 8;
    }

    public static int zzbu(long j) {
        return 8;
    }

    public static int zze(double d2) {
        return 8;
    }

    public static zzee zzf(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzr(boolean z) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, zzgi zzgiVar, dl dlVar) throws IOException;

    abstract void a(zzgi zzgiVar, dl dlVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzdp zzdpVar) throws IOException;

    public abstract void zza(int i, zzgi zzgiVar) throws IOException;

    public abstract void zza(zzdp zzdpVar) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzdp zzdpVar) throws IOException;

    public abstract void zzb(int i, zzgi zzgiVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzgi zzgiVar) throws IOException;

    public abstract void zzbe(int i) throws IOException;

    public abstract void zzbf(int i) throws IOException;

    public abstract void zzbh(int i) throws IOException;

    public abstract void zzbn(long j) throws IOException;

    public abstract void zzbp(long j) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzdr(String str) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract int zztg();

    /* loaded from: classes2.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzb(java.lang.String r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzb.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public static zzee zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (eg.b()) {
                return new c(byteBuffer);
            }
            return new d(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzee {
        private final ByteBuffer b;
        private final ByteBuffer c;
        private final int d;

        d(ByteBuffer byteBuffer) {
            super();
            this.b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzdp zzdpVar) throws IOException {
            zzb(i, 2);
            zza(zzdpVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzgi zzgiVar) throws IOException {
            zzb(i, 2);
            zzb(zzgiVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(int i, zzgi zzgiVar, dl dlVar) throws IOException {
            zzb(i, 2);
            a(zzgiVar, dlVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzgi zzgiVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgiVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzdp zzdpVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdpVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(zzgi zzgiVar) throws IOException {
            zzbf(zzgiVar.zzuk());
            zzgiVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(zzgi zzgiVar, dl dlVar) throws IOException {
            zzdf zzdfVar = (zzdf) zzgiVar;
            int b = zzdfVar.b();
            if (b == -1) {
                b = dlVar.b(zzdfVar);
                zzdfVar.a(b);
            }
            zzbf(b);
            dlVar.a((dl) zzgiVar, (ep) this.f4554a);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(byte b) throws IOException {
            try {
                this.c.put(b);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(zzdp zzdpVar) throws IOException {
            zzbf(zzdpVar.size());
            zzdpVar.a(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbf(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.c.put((byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzb(e);
                }
            }
            this.c.put((byte) i);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbh(int i) throws IOException {
            try {
                this.c.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbn(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.c.put((byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzb(e);
                }
            }
            this.c.put((byte) j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbp(long j) throws IOException {
            try {
                this.c.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.c.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(e);
            } catch (BufferOverflowException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdm
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzdr(String str) throws IOException {
            int position = this.c.position();
            try {
                int zzbk = zzbk(str.length() * 3);
                int zzbk2 = zzbk(str.length());
                if (zzbk2 == zzbk) {
                    int position2 = this.c.position() + zzbk2;
                    this.c.position(position2);
                    a(str);
                    int position3 = this.c.position();
                    this.c.position(position);
                    zzbf(position3 - position2);
                    this.c.position(position3);
                    return;
                }
                zzbf(ej.a(str));
                a(str);
            } catch (zzib e) {
                this.c.position(position);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void flush() {
            this.b.position(this.c.position());
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final int zztg() {
            return this.c.remaining();
        }

        private final void a(String str) throws IOException {
            try {
                ej.a(str, this.c);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzee {
        private final ByteBuffer b;
        private final ByteBuffer c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;
        private long h;

        c(ByteBuffer byteBuffer) {
            super();
            this.b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = eg.a(byteBuffer);
            this.e = this.d + byteBuffer.position();
            this.f = this.d + byteBuffer.limit();
            this.g = this.f - 10;
            this.h = this.e;
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzdp zzdpVar) throws IOException {
            zzb(i, 2);
            zza(zzdpVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzgi zzgiVar) throws IOException {
            zzb(i, 2);
            zzb(zzgiVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(int i, zzgi zzgiVar, dl dlVar) throws IOException {
            zzb(i, 2);
            a(zzgiVar, dlVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzgi zzgiVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgiVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzdp zzdpVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdpVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(zzgi zzgiVar) throws IOException {
            zzbf(zzgiVar.zzuk());
            zzgiVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(zzgi zzgiVar, dl dlVar) throws IOException {
            zzdf zzdfVar = (zzdf) zzgiVar;
            int b = zzdfVar.b();
            if (b == -1) {
                b = dlVar.b(zzdfVar);
                zzdfVar.a(b);
            }
            zzbf(b);
            dlVar.a((dl) zzgiVar, (ep) this.f4554a);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(byte b) throws IOException {
            long j = this.h;
            if (j >= this.f) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f), 1));
            }
            this.h = 1 + j;
            eg.a(j, b);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(zzdp zzdpVar) throws IOException {
            zzbf(zzdpVar.size());
            zzdpVar.a(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbf(int i) throws IOException {
            if (this.h <= this.g) {
                while ((i & (-128)) != 0) {
                    long j = this.h;
                    this.h = j + 1;
                    eg.a(j, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                long j2 = this.h;
                this.h = 1 + j2;
                eg.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.h;
                if (j3 >= this.f) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f), 1));
                }
                if ((i & (-128)) == 0) {
                    this.h = 1 + j3;
                    eg.a(j3, (byte) i);
                    return;
                } else {
                    this.h = j3 + 1;
                    eg.a(j3, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbh(int i) throws IOException {
            this.c.putInt((int) (this.h - this.d), i);
            this.h += 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbn(long j) throws IOException {
            if (this.h <= this.g) {
                while ((j & (-128)) != 0) {
                    long j2 = this.h;
                    this.h = j2 + 1;
                    eg.a(j2, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                long j3 = this.h;
                this.h = 1 + j3;
                eg.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.h;
                if (j4 >= this.f) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f), 1));
                }
                if ((j & (-128)) == 0) {
                    this.h = 1 + j4;
                    eg.a(j4, (byte) j);
                    return;
                } else {
                    this.h = j4 + 1;
                    eg.a(j4, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbp(long j) throws IOException {
            this.c.putLong((int) (this.h - this.d), j);
            this.h += 8;
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f - j;
                long j3 = this.h;
                if (j2 >= j3) {
                    eg.a(bArr, i, j3, j);
                    this.h += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.measurement.zzdm
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzdr(String str) throws IOException {
            long j = this.h;
            try {
                int zzbk = zzbk(str.length() * 3);
                int zzbk2 = zzbk(str.length());
                if (zzbk2 == zzbk) {
                    int i = ((int) (this.h - this.d)) + zzbk2;
                    this.c.position(i);
                    ej.a(str, this.c);
                    int position = this.c.position() - i;
                    zzbf(position);
                    this.h += position;
                    return;
                }
                int a2 = ej.a(str);
                zzbf(a2);
                a(this.h);
                ej.a(str, this.c);
                this.h += a2;
            } catch (zzib e) {
                this.h = j;
                a(this.h);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb(e3);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void flush() {
            this.b.position((int) (this.h - this.d));
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final int zztg() {
            return (int) (this.f - this.h);
        }

        private final void a(long j) {
            this.c.position((int) (j - this.d));
        }
    }

    /* loaded from: classes2.dex */
    static class a extends zzee {
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

        @Override // com.google.android.gms.internal.measurement.zzee
        public void flush() {
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzdp zzdpVar) throws IOException {
            zzb(i, 2);
            zza(zzdpVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(zzdp zzdpVar) throws IOException {
            zzbf(zzdpVar.size());
            zzdpVar.a(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zza(int i, zzgi zzgiVar) throws IOException {
            zzb(i, 2);
            zzb(zzgiVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(int i, zzgi zzgiVar, dl dlVar) throws IOException {
            zzb(i, 2);
            zzdf zzdfVar = (zzdf) zzgiVar;
            int b = zzdfVar.b();
            if (b == -1) {
                b = dlVar.b(zzdfVar);
                zzdfVar.a(b);
            }
            zzbf(b);
            dlVar.a((dl) zzgiVar, (ep) this.f4554a);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzgi zzgiVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgiVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(int i, zzdp zzdpVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdpVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzb(zzgi zzgiVar) throws IOException {
            zzbf(zzgiVar.zzuk());
            zzgiVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        final void a(zzgi zzgiVar, dl dlVar) throws IOException {
            zzdf zzdfVar = (zzdf) zzgiVar;
            int b = zzdfVar.b();
            if (b == -1) {
                b = dlVar.b(zzdfVar);
                zzdfVar.a(b);
            }
            zzbf(b);
            dlVar.a((dl) zzgiVar, (ep) this.f4554a);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
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

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbf(int i) throws IOException {
            if (!zzee.c || bf.a() || zztg() < 5) {
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
                eg.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.b;
            int i5 = this.e;
            this.e = i5 + 1;
            eg.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                eg.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.b;
            int i8 = this.e;
            this.e = i8 + 1;
            eg.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.b;
                int i10 = this.e;
                this.e = i10 + 1;
                eg.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.b;
            int i11 = this.e;
            this.e = i11 + 1;
            eg.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.b;
                int i13 = this.e;
                this.e = i13 + 1;
                eg.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.b;
            int i14 = this.e;
            this.e = i14 + 1;
            eg.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.b;
            int i15 = this.e;
            this.e = i15 + 1;
            eg.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbh(int i) throws IOException {
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
        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbn(long j) throws IOException {
            if (zzee.c && zztg() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    eg.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                eg.a(bArr2, i2, (byte) j);
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

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzbp(long j) throws IOException {
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

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdm
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final void zzdr(String str) throws IOException {
            int i = this.e;
            try {
                int zzbk = zzbk(str.length() * 3);
                int zzbk2 = zzbk(str.length());
                if (zzbk2 == zzbk) {
                    this.e = i + zzbk2;
                    int a2 = ej.a(str, this.b, this.e, zztg());
                    this.e = i;
                    zzbf((a2 - i) - zzbk2);
                    this.e = a2;
                    return;
                }
                zzbf(ej.a(str));
                this.e = ej.a(str, this.b, this.e, zztg());
            } catch (zzib e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzee
        public final int zztg() {
            return this.d - this.e;
        }

        public final int b() {
            return this.e - this.c;
        }
    }

    private zzee() {
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, a(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, a(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public final void zzbg(int i) throws IOException {
        zzbf(a(i));
    }

    public final void zzbo(long j) throws IOException {
        zzbn(a(j));
    }

    public final void zza(float f) throws IOException {
        zzbh(Float.floatToRawIntBits(f));
    }

    public final void zzd(double d2) throws IOException {
        zzbp(Double.doubleToRawLongBits(d2));
    }

    public final void zzq(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public static int zzg(int i, int i2) {
        return zzbi(i) + zzbj(i2);
    }

    public static int zzh(int i, int i2) {
        return zzbi(i) + zzbk(i2);
    }

    public static int zzi(int i, int i2) {
        return zzbi(i) + zzbk(a(i2));
    }

    public static int zzj(int i, int i2) {
        return zzbi(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzbi(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbi(i) + zzbr(j);
    }

    public static int zze(int i, long j) {
        return zzbi(i) + zzbr(j);
    }

    public static int zzf(int i, long j) {
        return zzbi(i) + zzbr(a(j));
    }

    public static int zzg(int i, long j) {
        return zzbi(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbi(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbi(i) + 4;
    }

    public static int zzb(int i, double d2) {
        return zzbi(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbi(i) + 1;
    }

    public static int zzl(int i, int i2) {
        return zzbi(i) + zzbj(i2);
    }

    public static int zzc(int i, String str) {
        return zzbi(i) + zzds(str);
    }

    public static int zzc(int i, zzdp zzdpVar) {
        int zzbi = zzbi(i);
        int size = zzdpVar.size();
        return zzbi + zzbk(size) + size;
    }

    public static int zza(int i, zzfn zzfnVar) {
        int zzbi = zzbi(i);
        int zzuk = zzfnVar.zzuk();
        return zzbi + zzbk(zzuk) + zzuk;
    }

    public static int zzc(int i, zzgi zzgiVar) {
        return zzbi(i) + zzc(zzgiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, zzgi zzgiVar, dl dlVar) {
        return zzbi(i) + b(zzgiVar, dlVar);
    }

    public static int zzd(int i, zzgi zzgiVar) {
        return (zzbi(1) << 1) + zzh(2, i) + zzc(3, zzgiVar);
    }

    public static int zzd(int i, zzdp zzdpVar) {
        return (zzbi(1) << 1) + zzh(2, i) + zzc(3, zzdpVar);
    }

    public static int zzb(int i, zzfn zzfnVar) {
        return (zzbi(1) << 1) + zzh(2, i) + zza(3, zzfnVar);
    }

    public static int zzbi(int i) {
        return zzbk(i << 3);
    }

    public static int zzbj(int i) {
        if (i >= 0) {
            return zzbk(i);
        }
        return 10;
    }

    public static int zzbl(int i) {
        return zzbk(a(i));
    }

    public static int zzbq(long j) {
        return zzbr(j);
    }

    public static int zzbs(long j) {
        return zzbr(a(j));
    }

    public static int zzbo(int i) {
        return zzbj(i);
    }

    public static int zzds(String str) {
        int length;
        try {
            length = ej.a(str);
        } catch (zzib unused) {
            length = str.getBytes(zzez.f4562a).length;
        }
        return zzbk(length) + length;
    }

    public static int zza(zzfn zzfnVar) {
        int zzuk = zzfnVar.zzuk();
        return zzbk(zzuk) + zzuk;
    }

    public static int zzb(zzdp zzdpVar) {
        int size = zzdpVar.size();
        return zzbk(size) + size;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        return zzbk(length) + length;
    }

    public static int zzc(zzgi zzgiVar) {
        int zzuk = zzgiVar.zzuk();
        return zzbk(zzuk) + zzuk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(zzgi zzgiVar, dl dlVar) {
        zzdf zzdfVar = (zzdf) zzgiVar;
        int b2 = zzdfVar.b();
        if (b2 == -1) {
            b2 = dlVar.b(zzdfVar);
            zzdfVar.a(b2);
        }
        return zzbk(b2) + b2;
    }

    public final void zzth() {
        if (zztg() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void a(String str, zzib zzibVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzibVar);
        byte[] bytes = str.getBytes(zzez.f4562a);
        try {
            zzbf(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int c(int i, zzgi zzgiVar, dl dlVar) {
        int zzbi = zzbi(i) << 1;
        zzdf zzdfVar = (zzdf) zzgiVar;
        int b2 = zzdfVar.b();
        if (b2 == -1) {
            b2 = dlVar.b(zzdfVar);
            zzdfVar.a(b2);
        }
        return zzbi + b2;
    }

    @Deprecated
    public static int zzd(zzgi zzgiVar) {
        return zzgiVar.zzuk();
    }

    @Deprecated
    public static int zzbq(int i) {
        return zzbk(i);
    }
}
