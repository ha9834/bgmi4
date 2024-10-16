package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class afg {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1844a = c();

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno a() {
        if (f1844a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzdno.f3586a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzdno b() {
        /*
            java.lang.Class<?> r0 = com.google.android.gms.internal.ads.afg.f1844a
            if (r0 == 0) goto Lb
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.ads.zzdno r0 = a(r0)     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L12
            com.google.android.gms.internal.ads.zzdno r0 = com.google.android.gms.internal.ads.zzdno.a()
        L12:
            if (r0 != 0) goto L18
            com.google.android.gms.internal.ads.zzdno r0 = a()
        L18:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afg.b():com.google.android.gms.internal.ads.zzdno");
    }

    private static final zzdno a(String str) throws Exception {
        return (zzdno) f1844a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
