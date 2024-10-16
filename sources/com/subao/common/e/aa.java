package com.subao.common.e;

import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.subao.common.e.ad;
import com.subao.common.n.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class aa extends ad {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f5952a = com.subao.common.k.r.a();
    private final com.subao.common.g.c b;

    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/parallel";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "Parallel";
    }

    aa(ad.a aVar, com.subao.common.g.c cVar) {
        super(aVar);
        this.b = cVar;
    }

    public static boolean a(ad.a aVar, com.subao.common.g.c cVar) {
        if (!com.subao.common.k.r.a()) {
            a(cVar, false);
            return false;
        }
        String str = aVar.f6011a;
        if ("827006BE-64F7-4082-B252-33ACF328A3A5".equals(str) || "84CC36C0-839F-4D72-8D6A-4B80D45BCD1C".equals(str)) {
            a(cVar, false);
            b(aVar, cVar);
            return true;
        }
        a(cVar, true);
        return false;
    }

    private static void b(ad.a aVar, com.subao.common.g.c cVar) {
        aa aaVar = new aa(aVar, cVar);
        ae k = aaVar.k();
        aaVar.b(k);
        aaVar.e(k);
    }

    public static boolean e() {
        return f5952a;
    }

    static boolean a(a aVar, int i, String str, String str2) {
        if (i <= 0) {
            i = Build.VERSION.SDK_INT;
        }
        if (i < 21) {
            com.subao.common.d.a("SubaoParallel", "Android SDK version too low");
            return false;
        }
        if (aVar == null) {
            return false;
        }
        if (!aVar.a()) {
            com.subao.common.d.a("SubaoParallel", "Parallel-Accel switch off");
            return false;
        }
        if (str == null) {
            str = Build.MODEL;
        }
        if (aVar.b(str)) {
            com.subao.common.d.a("SubaoParallel", String.format("The model '%s' matched", str));
            return true;
        }
        com.subao.common.d.a("SubaoParallel", String.format("The model '%s' is not matched, check CPU ...", str));
        if (str2 == null) {
            str2 = e.a.a();
        }
        if (aVar.a(str2)) {
            com.subao.common.d.a("SubaoParallel", String.format("The CPU '%s' matched", str2));
            return true;
        }
        com.subao.common.d.a("SubaoParallel", String.format("The CPU '%s' is not matched", str2));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public void a(ae aeVar) {
        super.a(aeVar);
        if (aeVar == null || !aeVar.d) {
            return;
        }
        b(aeVar);
    }

    private void b(ae aeVar) {
        a(this.b, a(a.a(aeVar), -1, null, null));
    }

    private static void a(com.subao.common.g.c cVar, boolean z) {
        f5952a = z;
        cVar.a(0, "key_enable_qpp", z ? 1 : 0);
        if (com.subao.common.d.a("SubaoParallel")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Now switch turn to ");
            sb.append(z ? "on" : "off");
            Log.d("SubaoParallel", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f5953a;
        private final List<String> b;
        private final List<String> c;

        private a(boolean z, List<String> list, List<String> list2) {
            this.f5953a = z;
            this.b = list;
            this.c = list2;
        }

        static a a(boolean z, List<String> list, List<String> list2) {
            if (list == null || list2 == null || list.isEmpty() || list2.isEmpty()) {
                return null;
            }
            return new a(z, list, list2);
        }

        public static a a(ae aeVar) {
            if (aeVar == null || aeVar.b() < 8) {
                return null;
            }
            JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(aeVar.a())));
            try {
                try {
                    return a(jsonReader);
                } finally {
                    com.subao.common.e.a(jsonReader);
                }
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
                return null;
            }
        }

        private static boolean a(List<String> list, String str) {
            if (list == null || TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (lowerCase.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }

        private static List<String> b() {
            return new ArrayList(128);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static a a(JsonReader jsonReader) {
            List<String> b = b();
            List<String> b2 = b();
            try {
                jsonReader.beginObject();
                boolean z = false;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if ("model".equals(nextName)) {
                        a(com.subao.common.n.g.b(jsonReader), b);
                    } else if ("cpu".equals(nextName)) {
                        a(com.subao.common.n.g.b(jsonReader), b2);
                    } else if ("switch".equals(nextName)) {
                        z = "1".equals(jsonReader.nextString());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return a(z, b, b2);
            } catch (AssertionError | RuntimeException e) {
                throw new IOException(e.getMessage());
            }
        }

        static int a(String str, List<String> list) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            StringReader stringReader = new StringReader(str.toLowerCase());
            try {
                return com.subao.common.n.h.a(stringReader, list);
            } finally {
                com.subao.common.e.a(stringReader);
            }
        }

        public boolean a() {
            return this.f5953a;
        }

        public boolean a(String str) {
            return a(this.c, str);
        }

        public boolean b(String str) {
            return a(this.b, str);
        }

        public String toString() {
            Locale locale = r.f6001a;
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.f5953a);
            List<String> list = this.c;
            objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
            List<String> list2 = this.b;
            objArr[2] = Integer.valueOf(list2 != null ? list2.size() : 0);
            return String.format(locale, "[enable=%b, cpu=%d, model=%d]", objArr);
        }
    }
}
