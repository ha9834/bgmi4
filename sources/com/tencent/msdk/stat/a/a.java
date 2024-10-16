package com.tencent.msdk.stat.a;

import android.content.Context;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.common.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.msdk.stat.f f6288a;

    public a(Context context, int i, com.tencent.msdk.stat.f fVar, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f6288a = null;
        this.f6288a = fVar;
    }

    @Override // com.tencent.msdk.stat.a.d
    public e a() {
        return e.ADDITION;
    }

    @Override // com.tencent.msdk.stat.a.d
    public boolean a(JSONObject jSONObject) {
        p.a(jSONObject, "qq", this.f6288a.b());
        jSONObject.put("acc", this.f6288a.a());
        return true;
    }
}
