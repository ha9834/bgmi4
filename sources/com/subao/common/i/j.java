package com.subao.common.i;

import android.content.Context;
import com.subao.common.e.r;

/* loaded from: classes2.dex */
public class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6039a;
    private final r.a b;
    private final String c;
    private final com.subao.common.j.l d;
    private final com.subao.common.i.a e;
    private final f f;

    public j(Context context, r.a aVar, String str, String str2, String str3, com.subao.common.j.l lVar, f fVar) {
        this.f6039a = context.getApplicationContext();
        this.b = aVar;
        this.c = str3;
        this.d = lVar;
        this.e = new com.subao.common.i.a(context, a(aVar), r.a(str, str2));
        this.f = fVar;
    }

    static com.subao.common.e.g a(r.a aVar) {
        switch (aVar) {
            case SDK:
            case ROM:
                return com.subao.common.e.g.ANDROID_SDK;
            default:
                return com.subao.common.e.g.ANDROID_APP;
        }
    }

    @Override // com.subao.common.i.i
    public void a(Runnable runnable) {
        if (com.subao.common.n.i.b()) {
            runnable.run();
        } else {
            com.subao.common.m.b.a().a(runnable);
        }
    }

    @Override // com.subao.common.i.i
    public void d() {
        a(new a());
    }

    @Override // com.subao.common.i.i
    public Context a() {
        return this.f6039a;
    }

    @Override // com.subao.common.i.i
    public com.subao.common.e.g c() {
        return com.subao.common.e.g.ANDROID_SDK;
    }

    @Override // com.subao.common.i.i
    public com.subao.common.j.l b() {
        return this.d;
    }

    @Override // com.subao.common.i.i
    public com.subao.common.i.a e() {
        return this.e;
    }

    @Override // com.subao.common.i.i
    public f f() {
        return this.f;
    }

    /* loaded from: classes2.dex */
    private static class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.subao.common.e.l.a().a(com.subao.common.n.c.a());
        }
    }
}
