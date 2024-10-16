package com.tencent.mid.a;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    protected Context f6251a;

    protected abstract int a();

    protected abstract void b(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
        this.f6251a = null;
        this.f6251a = context.getApplicationContext();
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("et", a());
        b(jSONObject);
        return jSONObject;
    }
}
