package com.tencent.imsdk.android.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.imsdk.android.base.interfaces.ILifeMonitor;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class IMSDKLifeMonitor {
    public static final String DEFAULT_PACKAGE_NAME_LIFE_CYCLE_FORMAT = "com.tencent.imsdk.android.common.%s.%sLifeMonitor";
    private static boolean isPreRegisterLoaded;
    private static List<ILifeMonitor> lifeChanges = new CopyOnWriteArrayList();

    public static void addActivityLifeMonitor(ILifeMonitor iLifeMonitor) {
        lifeChanges.add(iLifeMonitor);
    }

    public static void onStart() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public static void onRestart() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onRestart();
        }
    }

    public static void onActivityResult(int i, int i2, Intent intent) {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    public static void onResume() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public static void onPause() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public static void onStop() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public static void onDestroy() {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        lifeChanges.clear();
    }

    public static void onCreate(Bundle bundle, Activity activity, String... strArr) {
        T.setGlobalActivityUpToDate(activity);
        if (!isPreRegisterLoaded && strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                try {
                    String format = String.format(DEFAULT_PACKAGE_NAME_LIFE_CYCLE_FORMAT, str.toLowerCase(), str);
                    IMLogger.d(format + " loaded");
                    Class.forName(format);
                    isPreRegisterLoaded = true;
                } catch (ClassNotFoundException e) {
                    IMLogger.e(e.getMessage(), new Object[0]);
                    isPreRegisterLoaded = false;
                }
            }
        }
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onCreate(bundle);
        }
    }

    public static void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
    }

    public static void onNewIntent(Intent intent) {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onNewIntent(intent);
        }
    }

    public static void onRestoreInstanceState(Bundle bundle) {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onRestoreInstanceState(bundle);
        }
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Iterator<ILifeMonitor> it = lifeChanges.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
