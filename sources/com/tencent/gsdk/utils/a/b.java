package com.tencent.gsdk.utils.a;

import android.content.Context;
import java.util.Map;

/* loaded from: classes2.dex */
final class b extends a {
    public String toString() {
        return "BeaconReporterImpl{}";
    }

    @Override // com.tencent.gsdk.utils.a.a
    boolean b(Context context, String str) {
        return i.a(str) && i.a(context.getApplicationContext());
    }

    @Override // com.tencent.gsdk.utils.a.a
    boolean b(String str, Map<String, String> map) {
        return i.a(str, true, 0L, -1L, map, true);
    }
}
