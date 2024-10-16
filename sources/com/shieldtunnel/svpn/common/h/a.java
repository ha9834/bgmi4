package com.shieldtunnel.svpn.common.h;

import android.text.TextUtils;
import android.util.JsonWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements com.shieldtunnel.svpn.common.a, Iterable<Map.Entry<String, String>> {

    /* renamed from: a, reason: collision with root package name */
    public final String f5832a;
    public final long b;
    private final Map<String, String> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.shieldtunnel.svpn.common.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0153a implements Iterator<Map.Entry<String, String>> {
        C0153a(a aVar) {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<String, String> next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }
    }

    public a(String str, long j, Map<String, String> map) {
        this.f5832a = str;
        this.b = j;
        this.c = map;
    }

    public static a a(String str, long j, String str2) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str2)) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", str2);
            hashMap = hashMap2;
        }
        return new a(str, j, hashMap);
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
        return this.b == aVar.b && com.shieldtunnel.svpn.common.c.a(this.f5832a, aVar.f5832a) && com.shieldtunnel.svpn.common.c.a(this.c, aVar.c);
    }

    public int hashCode() {
        int hashCode = this.f5832a.hashCode() ^ ((int) this.b);
        Map<String, String> map = this.c;
        return map != null ? hashCode ^ map.hashCode() : hashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<String, String>> iterator() {
        Map<String, String> map = this.c;
        if (map != null) {
            return map.entrySet().iterator();
        }
        return new C0153a(this);
    }

    @Override // com.shieldtunnel.svpn.common.a
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("id").value(this.f5832a);
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

    public int a() {
        Map<String, String> map = this.c;
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
