package com.subao.common.i;

import android.util.JsonWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class n implements com.subao.common.c, Iterable<a> {

    /* renamed from: a, reason: collision with root package name */
    private k f6044a;
    private com.subao.common.e.g b;
    private r c;
    private final List<a> d;

    public n(k kVar, com.subao.common.e.g gVar, r rVar, List<a> list) {
        this.f6044a = kVar;
        this.b = gVar;
        this.c = rVar;
        this.d = list;
    }

    public boolean a() {
        List<a> list = this.d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        List<a> list = this.d;
        if (list != null) {
            return list.iterator();
        }
        return new Iterator<a>() { // from class: com.subao.common.i.n.1
            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a next() {
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
            }
        };
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        com.subao.common.n.g.a(jsonWriter, "id", this.f6044a);
        e.a(jsonWriter, "type", this.b);
        com.subao.common.n.g.a(jsonWriter, "version", this.c);
        if (a()) {
            jsonWriter.name("events");
            jsonWriter.beginArray();
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                it.next().serialize(jsonWriter);
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    public void b() {
        k kVar = this.f6044a;
        if (kVar != null) {
            kVar.h();
        }
        r rVar = this.c;
        if (rVar != null) {
            rVar.e();
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements com.subao.common.c, Iterable<Map.Entry<String, String>> {

        /* renamed from: a, reason: collision with root package name */
        public final String f6046a;
        public final long b;
        private final Map<String, String> c;

        public a(String str, Map<String, String> map) {
            this(str, System.currentTimeMillis() / 1000, map);
        }

        public a(String str, long j, Map<String, String> map) {
            this.f6046a = str;
            this.b = j;
            this.c = map;
        }

        private static boolean a(Map<String, String> map, Map<String, String> map2) {
            if (map == null) {
                return map2 == null;
            }
            if (map2 == null || map.size() != map2.size()) {
                return false;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!com.subao.common.e.a(entry.getValue(), map2.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }

        public int a() {
            Map<String, String> map = this.c;
            if (map == null) {
                return 0;
            }
            return map.size();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && com.subao.common.e.a(this.f6046a, aVar.f6046a) && a(this.c, aVar.c);
        }

        @Override // java.lang.Iterable
        public Iterator<Map.Entry<String, String>> iterator() {
            Map<String, String> map = this.c;
            if (map != null) {
                return map.entrySet().iterator();
            }
            return new Iterator<Map.Entry<String, String>>() { // from class: com.subao.common.i.n.a.1
                @Override // java.util.Iterator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry<String, String> next() {
                    return null;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return false;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            };
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.f6046a);
            jsonWriter.name("time").value(this.b);
            int a2 = a();
            if (a2 > 0) {
                jsonWriter.name("paras");
                jsonWriter.beginArray();
                Iterator<Map.Entry<String, String>> it = iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    jsonWriter.beginObject();
                    if (a2 > 1) {
                        jsonWriter.name("key").value(next.getKey());
                    }
                    jsonWriter.name("value").value(next.getValue());
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
    }

    public String toString() {
        Locale locale = com.subao.common.e.r.f6001a;
        Object[] objArr = new Object[1];
        List<a> list = this.d;
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        return String.format(locale, "[Message_Event: count=%d]", objArr);
    }
}
