package com.uqm.crashsight.protobuf;

import com.google.android.gms.games.Notifications;
import com.uqm.crashsight.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    private static final Logger b = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean c = aw.a();

    /* renamed from: a, reason: collision with root package name */
    g f6640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int b() {
        return 4;
    }

    public static int c() {
        return 4;
    }

    public static int d() {
        return 8;
    }

    public static int e() {
        return 8;
    }

    public static int f() {
        return 4;
    }

    public static int g() {
        return 8;
    }

    public static int g(long j) {
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

    public static int h() {
        return 1;
    }

    public static long i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int j(int i) {
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

    public static int n(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i, int i2) throws IOException;

    public abstract void a(int i, ByteString byteString) throws IOException;

    public abstract void a(int i, MessageLite messageLite) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, MessageLite messageLite, ao aoVar) throws IOException;

    public abstract void a(int i, String str) throws IOException;

    public abstract void a(int i, boolean z) throws IOException;

    public abstract void a(ByteString byteString) throws IOException;

    public abstract void a(MessageLite messageLite) throws IOException;

    public abstract void a(String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return false;
    }

    public abstract void b(int i) throws IOException;

    public abstract void b(int i, int i2) throws IOException;

    public abstract void b(int i, long j) throws IOException;

    public abstract void b(int i, ByteString byteString) throws IOException;

    public abstract void b(int i, MessageLite messageLite) throws IOException;

    public abstract void b(long j) throws IOException;

    @Override // com.uqm.crashsight.protobuf.ByteOutput
    public abstract void b(byte[] bArr, int i, int i2) throws IOException;

    public abstract void c(int i) throws IOException;

    public abstract void c(int i, int i2) throws IOException;

    abstract void c(byte[] bArr, int i, int i2) throws IOException;

    public abstract void d(int i, long j) throws IOException;

    public abstract void d(long j) throws IOException;

    public abstract void e(int i) throws IOException;

    public abstract void e(int i, int i2) throws IOException;

    public abstract void i() throws IOException;

    public abstract int j();

    /* synthetic */ CodedOutputStream(byte b2) {
        this();
    }

    public static CodedOutputStream a(OutputStream outputStream, int i) {
        return new c(outputStream, i);
    }

    public static CodedOutputStream a(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    private CodedOutputStream() {
    }

    public final void d(int i, int i2) throws IOException {
        c(i, (i2 >> 31) ^ (i2 << 1));
    }

    public final void f(int i, int i2) throws IOException {
        e(i, i2);
    }

    public final void a(int i, long j) throws IOException {
        b(i, j);
    }

    public final void c(int i, long j) throws IOException {
        b(i, (j >> 63) ^ (j << 1));
    }

    public final void e(int i, long j) throws IOException {
        d(i, j);
    }

    public final void a(int i, float f) throws IOException {
        e(i, Float.floatToRawIntBits(f));
    }

    public final void a(int i, double d) throws IOException {
        d(i, Double.doubleToRawLongBits(d));
    }

    public final void g(int i, int i2) throws IOException {
        b(i, i2);
    }

    public final void d(int i) throws IOException {
        c((i >> 31) ^ (i << 1));
    }

    public final void f(int i) throws IOException {
        e(i);
    }

    public final void a(long j) throws IOException {
        b(j);
    }

    public final void c(long j) throws IOException {
        b((j >> 63) ^ (j << 1));
    }

    public final void e(long j) throws IOException {
        d(j);
    }

    public final void a(float f) throws IOException {
        e(Float.floatToRawIntBits(f));
    }

    public final void a(double d) throws IOException {
        d(Double.doubleToRawLongBits(d));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : (byte) 0);
    }

    public final void g(int i) throws IOException {
        b(i);
    }

    public final void b(byte[] bArr) throws IOException {
        c(bArr, 0, bArr.length);
    }

    public static int h(int i, int i2) {
        return j(WireFormat.a(i, 0)) + (i2 >= 0 ? j(i2) : 10);
    }

    public static int i(int i, int i2) {
        return j(WireFormat.a(i, 0)) + j(i2);
    }

    public static int j(int i, int i2) {
        return j(WireFormat.a(i, 0)) + j((i2 >> 31) ^ (i2 << 1));
    }

    public static int k(int i, int i2) {
        return j(WireFormat.a(i, 0)) + 4;
    }

    public static int l(int i, int i2) {
        return j(WireFormat.a(i, 0)) + 4;
    }

    public static int f(int i, long j) {
        return j(WireFormat.a(i, 0)) + g(j);
    }

    public static int g(int i, long j) {
        return j(WireFormat.a(i, 0)) + g(j);
    }

    public static int h(int i, long j) {
        return j(WireFormat.a(i, 0)) + g((j >> 63) ^ (j << 1));
    }

    public static int i(int i, long j) {
        return j(WireFormat.a(i, 0)) + 8;
    }

    public static int j(int i, long j) {
        return j(WireFormat.a(i, 0)) + 8;
    }

    public static int b(int i, float f) {
        return j(WireFormat.a(i, 0)) + 4;
    }

    public static int b(int i, double d) {
        return j(WireFormat.a(i, 0)) + 8;
    }

    public static int b(int i, boolean z) {
        return j(WireFormat.a(i, 0)) + 1;
    }

    public static int m(int i, int i2) {
        return j(WireFormat.a(i, 0)) + (i2 >= 0 ? j(i2) : 10);
    }

    public static int b(int i, String str) {
        return j(WireFormat.a(i, 0)) + b(str);
    }

    public static int c(int i, ByteString byteString) {
        int j = j(WireFormat.a(i, 0));
        int b2 = byteString.b();
        return j + j(b2) + b2;
    }

    public static int a(int i, LazyFieldLite lazyFieldLite) {
        int j = j(WireFormat.a(i, 0));
        int b2 = lazyFieldLite.b();
        return j + j(b2) + b2;
    }

    public static int c(int i, MessageLite messageLite) {
        int j = j(WireFormat.a(i, 0));
        int serializedSize = messageLite.getSerializedSize();
        return j + j(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, MessageLite messageLite, ao aoVar) {
        int j = j(WireFormat.a(i, 0));
        int serializedSize = ((AbstractMessageLite) messageLite).getSerializedSize(aoVar);
        return j + j(serializedSize) + serializedSize;
    }

    public static int d(int i, MessageLite messageLite) {
        int j = (j(WireFormat.a(1, 0)) << 1) + j(WireFormat.a(2, 0)) + j(i);
        int j2 = j(WireFormat.a(3, 0));
        int serializedSize = messageLite.getSerializedSize();
        return j + j2 + j(serializedSize) + serializedSize;
    }

    public static int d(int i, ByteString byteString) {
        int j = (j(WireFormat.a(1, 0)) << 1) + j(WireFormat.a(2, 0)) + j(i);
        int j2 = j(WireFormat.a(3, 0));
        int b2 = byteString.b();
        return j + j2 + j(b2) + b2;
    }

    public static int b(int i, LazyFieldLite lazyFieldLite) {
        int j = (j(WireFormat.a(1, 0)) << 1) + j(WireFormat.a(2, 0)) + j(i);
        int j2 = j(WireFormat.a(3, 0));
        int b2 = lazyFieldLite.b();
        return j + j2 + j(b2) + b2;
    }

    public static int h(int i) {
        return j(WireFormat.a(i, 0));
    }

    public static int i(int i) {
        if (i >= 0) {
            return j(i);
        }
        return 10;
    }

    public static int k(int i) {
        return j((i >> 31) ^ (i << 1));
    }

    public static int f(long j) {
        return g(j);
    }

    public static int h(long j) {
        return g((j >> 63) ^ (j << 1));
    }

    public static int l(int i) {
        if (i >= 0) {
            return j(i);
        }
        return 10;
    }

    public static int b(String str) {
        int length;
        try {
            length = Utf8.a(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f6726a).length;
        }
        return j(length) + length;
    }

    public static int a(LazyFieldLite lazyFieldLite) {
        int b2 = lazyFieldLite.b();
        return j(b2) + b2;
    }

    public static int b(ByteString byteString) {
        int b2 = byteString.b();
        return j(b2) + b2;
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        return j(length) + length;
    }

    public static int b(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return j(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(MessageLite messageLite, ao aoVar) {
        int serializedSize = ((AbstractMessageLite) messageLite).getSerializedSize(aoVar);
        return j(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i) {
        return j(i) + i;
    }

    public final void k() {
        if (j() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    final void a(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f6726a);
        try {
            c(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException(e2);
        }
    }

    @Deprecated
    public final void e(int i, MessageLite messageLite) throws IOException {
        a(i, 3);
        messageLite.writeTo(this);
        a(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void c(int i, MessageLite messageLite, ao aoVar) throws IOException {
        a(i, 3);
        aoVar.a((ao) messageLite, (Writer) this.f6640a);
        a(i, 4);
    }

    @Deprecated
    public final void c(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    @Deprecated
    public static int f(int i, MessageLite messageLite) {
        return (j(WireFormat.a(i, 0)) << 1) + messageLite.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int d(int i, MessageLite messageLite, ao aoVar) {
        return (j(WireFormat.a(i, 0)) << 1) + ((AbstractMessageLite) messageLite).getSerializedSize(aoVar);
    }

    @Deprecated
    public static int d(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    public final void o(int i) throws IOException {
        c(i);
    }

    @Deprecated
    public static int p(int i) {
        return j(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends CodedOutputStream {
        private final byte[] b;
        private final int c;
        private final int d;
        private int e;

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public void i() {
        }

        b(byte[] bArr, int i, int i2) {
            super((byte) 0);
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

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, int i2) throws IOException {
            c(WireFormat.a(i, i2));
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, int i2) throws IOException {
            c(WireFormat.a(i, 0));
            if (i2 >= 0) {
                c(i2);
            } else {
                b(i2);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(int i, int i2) throws IOException {
            c(WireFormat.a(i, 0));
            c(i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void e(int i, int i2) throws IOException {
            c(WireFormat.a(i, 5));
            e(i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, long j) throws IOException {
            c(WireFormat.a(i, 0));
            b(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void d(int i, long j) throws IOException {
            c(WireFormat.a(i, 1));
            d(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, boolean z) throws IOException {
            c(WireFormat.a(i, 0));
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, String str) throws IOException {
            c(WireFormat.a(i, 2));
            a(str);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, ByteString byteString) throws IOException {
            c(WireFormat.a(i, 2));
            c(byteString.b());
            byteString.a(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(ByteString byteString) throws IOException {
            c(byteString.b());
            byteString.a(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(byte[] bArr, int i, int i2) throws IOException {
            c(i2);
            a(bArr, 0, i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, MessageLite messageLite) throws IOException {
            c(WireFormat.a(i, 2));
            c(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        final void a(int i, MessageLite messageLite, ao aoVar) throws IOException {
            c(WireFormat.a(i, 2));
            c(((AbstractMessageLite) messageLite).getSerializedSize(aoVar));
            aoVar.a((ao) messageLite, (Writer) this.f6640a);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, MessageLite messageLite) throws IOException {
            c(WireFormat.a(1, 3));
            c(WireFormat.a(2, 0));
            c(i);
            a(3, messageLite);
            c(WireFormat.a(1, 4));
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, ByteString byteString) throws IOException {
            c(WireFormat.a(1, 3));
            c(WireFormat.a(2, 0));
            c(i);
            a(3, byteString);
            c(WireFormat.a(1, 4));
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(MessageLite messageLite) throws IOException {
            c(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(byte b) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i) throws IOException {
            if (i >= 0) {
                c(i);
            } else {
                b(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(int i) throws IOException {
            if (CodedOutputStream.c && !com.uqm.crashsight.protobuf.b.a()) {
                int i2 = this.d;
                int i3 = this.e;
                if (i2 - i3 >= 5) {
                    if ((i & (-128)) == 0) {
                        byte[] bArr = this.b;
                        this.e = i3 + 1;
                        aw.a(bArr, i3, (byte) i);
                        return;
                    }
                    byte[] bArr2 = this.b;
                    this.e = i3 + 1;
                    aw.a(bArr2, i3, (byte) (i | 128));
                    int i4 = i >>> 7;
                    if ((i4 & (-128)) == 0) {
                        byte[] bArr3 = this.b;
                        int i5 = this.e;
                        this.e = i5 + 1;
                        aw.a(bArr3, i5, (byte) i4);
                        return;
                    }
                    byte[] bArr4 = this.b;
                    int i6 = this.e;
                    this.e = i6 + 1;
                    aw.a(bArr4, i6, (byte) (i4 | 128));
                    int i7 = i4 >>> 7;
                    if ((i7 & (-128)) == 0) {
                        byte[] bArr5 = this.b;
                        int i8 = this.e;
                        this.e = i8 + 1;
                        aw.a(bArr5, i8, (byte) i7);
                        return;
                    }
                    byte[] bArr6 = this.b;
                    int i9 = this.e;
                    this.e = i9 + 1;
                    aw.a(bArr6, i9, (byte) (i7 | 128));
                    int i10 = i7 >>> 7;
                    if ((i10 & (-128)) == 0) {
                        byte[] bArr7 = this.b;
                        int i11 = this.e;
                        this.e = i11 + 1;
                        aw.a(bArr7, i11, (byte) i10);
                        return;
                    }
                    byte[] bArr8 = this.b;
                    int i12 = this.e;
                    this.e = i12 + 1;
                    aw.a(bArr8, i12, (byte) (i10 | 128));
                    byte[] bArr9 = this.b;
                    int i13 = this.e;
                    this.e = i13 + 1;
                    aw.a(bArr9, i13, (byte) (i10 >>> 7));
                    return;
                }
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr10 = this.b;
                    int i14 = this.e;
                    this.e = i14 + 1;
                    bArr10[i14] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr11 = this.b;
            int i15 = this.e;
            this.e = i15 + 1;
            bArr11[i15] = (byte) i;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void e(int i) throws IOException {
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
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(long j) throws IOException {
            if (CodedOutputStream.c && this.d - this.e >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    aw.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                aw.a(bArr2, i2, (byte) j);
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
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.b;
            int i4 = this.e;
            this.e = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void d(long j) throws IOException {
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
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.uqm.crashsight.protobuf.ByteOutput
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream, com.uqm.crashsight.protobuf.ByteOutput
        public final void b(byte[] bArr, int i, int i2) throws IOException {
            a(bArr, i, i2);
        }

        @Override // com.uqm.crashsight.protobuf.ByteOutput
        public final void a(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.b, this.e, remaining);
                this.e += remaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(remaining)), e);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(String str) throws IOException {
            int i = this.e;
            try {
                int j = j(str.length() * 3);
                int j2 = j(str.length());
                if (j2 == j) {
                    this.e = i + j2;
                    int a2 = Utf8.a(str, this.b, this.e, this.d - this.e);
                    this.e = i;
                    c((a2 - i) - j2);
                    this.e = a2;
                    return;
                }
                c(Utf8.a(str));
                this.e = Utf8.a(str, this.b, this.e, this.d - this.e);
            } catch (Utf8.UnpairedSurrogateException e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final int j() {
            return this.d - this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class a extends CodedOutputStream {
        final byte[] b;
        final int c;
        int d;
        int e;

        a(int i) {
            super((byte) 0);
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.b = new byte[Math.max(i, 20)];
            this.c = this.b.length;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final int j() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void q(int i) {
            if (CodedOutputStream.c) {
                long j = this.d;
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i2 = this.d;
                    this.d = i2 + 1;
                    aw.a(bArr, i2, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i3 = this.d;
                this.d = i3 + 1;
                aw.a(bArr2, i3, (byte) i);
                this.e += (int) (this.d - j);
                return;
            }
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.b;
                int i4 = this.d;
                this.d = i4 + 1;
                bArr3[i4] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                this.e++;
                i >>>= 7;
            }
            byte[] bArr4 = this.b;
            int i5 = this.d;
            this.d = i5 + 1;
            bArr4[i5] = (byte) i;
            this.e++;
        }

        final void j(long j) {
            if (CodedOutputStream.c) {
                long j2 = this.d;
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.d;
                    this.d = i + 1;
                    aw.a(bArr, i, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.d;
                this.d = i2 + 1;
                aw.a(bArr2, i2, (byte) j);
                this.e += (int) (this.d - j2);
                return;
            }
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.b;
                int i3 = this.d;
                this.d = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                this.e++;
                j >>>= 7;
            }
            byte[] bArr4 = this.b;
            int i4 = this.d;
            this.d = i4 + 1;
            bArr4[i4] = (byte) j;
            this.e++;
        }

        final void r(int i) {
            byte[] bArr = this.b;
            int i2 = this.d;
            this.d = i2 + 1;
            bArr[i2] = (byte) i;
            int i3 = this.d;
            this.d = i3 + 1;
            bArr[i3] = (byte) (i >> 8);
            int i4 = this.d;
            this.d = i4 + 1;
            bArr[i4] = (byte) (i >> 16);
            int i5 = this.d;
            this.d = i5 + 1;
            bArr[i5] = (byte) (i >>> 24);
            this.e += 4;
        }

        final void k(long j) {
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            bArr[i] = (byte) (j & 255);
            int i2 = this.d;
            this.d = i2 + 1;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i3 = this.d;
            this.d = i3 + 1;
            bArr[i3] = (byte) ((j >> 16) & 255);
            int i4 = this.d;
            this.d = i4 + 1;
            bArr[i4] = (byte) (255 & (j >> 24));
            int i5 = this.d;
            this.d = i5 + 1;
            bArr[i5] = (byte) (j >> 32);
            int i6 = this.d;
            this.d = i6 + 1;
            bArr[i6] = (byte) (j >> 40);
            int i7 = this.d;
            this.d = i7 + 1;
            bArr[i7] = (byte) (j >> 48);
            int i8 = this.d;
            this.d = i8 + 1;
            bArr[i8] = (byte) (j >> 56);
            this.e += 8;
        }
    }

    /* loaded from: classes3.dex */
    static final class c extends a {
        private final OutputStream f;

        c(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f = outputStream;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, int i2) throws IOException {
            int a2 = WireFormat.a(i, i2);
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(a2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, int i2) throws IOException {
            if (this.c - this.d < 20) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 0));
            if (i2 >= 0) {
                q(i2);
            } else {
                j(i2);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(int i, int i2) throws IOException {
            if (this.c - this.d < 20) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 0));
            q(i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void e(int i, int i2) throws IOException {
            if (this.c - this.d < 14) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 5));
            r(i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, long j) throws IOException {
            if (this.c - this.d < 20) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 0));
            j(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void d(int i, long j) throws IOException {
            if (this.c - this.d < 18) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 1));
            k(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, boolean z) throws IOException {
            if (this.c - this.d < 11) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(WireFormat.a(i, 0));
            byte b = z ? (byte) 1 : (byte) 0;
            byte[] bArr = this.b;
            int i2 = this.d;
            this.d = i2 + 1;
            bArr[i2] = b;
            this.e++;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, String str) throws IOException {
            a(i, 2);
            a(str);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, ByteString byteString) throws IOException {
            a(i, 2);
            c(byteString.b());
            byteString.a(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(ByteString byteString) throws IOException {
            int b = byteString.b();
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(b);
            byteString.a(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(byte[] bArr, int i, int i2) throws IOException {
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(i2);
            a(bArr, 0, i2);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(int i, MessageLite messageLite) throws IOException {
            a(i, 2);
            c(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        final void a(int i, MessageLite messageLite, ao aoVar) throws IOException {
            a(i, 2);
            int serializedSize = ((AbstractMessageLite) messageLite).getSerializedSize(aoVar);
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(serializedSize);
            aoVar.a((ao) messageLite, (Writer) this.f6640a);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, MessageLite messageLite) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, 2);
            c(messageLite.getSerializedSize());
            messageLite.writeTo(this);
            a(1, 4);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i, ByteString byteString) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, 2);
            c(byteString.b());
            byteString.a(this);
            a(1, 4);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(MessageLite messageLite) throws IOException {
            int serializedSize = messageLite.getSerializedSize();
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(serializedSize);
            messageLite.writeTo(this);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(byte b) throws IOException {
            if (this.d == this.c) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            bArr[i] = b;
            this.e++;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(int i) throws IOException {
            if (i >= 0) {
                if (this.c - this.d < 5) {
                    this.f.write(this.b, 0, this.d);
                    this.d = 0;
                }
                q(i);
                return;
            }
            long j = i;
            if (this.c - this.d < 10) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            j(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void c(int i) throws IOException {
            if (this.c - this.d < 5) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            q(i);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void e(int i) throws IOException {
            if (this.c - this.d < 4) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            r(i);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void b(long j) throws IOException {
            if (this.c - this.d < 10) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            j(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void d(long j) throws IOException {
            if (this.c - this.d < 8) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
            k(j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void a(String str) throws IOException {
            int a2;
            try {
                int length = str.length() * 3;
                int j = j(length);
                int i = j + length;
                if (i > this.c) {
                    byte[] bArr = new byte[length];
                    int a3 = Utf8.a(str, bArr, 0, length);
                    c(a3);
                    a(bArr, 0, a3);
                    return;
                }
                if (i > this.c - this.d) {
                    this.f.write(this.b, 0, this.d);
                    this.d = 0;
                }
                int j2 = j(str.length());
                int i2 = this.d;
                try {
                    try {
                        if (j2 == j) {
                            this.d = i2 + j2;
                            int a4 = Utf8.a(str, this.b, this.d, this.c - this.d);
                            this.d = i2;
                            a2 = (a4 - i2) - j2;
                            q(a2);
                            this.d = a4;
                        } else {
                            a2 = Utf8.a(str);
                            q(a2);
                            this.d = Utf8.a(str, this.b, this.d, a2);
                        }
                        this.e += a2;
                    } catch (Utf8.UnpairedSurrogateException e) {
                        this.e -= this.d - i2;
                        this.d = i2;
                        throw e;
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(e2);
                }
            } catch (Utf8.UnpairedSurrogateException e3) {
                a(str, e3);
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream
        public final void i() throws IOException {
            if (this.d > 0) {
                this.f.write(this.b, 0, this.d);
                this.d = 0;
            }
        }

        @Override // com.uqm.crashsight.protobuf.ByteOutput
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            if (this.c - this.d >= i2) {
                System.arraycopy(bArr, i, this.b, this.d, i2);
                this.d += i2;
            } else {
                int i3 = this.c - this.d;
                System.arraycopy(bArr, i, this.b, this.d, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.d = this.c;
                this.e += i3;
                this.f.write(this.b, 0, this.d);
                this.d = 0;
                if (i2 <= this.c) {
                    System.arraycopy(bArr, i4, this.b, 0, i2);
                    this.d = i2;
                } else {
                    this.f.write(bArr, i4, i2);
                }
            }
            this.e += i2;
        }

        @Override // com.uqm.crashsight.protobuf.CodedOutputStream, com.uqm.crashsight.protobuf.ByteOutput
        public final void b(byte[] bArr, int i, int i2) throws IOException {
            a(bArr, i, i2);
        }

        @Override // com.uqm.crashsight.protobuf.ByteOutput
        public final void a(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            if (this.c - this.d >= remaining) {
                byteBuffer.get(this.b, this.d, remaining);
                this.d += remaining;
                this.e += remaining;
                return;
            }
            int i = this.c - this.d;
            byteBuffer.get(this.b, this.d, i);
            int i2 = remaining - i;
            this.d = this.c;
            this.e += i;
            this.f.write(this.b, 0, this.d);
            this.d = 0;
            while (i2 > this.c) {
                byteBuffer.get(this.b, 0, this.c);
                this.f.write(this.b, 0, this.c);
                i2 -= this.c;
                this.e += this.c;
            }
            byteBuffer.get(this.b, 0, i2);
            this.d = i2;
            this.e += i2;
        }
    }
}
