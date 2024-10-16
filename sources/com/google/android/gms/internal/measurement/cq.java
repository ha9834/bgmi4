package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cq implements Cdo {
    private static final cy b = new ct();

    /* renamed from: a, reason: collision with root package name */
    private final cy f4507a;

    public cq() {
        this(new cs(cg.a(), a()));
    }

    private cq(cy cyVar) {
        this.f4507a = (cy) zzez.a(cyVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.Cdo
    public final <T> dl<T> a(Class<T> cls) {
        dn.a((Class<?>) cls);
        cz b2 = this.f4507a.b(cls);
        if (b2.b()) {
            if (zzey.class.isAssignableFrom(cls)) {
                return dd.a(dn.c(), cc.a(), b2.c());
            }
            return dd.a(dn.a(), cc.b(), b2.c());
        }
        if (zzey.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return dc.a(cls, b2, dg.b(), cn.b(), dn.c(), cc.a(), cw.b());
            }
            return dc.a(cls, b2, dg.b(), cn.b(), dn.c(), (ca<?>) null, cw.b());
        }
        if (a(b2)) {
            return dc.a(cls, b2, dg.a(), cn.a(), dn.a(), cc.b(), cw.a());
        }
        return dc.a(cls, b2, dg.a(), cn.a(), dn.b(), (ca<?>) null, cw.a());
    }

    private static boolean a(cz czVar) {
        return czVar.a() == zzey.zzd.zzail;
    }

    private static cy a() {
        try {
            return (cy) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
