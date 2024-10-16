package com.vk.api.sdk.internal;

import android.net.Uri;
import com.vk.api.sdk.utils.f;
import com.vk.api.sdk.utils.h;
import com.vk.api.sdk.utils.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.w;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.j;
import kotlin.text.l;

/* loaded from: classes3.dex */
public final class c {
    static final /* synthetic */ kotlin.e.e<Object>[] b = {j.a(new PropertyReference1Impl(j.b(c.class), "strBuilder", "getStrBuilder()Ljava/lang/StringBuilder;"))};

    /* renamed from: a, reason: collision with root package name */
    public static final c f6883a = new c();
    private static final f c = h.a(new kotlin.jvm.a.a<StringBuilder>() { // from class: com.vk.api.sdk.internal.QueryStringGenerator$strBuilder$2
        @Override // kotlin.jvm.a.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StringBuilder b() {
            return new StringBuilder();
        }
    });

    private c() {
    }

    private final StringBuilder a() {
        return (StringBuilder) c.a(this, b[0]);
    }

    public final String a(String str, Map<String, String> map, String str2, String str3, String str4, int i) {
        kotlin.jvm.internal.h.b(str, "methodName");
        kotlin.jvm.internal.h.b(map, "methodArgs");
        kotlin.jvm.internal.h.b(str2, "methodVersion");
        return a(this, kotlin.jvm.internal.h.a("/method/", (Object) str), map, str2, str3, str4, i, null, 64, null);
    }

    public static /* synthetic */ String a(c cVar, String str, Map map, String str2, String str3, String str4, int i, Map map2, int i2, Object obj) {
        return cVar.a(str, map, str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? w.a() : map2);
    }

    public final String a(String str, Map<String, String> map, String str2, String str3, String str4, int i, Map<String, ? extends List<String>> map2) {
        kotlin.jvm.internal.h.b(str, "path");
        kotlin.jvm.internal.h.b(map, "args");
        kotlin.jvm.internal.h.b(str2, "version");
        kotlin.jvm.internal.h.b(map2, "arrayArgs");
        Map<String, String> b2 = w.b(map);
        b2.put("v", str2);
        b2.put("https", "1");
        String str5 = str3;
        if (!(str5 == null || str5.length() == 0)) {
            b2.put("access_token", str3);
        } else if (i != 0) {
            b2.put("api_id", String.valueOf(i));
        }
        return a(str, b2, str4, map2);
    }

    public final String a(String str, Map<String, String> map, String str2, Map<String, ? extends List<String>> map2) {
        kotlin.jvm.internal.h.b(str, "path");
        kotlin.jvm.internal.h.b(map, "args");
        kotlin.jvm.internal.h.b(map2, "arrayArgs");
        Uri.Builder builder = new Uri.Builder();
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!kotlin.jvm.internal.h.a(entry.getKey(), (Object) "sig")) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            String str3 = (String) entry2.getKey();
            Iterator it3 = ((List) entry2.getValue()).iterator();
            while (it3.hasNext()) {
                builder.appendQueryParameter(kotlin.jvm.internal.h.a(str3, (Object) "[]"), (String) it3.next());
            }
        }
        Uri build = builder.build();
        String str4 = str2;
        boolean z = true;
        if (str4 == null || str4.length() == 0) {
            String encodedQuery = build.getEncodedQuery();
            return encodedQuery == null ? "" : encodedQuery;
        }
        String query = build.getQuery();
        a().setLength(0);
        StringBuilder a2 = a();
        a2.append(str);
        a2.append('?');
        String str5 = query;
        if (str5 != null && !l.a((CharSequence) str5)) {
            z = false;
        }
        if (!z) {
            a().append(query);
        }
        a().append(str2);
        String sb = a().toString();
        kotlin.jvm.internal.h.a((Object) sb, "strBuilder.toString()");
        String encodedQuery2 = build.buildUpon().appendQueryParameter("sig", l.a.a(sb)).build().getEncodedQuery();
        return encodedQuery2 == null ? "" : encodedQuery2;
    }
}
