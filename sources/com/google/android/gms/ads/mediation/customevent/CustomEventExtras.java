package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Object> f1177a = new HashMap<>();

    public final Object getExtra(String str) {
        return this.f1177a.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.f1177a.put(str, obj);
    }
}
