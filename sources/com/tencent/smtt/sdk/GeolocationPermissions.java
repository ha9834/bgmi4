package com.tencent.smtt.sdk;

import java.util.Set;

/* loaded from: classes2.dex */
public class GeolocationPermissions {

    /* renamed from: a, reason: collision with root package name */
    private static GeolocationPermissions f6421a;

    public static GeolocationPermissions getInstance() {
        return a();
    }

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (f6421a == null) {
                f6421a = new GeolocationPermissions();
            }
            geolocationPermissions = f6421a;
        }
        return geolocationPermissions;
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().b(valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().c(str, valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        }
    }

    public void clear(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().f(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        }
    }

    public void allow(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().g(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        }
    }

    public void clearAll() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().l();
        } else {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        }
    }
}
