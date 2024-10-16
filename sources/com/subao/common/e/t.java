package com.subao.common.e;

import android.text.TextUtils;
import android.util.Log;
import com.subao.common.e.v;
import com.subao.common.j.b;

/* loaded from: classes2.dex */
public class t extends v {

    /* renamed from: a, reason: collision with root package name */
    private final String f6004a;
    private final String d;
    private String e;

    @Override // com.subao.common.e.v
    protected int a() {
        return 5;
    }

    protected t(v.a aVar, v.d dVar, String str) {
        super(aVar, dVar, b.EnumC0172b.POST, null);
        this.e = "https";
        this.f6004a = dVar.f6010a;
        if (aVar.c != null && !TextUtils.isEmpty(aVar.c.f5971a)) {
            this.e = aVar.c.f5971a;
        }
        this.d = str;
    }

    public static void a(v.a aVar, v.d dVar, String str) {
        new t(aVar, dVar, str).a(com.subao.common.m.d.a());
    }

    @Override // com.subao.common.e.v
    protected String b() {
        return String.format("/api/v2/%s/users/%s/coupons/%s", com.subao.common.e.a(this.b.f6011a), com.subao.common.e.a(this.f6004a), com.subao.common.e.a(this.d));
    }

    @Override // com.subao.common.e.v
    protected String c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.v
    public void a(v.b bVar) {
        if (com.subao.common.d.a("SubaoData")) {
            if (bVar != null && bVar.b != null) {
                Log.d("SubaoData", "HRCouponExchange code: " + bVar.b.f6066a);
                return;
            }
            Log.d("SubaoData", "HRCouponExchange result or response is null");
        }
    }
}
