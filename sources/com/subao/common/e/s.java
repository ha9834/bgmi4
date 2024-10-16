package com.subao.common.e;

import com.subao.common.e.ad;
import com.subao.common.e.y;

/* loaded from: classes2.dex */
public class s extends y {
    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/gip";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "game-ip";
    }

    @Override // com.subao.common.e.y
    protected String f() {
        return "key_game_server_ip";
    }

    private s(ad.a aVar, com.subao.common.g.c cVar) {
        super(aVar, cVar);
    }

    public static y.a e() {
        return new y.a() { // from class: com.subao.common.e.s.1
            @Override // com.subao.common.e.y.a
            public y a(ad.a aVar, com.subao.common.g.c cVar) {
                return new s(aVar, cVar);
            }
        };
    }
}
