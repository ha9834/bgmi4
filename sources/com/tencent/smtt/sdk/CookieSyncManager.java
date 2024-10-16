package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class CookieSyncManager {

    /* renamed from: a, reason: collision with root package name */
    private static android.webkit.CookieSyncManager f6419a;
    private static CookieSyncManager b;
    private static boolean c;

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            f6419a = android.webkit.CookieSyncManager.createInstance(context);
            if (b == null || !c) {
                b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (b == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = b;
        }
        return cookieSyncManager;
    }

    private CookieSyncManager(Context context) {
        r a2 = r.a();
        if (a2 == null || !r.b()) {
            return;
        }
        a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        c = true;
    }

    public void sync() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        } else {
            f6419a.sync();
        }
    }

    public void stopSync() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        } else {
            f6419a.stopSync();
        }
    }

    public void startSync() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        f6419a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f6419a)).setUncaughtExceptionHandler(new d());
        } catch (Exception unused) {
        }
    }
}
