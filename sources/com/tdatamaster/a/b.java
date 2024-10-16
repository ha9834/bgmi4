package com.tdatamaster.a;

import android.content.Context;
import android.util.Log;
import java.util.Map;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f6151a = new b();
    private Map<String, Object> b;
    private com.tdatamaster.a.a c;

    /* loaded from: classes2.dex */
    public interface a {
        void onResult(int i, Object obj);
    }

    private b() {
    }

    public static b a() {
        return f6151a;
    }

    public b a(Map<String, Object> map) {
        this.b = map;
        this.c = new com.tdatamaster.a.a(map);
        return f6151a;
    }

    public void a(Context context, a aVar) {
        com.tdatamaster.a.a aVar2 = this.c;
        if (aVar2 == null) {
            b("init beacon first, set Configs");
        } else {
            aVar2.b(context, aVar);
        }
    }

    public void b(Context context, a aVar) {
        com.tdatamaster.a.a aVar2 = this.c;
        if (aVar2 == null) {
            b("init beacon first, set Configs");
        } else {
            aVar2.c(context, aVar);
        }
    }

    public static void a(String str) {
        if (a().b != null && (a().b.get("TEST_MODE") instanceof Boolean)) {
            if (Boolean.TRUE.equals((Boolean) a().b.get("TEST_MODE"))) {
                Log.d("TDMQimei", str);
            }
        }
    }

    public static void b(String str) {
        Log.e("TDMQimei", str);
    }
}
