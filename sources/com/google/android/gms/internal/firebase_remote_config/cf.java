package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;

/* loaded from: classes2.dex */
final class cf implements cy {

    /* renamed from: a, reason: collision with root package name */
    private static final cf f4058a = new cf();

    private cf() {
    }

    public static cf a() {
        return f4058a;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cy
    public final boolean a(Class<?> cls) {
        return zzhh.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cy
    public final cw b(Class<?> cls) {
        if (!zzhh.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (cw) zzhh.a(cls.asSubclass(zzhh.class)).a(zzhh.zzd.zztm, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
