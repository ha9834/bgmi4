package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
final class afq implements agj {

    /* renamed from: a, reason: collision with root package name */
    private static final afq f1852a = new afq();

    private afq() {
    }

    public static afq a() {
        return f1852a;
    }

    @Override // com.google.android.gms.internal.ads.agj
    public final boolean a(Class<?> cls) {
        return zzdob.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.agj
    public final agi b(Class<?> cls) {
        if (!zzdob.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (agi) zzdob.a(cls.asSubclass(zzdob.class)).a(zzdob.zze.zzhhm, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
