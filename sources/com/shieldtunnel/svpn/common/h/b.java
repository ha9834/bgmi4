package com.shieldtunnel.svpn.common.h;

import android.util.JsonWriter;
import com.shieldtunnel.svpn.common.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b implements com.shieldtunnel.svpn.common.a, Iterable<com.shieldtunnel.svpn.common.h.a> {

    /* renamed from: a, reason: collision with root package name */
    public final com.shieldtunnel.svpn.common.f.d f5833a;
    public final d b;
    private List<com.shieldtunnel.svpn.common.h.a> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Iterator<com.shieldtunnel.svpn.common.h.a> {
        a(b bVar) {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.shieldtunnel.svpn.common.h.a next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }
    }

    public b(com.shieldtunnel.svpn.common.f.d dVar, d dVar2) {
        this.f5833a = dVar;
        this.b = dVar2;
    }

    public void a(com.shieldtunnel.svpn.common.h.a aVar) {
        if (this.c == null) {
            this.c = new ArrayList(2);
        }
        this.c.add(aVar);
    }

    @Override // java.lang.Iterable
    public Iterator<com.shieldtunnel.svpn.common.h.a> iterator() {
        List<com.shieldtunnel.svpn.common.h.a> list = this.c;
        if (list != null) {
            return list.iterator();
        }
        return new a(this);
    }

    @Override // com.shieldtunnel.svpn.common.a
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("type").value(this.f5833a.a());
        com.shieldtunnel.svpn.common.k.c.a(jsonWriter, "version", this.b);
        if (a()) {
            jsonWriter.name("events");
            jsonWriter.beginArray();
            Iterator<com.shieldtunnel.svpn.common.h.a> it = iterator();
            while (it.hasNext()) {
                it.next().serialize(jsonWriter);
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    public String toString() {
        Locale locale = f.b;
        Object[] objArr = new Object[1];
        List<com.shieldtunnel.svpn.common.h.a> list = this.c;
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        return String.format(locale, "[Message_Event: count=%d]", objArr);
    }

    public boolean a() {
        List<com.shieldtunnel.svpn.common.h.a> list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
