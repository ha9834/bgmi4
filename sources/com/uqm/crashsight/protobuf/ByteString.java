package com.uqm.crashsight.protobuf;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class ByteString implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f6635a = new LiteralByteString(Internal.c);
    private static final c b;
    private int c = 0;

    /* loaded from: classes3.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes3.dex */
    interface c {
        byte[] a(byte[] bArr, int i, int i2);
    }

    static /* synthetic */ int a(byte b2) {
        return b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public abstract byte a(int i);

    protected abstract int a(int i, int i2, int i3);

    public abstract ByteString a(int i, int i2);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ByteOutput byteOutput) throws IOException;

    abstract byte b(int i);

    public abstract int b();

    protected abstract int b(int i, int i2, int i3);

    abstract void b(ByteOutput byteOutput) throws IOException;

    protected abstract void b(byte[] bArr, int i, int i2, int i3);

    public abstract ByteBuffer e();

    public abstract boolean equals(Object obj);

    public abstract boolean g();

    public abstract CodedInputStream h();

    protected abstract int i();

    static {
        byte b2 = 0;
        b = com.uqm.crashsight.protobuf.b.a() ? new e(b2) : new b(b2);
        new Comparator<ByteString>() { // from class: com.uqm.crashsight.protobuf.ByteString.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(ByteString byteString, ByteString byteString2) {
                ByteString byteString3 = byteString;
                ByteString byteString4 = byteString2;
                ByteIterator it = byteString3.iterator();
                ByteIterator it2 = byteString4.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compare = Integer.compare(ByteString.a(it.a()), ByteString.a(it2.a()));
                    if (compare != 0) {
                        return compare;
                    }
                }
                return Integer.compare(byteString3.b(), byteString4.b());
            }
        };
    }

    /* loaded from: classes3.dex */
    static final class e implements c {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.c
        public final byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.c
        public final byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    ByteString() {
    }

    @Override // java.lang.Iterable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteIterator iterator() {
        return new a() { // from class: com.uqm.crashsight.protobuf.ByteString.1

            /* renamed from: a, reason: collision with root package name */
            private int f6636a = 0;
            private final int b;

            {
                this.b = ByteString.this.b();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6636a < this.b;
            }

            @Override // com.uqm.crashsight.protobuf.ByteString.ByteIterator
            public final byte a() {
                int i = this.f6636a;
                if (i >= this.b) {
                    throw new NoSuchElementException();
                }
                this.f6636a = i + 1;
                return ByteString.this.b(i);
            }
        };
    }

    /* loaded from: classes3.dex */
    static abstract class a implements ByteIterator {
        a() {
        }

        @Override // java.util.Iterator
        public /* synthetic */ Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean c() {
        return b() == 0;
    }

    public static ByteString a(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new LiteralByteString(b.a(bArr, i, i2));
    }

    public static ByteString a(byte[] bArr) {
        int length = bArr.length;
        c(0, length + 0, bArr.length);
        return new LiteralByteString(b.a(bArr, 0, length));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString b(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString b(byte[] bArr, int i, int i2) {
        return new BoundedByteString(bArr, i, i2);
    }

    public static ByteString a(String str) {
        return new LiteralByteString(str.getBytes(Internal.f6726a));
    }

    @Deprecated
    public final void a(byte[] bArr, int i, int i2, int i3) {
        c(i, i + i3, b());
        c(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            b(bArr, i, i2, i3);
        }
    }

    public final byte[] d() {
        int b2 = b();
        if (b2 == 0) {
            return Internal.c;
        }
        byte[] bArr = new byte[b2];
        b(bArr, 0, 0, b2);
        return bArr;
    }

    public final String f() {
        return b() == 0 ? "" : a(Internal.f6726a);
    }

    /* loaded from: classes3.dex */
    static abstract class LeafByteString extends ByteString {
        abstract boolean a(ByteString byteString, int i, int i2);

        @Override // com.uqm.crashsight.protobuf.ByteString
        protected final int i() {
            return 0;
        }

        LeafByteString() {
        }

        @Override // com.uqm.crashsight.protobuf.ByteString, java.lang.Iterable
        public /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        final void b(ByteOutput byteOutput) throws IOException {
            a(byteOutput);
        }
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int b2 = b();
            i = b(b2, 0, b2);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    /* loaded from: classes3.dex */
    public static final class Output extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final int f6637a;
        private final ArrayList<ByteString> b;
        private int c;
        private byte[] d;
        private int e;

        @Override // java.io.OutputStream
        public final synchronized void write(int i) {
            if (this.e == this.d.length) {
                a(1);
            }
            byte[] bArr = this.d;
            int i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public final synchronized void write(byte[] bArr, int i, int i2) {
            if (i2 <= this.d.length - this.e) {
                System.arraycopy(bArr, i, this.d, this.e, i2);
                this.e += i2;
                return;
            }
            int length = this.d.length - this.e;
            System.arraycopy(bArr, i, this.d, this.e, length);
            int i3 = i2 - length;
            a(i3);
            System.arraycopy(bArr, i + length, this.d, 0, i3);
            this.e = i3;
        }

        private synchronized int a() {
            return this.c + this.e;
        }

        public final String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a()));
        }

        private void a(int i) {
            this.b.add(new LiteralByteString(this.d));
            this.c += this.d.length;
            this.d = new byte[Math.max(this.f6637a, Math.max(i, this.c >>> 1))];
            this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d c(int i) {
        return new d(i, (byte) 0);
    }

    /* loaded from: classes3.dex */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f6638a;
        private final byte[] b;

        /* synthetic */ d(int i, byte b) {
            this(i);
        }

        private d(int i) {
            this.b = new byte[i];
            this.f6638a = CodedOutputStream.a(this.b);
        }

        public final ByteString a() {
            this.f6638a.k();
            return new LiteralByteString(this.b);
        }

        public final CodedOutputStream b() {
            return this.f6638a;
        }
    }

    protected final int j() {
        return this.c;
    }

    static void b(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    static int c(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(b());
        if (b() <= 50) {
            str = as.a(this);
        } else {
            str = as.a(a(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LiteralByteString extends LeafByteString {
        protected final byte[] b;

        protected int k() {
            return 0;
        }

        LiteralByteString(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.b = bArr;
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public byte a(int i) {
            return this.b[i];
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        byte b(int i) {
            return this.b[i];
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public int b() {
            return this.b.length;
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public final ByteString a(int i, int i2) {
            int c = c(i, i2, b());
            if (c == 0) {
                return ByteString.f6635a;
            }
            return new BoundedByteString(this.b, k() + i, c);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        protected void b(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.b, i, bArr, i2, i3);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public final ByteBuffer e() {
            return ByteBuffer.wrap(this.b, k(), b()).asReadOnlyBuffer();
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        final void a(ByteOutput byteOutput) throws IOException {
            byteOutput.b(this.b, k(), b());
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        protected final String a(Charset charset) {
            return new String(this.b, k(), b(), charset);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public final boolean g() {
            int k = k();
            return Utf8.a(this.b, k, b() + k);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        protected final int a(int i, int i2, int i3) {
            int k = k() + i2;
            return Utf8.a(i, this.b, k, i3 + k);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || b() != ((ByteString) obj).b()) {
                return false;
            }
            if (b() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int j = j();
                int j2 = literalByteString.j();
                if (j == 0 || j2 == 0 || j == j2) {
                    return a(literalByteString, 0, b());
                }
                return false;
            }
            return obj.equals(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.ByteString.LeafByteString
        final boolean a(ByteString byteString, int i, int i2) {
            if (i2 > byteString.b()) {
                throw new IllegalArgumentException("Length too large: " + i2 + b());
            }
            int i3 = i + i2;
            if (i3 > byteString.b()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + byteString.b());
            }
            if (byteString instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) byteString;
                byte[] bArr = this.b;
                byte[] bArr2 = literalByteString.b;
                int k = k() + i2;
                int k2 = k();
                int k3 = literalByteString.k() + i;
                while (k2 < k) {
                    if (bArr[k2] != bArr2[k3]) {
                        return false;
                    }
                    k2++;
                    k3++;
                }
                return true;
            }
            return byteString.a(i, i3).equals(a(0, i2));
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        protected final int b(int i, int i2, int i3) {
            return Internal.a(i, this.b, k() + i2, i3);
        }

        @Override // com.uqm.crashsight.protobuf.ByteString
        public final CodedInputStream h() {
            return CodedInputStream.a(this.b, k(), b(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private final int c;
        private final int d;

        BoundedByteString(byte[] bArr, int i, int i2) {
            super(bArr);
            c(i, i + i2, bArr.length);
            this.c = i;
            this.d = i2;
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.LiteralByteString, com.uqm.crashsight.protobuf.ByteString
        public final byte a(int i) {
            b(i, this.d);
            return this.b[this.c + i];
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.LiteralByteString, com.uqm.crashsight.protobuf.ByteString
        final byte b(int i) {
            return this.b[this.c + i];
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.LiteralByteString, com.uqm.crashsight.protobuf.ByteString
        public final int b() {
            return this.d;
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.LiteralByteString
        protected final int k() {
            return this.c;
        }

        @Override // com.uqm.crashsight.protobuf.ByteString.LiteralByteString, com.uqm.crashsight.protobuf.ByteString
        protected final void b(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.b, this.c + i, bArr, i2, i3);
        }
    }
}
