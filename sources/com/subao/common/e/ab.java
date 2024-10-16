package com.subao.common.e;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.f.c f5954a;

    public ab(com.subao.common.f.c cVar) {
        this.f5954a = cVar;
    }

    public void a(String str, byte[] bArr) {
        com.subao.common.f.c a2 = this.f5954a.a(str);
        if (bArr == null) {
            a2.d();
            return;
        }
        OutputStream c = a2.c();
        try {
            c.write(bArr);
        } finally {
            com.subao.common.e.a(c);
        }
    }

    public byte[] a(String str) {
        return this.f5954a.a(str).e();
    }
}
