package com.subao.common.k;

import android.content.Context;
import com.subao.common.e.aa;
import com.subao.common.k.m;

/* loaded from: classes2.dex */
public class u implements s {

    /* renamed from: a, reason: collision with root package name */
    private final a f6119a;

    public String toString() {
        return "[WiFiAccelImpl]";
    }

    public u(Context context, com.subao.common.g.c cVar) {
        this.f6119a = a.a(context, new b(cVar));
    }

    @Override // com.subao.common.a
    public void a() {
        this.f6119a.a();
    }

    @Override // com.subao.common.k.l
    public int a(Context context) {
        if (!aa.e()) {
            throw new m.d(2006);
        }
        return this.f6119a.a(context);
    }
}
