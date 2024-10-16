package com.google.android.gms.internal.firebase_remote_config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class bj {

    /* renamed from: a, reason: collision with root package name */
    private static final bj f4045a = new bj();
    private final String b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    bj() {
        /*
            r4 = this;
            java.lang.String r0 = "java.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "9"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L11
            java.lang.String r0 = "9.0.0"
            goto L15
        L11:
            java.lang.String r0 = c(r0)
        L15:
            com.google.android.gms.internal.firebase_remote_config.zzdz r1 = com.google.android.gms.internal.firebase_remote_config.zzdz.OS_NAME
            java.lang.String r1 = r1.value()
            com.google.android.gms.internal.firebase_remote_config.zzdz r2 = com.google.android.gms.internal.firebase_remote_config.zzdz.OS_VERSION
            java.lang.String r2 = r2.value()
            java.lang.String r3 = com.google.android.gms.internal.firebase_remote_config.zzb.VERSION
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.bj.<init>():void");
    }

    private bj(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("java/");
        sb.append(c(str));
        sb.append(" http-google-%s/");
        sb.append(c(str4));
        if (str2 != null && str3 != null) {
            sb.append(" ");
            sb.append(b(str2));
            sb.append("/");
            sb.append(c(str3));
        }
        this.b = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(String str) {
        return String.format(this.b, b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static bj b() {
        return f4045a;
    }

    private static String b(String str) {
        return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }
}
