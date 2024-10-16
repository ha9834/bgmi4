package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* loaded from: classes2.dex */
final class bx implements cp {

    /* renamed from: a, reason: collision with root package name */
    private static final bx f4325a = new bx();

    private bx() {
    }

    public static bx a() {
        return f4325a;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final boolean a(Class<?> cls) {
        return zzrc.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final co b(Class<?> cls) {
        if (!zzrc.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (co) zzrc.a(cls.asSubclass(zzrc.class)).a(zzrc.zze.zzbat, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
