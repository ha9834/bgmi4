package com.subao.common.c;

import com.subao.common.c.e;
import com.subao.common.e.an;
import com.subao.common.intf.Product;
import com.subao.common.intf.ProductList;

/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static String f5943a;
    private final String b;
    private final an c;
    private final String d;
    private final a e;

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: com.subao.common.c.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0166a {
            PRODUCTS,
            ORDER
        }

        void a(EnumC0166a enumC0166a, int i);
    }

    public f(String str, an anVar, String str2, a aVar) {
        this.b = str;
        this.c = anVar;
        this.d = str2;
        this.e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (f5943a == null) {
            b bVar = new b();
            new e(this.b, this.c, bVar).run();
            if (bVar.f5945a != 200) {
                this.e.a(a.EnumC0166a.PRODUCTS, bVar.f5945a);
                return;
            }
            Product findByType = bVar.b.findByType(3);
            if (findByType == null) {
                this.e.a(a.EnumC0166a.PRODUCTS, 500);
                return;
            }
            f5943a = findByType.getId();
        }
        c cVar = new c(this.b, this.c, this.d, new com.subao.common.c.b(f5943a, 1));
        cVar.run();
        this.e.a(a.EnumC0166a.ORDER, cVar.d());
    }

    /* loaded from: classes2.dex */
    private static class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        int f5945a;
        ProductList b;

        private b() {
            this.f5945a = -1;
        }

        @Override // com.subao.common.c.e.a
        public void a(int i, ProductList productList) {
            this.f5945a = i;
            this.b = productList;
        }
    }
}
