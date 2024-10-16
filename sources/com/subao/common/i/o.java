package com.subao.common.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.tencent.mid.api.MidEntity;

/* loaded from: classes2.dex */
public class o implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    private long f6048a;
    private a b;
    private m c;
    private r d;
    private com.subao.common.e.g e;

    public o(com.subao.common.e.g gVar, long j, a aVar, m mVar, r rVar) {
        this.f6048a = j;
        this.b = aVar;
        this.c = mVar;
        this.d = rVar;
        this.e = gVar;
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("time").value(this.f6048a);
        if (this.b != null) {
            jsonWriter.name("user");
            this.b.serialize(jsonWriter);
        }
        if (this.c != null) {
            jsonWriter.name("device");
            this.c.serialize(jsonWriter);
        }
        if (this.d != null) {
            jsonWriter.name("version");
            this.d.serialize(jsonWriter);
        }
        e.a(jsonWriter, "type", this.e);
        jsonWriter.endObject();
    }

    /* loaded from: classes2.dex */
    public static class a implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        private String f6049a;
        private String b;
        private String c;
        private String d;
        private String e;

        public a(String str, String str2, String str3, String str4, String str5) {
            this.f6049a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @SuppressLint({"HardwareIds"})
        public static a a(Context context) {
            String str;
            try {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (RuntimeException unused) {
                str = "";
            }
            return new a("", Build.SERIAL, "", "", str);
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            com.subao.common.n.g.a(jsonWriter, MidEntity.TAG_IMSI, this.f6049a);
            com.subao.common.n.g.a(jsonWriter, "sn", this.b);
            com.subao.common.n.g.a(jsonWriter, MidEntity.TAG_MAC, this.c);
            com.subao.common.n.g.a(jsonWriter, "deviceId", this.d);
            com.subao.common.n.g.a(jsonWriter, "androidId", this.e);
            jsonWriter.endObject();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return com.subao.common.e.a(this.f6049a, aVar.f6049a) && com.subao.common.e.a(this.b, aVar.b) && com.subao.common.e.a(this.c, aVar.c) && com.subao.common.e.a(this.d, aVar.d) && com.subao.common.e.a(this.e, aVar.e);
        }
    }
}
