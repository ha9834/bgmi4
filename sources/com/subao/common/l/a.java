package com.subao.common.l;

import com.subao.common.e.f;
import com.subao.common.e.p;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f6121a = new a();

    private a() {
    }

    public static a a() {
        return f6121a;
    }

    public void a(f.a[] aVarArr, f.a[] aVarArr2) {
        C0176a.a(aVarArr, aVarArr2);
    }

    /* renamed from: com.subao.common.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0176a {

        /* renamed from: a, reason: collision with root package name */
        private static p<f.a> f6122a = new C0177a();

        static void a(f.a[] aVarArr, f.a[] aVarArr2) {
            if ((aVarArr != null && aVarArr.length > 0) || (aVarArr2 != null && aVarArr2.length > 0)) {
                f6122a = new p<>(aVarArr, aVarArr2);
            } else {
                f6122a = new C0177a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.subao.common.l.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0177a extends p<f.a> {
            C0177a() {
                super(new f.a[]{new f.a("120.196.166.156", -1)}, null);
            }
        }
    }
}
