package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class by {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4494a = c();

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzel a() {
        if (f4494a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzel.f4555a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.zzel b() {
        /*
            java.lang.Class<?> r0 = com.google.android.gms.internal.measurement.by.f4494a
            if (r0 == 0) goto Lb
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.measurement.zzel r0 = a(r0)     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L12
            com.google.android.gms.internal.measurement.zzel r0 = com.google.android.gms.internal.measurement.zzel.a()
        L12:
            if (r0 != 0) goto L18
            com.google.android.gms.internal.measurement.zzel r0 = a()
        L18:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.by.b():com.google.android.gms.internal.measurement.zzel");
    }

    private static final zzel a(String str) throws Exception {
        return (zzel) f4494a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
