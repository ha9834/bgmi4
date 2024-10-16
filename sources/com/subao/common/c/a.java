package com.subao.common.c;

import com.subao.common.e.an;
import com.subao.common.intf.RequestBuyCallback;

/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f5938a;
    public final int b;
    public String c;
    private final String d;
    private final an e;
    private final RequestBuyCallback f;

    private static int a(int i) {
        return i < 0 ? 1006 : 1008;
    }

    public a(String str, an anVar, String str2, String str3, int i, RequestBuyCallback requestBuyCallback) {
        this.d = str;
        this.e = anVar;
        this.f5938a = str2;
        this.c = str3;
        this.b = i;
        this.f = requestBuyCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = new c(this.d, this.e, this.f5938a, new b(this.c, 1));
        cVar.run();
        String e = cVar.e();
        if (e == null) {
            this.f.onRequestBuyResult(a(cVar.d()), null);
        } else {
            d dVar = new d(this.d, this.e, this.f5938a, e, this.b);
            dVar.run();
            this.f.onRequestBuyResult(dVar.d(), dVar.e());
        }
    }
}
