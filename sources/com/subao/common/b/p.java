package com.subao.common.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, o> f5934a = new HashMap(2);

    public void a(String str, o oVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f5934a) {
            if (oVar == null) {
                this.f5934a.remove(str);
            } else {
                this.f5934a.put(str, oVar);
            }
        }
    }

    public o a(String str) {
        o oVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f5934a) {
            oVar = this.f5934a.get(str);
        }
        return oVar;
    }
}
