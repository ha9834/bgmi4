package com.subao.common.c;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.subao.common.e.an;
import com.subao.common.j.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class c extends g {

    /* renamed from: a, reason: collision with root package name */
    private final b f5940a;
    private int b;
    private String c;

    public c(String str, an anVar, String str2, b bVar) {
        super(str, anVar, str2);
        this.b = -1;
        this.f5940a = bVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String a(byte[] bArr) {
        JsonReader jsonReader;
        try {
            if (bArr == null) {
                return null;
            }
            try {
                jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("orderId".equals(jsonReader.nextName())) {
                            String b = com.subao.common.n.g.b(jsonReader);
                            com.subao.common.e.a(jsonReader);
                            return b;
                        }
                        jsonReader.skipValue();
                    }
                    jsonReader.endObject();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    com.subao.common.e.a(jsonReader);
                    return null;
                } catch (RuntimeException e2) {
                    e = e2;
                    e.printStackTrace();
                    com.subao.common.e.a(jsonReader);
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                jsonReader = null;
                e.printStackTrace();
                com.subao.common.e.a(jsonReader);
                return null;
            } catch (RuntimeException e4) {
                e = e4;
                jsonReader = null;
                e.printStackTrace();
                com.subao.common.e.a(jsonReader);
                return null;
            } catch (Throwable th) {
                th = th;
                com.subao.common.e.a((Closeable) null);
                throw th;
            }
            com.subao.common.e.a(jsonReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.subao.common.c.g
    protected b.EnumC0172b a() {
        return b.EnumC0172b.POST;
    }

    @Override // com.subao.common.c.g
    protected byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
        this.f5940a.serialize(jsonWriter);
        com.subao.common.e.a(jsonWriter);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.subao.common.c.g
    protected String c() {
        return "/api/v1/" + f() + "/orders";
    }

    @Override // com.subao.common.c.g
    protected void a(b.c cVar) {
        if (cVar == null) {
            this.b = -1;
            this.c = null;
        } else {
            this.b = cVar.f6066a;
            this.c = cVar.f6066a == 201 ? a(cVar.b) : null;
        }
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }
}
