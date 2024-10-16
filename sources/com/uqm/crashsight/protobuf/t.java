package com.uqm.crashsight.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class t implements ap {
    private static final z b = new z() { // from class: com.uqm.crashsight.protobuf.t.1
        @Override // com.uqm.crashsight.protobuf.z
        public final boolean a(Class<?> cls) {
            return false;
        }

        @Override // com.uqm.crashsight.protobuf.z
        public final y b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final z f6836a;

    public t() {
        this(new a(p.a(), a()));
    }

    private t(z zVar) {
        this.f6836a = (z) Internal.a(zVar, "messageInfoFactory");
    }

    @Override // com.uqm.crashsight.protobuf.ap
    public final <T> ao<T> a(Class<T> cls) {
        ae a2;
        r a3;
        at<?, ?> b2;
        k<?> kVar;
        u a4;
        ae a5;
        r a6;
        at<?, ?> a7;
        k<?> b3;
        u a8;
        aq.a((Class<?>) cls);
        y b4 = this.f6836a.b(cls);
        if (b4.b()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                return ac.a(aq.c(), n.a(), b4.c());
            }
            return ac.a(aq.a(), n.b(), b4.c());
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (b4.a() == ProtoSyntax.PROTO2) {
                a2 = ah.b();
                a3 = r.b();
                b2 = aq.c();
                kVar = n.a();
                a4 = x.b();
                return ab.a(b4, a2, a3, b2, kVar, a4);
            }
            a5 = ah.b();
            a6 = r.b();
            a7 = aq.c();
            b3 = null;
            a8 = x.b();
            return ab.a(b4, a5, a6, a7, b3, a8);
        }
        if (b4.a() == ProtoSyntax.PROTO2) {
            a5 = ah.a();
            a6 = r.a();
            a7 = aq.a();
            b3 = n.b();
            a8 = x.a();
            return ab.a(b4, a5, a6, a7, b3, a8);
        }
        a2 = ah.a();
        a3 = r.a();
        b2 = aq.b();
        kVar = null;
        a4 = x.a();
        return ab.a(b4, a2, a3, b2, kVar, a4);
    }

    /* loaded from: classes3.dex */
    static class a implements z {

        /* renamed from: a, reason: collision with root package name */
        private z[] f6837a;

        a(z... zVarArr) {
            this.f6837a = zVarArr;
        }

        @Override // com.uqm.crashsight.protobuf.z
        public final boolean a(Class<?> cls) {
            for (z zVar : this.f6837a) {
                if (zVar.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.z
        public final y b(Class<?> cls) {
            for (z zVar : this.f6837a) {
                if (zVar.a(cls)) {
                    return zVar.b(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    private static z a() {
        try {
            return (z) Class.forName("com.uqm.crashsight.protobuf.h").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
