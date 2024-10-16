package com.uqm.crashsight.protobuf;

import com.google.android.gms.games.Notifications;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.uqm.crashsight.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CodedInputStream {

    /* renamed from: a, reason: collision with root package name */
    int f6639a;
    int b;
    int c;
    f d;
    private boolean e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int a() throws IOException;

    public abstract <T extends MessageLite> T a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void a(int i) throws InvalidProtocolBufferException;

    public abstract void a(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract double b() throws IOException;

    public abstract boolean b(int i) throws IOException;

    public abstract float c() throws IOException;

    public abstract int c(int i) throws InvalidProtocolBufferException;

    public abstract long d() throws IOException;

    public abstract void d(int i);

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract long g() throws IOException;

    public abstract int h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract String j() throws IOException;

    public abstract String k() throws IOException;

    public abstract ByteString l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract int s() throws IOException;

    public abstract int w();

    public abstract boolean x() throws IOException;

    public abstract int y();

    /* synthetic */ CodedInputStream(byte b2) {
        this();
    }

    public static CodedInputStream a(InputStream inputStream) {
        byte b2 = 0;
        if (inputStream != null) {
            return new b(inputStream, 4096, b2);
        }
        byte[] bArr = Internal.c;
        return a(bArr, 0, bArr.length, false);
    }

    public static CodedInputStream a(byte[] bArr) {
        return a(bArr, 0, bArr.length, false);
    }

    public static CodedInputStream a(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream a(byte[] bArr, int i, int i2, boolean z) {
        a aVar = new a(bArr, i, i2, z, (byte) 0);
        try {
            aVar.c(i2);
            return aVar;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream a(ByteBuffer byteBuffer) {
        return a(byteBuffer, false);
    }

    static CodedInputStream a(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        byte b2 = 0;
        if (byteBuffer.isDirect() && c.z()) {
            return new c(byteBuffer, z, b2);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return a(bArr, 0, bArr.length, true);
    }

    private CodedInputStream() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }

    final void t() {
        this.e = true;
    }

    final void u() {
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.c();
            }
            i2 |= (read & Notifications.NOTIFICATION_TYPES_ALL) << i3;
            if ((read & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.c();
            }
            if ((read2 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a extends CodedInputStream {
        private final byte[] e;
        private final boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;

        /* synthetic */ a(byte[] bArr, int i, int i2, boolean z, byte b) {
            this(bArr, i, i2, z);
        }

        private a(byte[] bArr, int i, int i2, boolean z) {
            super((byte) 0);
            this.l = Integer.MAX_VALUE;
            this.e = bArr;
            this.g = i2 + i;
            this.i = i;
            this.j = this.i;
            this.f = z;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int a() throws IOException {
            if (this.i == this.g) {
                this.k = 0;
                return 0;
            }
            this.k = s();
            if (WireFormat.b(this.k) == 0) {
                throw InvalidProtocolBufferException.f();
            }
            return this.k;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i) throws InvalidProtocolBufferException {
            if (this.k != i) {
                throw InvalidProtocolBufferException.g();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(int r6) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = com.uqm.crashsight.protobuf.WireFormat.a(r6)
                r1 = 4
                r2 = 0
                r3 = 1
                switch(r0) {
                    case 0: goto L40;
                    case 1: goto L3a;
                    case 2: goto L32;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto Lf;
                    default: goto La;
                }
            La:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException$InvalidWireTypeException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.h()
                throw r6
            Lf:
                r5.f(r1)
                return r3
            L13:
                return r2
            L14:
                int r0 = r5.a()
                if (r0 == 0) goto L20
                boolean r0 = r5.b(r0)
                if (r0 != 0) goto L14
            L20:
                int r6 = com.uqm.crashsight.protobuf.WireFormat.b(r6)
                int r6 = com.uqm.crashsight.protobuf.WireFormat.a(r6, r1)
                int r0 = r5.k
                if (r0 != r6) goto L2d
                return r3
            L2d:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.g()
                throw r6
            L32:
                int r6 = r5.s()
                r5.f(r6)
                return r3
            L3a:
                r6 = 8
                r5.f(r6)
                return r3
            L40:
                int r6 = r5.g
                int r0 = r5.i
                int r6 = r6 - r0
                r0 = 10
                if (r6 < r0) goto L5f
            L49:
                if (r2 >= r0) goto L5a
                byte[] r6 = r5.e
                int r1 = r5.i
                int r4 = r1 + 1
                r5.i = r4
                r6 = r6[r1]
                if (r6 >= 0) goto L74
                int r2 = r2 + 1
                goto L49
            L5a:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r6
            L5f:
                if (r2 >= r0) goto L7a
                int r6 = r5.i
                int r1 = r5.g
                if (r6 == r1) goto L75
                byte[] r1 = r5.e
                int r4 = r6 + 1
                r5.i = r4
                r6 = r1[r6]
                if (r6 >= 0) goto L74
                int r2 = r2 + 1
                goto L5f
            L74:
                return r3
            L75:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.c()
                throw r6
            L7a:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.a.b(int):boolean");
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final double b() throws IOException {
            return Double.longBitsToDouble(C());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final float c() throws IOException {
            return Float.intBitsToFloat(B());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long d() throws IOException {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long e() throws IOException {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int f() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long g() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int h() throws IOException {
            return B();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean i() throws IOException {
            return z() != 0;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String j() throws IOException {
            int s = s();
            if (s > 0) {
                int i = this.g;
                int i2 = this.i;
                if (s <= i - i2) {
                    String str = new String(this.e, i2, s, Internal.f6726a);
                    this.i += s;
                    return str;
                }
            }
            if (s == 0) {
                return "";
            }
            if (s < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String k() throws IOException {
            int s = s();
            if (s > 0) {
                int i = this.g;
                int i2 = this.i;
                if (s <= i - i2) {
                    String b = Utf8.b(this.e, i2, s);
                    this.i += s;
                    return b;
                }
            }
            if (s == 0) {
                return "";
            }
            if (s <= 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.k != WireFormat.a(i, 4)) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.k != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.l = c;
            D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final <T extends MessageLite> T a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            T a2 = parser.a(this, extensionRegistryLite);
            if (this.k != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.l = c;
            D();
            return a2;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final ByteString l() throws IOException {
            byte[] bArr;
            int s = s();
            if (s > 0) {
                int i = this.g;
                int i2 = this.i;
                if (s <= i - i2) {
                    boolean z = this.f;
                    ByteString a2 = ByteString.a(this.e, i2, s);
                    this.i += s;
                    return a2;
                }
            }
            if (s == 0) {
                return ByteString.f6635a;
            }
            if (s > 0) {
                int i3 = this.g;
                int i4 = this.i;
                if (s <= i3 - i4) {
                    this.i = s + i4;
                    bArr = Arrays.copyOfRange(this.e, i4, this.i);
                    return ByteString.b(bArr);
                }
            }
            if (s > 0) {
                throw InvalidProtocolBufferException.c();
            }
            if (s != 0) {
                throw InvalidProtocolBufferException.d();
            }
            bArr = Internal.c;
            return ByteString.b(bArr);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int m() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int n() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int o() throws IOException {
            return B();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long p() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int q() throws IOException {
            int s = s();
            return (-(s & 1)) ^ (s >>> 1);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long r() throws IOException {
            long z = z();
            return (-(z & 1)) ^ (z >>> 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        
            if (r2[r3] >= 0) goto L33;
         */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int s() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.i
                int r1 = r5.g
                if (r1 == r0) goto L6d
                byte[] r2 = r5.e
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L11
                r5.i = r3
                return r0
            L11:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L6d
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L22
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L6a
            L22:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L2f
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                r1 = r3
                goto L6a
            L2f:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3d
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L6a
            L3d:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L6a
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L6a
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 < 0) goto L6d
                goto L6a
            L69:
                r1 = r3
            L6a:
                r5.i = r1
                return r0
            L6d:
                long r0 = r5.A()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.a.s():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        
            if (r2[r0] >= 0) goto L37;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private long z() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 195
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.a.z():long");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long A() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                int i2 = this.i;
                if (i2 == this.g) {
                    throw InvalidProtocolBufferException.c();
                }
                byte[] bArr = this.e;
                this.i = i2 + 1;
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((bArr[i2] & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private int B() throws IOException {
            int i = this.i;
            if (this.g - i < 4) {
                throw InvalidProtocolBufferException.c();
            }
            byte[] bArr = this.e;
            this.i = i + 4;
            return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        }

        private long C() throws IOException {
            int i = this.i;
            if (this.g - i < 8) {
                throw InvalidProtocolBufferException.c();
            }
            byte[] bArr = this.e;
            this.i = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int c(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i2 = i + (this.i - this.j);
            int i3 = this.l;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.c();
            }
            this.l = i2;
            D();
            return i3;
        }

        private void D() {
            this.g += this.h;
            int i = this.g;
            int i2 = i - this.j;
            int i3 = this.l;
            if (i2 > i3) {
                this.h = i2 - i3;
                this.g = i - this.h;
            } else {
                this.h = 0;
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void d(int i) {
            this.l = i;
            D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int w() {
            int i = this.l;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.i - this.j);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean x() throws IOException {
            return this.i == this.g;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int y() {
            return this.i - this.j;
        }

        private void f(int i) throws IOException {
            if (i >= 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (i <= i2 - i3) {
                    this.i = i3 + i;
                    return;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c extends CodedInputStream {
        private final ByteBuffer e;
        private final boolean f;
        private final long g;
        private long h;
        private long i;
        private long j;
        private int k;
        private int l;
        private int m;

        /* synthetic */ c(ByteBuffer byteBuffer, boolean z, byte b) {
            this(byteBuffer, z);
        }

        static boolean z() {
            return aw.b();
        }

        private c(ByteBuffer byteBuffer, boolean z) {
            super((byte) 0);
            this.m = Integer.MAX_VALUE;
            this.e = byteBuffer;
            this.g = aw.a(byteBuffer);
            this.h = this.g + byteBuffer.limit();
            this.i = this.g + byteBuffer.position();
            this.j = this.i;
            this.f = z;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int a() throws IOException {
            if (this.i == this.h) {
                this.l = 0;
                return 0;
            }
            this.l = s();
            if (WireFormat.b(this.l) == 0) {
                throw InvalidProtocolBufferException.f();
            }
            return this.l;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i) throws InvalidProtocolBufferException {
            if (this.l != i) {
                throw InvalidProtocolBufferException.g();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(int r10) throws java.io.IOException {
            /*
                r9 = this;
                int r0 = com.uqm.crashsight.protobuf.WireFormat.a(r10)
                r1 = 4
                r2 = 0
                r3 = 1
                switch(r0) {
                    case 0: goto L40;
                    case 1: goto L3a;
                    case 2: goto L32;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto Lf;
                    default: goto La;
                }
            La:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException$InvalidWireTypeException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.h()
                throw r10
            Lf:
                r9.f(r1)
                return r3
            L13:
                return r2
            L14:
                int r0 = r9.a()
                if (r0 == 0) goto L20
                boolean r0 = r9.b(r0)
                if (r0 != 0) goto L14
            L20:
                int r10 = com.uqm.crashsight.protobuf.WireFormat.b(r10)
                int r10 = com.uqm.crashsight.protobuf.WireFormat.a(r10, r1)
                int r0 = r9.l
                if (r0 != r10) goto L2d
                return r3
            L2d:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.g()
                throw r10
            L32:
                int r10 = r9.s()
                r9.f(r10)
                return r3
            L3a:
                r10 = 8
                r9.f(r10)
                return r3
            L40:
                long r0 = r9.h
                long r4 = r9.i
                long r0 = r0 - r4
                int r10 = (int) r0
                r0 = 1
                r4 = 10
                if (r10 < r4) goto L62
            L4c:
                if (r2 >= r4) goto L5d
                long r5 = r9.i
                long r7 = r5 + r0
                r9.i = r7
                byte r10 = com.uqm.crashsight.protobuf.aw.a(r5)
                if (r10 >= 0) goto L79
                int r2 = r2 + 1
                goto L4c
            L5d:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r10
            L62:
                if (r2 >= r4) goto L7f
                long r5 = r9.i
                long r7 = r9.h
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 == 0) goto L7a
                long r7 = r5 + r0
                r9.i = r7
                byte r10 = com.uqm.crashsight.protobuf.aw.a(r5)
                if (r10 >= 0) goto L79
                int r2 = r2 + 1
                goto L62
            L79:
                return r3
            L7a:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.c()
                throw r10
            L7f:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.c.b(int):boolean");
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final double b() throws IOException {
            return Double.longBitsToDouble(D());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final float c() throws IOException {
            return Float.intBitsToFloat(C());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long d() throws IOException {
            return A();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long e() throws IOException {
            return A();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int f() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long g() throws IOException {
            return D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int h() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean i() throws IOException {
            return A() != 0;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String j() throws IOException {
            int s = s();
            if (s > 0) {
                long j = this.h;
                long j2 = this.i;
                if (s <= ((int) (j - j2))) {
                    byte[] bArr = new byte[s];
                    long j3 = s;
                    aw.a(j2, bArr, 0L, j3);
                    String str = new String(bArr, Internal.f6726a);
                    this.i += j3;
                    return str;
                }
            }
            if (s == 0) {
                return "";
            }
            if (s < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String k() throws IOException {
            int s = s();
            if (s > 0) {
                long j = this.h;
                long j2 = this.i;
                if (s <= ((int) (j - j2))) {
                    String a2 = Utf8.a(this.e, (int) (j2 - this.g), s);
                    this.i += s;
                    return a2;
                }
            }
            if (s == 0) {
                return "";
            }
            if (s <= 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.l != WireFormat.a(i, 4)) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.l != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.m = c;
            E();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final <T extends MessageLite> T a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            T a2 = parser.a(this, extensionRegistryLite);
            if (this.l != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.m = c;
            E();
            return a2;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final ByteString l() throws IOException {
            int s = s();
            if (s > 0) {
                long j = this.h;
                long j2 = this.i;
                if (s <= ((int) (j - j2))) {
                    boolean z = this.f;
                    byte[] bArr = new byte[s];
                    long j3 = s;
                    aw.a(j2, bArr, 0L, j3);
                    this.i += j3;
                    return ByteString.b(bArr);
                }
            }
            if (s == 0) {
                return ByteString.f6635a;
            }
            if (s < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int m() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int n() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int o() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long p() throws IOException {
            return D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int q() throws IOException {
            int s = s();
            return (-(s & 1)) ^ (s >>> 1);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long r() throws IOException {
            long A = A();
            return (-(A & 1)) ^ (A >>> 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        
            if (com.uqm.crashsight.protobuf.aw.a(r4) >= 0) goto L33;
         */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int s() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.i
                long r2 = r10.h
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 == 0) goto L87
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.uqm.crashsight.protobuf.aw.a(r0)
                if (r0 < 0) goto L15
                r10.i = r4
                return r0
            L15:
                long r6 = r10.h
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 < 0) goto L87
                long r6 = r4 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2c
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L84
            L2c:
                long r4 = r6 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3b
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                r6 = r4
                goto L84
            L3b:
                long r6 = r4 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4b
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L84
            L4b:
                long r4 = r6 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L83
                long r6 = r4 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r4)
                if (r1 >= 0) goto L84
                long r4 = r6 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r6)
                if (r1 >= 0) goto L83
                long r6 = r4 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r4)
                if (r1 >= 0) goto L84
                long r4 = r6 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r6)
                if (r1 >= 0) goto L83
                long r6 = r4 + r2
                byte r1 = com.uqm.crashsight.protobuf.aw.a(r4)
                if (r1 < 0) goto L87
                goto L84
            L83:
                r6 = r4
            L84:
                r10.i = r6
                return r0
            L87:
                long r0 = r10.B()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.c.s():int");
        }

        private long A() throws IOException {
            long j;
            long a2;
            long j2 = this.i;
            if (this.h != j2) {
                long j3 = j2 + 1;
                byte a3 = aw.a(j2);
                if (a3 >= 0) {
                    this.i = j3;
                    return a3;
                }
                if (this.h - j3 >= 9) {
                    long j4 = j3 + 1;
                    int a4 = a3 ^ (aw.a(j3) << 7);
                    if (a4 < 0) {
                        a2 = a4 ^ (-128);
                        j = j4;
                    } else {
                        j = j4 + 1;
                        int a5 = a4 ^ (aw.a(j4) << 14);
                        if (a5 >= 0) {
                            a2 = a5 ^ 16256;
                        } else {
                            long j5 = j + 1;
                            int a6 = a5 ^ (aw.a(j) << 21);
                            if (a6 < 0) {
                                a2 = a6 ^ (-2080896);
                                j = j5;
                            } else {
                                j = j5 + 1;
                                long a7 = a6 ^ (aw.a(j5) << 28);
                                if (a7 >= 0) {
                                    a2 = a7 ^ 266354560;
                                } else {
                                    long j6 = j + 1;
                                    long a8 = a7 ^ (aw.a(j) << 35);
                                    if (a8 < 0) {
                                        a2 = a8 ^ (-34093383808L);
                                        j = j6;
                                    } else {
                                        j = j6 + 1;
                                        long a9 = a8 ^ (aw.a(j6) << 42);
                                        if (a9 >= 0) {
                                            a2 = a9 ^ 4363953127296L;
                                        } else {
                                            long j7 = j + 1;
                                            long a10 = a9 ^ (aw.a(j) << 49);
                                            if (a10 < 0) {
                                                a2 = a10 ^ (-558586000294016L);
                                                j = j7;
                                            } else {
                                                j = j7 + 1;
                                                a2 = (a10 ^ (aw.a(j7) << 56)) ^ 71499008037633920L;
                                                if (a2 < 0) {
                                                    long j8 = 1 + j;
                                                    if (aw.a(j) >= 0) {
                                                        j = j8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.i = j;
                    return a2;
                }
            }
            return B();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long B() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                long j2 = this.i;
                if (j2 == this.h) {
                    throw InvalidProtocolBufferException.c();
                }
                this.i = 1 + j2;
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((aw.a(j2) & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private int C() throws IOException {
            long j = this.i;
            if (this.h - j < 4) {
                throw InvalidProtocolBufferException.c();
            }
            this.i = 4 + j;
            return ((aw.a(j + 3) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (aw.a(j) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((aw.a(1 + j) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((aw.a(2 + j) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        }

        private long D() throws IOException {
            long j = this.i;
            if (this.h - j < 8) {
                throw InvalidProtocolBufferException.c();
            }
            this.i = 8 + j;
            return ((aw.a(j + 7) & 255) << 56) | (aw.a(j) & 255) | ((aw.a(1 + j) & 255) << 8) | ((aw.a(2 + j) & 255) << 16) | ((aw.a(3 + j) & 255) << 24) | ((aw.a(4 + j) & 255) << 32) | ((aw.a(5 + j) & 255) << 40) | ((aw.a(6 + j) & 255) << 48);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int c(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i2 = i + ((int) (this.i - this.j));
            int i3 = this.m;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.c();
            }
            this.m = i2;
            E();
            return i3;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void d(int i) {
            this.m = i;
            E();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int w() {
            int i = this.m;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - ((int) (this.i - this.j));
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean x() throws IOException {
            return this.i == this.h;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int y() {
            return (int) (this.i - this.j);
        }

        private void f(int i) throws IOException {
            if (i >= 0) {
                long j = this.h;
                long j2 = this.i;
                if (i <= ((int) (j - j2))) {
                    this.i = j2 + i;
                    return;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.c();
        }

        private void E() {
            this.h += this.k;
            long j = this.h;
            int i = (int) (j - this.j);
            int i2 = this.m;
            if (i > i2) {
                this.k = i - i2;
                this.h = j - this.k;
            } else {
                this.k = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b extends CodedInputStream {
        private final InputStream e;
        private final byte[] f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private a m;

        /* loaded from: classes3.dex */
        interface a {
        }

        /* synthetic */ b(InputStream inputStream, int i, byte b) {
            this(inputStream, i);
        }

        private b(InputStream inputStream, int i) {
            super((byte) 0);
            this.l = Integer.MAX_VALUE;
            this.m = null;
            Internal.a(inputStream, EvaluateItemInfo.ACTIONTYPE_INPUT);
            this.e = inputStream;
            this.f = new byte[i];
            this.g = 0;
            this.i = 0;
            this.k = 0;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int a() throws IOException {
            if (this.i == this.g && !g(1)) {
                this.j = 0;
                return 0;
            }
            this.j = s();
            if (WireFormat.b(this.j) == 0) {
                throw InvalidProtocolBufferException.f();
            }
            return this.j;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i) throws InvalidProtocolBufferException {
            if (this.j != i) {
                throw InvalidProtocolBufferException.g();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(int r6) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = com.uqm.crashsight.protobuf.WireFormat.a(r6)
                r1 = 4
                r2 = 0
                r3 = 1
                switch(r0) {
                    case 0: goto L40;
                    case 1: goto L3a;
                    case 2: goto L32;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto Lf;
                    default: goto La;
                }
            La:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException$InvalidWireTypeException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.h()
                throw r6
            Lf:
                r5.j(r1)
                return r3
            L13:
                return r2
            L14:
                int r0 = r5.a()
                if (r0 == 0) goto L20
                boolean r0 = r5.b(r0)
                if (r0 != 0) goto L14
            L20:
                int r6 = com.uqm.crashsight.protobuf.WireFormat.b(r6)
                int r6 = com.uqm.crashsight.protobuf.WireFormat.a(r6, r1)
                int r0 = r5.j
                if (r0 != r6) goto L2d
                return r3
            L2d:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.g()
                throw r6
            L32:
                int r6 = r5.s()
                r5.j(r6)
                return r3
            L3a:
                r6 = 8
                r5.j(r6)
                return r3
            L40:
                int r6 = r5.g
                int r0 = r5.i
                int r6 = r6 - r0
                r0 = 10
                if (r6 < r0) goto L5f
            L49:
                if (r2 >= r0) goto L5a
                byte[] r6 = r5.f
                int r1 = r5.i
                int r4 = r1 + 1
                r5.i = r4
                r6 = r6[r1]
                if (r6 >= 0) goto L6a
                int r2 = r2 + 1
                goto L49
            L5a:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r6
            L5f:
                if (r2 >= r0) goto L6b
                byte r6 = r5.E()
                if (r6 >= 0) goto L6a
                int r2 = r2 + 1
                goto L5f
            L6a:
                return r3
            L6b:
                com.uqm.crashsight.protobuf.InvalidProtocolBufferException r6 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.e()
                throw r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.b.b(int):boolean");
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final double b() throws IOException {
            return Double.longBitsToDouble(C());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final float c() throws IOException {
            return Float.intBitsToFloat(B());
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long d() throws IOException {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long e() throws IOException {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int f() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long g() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int h() throws IOException {
            return B();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean i() throws IOException {
            return z() != 0;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String j() throws IOException {
            int s = s();
            if (s > 0) {
                int i = this.g;
                int i2 = this.i;
                if (s <= i - i2) {
                    String str = new String(this.f, i2, s, Internal.f6726a);
                    this.i += s;
                    return str;
                }
            }
            if (s == 0) {
                return "";
            }
            if (s <= this.g) {
                f(s);
                String str2 = new String(this.f, this.i, s, Internal.f6726a);
                this.i += s;
                return str2;
            }
            return new String(a(s, false), Internal.f6726a);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final String k() throws IOException {
            byte[] a2;
            int s = s();
            int i = this.i;
            int i2 = 0;
            if (s <= this.g - i && s > 0) {
                a2 = this.f;
                this.i = i + s;
                i2 = i;
            } else {
                if (s == 0) {
                    return "";
                }
                if (s <= this.g) {
                    f(s);
                    a2 = this.f;
                    this.i = s + 0;
                } else {
                    a2 = a(s, false);
                }
            }
            return Utf8.b(a2, i2, s);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.j != WireFormat.a(i, 4)) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            builder.mergeFrom(this, extensionRegistryLite);
            if (this.j != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.l = c;
            D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final <T extends MessageLite> T a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s = s();
            if (this.f6639a >= this.b) {
                throw InvalidProtocolBufferException.i();
            }
            int c = c(s);
            this.f6639a++;
            T a2 = parser.a(this, extensionRegistryLite);
            if (this.j != 0) {
                throw InvalidProtocolBufferException.g();
            }
            this.f6639a--;
            this.l = c;
            D();
            return a2;
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final ByteString l() throws IOException {
            int s = s();
            int i = this.g;
            int i2 = this.i;
            if (s <= i - i2 && s > 0) {
                ByteString a2 = ByteString.a(this.f, i2, s);
                this.i += s;
                return a2;
            }
            if (s == 0) {
                return ByteString.f6635a;
            }
            byte[] h = h(s);
            if (h != null) {
                return ByteString.a(h);
            }
            int i3 = this.i;
            int i4 = this.g;
            int i5 = i4 - i3;
            this.k += i4;
            this.i = 0;
            this.g = 0;
            List<byte[]> i6 = i(s - i5);
            byte[] bArr = new byte[s];
            System.arraycopy(this.f, i3, bArr, 0, i5);
            for (byte[] bArr2 : i6) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return ByteString.b(bArr);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int m() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int n() throws IOException {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int o() throws IOException {
            return B();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long p() throws IOException {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int q() throws IOException {
            int s = s();
            return (-(s & 1)) ^ (s >>> 1);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final long r() throws IOException {
            long z = z();
            return (-(z & 1)) ^ (z >>> 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        
            if (r2[r3] >= 0) goto L33;
         */
        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int s() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.i
                int r1 = r5.g
                if (r1 == r0) goto L6d
                byte[] r2 = r5.f
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L11
                r5.i = r3
                return r0
            L11:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L6d
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L22
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L6a
            L22:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L2f
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                r1 = r3
                goto L6a
            L2f:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3d
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L6a
            L3d:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L6a
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L6a
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L69
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 < 0) goto L6d
                goto L6a
            L69:
                r1 = r3
            L6a:
                r5.i = r1
                return r0
            L6d:
                long r0 = r5.A()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.b.s():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        
            if (r2[r0] >= 0) goto L37;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private long z() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 195
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.CodedInputStream.b.z():long");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long A() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((E() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private int B() throws IOException {
            int i = this.i;
            if (this.g - i < 4) {
                f(4);
                i = this.i;
            }
            byte[] bArr = this.f;
            this.i = i + 4;
            return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        }

        private long C() throws IOException {
            int i = this.i;
            if (this.g - i < 8) {
                f(8);
                i = this.i;
            }
            byte[] bArr = this.f;
            this.i = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int c(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i2 = i + this.k + this.i;
            int i3 = this.l;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.c();
            }
            this.l = i2;
            D();
            return i3;
        }

        private void D() {
            this.g += this.h;
            int i = this.k;
            int i2 = this.g;
            int i3 = i + i2;
            int i4 = this.l;
            if (i3 > i4) {
                this.h = i3 - i4;
                this.g = i2 - this.h;
            } else {
                this.h = 0;
            }
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final void d(int i) {
            this.l = i;
            D();
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int w() {
            int i = this.l;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.k + this.i);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final boolean x() throws IOException {
            return this.i == this.g && !g(1);
        }

        @Override // com.uqm.crashsight.protobuf.CodedInputStream
        public final int y() {
            return this.k + this.i;
        }

        private void f(int i) throws IOException {
            if (g(i)) {
                return;
            }
            if (i > (this.c - this.k) - this.i) {
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.c();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean g(int i) throws IOException {
            while (this.i + i > this.g) {
                int i2 = this.c;
                int i3 = this.k;
                int i4 = this.i;
                if (i > (i2 - i3) - i4 || i3 + i4 + i > this.l) {
                    return false;
                }
                if (i4 > 0) {
                    int i5 = this.g;
                    if (i5 > i4) {
                        byte[] bArr = this.f;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.k += i4;
                    this.g -= i4;
                    this.i = 0;
                }
                InputStream inputStream = this.e;
                byte[] bArr2 = this.f;
                int i6 = this.g;
                int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.c - this.k) - this.g));
                if (read == 0 || read < -1 || read > this.f.length) {
                    throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                }
                if (read <= 0) {
                    return false;
                }
                this.g += read;
                D();
                if (this.g >= i) {
                    return true;
                }
            }
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }

        private byte E() throws IOException {
            if (this.i == this.g) {
                f(1);
            }
            byte[] bArr = this.f;
            int i = this.i;
            this.i = i + 1;
            return bArr[i];
        }

        private byte[] a(int i, boolean z) throws IOException {
            byte[] h = h(i);
            if (h != null) {
                return h;
            }
            int i2 = this.i;
            int i3 = this.g;
            int i4 = i3 - i2;
            this.k += i3;
            this.i = 0;
            this.g = 0;
            List<byte[]> i5 = i(i - i4);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f, i2, bArr, 0, i4);
            for (byte[] bArr2 : i5) {
                System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                i4 += bArr2.length;
            }
            return bArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private byte[] h(int i) throws IOException {
            if (i == 0) {
                return Internal.c;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i2 = this.k + this.i + i;
            if (i2 - this.c > 0) {
                throw InvalidProtocolBufferException.j();
            }
            int i3 = this.l;
            if (i2 > i3) {
                j((i3 - this.k) - this.i);
                throw InvalidProtocolBufferException.c();
            }
            int i4 = this.g - this.i;
            int i5 = i - i4;
            if (i5 >= 4096 && i5 > this.e.available()) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.f, this.i, bArr, 0, i4);
            this.k += this.g;
            this.i = 0;
            this.g = 0;
            while (i4 < bArr.length) {
                int read = this.e.read(bArr, i4, i - i4);
                if (read == -1) {
                    throw InvalidProtocolBufferException.c();
                }
                this.k += read;
                i4 += read;
            }
            return bArr;
        }

        private List<byte[]> i(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                byte[] bArr = new byte[Math.min(i, 4096)];
                int i2 = 0;
                while (i2 < bArr.length) {
                    int read = this.e.read(bArr, i2, bArr.length - i2);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.c();
                    }
                    this.k += read;
                    i2 += read;
                }
                i -= bArr.length;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void j(int i) throws IOException {
            int i2 = this.g;
            int i3 = this.i;
            if (i <= i2 - i3 && i >= 0) {
                this.i = i3 + i;
                return;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i4 = this.k;
            int i5 = this.i;
            int i6 = i4 + i5 + i;
            int i7 = this.l;
            if (i6 > i7) {
                j((i7 - i4) - i5);
                throw InvalidProtocolBufferException.c();
            }
            this.k = i4 + i5;
            int i8 = this.g - i5;
            this.g = 0;
            this.i = 0;
            while (i8 < i) {
                try {
                    long j = i - i8;
                    long skip = this.e.skip(j);
                    if (skip >= 0 && skip <= j) {
                        if (skip == 0) {
                            break;
                        } else {
                            i8 += (int) skip;
                        }
                    } else {
                        throw new IllegalStateException(this.e.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                } finally {
                    this.k += i8;
                    D();
                }
            }
            if (i8 >= i) {
                return;
            }
            int i9 = this.g;
            int i10 = i9 - this.i;
            this.i = i9;
            while (true) {
                f(1);
                int i11 = i - i10;
                int i12 = this.g;
                if (i11 <= i12) {
                    this.i = i11;
                    return;
                } else {
                    i10 += i12;
                    this.i = i12;
                }
            }
        }
    }
}
