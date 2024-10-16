package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;

/* loaded from: classes2.dex */
final class cg implements cy {

    /* renamed from: a, reason: collision with root package name */
    private static final cg f4500a = new cg();

    private cg() {
    }

    public static cg a() {
        return f4500a;
    }

    @Override // com.google.android.gms.internal.measurement.cy
    public final boolean a(Class<?> cls) {
        return zzey.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.cy
    public final cz b(Class<?> cls) {
        if (!zzey.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (cz) zzey.a(cls.asSubclass(zzey.class)).a(zzey.zzd.zzaif, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
