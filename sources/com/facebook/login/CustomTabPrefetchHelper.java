package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.a;
import androidx.browser.customtabs.b;
import androidx.browser.customtabs.d;
import androidx.browser.customtabs.e;

/* loaded from: classes.dex */
public class CustomTabPrefetchHelper extends d {
    private static b client;
    private static e session;

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    private static void prepareSession() {
        b bVar;
        if (session != null || (bVar = client) == null) {
            return;
        }
        session = bVar.a((a) null);
    }

    public static void mayLaunchUrl(Uri uri) {
        if (session == null) {
            prepareSession();
        }
        e eVar = session;
        if (eVar != null) {
            eVar.a(uri, null, null);
        }
    }

    public static e getPreparedSessionOnce() {
        e eVar = session;
        session = null;
        return eVar;
    }

    @Override // androidx.browser.customtabs.d
    public void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
        client = bVar;
        client.a(0L);
        prepareSession();
    }
}
