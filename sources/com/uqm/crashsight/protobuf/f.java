package com.uqm.crashsight.protobuf;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.uqm.crashsight.protobuf.InvalidProtocolBufferException;
import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements an {

    /* renamed from: a, reason: collision with root package name */
    private final CodedInputStream f6812a;
    private int b;
    private int c;
    private int d = 0;

    public static f a(CodedInputStream codedInputStream) {
        if (codedInputStream.d != null) {
            return codedInputStream.d;
        }
        return new f(codedInputStream);
    }

    private f(CodedInputStream codedInputStream) {
        this.f6812a = (CodedInputStream) Internal.a(codedInputStream, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.f6812a.d = this;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final boolean a() {
        return this.f6812a.v();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int b() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f6812a.a();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.b(i2);
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int c() {
        return this.b;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final boolean d() throws IOException {
        int i;
        if (this.f6812a.x() || (i = this.b) == this.c) {
            return false;
        }
        return this.f6812a.b(i);
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final double e() throws IOException {
        if (WireFormat.a(this.b) != 1) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.b();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final float f() throws IOException {
        if (WireFormat.a(this.b) != 5) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.c();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final long g() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.d();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final long h() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.e();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int i() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.f();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final long j() throws IOException {
        if (WireFormat.a(this.b) != 1) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.g();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int k() throws IOException {
        if (WireFormat.a(this.b) != 5) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.h();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final boolean l() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.i();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final String m() throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.j();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final String n() throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.k();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final <T> T a(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        return (T) c(ak.a().a((Class) cls), extensionRegistryLite);
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final <T> T a(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        return (T) c(aoVar, extensionRegistryLite);
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final <T> T b(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.a(this.b) != 3) {
            throw InvalidProtocolBufferException.h();
        }
        return (T) d(ak.a().a((Class) cls), extensionRegistryLite);
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final <T> T b(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.a(this.b) != 3) {
            throw InvalidProtocolBufferException.h();
        }
        return (T) d(aoVar, extensionRegistryLite);
    }

    private <T> T c(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int m = this.f6812a.m();
        if (this.f6812a.f6639a >= this.f6812a.b) {
            throw InvalidProtocolBufferException.i();
        }
        int c = this.f6812a.c(m);
        T a2 = aoVar.a();
        this.f6812a.f6639a++;
        aoVar.a(a2, this, extensionRegistryLite);
        aoVar.d(a2);
        this.f6812a.a(0);
        CodedInputStream codedInputStream = this.f6812a;
        codedInputStream.f6639a--;
        this.f6812a.d(c);
        return a2;
    }

    private <T> T d(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i = this.c;
        this.c = WireFormat.a(WireFormat.b(this.b), 4);
        try {
            T a2 = aoVar.a();
            aoVar.a(a2, this, extensionRegistryLite);
            aoVar.d(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw InvalidProtocolBufferException.k();
        } finally {
            this.c = i;
        }
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final ByteString o() throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.l();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int p() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.m();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int q() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.n();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int r() throws IOException {
        if (WireFormat.a(this.b) != 5) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.o();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final long s() throws IOException {
        if (WireFormat.a(this.b) != 1) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.p();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final int t() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.q();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final long u() throws IOException {
        if (WireFormat.a(this.b) != 0) {
            throw InvalidProtocolBufferException.h();
        }
        return this.f6812a.r();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void a(List<Double> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof i) {
            i iVar = (i) list;
            switch (WireFormat.a(this.b)) {
                case 1:
                    break;
                case 2:
                    int m = this.f6812a.m();
                    if ((m & 7) != 0) {
                        throw InvalidProtocolBufferException.k();
                    }
                    int y = this.f6812a.y() + m;
                    do {
                        iVar.a(this.f6812a.b());
                    } while (this.f6812a.y() < y);
                    return;
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                iVar.a(this.f6812a.b());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        switch (WireFormat.a(this.b)) {
            case 1:
                break;
            case 2:
                int m2 = this.f6812a.m();
                if ((m2 & 7) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y2 = this.f6812a.y() + m2;
                do {
                    list.add(Double.valueOf(this.f6812a.b()));
                } while (this.f6812a.y() < y2);
                return;
            default:
                throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Double.valueOf(this.f6812a.b()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final void b(List<Float> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof o) {
            o oVar = (o) list;
            int a4 = WireFormat.a(this.b);
            if (a4 == 2) {
                int m = this.f6812a.m();
                if ((m & 3) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y = this.f6812a.y() + m;
                do {
                    oVar.a(this.f6812a.c());
                } while (this.f6812a.y() < y);
                return;
            }
            if (a4 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                oVar.a(this.f6812a.c());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 == 2) {
            int m2 = this.f6812a.m();
            if ((m2 & 3) != 0) {
                throw InvalidProtocolBufferException.k();
            }
            int y2 = this.f6812a.y() + m2;
            do {
                list.add(Float.valueOf(this.f6812a.c()));
            } while (this.f6812a.y() < y2);
            return;
        }
        if (a5 != 5) {
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Float.valueOf(this.f6812a.c()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void c(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof s) {
            s sVar = (s) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        sVar.a(this.f6812a.d());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                sVar.a(this.f6812a.d());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Long.valueOf(this.f6812a.d()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Long.valueOf(this.f6812a.d()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void d(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof s) {
            s sVar = (s) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        sVar.a(this.f6812a.e());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                sVar.a(this.f6812a.e());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Long.valueOf(this.f6812a.e()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Long.valueOf(this.f6812a.e()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void e(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        qVar.d(this.f6812a.f());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.f());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Integer.valueOf(this.f6812a.f()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.f()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void f(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof s) {
            s sVar = (s) list;
            switch (WireFormat.a(this.b)) {
                case 1:
                    break;
                case 2:
                    int m = this.f6812a.m();
                    if ((m & 7) != 0) {
                        throw InvalidProtocolBufferException.k();
                    }
                    int y = this.f6812a.y() + m;
                    do {
                        sVar.a(this.f6812a.g());
                    } while (this.f6812a.y() < y);
                    return;
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                sVar.a(this.f6812a.g());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        switch (WireFormat.a(this.b)) {
            case 1:
                break;
            case 2:
                int m2 = this.f6812a.m();
                if ((m2 & 7) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y2 = this.f6812a.y() + m2;
                do {
                    list.add(Long.valueOf(this.f6812a.g()));
                } while (this.f6812a.y() < y2);
                return;
            default:
                throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Long.valueOf(this.f6812a.g()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final void g(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 == 2) {
                int m = this.f6812a.m();
                if ((m & 3) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y = this.f6812a.y() + m;
                do {
                    qVar.d(this.f6812a.h());
                } while (this.f6812a.y() < y);
                return;
            }
            if (a4 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.h());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 == 2) {
            int m2 = this.f6812a.m();
            if ((m2 & 3) != 0) {
                throw InvalidProtocolBufferException.k();
            }
            int y2 = this.f6812a.y() + m2;
            do {
                list.add(Integer.valueOf(this.f6812a.h()));
            } while (this.f6812a.y() < y2);
            return;
        }
        if (a5 != 5) {
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.h()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void h(List<Boolean> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof e) {
            e eVar = (e) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        eVar.a(this.f6812a.i());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                eVar.a(this.f6812a.i());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Boolean.valueOf(this.f6812a.i()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Boolean.valueOf(this.f6812a.i()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
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
        String j;
        int a2;
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        if ((list instanceof LazyStringList) && !z) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (WireFormat.a(this.b) == 2) {
                lazyStringList.a(this.f6812a.l());
                if (this.f6812a.x()) {
                    return;
                }
                int a3 = this.f6812a.a();
                if (a3 != this.b) {
                    this.d = a3;
                    return;
                }
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            if (z) {
                if (WireFormat.a(this.b) != 2) {
                    throw InvalidProtocolBufferException.h();
                }
                j = this.f6812a.k();
            } else {
                if (WireFormat.a(this.b) != 2) {
                    throw InvalidProtocolBufferException.h();
                }
                j = this.f6812a.j();
            }
            list.add(j);
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final <T> void a(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int a2;
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        int i = this.b;
        do {
            list.add(c(aoVar, extensionRegistryLite));
            if (this.f6812a.x() || this.d != 0) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == i);
        this.d = a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final <T> void b(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int a2;
        if (WireFormat.a(this.b) != 3) {
            throw InvalidProtocolBufferException.h();
        }
        int i = this.b;
        do {
            list.add(d(aoVar, extensionRegistryLite));
            if (this.f6812a.x() || this.d != 0) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == i);
        this.d = a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final void k(List<ByteString> list) throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        while (WireFormat.a(this.b) == 2) {
            list.add(this.f6812a.l());
            if (this.f6812a.x()) {
                return;
            }
            int a2 = this.f6812a.a();
            if (a2 != this.b) {
                this.d = a2;
                return;
            }
        }
        throw InvalidProtocolBufferException.h();
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void l(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        qVar.d(this.f6812a.m());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.m());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Integer.valueOf(this.f6812a.m()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.m()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void m(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        qVar.d(this.f6812a.n());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.n());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Integer.valueOf(this.f6812a.n()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.n()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final void n(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 == 2) {
                int m = this.f6812a.m();
                if ((m & 3) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y = this.f6812a.y() + m;
                do {
                    qVar.d(this.f6812a.o());
                } while (this.f6812a.y() < y);
                return;
            }
            if (a4 != 5) {
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.o());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 == 2) {
            int m2 = this.f6812a.m();
            if ((m2 & 3) != 0) {
                throw InvalidProtocolBufferException.k();
            }
            int y2 = this.f6812a.y() + m2;
            do {
                list.add(Integer.valueOf(this.f6812a.o()));
            } while (this.f6812a.y() < y2);
            return;
        }
        if (a5 != 5) {
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.o()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void o(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof s) {
            s sVar = (s) list;
            switch (WireFormat.a(this.b)) {
                case 1:
                    break;
                case 2:
                    int m = this.f6812a.m();
                    if ((m & 7) != 0) {
                        throw InvalidProtocolBufferException.k();
                    }
                    int y = this.f6812a.y() + m;
                    do {
                        sVar.a(this.f6812a.p());
                    } while (this.f6812a.y() < y);
                    return;
                default:
                    throw InvalidProtocolBufferException.h();
            }
            do {
                sVar.a(this.f6812a.p());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        switch (WireFormat.a(this.b)) {
            case 1:
                break;
            case 2:
                int m2 = this.f6812a.m();
                if ((m2 & 7) != 0) {
                    throw InvalidProtocolBufferException.k();
                }
                int y2 = this.f6812a.y() + m2;
                do {
                    list.add(Long.valueOf(this.f6812a.p()));
                } while (this.f6812a.y() < y2);
                return;
            default:
                throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Long.valueOf(this.f6812a.p()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void p(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof q) {
            q qVar = (q) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        qVar.d(this.f6812a.q());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                qVar.d(this.f6812a.q());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Integer.valueOf(this.f6812a.q()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Integer.valueOf(this.f6812a.q()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    @Override // com.uqm.crashsight.protobuf.an
    public final void q(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof s) {
            s sVar = (s) list;
            int a4 = WireFormat.a(this.b);
            if (a4 != 0) {
                if (a4 == 2) {
                    int y = this.f6812a.y() + this.f6812a.m();
                    do {
                        sVar.a(this.f6812a.r());
                    } while (this.f6812a.y() < y);
                    if (this.f6812a.y() != y) {
                        throw InvalidProtocolBufferException.c();
                    }
                    return;
                }
                throw InvalidProtocolBufferException.h();
            }
            do {
                sVar.a(this.f6812a.r());
                if (this.f6812a.x()) {
                    return;
                } else {
                    a3 = this.f6812a.a();
                }
            } while (a3 == this.b);
            this.d = a3;
            return;
        }
        int a5 = WireFormat.a(this.b);
        if (a5 != 0) {
            if (a5 == 2) {
                int y2 = this.f6812a.y() + this.f6812a.m();
                do {
                    list.add(Long.valueOf(this.f6812a.r()));
                } while (this.f6812a.y() < y2);
                if (this.f6812a.y() != y2) {
                    throw InvalidProtocolBufferException.c();
                }
                return;
            }
            throw InvalidProtocolBufferException.h();
        }
        do {
            list.add(Long.valueOf(this.f6812a.r()));
            if (this.f6812a.x()) {
                return;
            } else {
                a2 = this.f6812a.a();
            }
        } while (a2 == this.b);
        this.d = a2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.an
    public final <K, V> void a(Map<K, V> map, MapEntryLite.a<K, V> aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.a(this.b) != 2) {
            throw InvalidProtocolBufferException.h();
        }
        int c = this.f6812a.c(this.f6812a.m());
        Object obj = aVar.d;
        Object obj2 = aVar.f;
        while (true) {
            try {
                int b = b();
                if (b != Integer.MAX_VALUE && !this.f6812a.x()) {
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
                }
            } finally {
                this.f6812a.d(c);
            }
        }
        map.put(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.protobuf.f$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6813a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6813a[WireFormat.FieldType.h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6813a[WireFormat.FieldType.l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6813a[WireFormat.FieldType.f6781a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6813a[WireFormat.FieldType.n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6813a[WireFormat.FieldType.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6813a[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6813a[WireFormat.FieldType.b.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6813a[WireFormat.FieldType.e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6813a[WireFormat.FieldType.c.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6813a[WireFormat.FieldType.k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6813a[WireFormat.FieldType.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6813a[WireFormat.FieldType.p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6813a[WireFormat.FieldType.q.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6813a[WireFormat.FieldType.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6813a[WireFormat.FieldType.i.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6813a[WireFormat.FieldType.m.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6813a[WireFormat.FieldType.d.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private Object a(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        switch (AnonymousClass1.f6813a[fieldType.ordinal()]) {
            case 1:
                if (WireFormat.a(this.b) == 0) {
                    return Boolean.valueOf(this.f6812a.i());
                }
                throw InvalidProtocolBufferException.h();
            case 2:
                if (WireFormat.a(this.b) == 2) {
                    return this.f6812a.l();
                }
                throw InvalidProtocolBufferException.h();
            case 3:
                if (WireFormat.a(this.b) == 1) {
                    return Double.valueOf(this.f6812a.b());
                }
                throw InvalidProtocolBufferException.h();
            case 4:
                if (WireFormat.a(this.b) == 0) {
                    return Integer.valueOf(this.f6812a.n());
                }
                throw InvalidProtocolBufferException.h();
            case 5:
                if (WireFormat.a(this.b) == 5) {
                    return Integer.valueOf(this.f6812a.h());
                }
                throw InvalidProtocolBufferException.h();
            case 6:
                if (WireFormat.a(this.b) == 1) {
                    return Long.valueOf(this.f6812a.g());
                }
                throw InvalidProtocolBufferException.h();
            case 7:
                if (WireFormat.a(this.b) == 5) {
                    return Float.valueOf(this.f6812a.c());
                }
                throw InvalidProtocolBufferException.h();
            case 8:
                if (WireFormat.a(this.b) == 0) {
                    return Integer.valueOf(this.f6812a.f());
                }
                throw InvalidProtocolBufferException.h();
            case 9:
                if (WireFormat.a(this.b) == 0) {
                    return Long.valueOf(this.f6812a.e());
                }
                throw InvalidProtocolBufferException.h();
            case 10:
                return a(cls, extensionRegistryLite);
            case 11:
                if (WireFormat.a(this.b) == 5) {
                    return Integer.valueOf(this.f6812a.o());
                }
                throw InvalidProtocolBufferException.h();
            case 12:
                if (WireFormat.a(this.b) == 1) {
                    return Long.valueOf(this.f6812a.p());
                }
                throw InvalidProtocolBufferException.h();
            case 13:
                if (WireFormat.a(this.b) == 0) {
                    return Integer.valueOf(this.f6812a.q());
                }
                throw InvalidProtocolBufferException.h();
            case 14:
                if (WireFormat.a(this.b) == 0) {
                    return Long.valueOf(this.f6812a.r());
                }
                throw InvalidProtocolBufferException.h();
            case 15:
                if (WireFormat.a(this.b) == 2) {
                    return this.f6812a.k();
                }
                throw InvalidProtocolBufferException.h();
            case 16:
                if (WireFormat.a(this.b) == 0) {
                    return Integer.valueOf(this.f6812a.m());
                }
                throw InvalidProtocolBufferException.h();
            case 17:
                if (WireFormat.a(this.b) == 0) {
                    return Long.valueOf(this.f6812a.d());
                }
                throw InvalidProtocolBufferException.h();
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
