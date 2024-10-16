package com.subao.common.e;

import com.subao.common.e.ad;

/* loaded from: classes2.dex */
public class ai extends ad {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f5964a;

    @Override // com.subao.common.e.ad
    protected String a() {
        return "portraits";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "portraits";
    }

    protected ai(ad.a aVar, com.subao.common.g.c cVar, ad.g gVar) {
        super(aVar, gVar);
        this.f5964a = cVar;
    }

    public static void a(ad.a aVar, com.subao.common.g.c cVar) {
        a(aVar, cVar, null);
    }

    public static void a(ad.a aVar, com.subao.common.g.c cVar, ad.g gVar) {
        ai aiVar = new ai(aVar, cVar, gVar);
        ae k = aiVar.k();
        if (k != null) {
            if (aiVar.d(k)) {
                aiVar.b(k);
            } else {
                k = null;
            }
        }
        aiVar.e(k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public void a(ae aeVar) {
        super.a(aeVar);
        if (aeVar == null || !aeVar.d) {
            return;
        }
        b(aeVar);
    }

    private void b(ae aeVar) {
        if (aeVar == null || aeVar.c == null) {
            return;
        }
        this.f5964a.a(0, "key_portal_portraits", aeVar.c);
    }
}
