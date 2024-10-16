package com.tencent.msdk.stat.a;

import android.content.Context;
import com.tencent.msdk.stat.StatServiceImpl;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: a, reason: collision with root package name */
    protected c f6289a;
    private long p;

    public b(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f6289a = new c();
        this.p = -1L;
        this.f6289a.f6290a = str;
    }

    private void h() {
        Properties commonKeyValueForKVEvent;
        if (this.f6289a.f6290a == null || (commonKeyValueForKVEvent = StatServiceImpl.getCommonKeyValueForKVEvent(this.f6289a.f6290a)) == null || commonKeyValueForKVEvent.size() <= 0) {
            return;
        }
        if (this.f6289a.c == null || this.f6289a.c.length() == 0) {
            this.f6289a.c = new JSONObject(commonKeyValueForKVEvent);
            return;
        }
        for (Map.Entry entry : commonKeyValueForKVEvent.entrySet()) {
            try {
                this.f6289a.c.put(entry.getKey().toString(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.msdk.stat.a.d
    public e a() {
        return e.CUSTOM;
    }

    public void a(long j) {
        this.p = j;
    }

    @Override // com.tencent.msdk.stat.a.d
    public boolean a(JSONObject jSONObject) {
        String str;
        Object obj;
        jSONObject.put("ei", this.f6289a.f6290a);
        long j = this.p;
        if (j > 0) {
            jSONObject.put("du", j);
        }
        if (this.f6289a.b == null) {
            h();
            str = "kv";
            obj = this.f6289a.c;
        } else {
            str = "ar";
            obj = this.f6289a.b;
        }
        jSONObject.put(str, obj);
        return true;
    }

    public c b() {
        return this.f6289a;
    }
}
