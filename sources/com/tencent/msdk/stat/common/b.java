package com.tencent.msdk.stat.common;

import android.content.Context;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static d f6319a;
    private static StatLogger d = j.b();
    private static JSONObject e = new JSONObject();
    Integer b;
    String c;

    public b(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.b = null;
        this.c = null;
        try {
            a(context, statSpecifyReportedInfo);
            this.b = j.l(context.getApplicationContext());
            this.c = com.tencent.msdk.stat.a.a(context).b();
        } catch (Throwable th) {
            d.e(th);
        }
    }

    static synchronized d a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        d dVar;
        synchronized (b.class) {
            if (f6319a == null) {
                f6319a = new d(context.getApplicationContext(), statSpecifyReportedInfo);
            }
            dVar = f6319a;
        }
        return dVar;
    }

    public static void a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : new HashMap(map).entrySet()) {
            e.put((String) entry.getKey(), entry.getValue());
        }
    }

    public void a(JSONObject jSONObject, Thread thread) {
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f6319a != null) {
                f6319a.a(jSONObject2, thread);
            }
            p.a(jSONObject2, "cn", this.c);
            if (this.b != null) {
                jSONObject2.put("tn", this.b);
            }
            if (thread == null) {
                str = "ev";
                str2 = jSONObject2;
            } else {
                str = "errkv";
                str2 = jSONObject2.toString();
            }
            jSONObject.put(str, str2);
            if (e == null || e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", e);
        } catch (Throwable th) {
            d.e(th);
        }
    }
}
