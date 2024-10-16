package com.shieldtunnel.svpn.common.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final String f5799a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final int f;

    public k(String str, String str2, String str3, int i, int i2, int i3) {
        this.f5799a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public String e() {
        return this.f5799a;
    }

    public String f() {
        return this.b;
    }

    public String toString() {
        return String.format(com.shieldtunnel.svpn.common.f.f.b, "[%s,%s,%s,%d,%d,%d]", this.f5799a, com.shieldtunnel.svpn.common.k.e.b(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
    
        if (r11.length() == 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.shieldtunnel.svpn.common.d.k a(java.lang.String r11) {
        /*
            java.util.List r11 = b(r11)
            r0 = 0
            if (r11 == 0) goto L5c
            int r1 = r11.size()
            r2 = 5
            if (r1 >= r2) goto Lf
            goto L5c
        Lf:
            r1 = 0
            java.lang.Object r3 = r11.get(r1)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            r3 = 1
            java.lang.Object r3 = r11.get(r3)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            r3 = 2
            java.lang.Object r3 = r11.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4 = 3
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r6 = 4
            java.lang.Object r6 = r11.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            int r8 = r11.size()
            r9 = 6
            if (r8 >= r9) goto L3c
            goto L48
        L3c:
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            int r2 = r11.length()
            if (r2 != 0) goto L49
        L48:
            r11 = r0
        L49:
            com.shieldtunnel.svpn.common.d.k r0 = new com.shieldtunnel.svpn.common.d.k
            int r8 = com.shieldtunnel.svpn.common.k.e.a(r3, r1)
            int r9 = com.shieldtunnel.svpn.common.k.e.a(r4, r1)
            int r10 = com.shieldtunnel.svpn.common.k.e.a(r6, r1)
            r4 = r0
            r6 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shieldtunnel.svpn.common.d.k.a(java.lang.String):com.shieldtunnel.svpn.common.d.k");
    }

    private static List<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(6);
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf < 0) {
                break;
            }
            arrayList.add(str.substring(i, indexOf).trim());
            i = indexOf + 1;
        }
        if (i < str.length()) {
            arrayList.add(str.substring(i).trim());
        }
        return arrayList;
    }
}
