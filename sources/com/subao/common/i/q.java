package com.subao.common.i;

import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class q implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    private k f6055a;
    private long b = System.currentTimeMillis() / 1000;
    private c c;
    private int d;
    private int e;
    private b f;
    private r g;
    private com.subao.common.e.g h;

    /* loaded from: classes2.dex */
    public enum a {
        UNKNOWN_EXCE_RESULT(0),
        NO_SCRIPT(1),
        SCRIPT_DOWNLOAD_FAIL(2),
        SCRIPT_EXEC_SUCCESS(3),
        SCRIPT_EXEC_FAIL(4);

        public final int f;

        a(int i) {
            this.f = i;
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        UNKNOWN_START_TYPE(0),
        START(1),
        DAILY(2);

        public final int d;

        c(int i) {
            this.d = i;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        private a f6057a;
        private String b;

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            if (this.f6057a != null) {
                jsonWriter.name("result");
                jsonWriter.value(this.f6057a.f);
            }
            com.subao.common.n.g.a(jsonWriter, "note", this.b);
            jsonWriter.endObject();
        }

        public void a() {
            this.f6057a = a.UNKNOWN_EXCE_RESULT;
            this.b = "";
        }
    }

    public q(k kVar, c cVar, int i, int i2, b bVar, r rVar, com.subao.common.e.g gVar) {
        this.f6055a = kVar;
        this.c = cVar;
        this.d = i;
        this.e = i2;
        this.f = bVar;
        this.g = rVar;
        this.h = gVar;
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        if (this.f6055a != null) {
            jsonWriter.name("id");
            this.f6055a.serialize(jsonWriter);
        }
        jsonWriter.name("time").value(this.b);
        if (this.c != null) {
            jsonWriter.name("startType");
            jsonWriter.value(this.c.d);
        }
        com.subao.common.n.g.a(jsonWriter, "nodeNum", Integer.valueOf(this.d));
        com.subao.common.n.g.a(jsonWriter, "gameNum", Integer.valueOf(this.e));
        com.subao.common.n.g.a(jsonWriter, "scriptResult", this.f);
        com.subao.common.n.g.a(jsonWriter, "version", this.g);
        e.a(jsonWriter, "type", this.h);
        jsonWriter.endObject();
    }

    public void a() {
        this.b = 0L;
        this.c = c.UNKNOWN_START_TYPE;
        this.d = 0;
        this.e = 0;
        b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        r rVar = this.g;
        if (rVar != null) {
            rVar.e();
        }
    }
}
