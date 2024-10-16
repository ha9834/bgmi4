package com.huawei.game.gamekit.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, Map<String, String>> f5461a = new HashMap();

    /* renamed from: com.huawei.game.gamekit.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0132a {

        /* renamed from: a, reason: collision with root package name */
        String f5462a;
        Object b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a(String str, Object obj) {
            this.f5462a = str;
            this.b = obj;
        }

        private String a() {
            return this.f5462a;
        }

        private Object b() {
            return this.b;
        }
    }

    private String a(String str, String str2) {
        Map<String, String> a2 = a(str);
        if (a2.containsKey(str2)) {
            return a2.get(str2);
        }
        return null;
    }

    public final C0132a a(String str, C0132a c0132a) {
        Object a2;
        String str2 = c0132a.f5462a;
        Map<String, String> a3 = a(str);
        String str3 = a3.containsKey(str2) ? a3.get(str2) : null;
        if (TextUtils.isEmpty(str3) || (a2 = a(c0132a.f5462a, c0132a.b)) == null) {
            return null;
        }
        return new C0132a(str3, a2);
    }

    public Object a(String str, Object obj) {
        return obj;
    }

    public Map<String, String> a(String str) {
        if (!this.f5461a.containsKey(str)) {
            str = com.huawei.game.gamekit.b.a.f5471a;
        }
        return this.f5461a.get(str);
    }
}
