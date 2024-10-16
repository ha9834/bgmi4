package com.tencent.hawk.bridge;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LifeCycleMgr {
    private static List<ActivityStatusChangedInterface> sActivityStatusChangedList = null;
    private static Application.ActivityLifecycleCallbacks sCallbacks = null;
    public static volatile boolean sIsForeground = true;

    public static void addNotifier(ActivityStatusChangedInterface activityStatusChangedInterface) {
        if (!CC.getStrategy().isLifecycleEnabled) {
            HawkLogger.e("addNotifier: LifeCycle is disabled");
            return;
        }
        synchronized (sActivityStatusChangedList) {
            sActivityStatusChangedList.add(activityStatusChangedInterface);
        }
    }

    @TargetApi(14)
    public static void registerLifeCycle(Context context, List<ActivityStatusChangedInterface> list) {
        Application application;
        sActivityStatusChangedList = list;
        if (!CC.getStrategy().isLifecycleEnabled) {
            HawkLogger.e("registerLifeCycle: LifeCycle is disabled");
            return;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (context.getApplicationContext() instanceof Application) {
            HawkLogger.d("Get ApplicationContext");
            application = (Application) context.getApplicationContext();
        } else {
            application = null;
        }
        if (application == null) {
            HawkLogger.e("Get ApplicationContext error, lifecycle register failed");
            return;
        }
        if (sCallbacks == null) {
            sCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.hawk.bridge.LifeCycleMgr.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    HawkLogger.d("======Stopped: " + activity.getComponentName());
                    HawkNative.postFbStatus(6, "stopped");
                    HawkLogger.d("=========Stopped processed");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    HawkLogger.d("=======created: " + activity.getComponentName());
                    HawkNative.postFbStatus(1, "created");
                    HawkLogger.d("=========created processed");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    HawkLogger.d("=========started: " + activity.getComponentName());
                    HawkNative.postFbStatus(2, "started");
                    HawkLogger.d("=========started processed");
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    HawkLogger.d("=========resumed: " + activity.getComponentName());
                    HawkNative.postFbStatus(3, "resumed");
                    synchronized (LifeCycleMgr.sActivityStatusChangedList) {
                        if (LifeCycleMgr.sActivityStatusChangedList != null) {
                            Iterator it = LifeCycleMgr.sActivityStatusChangedList.iterator();
                            while (it.hasNext()) {
                                ((ActivityStatusChangedInterface) it.next()).foreground();
                            }
                        }
                    }
                    HawkLogger.d("=========resumed processed");
                    LifeCycleMgr.sIsForeground = true;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    HawkLogger.d("=========paused: " + activity.getComponentName());
                    HawkNative.postFbStatus(4, "paused");
                    synchronized (LifeCycleMgr.sActivityStatusChangedList) {
                        if (LifeCycleMgr.sActivityStatusChangedList != null) {
                            Iterator it = LifeCycleMgr.sActivityStatusChangedList.iterator();
                            while (it.hasNext()) {
                                ((ActivityStatusChangedInterface) it.next()).backgroud();
                            }
                        }
                    }
                    HawkLogger.d("=========paused processed");
                    LifeCycleMgr.sIsForeground = false;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    HawkLogger.d("====destroyed====: " + activity.getComponentName());
                    HawkNative.postFbStatus(5, "destroyed");
                    HawkLogger.d("====destroyed processed====");
                }
            };
        }
        try {
            application.unregisterActivityLifecycleCallbacks(sCallbacks);
            application.registerActivityLifecycleCallbacks(sCallbacks);
        } catch (Exception e) {
            HawkLogger.e("register lifecycle error: " + e.getMessage());
        }
    }
}
