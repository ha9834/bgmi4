package com.subao.common.e;

import android.util.Log;
import com.subao.common.e.ad;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class ak extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static a f5966a;
    private a b;
    private final com.subao.common.g.c c;

    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/qos_region";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "QosRegion";
    }

    protected ak(ad.a aVar, com.subao.common.g.c cVar) {
        super(aVar);
        this.b = new a(new HashMap(16));
        this.c = cVar;
    }

    public static void a(ad.a aVar, com.subao.common.g.c cVar) {
        ag.a((ag) new ak(aVar, cVar));
    }

    public static boolean e() {
        a aVar = f5966a;
        return (aVar == null || aVar.a()) ? false : true;
    }

    public static com.subao.common.l.b a(int i, int i2) {
        a aVar = f5966a;
        com.subao.common.l.b a2 = aVar == null ? null : aVar.a(i, i2);
        if (com.subao.common.d.a("SubaoData")) {
            Log.d("SubaoData", String.format(r.f6001a, "getQosParam(%d, %d) return %s", Integer.valueOf(i), Integer.valueOf(i2), com.subao.common.n.h.a(a2)));
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.subao.common.e.ag
    public void b(ae aeVar) {
        if (aeVar != null && aeVar.c != null && aeVar.c.length > 2) {
            this.c.b(0, "key_qos_config", new String(aeVar.c));
        }
        super.b(aeVar);
    }

    @Override // com.subao.common.e.ag
    protected void a(String str, String str2) {
        this.b.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ag
    public void a(boolean z) {
        super.a(z);
        f5966a = this.b;
        com.subao.common.l.c.a().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<al, com.subao.common.l.b> f5967a;

        a(Map<al, com.subao.common.l.b> map) {
            this.f5967a = map;
        }

        private static al a(String str) {
            String[] split = str.split("\\.");
            if (split.length < 2) {
                return null;
            }
            try {
                return new al(b(split[0]), b(split[1]));
            } catch (NumberFormatException unused) {
                return null;
            }
        }

        private static int b(String str) {
            if ("*".equals(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        }

        void a(String str, String str2) {
            if (str == null || !str.startsWith("cfg_")) {
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            al a2 = a(str.substring(4));
            if (a2 != null) {
                this.f5967a.put(a2, com.subao.common.l.b.a(str2));
            }
        }

        boolean a() {
            Map<al, com.subao.common.l.b> map = this.f5967a;
            return map == null || map.isEmpty();
        }

        com.subao.common.l.b a(int i, int i2) {
            Map<al, com.subao.common.l.b> map = this.f5967a;
            if (map == null) {
                return null;
            }
            for (Map.Entry<al, com.subao.common.l.b> entry : map.entrySet()) {
                al key = entry.getKey();
                if (key.f5968a < 0 || key.f5968a == i) {
                    if (key.b < 0 || key.b == i2) {
                        return entry.getValue();
                    }
                }
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                return com.subao.common.e.a(this.f5967a, ((a) obj).f5967a);
            }
            return false;
        }

        public String toString() {
            Locale locale = r.f6001a;
            Object[] objArr = new Object[1];
            Map<al, com.subao.common.l.b> map = this.f5967a;
            objArr[0] = Integer.valueOf(map == null ? 0 : map.size());
            return String.format(locale, "[QosRegion and Params: count=%d]", objArr);
        }
    }
}
