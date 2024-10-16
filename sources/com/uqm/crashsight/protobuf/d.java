package com.uqm.crashsight.protobuf;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.uqm.crashsight.protobuf.InvalidProtocolBufferException;
import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class d implements an {
    @Override // com.uqm.crashsight.protobuf.an
    public final boolean a() {
        return false;
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static d a(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new a(byteBuffer, true);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f6810a;
        private final byte[] b;
        private int c;
        private int d;
        private int e;
        private int f;

        public a(ByteBuffer byteBuffer, boolean z) {
            super((byte) 0);
            this.f6810a = z;
            this.b = byteBuffer.array();
            this.c = byteBuffer.arrayOffset() + byteBuffer.position();
            this.d = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int b() throws IOException {
            if (this.c == this.d) {
                return Integer.MAX_VALUE;
            }
            this.e = v();
            int i = this.e;
            if (i == this.f) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.b(i);
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int c() {
            return this.e;
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final boolean d() throws IOException {
            int i;
            if ((this.c == this.d) || (i = this.e) == this.f) {
                return false;
            }
            int a2 = WireFormat.a(i);
            if (a2 != 5) {
                switch (a2) {
                    case 0:
                        int i2 = this.d;
                        int i3 = this.c;
                        if (i2 - i3 >= 10) {
                            byte[] bArr = this.b;
                            int i4 = i3;
                            int i5 = 0;
                            while (i5 < 10) {
                                int i6 = i4 + 1;
                                if (bArr[i4] >= 0) {
                                    this.c = i6;
                                    return true;
                                }
                                i5++;
                                i4 = i6;
                            }
                        }
                        for (int i7 = 0; i7 < 10; i7++) {
                            int i8 = this.c;
                            if (i8 == this.d) {
                                throw InvalidProtocolBufferException.c();
                            }
                            byte[] bArr2 = this.b;
                            this.c = i8 + 1;
                            if (bArr2[i8] >= 0) {
                                return true;
                            }
                        }
                        throw InvalidProtocolBufferException.e();
                    case 1:
                        int i9 = this.d;
                        int i10 = this.c;
                        if (8 > i9 - i10) {
                            throw InvalidProtocolBufferException.c();
                        }
                        this.c = i10 + 8;
                        return true;
                    case 2:
                        int v = v();
                        if (v >= 0) {
                            int i11 = this.d;
                            int i12 = this.c;
                            if (v <= i11 - i12) {
                                this.c = i12 + v;
                                return true;
                            }
                        }
                        throw InvalidProtocolBufferException.c();
                    case 3:
                        int i13 = this.f;
                        this.f = WireFormat.a(WireFormat.b(this.e), 4);
                        while (b() != Integer.MAX_VALUE && d()) {
                        }
                        if (this.e != this.f) {
                            throw InvalidProtocolBufferException.k();
                        }
                        this.f = i13;
                        return true;
                    default:
                        throw InvalidProtocolBufferException.h();
                }
            }
            int i14 = this.d;
            int i15 = this.c;
            if (4 > i14 - i15) {
                throw InvalidProtocolBufferException.c();
            }
            this.c = i15 + 4;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final double e() throws IOException {
            if (WireFormat.a(this.e) != 1) {
                throw InvalidProtocolBufferException.h();
            }
            if (8 <= this.d - this.c) {
                return Double.longBitsToDouble(z());
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final float f() throws IOException {
            if (WireFormat.a(this.e) != 5) {
                throw InvalidProtocolBufferException.h();
            }
            if (4 <= this.d - this.c) {
                return Float.intBitsToFloat(y());
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final long g() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return w();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final long h() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return w();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int i() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return v();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final long j() throws IOException {
            if (WireFormat.a(this.e) != 1) {
                throw InvalidProtocolBufferException.h();
            }
            if (8 <= this.d - this.c) {
                return z();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int k() throws IOException {
            if (WireFormat.a(this.e) != 5) {
                throw InvalidProtocolBufferException.h();
            }
            if (4 <= this.d - this.c) {
                return y();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final boolean l() throws IOException {
            if (WireFormat.a(this.e) == 0) {
                return v() != 0;
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final String m() throws IOException {
            return a(false);
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final String n() throws IOException {
            return a(true);
        }

        private String a(boolean z) throws IOException {
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            int v = v();
            if (v == 0) {
                return "";
            }
            if (v >= 0) {
                int i = this.d;
                int i2 = this.c;
                if (v <= i - i2) {
                    if (z && !Utf8.a(this.b, i2, i2 + v)) {
                        throw InvalidProtocolBufferException.l();
                    }
                    String str = new String(this.b, this.c, v, Internal.f6726a);
                    this.c += v;
                    return str;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final <T> T a(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            return (T) c(ak.a().a((Class) cls), extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final <T> T a(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            return (T) c(aoVar, extensionRegistryLite);
        }

        private <T> T c(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int v = v();
            if (v >= 0) {
                int i = this.d;
                int i2 = this.c;
                if (v <= i - i2) {
                    int i3 = i2 + v;
                    this.d = i3;
                    try {
                        T a2 = aoVar.a();
                        aoVar.a(a2, this, extensionRegistryLite);
                        aoVar.d(a2);
                        if (this.c == i3) {
                            return a2;
                        }
                        throw InvalidProtocolBufferException.k();
                    } finally {
                        this.d = i;
                    }
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final <T> T b(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.a(this.e) != 3) {
                throw InvalidProtocolBufferException.h();
            }
            return (T) d(ak.a().a((Class) cls), extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final <T> T b(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.a(this.e) != 3) {
                throw InvalidProtocolBufferException.h();
            }
            return (T) d(aoVar, extensionRegistryLite);
        }

        private <T> T d(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = this.f;
            this.f = WireFormat.a(WireFormat.b(this.e), 4);
            try {
                T a2 = aoVar.a();
                aoVar.a(a2, this, extensionRegistryLite);
                aoVar.d(a2);
                if (this.e == this.f) {
                    return a2;
                }
                throw InvalidProtocolBufferException.k();
            } finally {
                this.f = i;
            }
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final ByteString o() throws IOException {
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            int v = v();
            if (v == 0) {
                return ByteString.f6635a;
            }
            if (v >= 0) {
                int i = this.d;
                int i2 = this.c;
                if (v <= i - i2) {
                    ByteString b = this.f6810a ? ByteString.b(this.b, i2, v) : ByteString.a(this.b, i2, v);
                    this.c += v;
                    return b;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int p() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return v();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int q() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return v();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int r() throws IOException {
            if (WireFormat.a(this.e) != 5) {
                throw InvalidProtocolBufferException.h();
            }
            if (4 <= this.d - this.c) {
                return y();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final long s() throws IOException {
            if (WireFormat.a(this.e) != 1) {
                throw InvalidProtocolBufferException.h();
            }
            if (8 <= this.d - this.c) {
                return z();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final int t() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return CodedInputStream.e(v());
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final long u() throws IOException {
            if (WireFormat.a(this.e) != 0) {
                throw InvalidProtocolBufferException.h();
            }
            return CodedInputStream.a(w());
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final void a(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof i) {
                i iVar = (i) list;
                switch (WireFormat.a(this.e)) {
                    case 1:
                        break;
                    case 2:
                        int v = v();
                        if (v >= 0) {
                            int i3 = this.d;
                            int i4 = this.c;
                            if (v <= i3 - i4) {
                                if ((v & 7) != 0) {
                                    throw InvalidProtocolBufferException.k();
                                }
                                int i5 = i4 + v;
                                while (this.c < i5) {
                                    iVar.a(Double.longBitsToDouble(z()));
                                }
                                return;
                            }
                        }
                        throw InvalidProtocolBufferException.c();
                    default:
                        throw InvalidProtocolBufferException.h();
                }
                do {
                    iVar.a(e());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            switch (WireFormat.a(this.e)) {
                case 1:
                    break;
                case 2:
                    int v2 = v();
                    if (v2 >= 0) {
                        int i6 = this.d;
                        int i7 = this.c;
                        if (v2 <= i6 - i7) {
                            if ((v2 & 7) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i8 = i7 + v2;
                            while (this.c < i8) {
                                list.add(Double.valueOf(Double.longBitsToDouble(z())));
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Double.valueOf(e()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void b(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof o) {
                o oVar = (o) list;
                int a2 = WireFormat.a(this.e);
                if (a2 == 2) {
                    int v = v();
                    if (v >= 0) {
                        int i3 = this.d;
                        int i4 = this.c;
                        if (v <= i3 - i4) {
                            if ((v & 3) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i5 = i4 + v;
                            while (this.c < i5) {
                                oVar.a(Float.intBitsToFloat(y()));
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                if (a2 != 5) {
                    throw InvalidProtocolBufferException.h();
                }
                do {
                    oVar.a(f());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            int a3 = WireFormat.a(this.e);
            if (a3 == 2) {
                int v2 = v();
                if (v2 >= 0) {
                    int i6 = this.d;
                    int i7 = this.c;
                    if (v2 <= i6 - i7) {
                        if ((v2 & 3) != 0) {
                            throw InvalidProtocolBufferException.k();
                        }
                        int i8 = i7 + v2;
                        while (this.c < i8) {
                            list.add(Float.valueOf(Float.intBitsToFloat(y())));
                        }
                        return;
                    }
                }
                throw InvalidProtocolBufferException.c();
            }
            if (a3 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Float.valueOf(f()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void c(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof s) {
                s sVar = (s) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (true) {
                            i2 = this.c;
                            if (i2 >= v) {
                                break;
                            } else {
                                sVar.a(w());
                            }
                        }
                        if (i2 != v) {
                            throw InvalidProtocolBufferException.c();
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    sVar.a(w());
                    if (this.c == this.d) {
                        return;
                    }
                    int i3 = this.c;
                    if (v() != this.e) {
                        this.c = i3;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (true) {
                        i = this.c;
                        if (i >= v2) {
                            break;
                        } else {
                            list.add(Long.valueOf(w()));
                        }
                    }
                    if (i != v2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Long.valueOf(w()));
                if (this.c == this.d) {
                    return;
                }
                int i4 = this.c;
                if (v() != this.e) {
                    this.c = i4;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void d(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof s) {
                s sVar = (s) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (true) {
                            i2 = this.c;
                            if (i2 >= v) {
                                break;
                            } else {
                                sVar.a(w());
                            }
                        }
                        if (i2 != v) {
                            throw InvalidProtocolBufferException.c();
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    sVar.a(w());
                    if (this.c == this.d) {
                        return;
                    }
                    int i3 = this.c;
                    if (v() != this.e) {
                        this.c = i3;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (true) {
                        i = this.c;
                        if (i >= v2) {
                            break;
                        } else {
                            list.add(Long.valueOf(w()));
                        }
                    }
                    if (i != v2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Long.valueOf(w()));
                if (this.c == this.d) {
                    return;
                }
                int i4 = this.c;
                if (v() != this.e) {
                    this.c = i4;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void e(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (true) {
                            i2 = this.c;
                            if (i2 >= v) {
                                break;
                            } else {
                                qVar.d(v());
                            }
                        }
                        if (i2 != v) {
                            throw InvalidProtocolBufferException.c();
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    qVar.d(v());
                    if (this.c == this.d) {
                        return;
                    }
                    int i3 = this.c;
                    if (v() != this.e) {
                        this.c = i3;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (true) {
                        i = this.c;
                        if (i >= v2) {
                            break;
                        } else {
                            list.add(Integer.valueOf(v()));
                        }
                    }
                    if (i != v2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Integer.valueOf(v()));
                if (this.c == this.d) {
                    return;
                }
                int i4 = this.c;
                if (v() != this.e) {
                    this.c = i4;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final void f(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof s) {
                s sVar = (s) list;
                switch (WireFormat.a(this.e)) {
                    case 1:
                        break;
                    case 2:
                        int v = v();
                        if (v >= 0) {
                            int i3 = this.d;
                            int i4 = this.c;
                            if (v <= i3 - i4) {
                                if ((v & 7) != 0) {
                                    throw InvalidProtocolBufferException.k();
                                }
                                int i5 = i4 + v;
                                while (this.c < i5) {
                                    sVar.a(z());
                                }
                                return;
                            }
                        }
                        throw InvalidProtocolBufferException.c();
                    default:
                        throw InvalidProtocolBufferException.h();
                }
                do {
                    sVar.a(j());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            switch (WireFormat.a(this.e)) {
                case 1:
                    break;
                case 2:
                    int v2 = v();
                    if (v2 >= 0) {
                        int i6 = this.d;
                        int i7 = this.c;
                        if (v2 <= i6 - i7) {
                            if ((v2 & 7) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i8 = i7 + v2;
                            while (this.c < i8) {
                                list.add(Long.valueOf(z()));
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Long.valueOf(j()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void g(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 == 2) {
                    int v = v();
                    if (v >= 0) {
                        int i3 = this.d;
                        int i4 = this.c;
                        if (v <= i3 - i4) {
                            if ((v & 3) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i5 = i4 + v;
                            while (this.c < i5) {
                                qVar.d(y());
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                if (a2 != 5) {
                    throw InvalidProtocolBufferException.h();
                }
                do {
                    qVar.d(k());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            int a3 = WireFormat.a(this.e);
            if (a3 == 2) {
                int v2 = v();
                if (v2 >= 0) {
                    int i6 = this.d;
                    int i7 = this.c;
                    if (v2 <= i6 - i7) {
                        if ((v2 & 3) != 0) {
                            throw InvalidProtocolBufferException.k();
                        }
                        int i8 = i7 + v2;
                        while (this.c < i8) {
                            list.add(Integer.valueOf(y()));
                        }
                        return;
                    }
                }
                throw InvalidProtocolBufferException.c();
            }
            if (a3 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Integer.valueOf(k()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void h(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof e) {
                e eVar = (e) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (true) {
                            i2 = this.c;
                            if (i2 >= v) {
                                break;
                            } else {
                                eVar.a(v() != 0);
                            }
                        }
                        if (i2 != v) {
                            throw InvalidProtocolBufferException.c();
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    eVar.a(v() != 0);
                    if (this.c == this.d) {
                        return;
                    }
                    int i3 = this.c;
                    if (v() != this.e) {
                        this.c = i3;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (true) {
                        i = this.c;
                        if (i >= v2) {
                            break;
                        } else {
                            list.add(Boolean.valueOf(v() != 0));
                        }
                    }
                    if (i != v2) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Boolean.valueOf(v() != 0));
                if (this.c == this.d) {
                    return;
                }
                int i4 = this.c;
                if (v() != this.e) {
                    this.c = i4;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final void i(List<String> list) throws IOException {
            a(list, false);
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final void j(List<String> list) throws IOException {
            a(list, true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void a(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            if ((list instanceof LazyStringList) && !z) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.a(o());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            do {
                list.add(a(z));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final <T> void a(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            int i2 = this.e;
            do {
                list.add(c(aoVar, extensionRegistryLite));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == i2);
            this.c = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final <T> void b(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.a(this.e) != 3) {
                throw InvalidProtocolBufferException.h();
            }
            int i2 = this.e;
            do {
                list.add(d(aoVar, extensionRegistryLite));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == i2);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void k(List<ByteString> list) throws IOException {
            int i;
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(o());
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void l(List<Integer> list) throws IOException {
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (this.c < v) {
                            qVar.d(v());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    qVar.d(v());
                    if (this.c == this.d) {
                        return;
                    }
                    int i = this.c;
                    if (v() != this.e) {
                        this.c = i;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (this.c < v2) {
                        list.add(Integer.valueOf(v()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Integer.valueOf(v()));
                if (this.c == this.d) {
                    return;
                }
                int i2 = this.c;
                if (v() != this.e) {
                    this.c = i2;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void m(List<Integer> list) throws IOException {
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (this.c < v) {
                            qVar.d(v());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    qVar.d(v());
                    if (this.c == this.d) {
                        return;
                    }
                    int i = this.c;
                    if (v() != this.e) {
                        this.c = i;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (this.c < v2) {
                        list.add(Integer.valueOf(v()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Integer.valueOf(v()));
                if (this.c == this.d) {
                    return;
                }
                int i2 = this.c;
                if (v() != this.e) {
                    this.c = i2;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void n(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 == 2) {
                    int v = v();
                    if (v >= 0) {
                        int i3 = this.d;
                        int i4 = this.c;
                        if (v <= i3 - i4) {
                            if ((v & 3) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i5 = i4 + v;
                            while (this.c < i5) {
                                qVar.d(y());
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                if (a2 != 5) {
                    throw InvalidProtocolBufferException.h();
                }
                do {
                    qVar.d(r());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            int a3 = WireFormat.a(this.e);
            if (a3 == 2) {
                int v2 = v();
                if (v2 >= 0) {
                    int i6 = this.d;
                    int i7 = this.c;
                    if (v2 <= i6 - i7) {
                        if ((v2 & 3) != 0) {
                            throw InvalidProtocolBufferException.k();
                        }
                        int i8 = i7 + v2;
                        while (this.c < i8) {
                            list.add(Integer.valueOf(y()));
                        }
                        return;
                    }
                }
                throw InvalidProtocolBufferException.c();
            }
            if (a3 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Integer.valueOf(r()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        @Override // com.uqm.crashsight.protobuf.an
        public final void o(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof s) {
                s sVar = (s) list;
                switch (WireFormat.a(this.e)) {
                    case 1:
                        break;
                    case 2:
                        int v = v();
                        if (v >= 0) {
                            int i3 = this.d;
                            int i4 = this.c;
                            if (v <= i3 - i4) {
                                if ((v & 7) != 0) {
                                    throw InvalidProtocolBufferException.k();
                                }
                                int i5 = i4 + v;
                                while (this.c < i5) {
                                    sVar.a(z());
                                }
                                return;
                            }
                        }
                        throw InvalidProtocolBufferException.c();
                    default:
                        throw InvalidProtocolBufferException.h();
                }
                do {
                    sVar.a(s());
                    if (this.c == this.d) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (v() == this.e);
                this.c = i2;
                return;
            }
            switch (WireFormat.a(this.e)) {
                case 1:
                    break;
                case 2:
                    int v2 = v();
                    if (v2 >= 0) {
                        int i6 = this.d;
                        int i7 = this.c;
                        if (v2 <= i6 - i7) {
                            if ((v2 & 7) != 0) {
                                throw InvalidProtocolBufferException.k();
                            }
                            int i8 = i7 + v2;
                            while (this.c < i8) {
                                list.add(Long.valueOf(z()));
                            }
                            return;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                list.add(Long.valueOf(s()));
                if (this.c == this.d) {
                    return;
                } else {
                    i = this.c;
                }
            } while (v() == this.e);
            this.c = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void p(List<Integer> list) throws IOException {
            if (list instanceof q) {
                q qVar = (q) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (this.c < v) {
                            qVar.d(CodedInputStream.e(v()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    qVar.d(CodedInputStream.e(v()));
                    if (this.c == this.d) {
                        return;
                    }
                    int i = this.c;
                    if (v() != this.e) {
                        this.c = i;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (this.c < v2) {
                        list.add(Integer.valueOf(CodedInputStream.e(v())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Integer.valueOf(CodedInputStream.e(v())));
                if (this.c == this.d) {
                    return;
                }
                int i2 = this.c;
                if (v() != this.e) {
                    this.c = i2;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final void q(List<Long> list) throws IOException {
            if (list instanceof s) {
                s sVar = (s) list;
                int a2 = WireFormat.a(this.e);
                if (a2 != 0) {
                    if (a2 == 2) {
                        int v = this.c + v();
                        while (this.c < v) {
                            sVar.a(CodedInputStream.a(w()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.h();
                }
                while (WireFormat.a(this.e) == 0) {
                    sVar.a(CodedInputStream.a(w()));
                    if (this.c == this.d) {
                        return;
                    }
                    int i = this.c;
                    if (v() != this.e) {
                        this.c = i;
                        return;
                    }
                }
                throw InvalidProtocolBufferException.h();
            }
            int a3 = WireFormat.a(this.e);
            if (a3 != 0) {
                if (a3 == 2) {
                    int v2 = this.c + v();
                    while (this.c < v2) {
                        list.add(Long.valueOf(CodedInputStream.a(w())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            while (WireFormat.a(this.e) == 0) {
                list.add(Long.valueOf(CodedInputStream.a(w())));
                if (this.c == this.d) {
                    return;
                }
                int i2 = this.c;
                if (v() != this.e) {
                    this.c = i2;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0027. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.an
        public final <K, V> void a(Map<K, V> map, MapEntryLite.a<K, V> aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.a(this.e) != 2) {
                throw InvalidProtocolBufferException.h();
            }
            int v = v();
            if (v >= 0) {
                int i = this.d;
                int i2 = this.c;
                if (v <= i - i2) {
                    this.d = i2 + v;
                    try {
                        Object obj = aVar.d;
                        Object obj2 = aVar.f;
                        while (true) {
                            int b = b();
                            if (b != Integer.MAX_VALUE) {
                                switch (b) {
                                    case 1:
                                        obj = a(aVar.c, (Class<?>) null, (ExtensionRegistryLite) null);
                                    case 2:
                                        obj2 = a(aVar.e, aVar.f.getClass(), extensionRegistryLite);
                                    default:
                                        try {
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                            if (!d()) {
                                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                            }
                                        }
                                        if (!d()) {
                                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                            break;
                                        }
                                }
                            } else {
                                map.put(obj, obj2);
                                return;
                            }
                        }
                    } finally {
                        this.d = i;
                    }
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        private Object a(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.f6809a[fieldType.ordinal()]) {
                case 1:
                    if (WireFormat.a(this.e) == 0) {
                        return Boolean.valueOf(v() != 0);
                    }
                    throw InvalidProtocolBufferException.h();
                case 2:
                    return o();
                case 3:
                    return Double.valueOf(e());
                case 4:
                    if (WireFormat.a(this.e) == 0) {
                        return Integer.valueOf(v());
                    }
                    throw InvalidProtocolBufferException.h();
                case 5:
                    return Integer.valueOf(k());
                case 6:
                    return Long.valueOf(j());
                case 7:
                    return Float.valueOf(f());
                case 8:
                    if (WireFormat.a(this.e) == 0) {
                        return Integer.valueOf(v());
                    }
                    throw InvalidProtocolBufferException.h();
                case 9:
                    if (WireFormat.a(this.e) == 0) {
                        return Long.valueOf(w());
                    }
                    throw InvalidProtocolBufferException.h();
                case 10:
                    return a(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(r());
                case 12:
                    return Long.valueOf(s());
                case 13:
                    if (WireFormat.a(this.e) == 0) {
                        return Integer.valueOf(CodedInputStream.e(v()));
                    }
                    throw InvalidProtocolBufferException.h();
                case 14:
                    if (WireFormat.a(this.e) == 0) {
                        return Long.valueOf(CodedInputStream.a(w()));
                    }
                    throw InvalidProtocolBufferException.h();
                case 15:
                    return a(true);
                case 16:
                    if (WireFormat.a(this.e) == 0) {
                        return Integer.valueOf(v());
                    }
                    throw InvalidProtocolBufferException.h();
                case 17:
                    if (WireFormat.a(this.e) == 0) {
                        return Long.valueOf(w());
                    }
                    throw InvalidProtocolBufferException.h();
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int v() throws IOException {
            int i;
            int i2 = this.c;
            int i3 = this.d;
            if (i3 == i2) {
                throw InvalidProtocolBufferException.c();
            }
            byte[] bArr = this.b;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.c = i4;
                return b;
            }
            if (i3 - i4 < 9) {
                return (int) x();
            }
            int i5 = i4 + 1;
            int i6 = b ^ (bArr[i4] << 7);
            if (i6 < 0) {
                i = i6 ^ (-128);
            } else {
                int i7 = i5 + 1;
                int i8 = i6 ^ (bArr[i5] << 14);
                if (i8 >= 0) {
                    i = i8 ^ 16256;
                    i5 = i7;
                } else {
                    i5 = i7 + 1;
                    int i9 = i8 ^ (bArr[i7] << 21);
                    if (i9 < 0) {
                        i = i9 ^ (-2080896);
                    } else {
                        int i10 = i5 + 1;
                        byte b2 = bArr[i5];
                        i = (i9 ^ (b2 << 28)) ^ 266354560;
                        if (b2 < 0) {
                            i5 = i10 + 1;
                            if (bArr[i10] < 0) {
                                i10 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i10 + 1;
                                    if (bArr[i10] < 0) {
                                        i10 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i10 + 1;
                                            if (bArr[i10] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i5 = i10;
                    }
                }
            }
            this.c = i5;
            return i;
        }

        private long w() throws IOException {
            long j;
            int i = this.c;
            int i2 = this.d;
            if (i2 == i) {
                throw InvalidProtocolBufferException.c();
            }
            byte[] bArr = this.b;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.c = i3;
                return b;
            }
            if (i2 - i3 < 9) {
                return x();
            }
            int i4 = i3 + 1;
            int i5 = b ^ (bArr[i3] << 7);
            if (i5 < 0) {
                j = i5 ^ (-128);
            } else {
                int i6 = i4 + 1;
                int i7 = i5 ^ (bArr[i4] << 14);
                if (i7 >= 0) {
                    i4 = i6;
                    j = i7 ^ 16256;
                } else {
                    i4 = i6 + 1;
                    int i8 = i7 ^ (bArr[i6] << 21);
                    if (i8 < 0) {
                        j = i8 ^ (-2080896);
                    } else {
                        long j2 = i8;
                        int i9 = i4 + 1;
                        long j3 = j2 ^ (bArr[i4] << 28);
                        if (j3 >= 0) {
                            j = 266354560 ^ j3;
                            i4 = i9;
                        } else {
                            i4 = i9 + 1;
                            long j4 = j3 ^ (bArr[i9] << 35);
                            if (j4 < 0) {
                                j = j4 ^ (-34093383808L);
                            } else {
                                int i10 = i4 + 1;
                                long j5 = j4 ^ (bArr[i4] << 42);
                                if (j5 >= 0) {
                                    j = 4363953127296L ^ j5;
                                    i4 = i10;
                                } else {
                                    i4 = i10 + 1;
                                    long j6 = j5 ^ (bArr[i10] << 49);
                                    if (j6 < 0) {
                                        j = j6 ^ (-558586000294016L);
                                    } else {
                                        int i11 = i4 + 1;
                                        j = (j6 ^ (bArr[i4] << 56)) ^ 71499008037633920L;
                                        if (j < 0) {
                                            i4 = i11 + 1;
                                            if (bArr[i11] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                        } else {
                                            i4 = i11;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.c = i4;
            return j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long x() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                int i2 = this.c;
                if (i2 == this.d) {
                    throw InvalidProtocolBufferException.c();
                }
                byte[] bArr = this.b;
                this.c = i2 + 1;
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((bArr[i2] & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private int y() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 4;
            return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        }

        private long z() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.protobuf.d$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6809a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6809a[WireFormat.FieldType.h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6809a[WireFormat.FieldType.l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6809a[WireFormat.FieldType.f6781a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6809a[WireFormat.FieldType.n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6809a[WireFormat.FieldType.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6809a[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6809a[WireFormat.FieldType.b.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6809a[WireFormat.FieldType.e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6809a[WireFormat.FieldType.c.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6809a[WireFormat.FieldType.k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6809a[WireFormat.FieldType.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6809a[WireFormat.FieldType.p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6809a[WireFormat.FieldType.q.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6809a[WireFormat.FieldType.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6809a[WireFormat.FieldType.i.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6809a[WireFormat.FieldType.m.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6809a[WireFormat.FieldType.d.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }
}
