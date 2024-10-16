package com.tencent.grobot.lite;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.jni.JNIManager;
import com.tencent.grobot.lite.ui.IM;
import com.tencent.grobot.lite.ui.container.Router;
import com.tencent.grobot.lite.ui.container.RouterCompat;
import com.unity3d.player.UnityPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GRobotEnterManager {
    private static final String TAG = "GRobotEnterManager";
    public static String area = "";
    private static WeakReference<Activity> hostActPtr = null;
    public static String lang = "";

    public static void closeGRobtoView(Activity activity) {
        if (activity == null) {
            activity = getHostActivity();
        }
        if (activity != null) {
            activity.sendBroadcast(new Intent(Const.BROADCAST_ACTION_CLOSE));
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.grobot.lite.GRobotEnterManager.1
                @Override // java.lang.Runnable
                public void run() {
                    GRobotApplication.getInstance().doLastGC();
                }
            });
        }
        onGRobotClose();
    }

    public static void onClose() {
        GRobotApplication.getInstance().onClose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setHostActivity(Activity activity) {
        WeakReference<Activity> weakReference = hostActPtr;
        if (weakReference != null) {
            weakReference.clear();
            hostActPtr = null;
        }
        hostActPtr = new WeakReference<>(activity);
    }

    private static Activity getHostActivity() {
        WeakReference<Activity> weakReference = hostActPtr;
        if (weakReference != null) {
            return weakReference.get();
        }
        try {
            if (Class.forName("com.unity3d.player.UnityPlayer") != null) {
                return UnityPlayer.currentActivity;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startGRobot(String str) {
        Activity hostActivity = getHostActivity();
        if (hostActivity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    parseLang(str);
                } else {
                    lang = "";
                    area = "";
                }
                SharedPreferences.Editor edit = hostActivity.getSharedPreferences(Const.PREFERENCE_NAME, 0).edit();
                edit.putString(Const.GAME_LOCALE_KEY, lang);
                edit.putString(Const.GAME_AREA_KEY, area);
                edit.apply();
            } catch (Exception e) {
                TLog.d(TAG, "startGRobot, parsed lang failed," + e.getMessage());
            }
            GRobotApplication.getInstance().init(hostActivity, str);
            Bundle bundle = new Bundle();
            bundle.putString("grobot_params", str);
            if (GRobotApplication.getInstance().isHighPerformace()) {
                RouterCompat.main(hostActivity, bundle);
            } else {
                Router.jump(hostActivity, IM.class, bundle, false, false);
            }
            onGRobotShow();
            return;
        }
        TLog.d(TAG, "startGRobot failed.");
    }

    public static void parseLang(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("language")) {
                String optString = jSONObject.optString("language", null);
                if (!TextUtils.isEmpty(optString)) {
                    if (optString.startsWith("zh-")) {
                        String[] split = optString.split("zh-");
                        if (split.length == 2) {
                            lang = "zh";
                            area = split[1];
                        }
                    } else if ("zh".equals(optString)) {
                        lang = "zh";
                        area = "CN";
                    } else if ("HK".equals(optString)) {
                        lang = "zh";
                        area = "HK";
                    } else if ("TW".equals(optString)) {
                        lang = "zh";
                        area = "HK";
                    } else if ("en".equals(optString)) {
                        lang = "en";
                        area = "US";
                    } else {
                        lang = optString;
                        area = "";
                    }
                }
            } else {
                lang = "";
                area = "";
            }
        } catch (Exception e) {
            lang = "";
            area = "";
            TLog.d(TAG, "parseLang failed, " + e);
        }
    }

    static void onGRobotClose() {
        JNIManager.onGRobotClose();
    }

    static void onGRobotShow() {
        JNIManager.onGRobotShow();
    }
}
