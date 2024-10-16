package com.subao.common.e;

import android.util.JsonReader;
import android.util.Log;
import com.subao.common.e.ad;
import com.subao.common.e.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class d extends ad {

    /* renamed from: a, reason: collision with root package name */
    private final int f5980a;
    private final b b;

    /* loaded from: classes2.dex */
    public interface b {
        void a(List<com.subao.common.e.b> list);
    }

    @Override // com.subao.common.e.ad
    protected String a() {
        return "games";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "AccelGames";
    }

    protected d(ad.a aVar, int i, b bVar) {
        super(aVar);
        this.f5980a = i;
        this.b = bVar;
    }

    public static List<com.subao.common.e.b> a(ad.a aVar, int i, b bVar, byte[] bArr) {
        d dVar = new d(aVar, i, bVar);
        ae k = dVar.k();
        dVar.e(k);
        List<com.subao.common.e.b> a2 = a(k, i);
        return a2 == null ? a(bArr, i) : a2;
    }

    private static List<com.subao.common.e.b> a(ae aeVar, int i) {
        if (aeVar == null || aeVar.a() == null) {
            return null;
        }
        return a(aeVar.a(), i);
    }

    private static List<com.subao.common.e.b> a(byte[] bArr, int i) {
        List<com.subao.common.e.b> list = null;
        if (bArr != null && bArr.length > 2) {
            try {
                list = a.a(new ByteArrayInputStream(bArr), i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (list == null) {
                Log.w("SubaoData", "Parse accel game list fail");
            } else if (com.subao.common.d.a("SubaoData")) {
                Log.d("SubaoData", String.format(r.f6001a, "Parse %d games from JSON", Integer.valueOf(list.size())));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public void a(ae aeVar) {
        List<com.subao.common.e.b> a2;
        super.a(aeVar);
        if (this.b == null || aeVar == null || !aeVar.d || (a2 = a(aeVar, this.f5980a)) == null) {
            return;
        }
        this.b.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public String c() {
        return m().a() ? "v4" : super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r3 = a(r0, r4);
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.util.List<com.subao.common.e.b> a(java.io.InputStream r3, int r4) {
            /*
                android.util.JsonReader r0 = new android.util.JsonReader
                java.io.InputStreamReader r1 = new java.io.InputStreamReader
                java.lang.String r2 = "UTF-8"
                r1.<init>(r3, r2)
                r0.<init>(r1)
                r0.beginObject()     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
            Lf:
                boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
                if (r3 == 0) goto L2a
                java.lang.String r3 = r0.nextName()     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
                java.lang.String r1 = "gameList"
                boolean r3 = r1.equals(r3)     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
                if (r3 == 0) goto L26
                java.util.List r3 = a(r0, r4)     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
                goto L2b
            L26:
                r0.skipValue()     // Catch: java.lang.Throwable -> L2f java.lang.RuntimeException -> L31
                goto Lf
            L2a:
                r3 = 0
            L2b:
                com.subao.common.e.a(r0)
                return r3
            L2f:
                r3 = move-exception
                goto L3b
            L31:
                r3 = move-exception
                r3.printStackTrace()     // Catch: java.lang.Throwable -> L2f
                java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L2f
                r3.<init>()     // Catch: java.lang.Throwable -> L2f
                throw r3     // Catch: java.lang.Throwable -> L2f
            L3b:
                com.subao.common.e.a(r0)
                throw r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.subao.common.e.d.a.a(java.io.InputStream, int):java.util.List");
        }

        private static List<com.subao.common.e.b> a(JsonReader jsonReader, int i) {
            ArrayList arrayList = new ArrayList(i);
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                com.subao.common.e.b a2 = a(jsonReader);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            jsonReader.endArray();
            return arrayList;
        }

        private static com.subao.common.e.b a(JsonReader jsonReader) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            List<b.a> list = null;
            List<b.a> list2 = null;
            List<String> list3 = null;
            List<String> list4 = null;
            int i = 1;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("appLabel".equals(nextName)) {
                    str = com.subao.common.n.g.b(jsonReader);
                } else if ("accelMode".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("bitFlag".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("whitePorts".equals(nextName)) {
                    list = c(jsonReader);
                } else if ("blackPorts".equals(nextName)) {
                    list2 = c(jsonReader);
                } else if ("blackIps".equals(nextName)) {
                    list4 = b(jsonReader);
                } else if ("whiteIps".equals(nextName)) {
                    list3 = b(jsonReader);
                } else if ("icon".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return com.subao.common.e.b.a(str, i, str2, i2, list, list2, list3, list4);
        }

        private static List<String> b(JsonReader jsonReader) {
            jsonReader.beginArray();
            ArrayList arrayList = null;
            while (jsonReader.hasNext()) {
                String b = com.subao.common.n.g.b(jsonReader);
                if (b != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(b);
                }
            }
            jsonReader.endArray();
            return arrayList;
        }

        private static List<b.a> c(JsonReader jsonReader) {
            jsonReader.beginArray();
            ArrayList arrayList = null;
            while (jsonReader.hasNext()) {
                jsonReader.beginObject();
                Integer num = null;
                Integer num2 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if ("start".equals(nextName)) {
                        num = Integer.valueOf(jsonReader.nextInt());
                    } else if ("end".equals(nextName)) {
                        num2 = Integer.valueOf(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                if (num != null && num2 != null) {
                    b.a aVar = new b.a(num.intValue(), num2.intValue());
                    if (arrayList == null) {
                        arrayList = new ArrayList(8);
                    }
                    arrayList.add(aVar);
                }
            }
            jsonReader.endArray();
            return arrayList;
        }
    }
}
