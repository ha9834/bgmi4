package com.huawei.game.gamekit.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5463a = "DownstreamTranslatorFactory";
    private static final int b = 0;
    private static final int c = 9999;

    @Override // com.huawei.game.gamekit.a.g
    public final e a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return c.a();
        }
        try {
            int i = new JSONObject(str).getInt("MessageType");
            if (i < 0 || i > 9999) {
                com.huawei.game.gamekit.b.c.b(f5463a, "Do not translate MessageTypeID: " + i);
                return c.a();
            }
            com.huawei.game.gamekit.b.c.a(f5463a, "GameDeliver message: " + i);
            return d.a();
        } catch (JSONException unused) {
            com.huawei.game.gamekit.b.c.d(f5463a, "getManager JSONObject operation exception");
            return c.a();
        }
    }
}
