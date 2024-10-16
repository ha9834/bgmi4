package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cr implements dl {
    private static final cy b = new cq();

    /* renamed from: a, reason: collision with root package name */
    private final cy f4066a;

    public cr() {
        this(new cs(cf.a(), a()));
    }

    private cr(cy cyVar) {
        this.f4066a = (cy) zzhi.a(cyVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dl
    public final <T> dm<T> a(Class<T> cls) {
        Cdo.a((Class<?>) cls);
        cw b2 = this.f4066a.b(cls);
        if (b2.b()) {
            if (zzhh.class.isAssignableFrom(cls)) {
                return db.a(Cdo.c(), bz.a(), b2.c());
            }
            return db.a(Cdo.a(), bz.b(), b2.c());
        }
        if (zzhh.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return cz.a(cls, b2, de.b(), cl.b(), Cdo.c(), bz.a(), cx.b());
            }
            return cz.a(cls, b2, de.b(), cl.b(), Cdo.c(), (by<?>) null, cx.b());
        }
        if (a(b2)) {
            return cz.a(cls, b2, de.a(), cl.a(), Cdo.a(), bz.b(), cx.a());
        }
        return cz.a(cls, b2, de.a(), cl.a(), Cdo.b(), (by<?>) null, cx.a());
    }

    private static boolean a(cw cwVar) {
        return cwVar.a() == zzhh.zzd.zzts;
    }

    private static cy a() {
        try {
            return (cy) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
