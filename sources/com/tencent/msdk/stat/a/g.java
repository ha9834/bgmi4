package com.tencent.msdk.stat.a;

import android.content.Context;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.common.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: a, reason: collision with root package name */
    Long f6294a;
    String p;
    String q;

    public g(Context context, String str, String str2, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f6294a = null;
        this.q = str;
        this.p = str2;
        this.f6294a = l;
    }

    @Override // com.tencent.msdk.stat.a.d
    public e a() {
        return e.PAGE_VIEW;
    }

    @Override // com.tencent.msdk.stat.a.d
    public boolean a(JSONObject jSONObject) {
        p.a(jSONObject, "pi", this.p);
        p.a(jSONObject, "rf", this.q);
        Long l = this.f6294a;
        if (l == null) {
            return true;
        }
        jSONObject.put("du", l);
        return true;
    }
}
