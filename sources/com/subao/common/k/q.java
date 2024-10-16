package com.subao.common.k;

import android.content.Context;
import com.subao.common.j.q;

/* loaded from: classes2.dex */
public class q {
    private q() {
    }

    public static void a(Context context, com.subao.common.m.a aVar, int i, h hVar) {
        new a(i, hVar).a(context, aVar);
    }

    /* loaded from: classes2.dex */
    private static class a implements q.a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f6117a = !q.class.desiredAssertionStatus();
        private final int b;
        private final h c;
        private com.subao.common.j.q d;
        private int e = -1;

        a(int i, h hVar) {
            this.b = i;
            this.c = hVar;
        }

        public void a(Context context, com.subao.common.m.a aVar) {
            if (!f6117a && this.d != null) {
                throw new AssertionError();
            }
            this.d = new com.subao.common.j.r(this);
            this.d.a(context);
            aVar.a(this, 1000L);
        }

        @Override // com.subao.common.j.q.a
        public void a(int i) {
            this.e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.a();
            int i = this.e;
            this.c.a(i < 0 ? this.b : i + 2100, -1, g.MOBILE);
        }
    }
}
