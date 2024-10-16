package com.subao.common.e;

import com.subao.common.e.v;
import com.subao.common.j.b;

/* loaded from: classes2.dex */
public class ar extends v {

    /* renamed from: a, reason: collision with root package name */
    private static String f5976a = "http";
    private final String d;

    @Override // com.subao.common.e.v
    protected int a() {
        return 3;
    }

    ar(v.a aVar, v.d dVar, byte[] bArr) {
        super(aVar, dVar, b.EnumC0172b.POST, bArr);
        this.d = dVar.f6010a;
    }

    public static void a(v.a aVar, v.d dVar, byte[] bArr) {
        new ar(aVar, dVar, bArr).a(com.subao.common.m.d.a());
    }

    public static void a(String str) {
        if ("https".equals(str)) {
            f5976a = str;
        } else {
            f5976a = "http";
        }
    }

    @Override // com.subao.common.e.v
    protected String b() {
        return "/api/v1/" + this.b.f6011a + "/users/" + this.d + "/gameAccel";
    }

    @Override // com.subao.common.e.v
    protected String c() {
        return f5976a;
    }
}
