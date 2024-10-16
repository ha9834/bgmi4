package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLite {

    /* renamed from: a, reason: collision with root package name */
    private static final UnknownFieldSetLite f6774a = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static UnknownFieldSetLite a() {
        return f6774a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite b() {
        return new UnknownFieldSetLite();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.b + unknownFieldSetLite2.b;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.c, i);
        System.arraycopy(unknownFieldSetLite2.c, 0, copyOf, unknownFieldSetLite.b, unknownFieldSetLite2.b);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.d, i);
        System.arraycopy(unknownFieldSetLite2.d, 0, copyOf2, unknownFieldSetLite.b, unknownFieldSetLite2.b);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void c() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Writer writer) throws IOException {
        if (writer.a() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.b - 1; i >= 0; i--) {
                writer.c(WireFormat.b(this.c[i]), this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            writer.c(WireFormat.b(this.c[i2]), this.d[i2]);
        }
    }

    public final void b(Writer writer) throws IOException {
        if (this.b == 0) {
            return;
        }
        if (writer.a() == Writer.FieldOrder.ASCENDING) {
            for (int i = 0; i < this.b; i++) {
                a(this.c[i], this.d[i], writer);
            }
            return;
        }
        for (int i2 = this.b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], writer);
        }
    }

    private static void a(int i, Object obj, Writer writer) throws IOException {
        int b = WireFormat.b(i);
        int a2 = WireFormat.a(i);
        if (a2 != 5) {
            switch (a2) {
                case 0:
                    writer.a(b, ((Long) obj).longValue());
                    return;
                case 1:
                    writer.d(b, ((Long) obj).longValue());
                    return;
                case 2:
                    writer.a(b, (ByteString) obj);
                    return;
                case 3:
                    if (writer.a() == Writer.FieldOrder.ASCENDING) {
                        writer.a(b);
                        ((UnknownFieldSetLite) obj).b(writer);
                        writer.b(b);
                        return;
                    } else {
                        writer.b(b);
                        ((UnknownFieldSetLite) obj).b(writer);
                        writer.a(b);
                        return;
                    }
                default:
                    throw new RuntimeException(InvalidProtocolBufferException.h());
            }
        }
        writer.d(b, ((Integer) obj).intValue());
    }

    public final int d() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            i2 += CodedOutputStream.d(WireFormat.b(this.c[i3]), (ByteString) this.d[i3]);
        }
        this.e = i2;
        return i2;
    }

    public final int e() {
        int k;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int i4 = this.c[i3];
            int b = WireFormat.b(i4);
            int a2 = WireFormat.a(i4);
            if (a2 != 5) {
                switch (a2) {
                    case 0:
                        k = CodedOutputStream.g(b, ((Long) this.d[i3]).longValue());
                        break;
                    case 1:
                        k = CodedOutputStream.i(b, ((Long) this.d[i3]).longValue());
                        break;
                    case 2:
                        k = CodedOutputStream.c(b, (ByteString) this.d[i3]);
                        break;
                    case 3:
                        k = (CodedOutputStream.h(b) << 1) + ((UnknownFieldSetLite) this.d[i3]).e();
                        break;
                    default:
                        throw new IllegalStateException(InvalidProtocolBufferException.h());
                }
            } else {
                k = CodedOutputStream.k(b, ((Integer) this.d[i3]).intValue());
            }
            i2 += k;
        }
        this.e = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.b;
        if (i == unknownFieldSetLite.b) {
            int[] iArr = this.c;
            int[] iArr2 = unknownFieldSetLite.c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = unknownFieldSetLite.d;
                int i3 = this.b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.d;
        int i7 = this.b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            aa.a(sb, i, String.valueOf(WireFormat.b(this.c[i2])), this.d[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Object obj) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.b;
        if (i2 == this.c.length) {
            int i3 = this.b + (i2 < 4 ? 8 : i2 >> 1);
            this.c = Arrays.copyOf(this.c, i3);
            this.d = Arrays.copyOf(this.d, i3);
        }
        int[] iArr = this.c;
        int i4 = this.b;
        iArr[i4] = i;
        this.d[i4] = obj;
        this.b = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean a(int i, CodedInputStream codedInputStream) throws IOException {
        int a2;
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        int b = WireFormat.b(i);
        switch (WireFormat.a(i)) {
            case 0:
                a(i, Long.valueOf(codedInputStream.e()));
                return true;
            case 1:
                a(i, Long.valueOf(codedInputStream.g()));
                return true;
            case 2:
                a(i, codedInputStream.l());
                return true;
            case 3:
                UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
                do {
                    a2 = codedInputStream.a();
                    if (a2 != 0) {
                    }
                    codedInputStream.a(WireFormat.a(b, 4));
                    a(i, unknownFieldSetLite);
                    return true;
                } while (unknownFieldSetLite.a(a2, codedInputStream));
                codedInputStream.a(WireFormat.a(b, 4));
                a(i, unknownFieldSetLite);
                return true;
            case 4:
                return false;
            case 5:
                a(i, Integer.valueOf(codedInputStream.h()));
                return true;
            default:
                throw InvalidProtocolBufferException.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final UnknownFieldSetLite a(int i, int i2) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        a(WireFormat.a(i, 0), Long.valueOf(i2));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final UnknownFieldSetLite a(int i, ByteString byteString) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        a(WireFormat.a(i, 2), (Object) byteString);
        return this;
    }
}
