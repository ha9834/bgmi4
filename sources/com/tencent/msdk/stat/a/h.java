package com.tencent.msdk.stat.a;

import android.content.Context;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.common.j;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.msdk.stat.common.b f6295a;
    private JSONObject p;

    public h(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.p = null;
        this.f6295a = new com.tencent.msdk.stat.common.b(context, statSpecifyReportedInfo);
        this.p = jSONObject;
    }

    @Override // com.tencent.msdk.stat.a.d
    public e a() {
        return e.SESSION_ENV;
    }

    @Override // com.tencent.msdk.stat.a.d
    public boolean a(JSONObject jSONObject) {
        if (this.e != null) {
            jSONObject.put("ut", this.e.d());
        }
        JSONObject jSONObject2 = this.p;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (j.x(this.n)) {
            jSONObject.put("ncts", 1);
        }
        this.f6295a.a(jSONObject, (Thread) null);
        return true;
    }
}
