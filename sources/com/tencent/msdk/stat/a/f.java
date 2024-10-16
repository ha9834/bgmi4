package com.tencent.msdk.stat.a;

import android.content.Context;
import com.tencent.msdk.stat.StatConfig;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import com.tencent.msdk.stat.common.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a, reason: collision with root package name */
    public static final StatSpecifyReportedInfo f6293a = new StatSpecifyReportedInfo();

    static {
        f6293a.setAppKey("A9VH9B8L4GX4");
    }

    public f(Context context) {
        super(context, 0, f6293a);
    }

    @Override // com.tencent.msdk.stat.a.d
    public e a() {
        return e.NETWORK_DETECTOR;
    }

    @Override // com.tencent.msdk.stat.a.d
    public boolean a(JSONObject jSONObject) {
        p.a(jSONObject, "actky", StatConfig.getAppKey(this.n));
        return true;
    }
}
