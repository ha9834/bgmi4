package com.tencent.gsdk.utils.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class a implements d {
    abstract boolean b(Context context, String str);

    abstract boolean b(String str, Map<String, String> map);

    @Override // com.tencent.gsdk.utils.a.d
    public boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return b(context, str);
    }

    @Override // com.tencent.gsdk.utils.a.d
    public boolean a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return false;
        }
        return b(str, map);
    }
}
