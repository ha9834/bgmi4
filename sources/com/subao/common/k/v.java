package com.subao.common.k;

import android.content.Context;
import com.subao.common.k.m;

/* loaded from: classes2.dex */
public class v implements s {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6120a;
    private final com.subao.common.g.c b;
    private s c;
    private volatile boolean d;

    public v(Context context, com.subao.common.g.c cVar) {
        this.f6120a = context;
        this.b = cVar;
    }

    @Override // com.subao.common.a
    public void a() {
        s sVar;
        com.subao.common.d.a("SubaoParallel", "reset");
        synchronized (this) {
            sVar = this.c;
            this.c = null;
        }
        if (sVar != null) {
            sVar.a();
        }
    }

    @Override // com.subao.common.k.l
    public int a(Context context) {
        s sVar;
        synchronized (this) {
            sVar = this.c;
        }
        if (sVar == null) {
            sVar = b();
            synchronized (this) {
                if (this.c == null) {
                    this.c = sVar;
                } else {
                    sVar.a();
                    sVar = this.c;
                }
            }
        }
        try {
            int a2 = sVar.a(context);
            this.d = false;
            return a2;
        } catch (m.d e) {
            int a3 = e.a();
            if (a3 != 2007) {
                if (a3 == 2009) {
                    a();
                }
            } else if (!this.d) {
                this.d = true;
                a();
            }
            throw e;
        }
    }

    private s b() {
        s tVar;
        try {
            tVar = new u(this.f6120a, this.b);
        } catch (m.d e) {
            tVar = new t(e.a());
        }
        com.subao.common.d.a("SubaoParallel", String.format("Create '%s'", tVar.toString()));
        return tVar;
    }
}
