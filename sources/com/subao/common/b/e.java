package com.subao.common.b;

import android.text.TextUtils;
import com.subao.common.e.an;
import com.subao.common.e.f;
import com.subao.common.intf.UserInfo;
import com.subao.common.j.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static e f5919a;
    private final String b;
    private final an c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum b {
        GET,
        POST
    }

    private e(an anVar, String str) {
        this.c = anVar;
        this.b = TextUtils.isEmpty(str) ? "android" : str;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(an anVar, String str) {
        f5919a = new e(anVar, str);
    }

    static String a(int i) {
        return f5919a.d + "v" + i + "/";
    }

    public static void a(boolean z) {
        e eVar = f5919a;
        if (eVar.e != z) {
            eVar.e = z;
            eVar.b();
        }
    }

    public static String a() {
        return f5919a.b;
    }

    public static void a(String str, String str2, com.subao.common.j.p pVar) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("https://");
        sb.append(str);
        sb.append(":801/api/v1/");
        sb.append(f5919a.b);
        sb.append("/token");
        com.subao.common.j.d.a(a(str2), pVar, sb.toString());
    }

    private static List<com.subao.common.j.o> a(String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.subao.common.j.o("Authorization", "Bearer " + str));
        return arrayList;
    }

    public static void a(c cVar, String str) {
        try {
            com.subao.common.j.d.a(null, cVar.d, a(1) + com.subao.common.e.a(cVar.c) + "/sessions?grant_type=client_credentials&version=" + com.subao.common.e.a(str), com.subao.common.n.g.b(new UserInfo(cVar.f5922a, cVar.b, cVar.e)));
        } catch (IOException unused) {
            com.subao.common.m.b.a().a(new a(cVar.d));
        }
    }

    public static void b(String str, String str2, com.subao.common.j.p pVar) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append(a(1));
        sb.append(f5919a.b);
        sb.append("/accounts/");
        sb.append(str);
        com.subao.common.j.d.a(a(str2), pVar, sb.toString());
    }

    private static String a(String str, String str2, b bVar) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append(a(2));
        sb.append(f5919a.b);
        sb.append("/users/");
        sb.append(str);
        sb.append("/configs");
        if (bVar == b.POST) {
            sb.append("/userConfig");
        } else {
            sb.append("?clientVersion=");
            sb.append(str2);
        }
        return sb.toString();
    }

    public static void a(String str, String str2, String str3, com.subao.common.j.p pVar) {
        com.subao.common.j.d.a(a(str), pVar, a(str2, str3, b.GET));
    }

    public static void a(String str, String str2, byte[] bArr, com.subao.common.j.p pVar) {
        com.subao.common.j.d.a(a(str), pVar, a(str2, (String) null, b.POST), bArr);
    }

    public static void a(String str, int i, String str2, com.subao.common.j.p pVar) {
        try {
            com.subao.common.j.d.a(a(str2), pVar, a(1) + f5919a.b + "/orders", com.subao.common.n.g.b(new i(str, i)));
        } catch (IOException unused) {
        }
    }

    private void b() {
        String str;
        StringBuilder sb = new StringBuilder(512);
        if (this.e) {
            str = "http";
        } else {
            an anVar = this.c;
            str = anVar == null ? "https" : anVar.f5971a;
        }
        sb.append(str);
        sb.append("://");
        an anVar2 = this.c;
        if (anVar2 == null) {
            sb.append(com.subao.common.e.f.b(f.g.HR));
        } else {
            sb.append(anVar2.b);
            if (this.c.c > 0) {
                sb.append(':');
                sb.append(this.c.c);
            }
        }
        sb.append("/api/");
        this.d = sb.toString();
    }

    /* loaded from: classes2.dex */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f5922a;
        public final String b;
        public final String c;
        public final com.subao.common.j.p d;
        public final String e;

        public c(String str, String str2, String str3, String str4, com.subao.common.j.p pVar) {
            this.d = pVar;
            this.f5922a = str;
            this.b = str2;
            this.c = str3;
            this.e = str4;
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.subao.common.j.p f5920a;

        private a(com.subao.common.j.p pVar) {
            this.f5920a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5920a.a((b.c) null);
        }
    }
}
