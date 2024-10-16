package com.subao.common.e;

import android.util.JsonReader;
import android.util.Log;
import com.subao.common.e.ad;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* loaded from: classes2.dex */
public class e extends ad {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f5981a = {"2200F76E-E295-4A1B-BD85-7F765ADE5371", "A337EEB8-1A39-4837-8F8F-E4EF89DB7C96", "0B34A884-A3DA-4F58-AD21-33348F668879", "0E8748F7-94AA-4FBB-A673-29DF2DA570F4", "D35E4042-AAB7-4CEA-9C26-1EBB4A2F5BFF"};

    @Override // com.subao.common.e.ad
    protected String a() {
        return "nodes";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "AccelNodes";
    }

    protected e(ad.a aVar) {
        super(aVar);
    }

    public static a a(ad.a aVar) {
        e eVar = new e(aVar);
        ae k = eVar.k();
        eVar.e(k);
        if (eVar.d(k)) {
            return b(k);
        }
        return new a(0, null);
    }

    private static a a(JsonReader jsonReader) {
        StringBuilder sb = new StringBuilder(12288);
        jsonReader.beginArray();
        int i = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i3 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("ip".equals(nextName)) {
                    str = com.subao.common.n.g.b(jsonReader);
                } else if ("isp".equals(nextName)) {
                    str2 = com.subao.common.n.g.b(jsonReader);
                } else if ("bitFlag".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else if ("region".equals(nextName)) {
                    str3 = com.subao.common.n.g.b(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            i2++;
            jsonReader.endObject();
            if (str != null && str.length() >= 7 && str2 != null && str2.length() != 0) {
                i++;
                sb.append(str);
                sb.append(':');
                sb.append(i3);
                sb.append(':');
                sb.append(str3);
                for (String str4 : str2.split(",")) {
                    sb.append(':');
                    sb.append(str4);
                }
                sb.append(',');
            }
        }
        jsonReader.endArray();
        if (com.subao.common.d.a("SubaoData")) {
            Log.d("SubaoData", String.format(r.f6001a, "Parse nodes from json: %d / %d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return new a(i, sb.toString());
    }

    static a b(ae aeVar) {
        byte[] a2;
        a aVar = null;
        if (aeVar == null || (a2 = aeVar.a()) == null || a2.length < 8) {
            return null;
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(a2)));
        try {
            try {
                aVar = a(jsonReader);
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public URL d() {
        String str = m().f6011a;
        for (String str2 : f5981a) {
            if (str2.equals(str)) {
                return new URL("http://pic.xunyou.mobi/custom_node_list/" + str + "/");
            }
        }
        return super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public String c() {
        return m().a() ? "v4" : super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public boolean c(ae aeVar) {
        return aeVar != null && aeVar.b() > 16;
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5982a;
        public final String b;

        public a(int i, String str) {
            this.f5982a = i;
            this.b = str;
        }

        public String toString() {
            return String.format(r.f6001a, "[Accel Nodes %d]", Integer.valueOf(this.f5982a));
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5982a == aVar.f5982a && com.subao.common.e.a(this.b, aVar.b);
        }
    }
}
