package com.subao.common.k;

import android.content.Context;
import android.util.Log;
import com.subao.common.k.m;

/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6108a;
    private final l b;
    private final h c;
    private final com.subao.common.m.a d;
    private final a e;
    private int f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public k(Context context, l lVar, h hVar, com.subao.common.m.a aVar, a aVar2) {
        this.f6108a = context;
        this.b = lVar;
        this.c = hVar;
        this.d = aVar;
        this.e = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.e.a();
        }
    }

    private boolean a() {
        int i;
        this.f++;
        int i2 = 0;
        try {
            i = this.b.a(this.f6108a);
        } catch (m.d e) {
            int a2 = e.a();
            c.b().a(a2);
            if (this.f < 4 && com.subao.common.b.a(a2)) {
                if (com.subao.common.d.a("SubaoParallel")) {
                    Log.d("SubaoParallel", String.format(com.subao.common.e.r.f6001a, "Request mobile fd error #%d, retry after 1.5 seconds", Integer.valueOf(a2)));
                }
                this.d.a(this, 1500L);
                return false;
            }
            i2 = a2;
            i = -1;
        }
        if (i2 == 2007 || i2 == 2008) {
            q.a(this.f6108a, com.subao.common.m.b.a(), i2, this.c);
        } else {
            this.c.a(i2, i, g.MOBILE);
        }
        return true;
    }
}
