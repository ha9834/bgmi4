package com.huawei.game.gamekit.a;

import com.facebook.internal.security.CertificateUtil;
import com.huawei.game.gamekit.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.huawei.game.gamekit.a.e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5465a = "GameDeliverMessage";
    private static final int b = -1;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final String i = "default";
    private static d j;
    private Map<Integer, com.huawei.game.gamekit.a.a> k = new HashMap();

    /* loaded from: classes2.dex */
    static class a extends com.huawei.game.gamekit.a.a {
        private static final String b = "AppVersion";
        private static final String c = "ResourceVersion";
        private static final String d = "1";
        private static final String e = "2";

        a() {
            this.f5461a.put("default", new HashMap());
        }
    }

    /* loaded from: classes2.dex */
    static class b extends com.huawei.game.gamekit.a.a {
        private static final String b = "NetLatency";
        private static final String c = "NetServerIP";
        private static final String d = "7";
        private static final String e = "9";
        private static final String f = "12";
        private static final String g = "15";

        b() {
            HashMap hashMap = new HashMap();
            hashMap.put(b, "7");
            hashMap.put(c, "9");
            this.f5461a.put("default", hashMap);
        }

        @Override // com.huawei.game.gamekit.a.a
        public final Object a(String str, Object obj) {
            if (!b.equals(str)) {
                return obj;
            }
            String valueOf = String.valueOf(obj);
            int indexOf = valueOf.indexOf(CertificateUtil.DELIMITER) + 1;
            int indexOf2 = valueOf.indexOf("|");
            if (indexOf2 <= indexOf) {
                return obj;
            }
            try {
                return Integer.valueOf(valueOf.substring(indexOf, indexOf2));
            } catch (NumberFormatException unused) {
                com.huawei.game.gamekit.b.c.c(d.f5465a, "translateValue NetLatency failed");
                return obj;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class c extends com.huawei.game.gamekit.a.a {
        private static final String b = "Status";
        private static final String c = "16";

        c() {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "16");
            this.f5461a.put("default", hashMap);
        }
    }

    /* renamed from: com.huawei.game.gamekit.a.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0133d extends com.huawei.game.gamekit.a.a {
        private static final String b = "SceneID";
        private static final String c = "KeyThread";
        private static final String d = "PeopleNum";
        private static final String e = "MeanFps";
        private static final String f = "1";
        private static final String g = "3";
        private static final String h = "4";
        private static final String i = "5";
        private static final String j = "11";
        private static final String k = "13";
        private static final String l = "15";
        private static final String m = "51";
        private static final String n = "render\\|";
        private static final String o = "logic\\|";
        private static final String p = "net\\|";

        C0133d() {
            HashMap hashMap = new HashMap();
            hashMap.put(b, "1");
            hashMap.put(c, "15");
            hashMap.put(d, "13");
            hashMap.put(e, "3");
            this.f5461a.put("default", hashMap);
        }

        @Override // com.huawei.game.gamekit.a.a
        public final Object a(String str, Object obj) {
            return c.equals(str) ? String.valueOf(obj).replaceAll(n, "").replaceAll(o, "").replaceAll(p, "") : obj;
        }
    }

    /* loaded from: classes2.dex */
    static class e extends com.huawei.game.gamekit.a.a {
        private static final String b = "PictureQualityCurLevel";
        private static final String c = "FrameRateCurValue";
        private static final String d = "AntiAliasing";
        private static final String e = "HDMode";
        private static final String f = "MultiThread";
        private static final String g = "7";
        private static final String h = "8";
        private static final String i = "10";
        private static final String j = "11";
        private static final String k = "12";
        private static final String l = "43";
        private static final String m = "54";
        private static final String n = "true";

        e() {
            HashMap hashMap = new HashMap();
            hashMap.put(b, "12");
            hashMap.put(c, "10");
            hashMap.put(d, m);
            hashMap.put(e, "11");
            this.f5461a.put("default", hashMap);
        }

        @Override // com.huawei.game.gamekit.a.a
        public final Object a(String str, Object obj) {
            return (d.equals(str) || e.equals(str) || f.equals(str)) ? Integer.valueOf("true".equalsIgnoreCase(String.valueOf(obj)) ? 1 : 0) : obj;
        }
    }

    /* loaded from: classes2.dex */
    static class f extends com.huawei.game.gamekit.a.a {
        f() {
            this.f5461a.put("default", new HashMap());
        }
    }

    private d() {
        this.k.put(0, new a());
        this.k.put(1, new e());
        this.k.put(2, new c());
        this.k.put(3, new C0133d());
        this.k.put(4, new f());
        this.k.put(5, new b());
    }

    private static int a(Map<String, Object> map) {
        try {
            return Integer.parseInt(String.valueOf(map.get("MessageType")));
        } catch (NumberFormatException unused) {
            com.huawei.game.gamekit.b.c.d(f5465a, "getMessageType illegal MessageType");
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (j == null) {
                j = new d();
            }
            dVar = j;
        }
        return dVar;
    }

    @Override // com.huawei.game.gamekit.a.e
    public final String a(String str, String str2) {
        String str3;
        String str4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            str3 = f5465a;
            str4 = "translateMessage JSONObject operation exception";
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.huawei.game.gamekit.a.a aVar = this.k.get(Integer.valueOf(a(linkedHashMap)));
            if (aVar == null) {
                return str2;
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                a.C0132a a2 = aVar.a(str, new a.C0132a((String) entry.getKey(), entry.getValue()));
                if (a2 != null) {
                    jSONObject2.put(a2.f5462a, a2.b);
                }
            }
            return jSONObject2.toString();
        } catch (JSONException unused2) {
            str3 = f5465a;
            str4 = "translateMessage outJson operation exception";
            com.huawei.game.gamekit.b.c.d(str3, str4);
            return str2;
        }
    }
}
