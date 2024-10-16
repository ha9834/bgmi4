package com.subao.common.e;

import android.text.TextUtils;
import com.subao.common.e.ad;

/* loaded from: classes2.dex */
public class af extends ag {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f5961a;

    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/general";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "general";
    }

    protected af(ad.a aVar, com.subao.common.g.c cVar) {
        super(aVar);
        this.f5961a = cVar;
    }

    public static void a(ad.a aVar, com.subao.common.g.c cVar) {
        ag.a((ag) new af(aVar, cVar));
    }

    @Override // com.subao.common.e.ag
    protected void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5961a.a(str, str2);
    }
}
