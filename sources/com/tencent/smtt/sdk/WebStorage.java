package com.tencent.smtt.sdk;

import java.util.Map;

/* loaded from: classes2.dex */
public class WebStorage {

    /* renamed from: a, reason: collision with root package name */
    private static WebStorage f6487a;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a(valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().b(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a(str, j);
        } else {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        }
    }

    public void deleteOrigin(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().e(str);
        } else {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public void deleteAllData() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().k();
        } else {
            android.webkit.WebStorage.getInstance().deleteAllData();
        }
    }

    public static WebStorage getInstance() {
        return a();
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (f6487a == null) {
                f6487a = new WebStorage();
            }
            webStorage = f6487a;
        }
        return webStorage;
    }
}
