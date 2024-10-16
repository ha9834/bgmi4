package com.vk.api.sdk.auth;

import com.facebook.internal.NativeProtocol;
import com.tencent.midas.http.midashttp.IAPMidasEncodeKeyType;
import com.vk.api.sdk.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0221a f6858a = new C0221a(null);
    private static final List<String> k = j.b("access_token", "expires_in", "user_id", IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET, "https_required", "created", "vk_access_token", "email", "phone", "phone_access_key");
    private final int b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;
    private final long j;

    public a(Map<String, String> map) {
        long currentTimeMillis;
        long j;
        h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        String str = map.get("user_id");
        Integer valueOf = str == null ? null : Integer.valueOf(Integer.parseInt(str));
        h.a(valueOf);
        this.b = valueOf.intValue();
        String str2 = map.get("access_token");
        h.a((Object) str2);
        this.c = str2;
        this.d = map.get(IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET);
        this.i = h.a((Object) "1", (Object) map.get("https_required"));
        if (map.containsKey("created")) {
            String str3 = map.get("created");
            h.a((Object) str3);
            currentTimeMillis = Long.parseLong(str3);
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        this.e = currentTimeMillis;
        if (map.containsKey("expires_in")) {
            String str4 = map.get("expires_in");
            h.a((Object) str4);
            j = Long.parseLong(str4);
        } else {
            j = -1;
        }
        this.j = j;
        this.f = map.containsKey("email") ? map.get("email") : null;
        this.g = map.containsKey("phone") ? map.get("phone") : null;
        this.h = map.containsKey("phone_access_key") ? map.get("phone_access_key") : null;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        long j = this.j;
        return j <= 0 || this.e + (j * ((long) 1000)) > System.currentTimeMillis();
    }

    public final void a(m mVar) {
        h.b(mVar, "storage");
        for (Map.Entry<String, String> entry : f().entrySet()) {
            mVar.b(entry.getKey(), entry.getValue());
        }
    }

    private final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.c);
        hashMap.put(IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET, this.d);
        hashMap.put("https_required", this.i ? "1" : "0");
        hashMap.put("created", String.valueOf(this.e));
        hashMap.put("expires_in", String.valueOf(this.j));
        hashMap.put("user_id", String.valueOf(this.b));
        hashMap.put("email", this.f);
        hashMap.put("phone", this.g);
        hashMap.put("phone_access_key", this.h);
        return hashMap;
    }

    /* renamed from: com.vk.api.sdk.auth.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0221a {
        public /* synthetic */ C0221a(f fVar) {
            this();
        }

        private C0221a() {
        }

        public final List<String> a() {
            return a.k;
        }

        public final void a(m mVar) {
            h.b(mVar, "keyValueStorage");
            Iterator<T> it = a().iterator();
            while (it.hasNext()) {
                mVar.b((String) it.next());
            }
        }

        public final a b(m mVar) {
            h.b(mVar, "keyValueStorage");
            HashMap hashMap = new HashMap(a().size());
            for (String str : a()) {
                String a2 = mVar.a(str);
                if (a2 != null) {
                    hashMap.put(str, a2);
                }
            }
            if (hashMap.containsKey("access_token") && hashMap.containsKey("user_id")) {
                return new a(hashMap);
            }
            return null;
        }
    }
}
