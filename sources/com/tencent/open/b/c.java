package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f6368a;

    public c(Bundle bundle) {
        this.f6368a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f6368a.put(str, bundle.getString(str));
            }
        }
    }

    public c(HashMap<String, String> hashMap) {
        this.f6368a = new HashMap<>(hashMap);
    }

    public String toString() {
        return "BaseData{time=" + this.f6368a.get("time") + ", name=" + this.f6368a.get("interface_name") + '}';
    }
}
