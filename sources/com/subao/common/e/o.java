package com.subao.common.e;

import com.amazonaws.services.s3.Headers;
import com.subao.common.e.v;
import com.subao.common.j.b;

/* loaded from: classes2.dex */
public class o extends v {

    /* renamed from: a, reason: collision with root package name */
    protected final b f5996a;
    private final String d;

    @Override // com.subao.common.e.v
    protected int a() {
        return 0;
    }

    @Override // com.subao.common.e.v
    protected String c() {
        return "https";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o(v.a aVar, v.d dVar, b bVar) {
        super(aVar, dVar, b.EnumC0172b.GET, null);
        this.d = dVar.f6010a;
        this.f5996a = bVar;
    }

    public static a b(v.b bVar) {
        return new a(c(bVar), bVar == null ? null : bVar.b);
    }

    private static String c(v.b bVar) {
        String headerField;
        if (bVar == null || bVar.f6008a == null || (headerField = bVar.f6008a.getHeaderField(Headers.ETAG)) == null || headerField.length() != 34) {
            return null;
        }
        return headerField.substring(1, 33);
    }

    @Override // com.subao.common.e.v
    protected String b() {
        return String.format("/api/v2/%s/scripts?serviceId=%s&userId=%s&subaoId=%s&clientVersion=%s", this.b.f6011a, com.subao.common.e.a(this.f5996a.f5998a), com.subao.common.e.a(this.d), com.subao.common.e.a(this.f5996a.b), com.subao.common.e.a(this.b.b));
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f5998a;
        public final String b;

        public b(String str, String str2) {
            this.f5998a = str;
            this.b = str2;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5997a;
        public final b.c b;

        public a(String str, b.c cVar) {
            this.f5997a = str;
            this.b = cVar;
        }
    }
}
