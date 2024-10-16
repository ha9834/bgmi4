package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aga implements agy {
    private static final agj b = new agc();

    /* renamed from: a, reason: collision with root package name */
    private final agj f1859a;

    public aga() {
        this(new agd(afq.a(), a()));
    }

    private aga(agj agjVar) {
        this.f1859a = (agj) zzdod.a(agjVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.ads.agy
    public final <T> agx<T> a(Class<T> cls) {
        agz.a((Class<?>) cls);
        agi b2 = this.f1859a.b(cls);
        if (b2.b()) {
            if (zzdob.class.isAssignableFrom(cls)) {
                return agn.a(agz.c(), afj.a(), b2.c());
            }
            return agn.a(agz.a(), afj.b(), b2.c());
        }
        if (zzdob.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return agl.a(cls, b2, agq.b(), afv.b(), agz.c(), afj.a(), agh.b());
            }
            return agl.a(cls, b2, agq.b(), afv.b(), agz.c(), (afh<?>) null, agh.b());
        }
        if (a(b2)) {
            return agl.a(cls, b2, agq.a(), afv.a(), agz.a(), afj.b(), agh.a());
        }
        return agl.a(cls, b2, agq.a(), afv.a(), agz.b(), (afh<?>) null, agh.a());
    }

    private static boolean a(agi agiVar) {
        return agiVar.a() == zzdob.zze.zzhhs;
    }

    private static agj a() {
        try {
            return (agj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
