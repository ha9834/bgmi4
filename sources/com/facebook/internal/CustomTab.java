package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.c;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;

/* loaded from: classes.dex */
public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        this.uri = getURIForAction(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri getURIForAction(String str, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(CustomTab.class)) {
            return null;
        }
        try {
            return Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTab.class);
            return null;
        }
    }

    public boolean openCustomTab(Activity activity, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            c a2 = new c.a(CustomTabPrefetchHelper.getPreparedSessionOnce()).a();
            a2.f400a.setPackage(str);
            a2.f400a.addFlags(1073741824);
            try {
                a2.a(activity, this.uri);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
