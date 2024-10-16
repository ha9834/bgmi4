package com.subao.common.e;

import com.subao.common.e.ad;
import com.subao.common.e.y;

/* loaded from: classes2.dex */
public class m extends y {
    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/cip";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "convergence";
    }

    @Override // com.subao.common.e.y
    protected String f() {
        return "key_convergence_node";
    }

    m(ad.a aVar, com.subao.common.g.c cVar) {
        super(new ad.b(aVar), cVar);
    }

    public static y.a e() {
        return new y.a() { // from class: com.subao.common.e.m.1
            @Override // com.subao.common.e.y.a
            public y a(ad.a aVar, com.subao.common.g.c cVar) {
                return new m(aVar, cVar);
            }
        };
    }
}
