package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ch implements db {
    private static final cp b = new ci();

    /* renamed from: a, reason: collision with root package name */
    private final cp f4333a;

    public ch() {
        this(new cj(bx.a(), a()));
    }

    private ch(cp cpVar) {
        this.f4333a = (cp) zzre.a(cpVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.gtm.db
    public final <T> da<T> a(Class<T> cls) {
        dc.a((Class<?>) cls);
        co b2 = this.f4333a.b(cls);
        if (b2.b()) {
            if (zzrc.class.isAssignableFrom(cls)) {
                return cs.a(dc.c(), br.a(), b2.c());
            }
            return cs.a(dc.a(), br.b(), b2.c());
        }
        if (zzrc.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return cr.a(cls, b2, cv.b(), cc.b(), dc.c(), br.a(), cn.b());
            }
            return cr.a(cls, b2, cv.b(), cc.b(), dc.c(), null, cn.b());
        }
        if (a(b2)) {
            return cr.a(cls, b2, cv.a(), cc.a(), dc.a(), br.b(), cn.a());
        }
        return cr.a(cls, b2, cv.a(), cc.a(), dc.b(), null, cn.a());
    }

    private static boolean a(co coVar) {
        return coVar.a() == zzrc.zze.zzbaz;
    }

    private static cp a() {
        try {
            return (cp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
