package com.tencent.mid.a;

import android.content.Context;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f extends e {
    @Override // com.tencent.mid.a.e
    protected int a() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        super(context);
    }

    private String a(String str) {
        return !Util.isEmpty(str) ? str : "-";
    }

    @Override // com.tencent.mid.a.e
    protected void b(JSONObject jSONObject) {
        jSONObject.put("mid", "0");
        jSONObject.put(MidEntity.TAG_IMEI, a(CustomDeviceInfos.getDeviceId(this.f6251a)));
        jSONObject.put(MidEntity.TAG_IMSI, a(CustomDeviceInfos.getImsi(this.f6251a)));
        jSONObject.put(MidEntity.TAG_MAC, a(CustomDeviceInfos.getMacAddress(this.f6251a)));
        jSONObject.put("ts", System.currentTimeMillis() / 1000);
        MidEntity a2 = g.a(this.f6251a);
        if (a2 != null && a2.isMidValid()) {
            jSONObject.put("mid", a2.getMid());
        }
        String b = com.tencent.mid.b.g.a(this.f6251a).b();
        if (Util.isMidValid(b)) {
            jSONObject.put(MidConstants.NEW_MID_TAG, b);
        } else {
            jSONObject.put(MidConstants.NEW_MID_TAG, "0");
        }
        try {
            new com.tencent.mid.util.c(this.f6251a).a(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
