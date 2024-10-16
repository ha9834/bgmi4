package com.b.a;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.helpshift.Core;
import com.helpshift.HelpshiftBridge;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.exceptions.InstallException;
import com.helpshift.support.Support;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Activity f997a;
    private static Service b;

    public static void a(Activity activity) {
        Log.d("GPCHelpshiftBridge", "init()");
        f997a = activity;
    }

    public static void a() {
        Log.d("GPCHelpshiftBridge", "install()");
        try {
            Context context = f997a != null ? f997a : b;
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String string = applicationInfo.metaData.getString("com.gpc.helpshift.HelpshiftAppKey");
            String string2 = applicationInfo.metaData.getString("com.gpc.helpshift.HelpshiftDomainName");
            String string3 = applicationInfo.metaData.getString("com.gpc.helpshift.HelpshiftAppId");
            HashMap hashMap = new HashMap();
            hashMap.put("enableLogging", true);
            hashMap.put(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION, true);
            if (f997a != null) {
                HelpshiftBridge.install(f997a, string, string2, string3, hashMap);
            } else {
                Core.init(Support.getInstance());
                Core.install(b.getApplication(), string, string2, string3, hashMap);
            }
            Log.d("GPCHelpshiftBridge", "HelpshiftBridge install");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (InstallException unused) {
            Log.d("GPCHelpshiftBridge", "Invalid install credentials");
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }
}
