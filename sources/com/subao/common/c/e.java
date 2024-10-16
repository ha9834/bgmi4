package com.subao.common.c;

import android.util.JsonReader;
import com.subao.common.e.an;
import com.subao.common.intf.ProductList;
import com.subao.common.j.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class e extends g {

    /* renamed from: a, reason: collision with root package name */
    private final a f5942a;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, ProductList productList);
    }

    @Override // com.subao.common.c.g
    protected boolean a_() {
        return true;
    }

    public e(String str, an anVar, a aVar) {
        super(str, anVar, null);
        this.f5942a = aVar;
    }

    @Override // com.subao.common.c.g
    protected String c() {
        return "/api/v1/" + f() + "/products";
    }

    @Override // com.subao.common.c.g
    protected b.EnumC0172b a() {
        return b.EnumC0172b.GET;
    }

    @Override // com.subao.common.c.g
    protected void a(b.c cVar) {
        if (cVar == null) {
            this.f5942a.a(-1, null);
            return;
        }
        if (cVar.f6066a != 200) {
            this.f5942a.a(cVar.f6066a, null);
            return;
        }
        if (cVar.b == null || cVar.b.length <= 2) {
            this.f5942a.a(500, null);
            return;
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(cVar.b)));
        try {
            try {
                ProductList createFromJson = ProductList.createFromJson(jsonReader);
                if (createFromJson != null) {
                    this.f5942a.a(cVar.f6066a, createFromJson);
                    return;
                }
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
        this.f5942a.a(500, null);
    }
}
