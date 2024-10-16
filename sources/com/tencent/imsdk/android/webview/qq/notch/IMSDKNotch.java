package com.tencent.imsdk.android.webview.qq.notch;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.webkit.JavascriptInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.webview.qq.notch.INotch;
import com.tencent.imsdk.android.webview.qq.notch.impl.AndroidNotch;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKNotch {
    private static Activity activity;
    private static DisplayCutout displayCutout;
    private static INotch instance;
    private static String jsonNotchInfoList;
    private static boolean notchUsed;

    /* loaded from: classes.dex */
    public enum NotchStatus {
        DEFAULT,
        USING,
        NEVER
    }

    public static INotch getInstance() {
        synchronized (IMSDKNotch.class) {
            if (instance == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    instance = new AndroidNotch();
                } else {
                    instance = new AndroidNotch();
                }
            }
        }
        return instance;
    }

    public static boolean init(Activity activity2) {
        activity = activity2;
        notchUsed = false;
        return activity != null;
    }

    public static void setDisplayCutout(DisplayCutout displayCutout2) {
        displayCutout = displayCutout2;
        jsonNotchInfoList = null;
        getNotchInfoList();
    }

    public static DisplayCutout getDisplayCutout() {
        return displayCutout;
    }

    @JavascriptInterface
    public static boolean hasNotch() {
        return getInstance().hasNotch(activity);
    }

    @JavascriptInterface
    public static void useNotch() {
        getInstance().useNotch(activity);
        notchUsed = true;
    }

    @JavascriptInterface
    public static void cancelUseNotch() {
        getInstance().cancelUsingNotch(activity);
        notchUsed = false;
    }

    @JavascriptInterface
    public static boolean notchUsed() {
        return notchUsed;
    }

    @JavascriptInterface
    public static String getNotchInfoList() {
        String str = jsonNotchInfoList;
        if (str != null && str.length() > 0) {
            return jsonNotchInfoList;
        }
        getInstance().getNotchInfo(activity, new INotch.NotchInfoCallback() { // from class: com.tencent.imsdk.android.webview.qq.notch.IMSDKNotch.1
            @Override // com.tencent.imsdk.android.webview.qq.notch.INotch.NotchInfoCallback
            public void onResult(List<Rect> list) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (Rect rect : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, rect.left);
                        jSONObject.put("right", rect.right);
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect.top);
                        jSONObject.put("bottom", rect.bottom);
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, rect.width());
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, rect.height());
                        jSONArray.put(jSONObject);
                    }
                    String unused = IMSDKNotch.jsonNotchInfoList = jSONArray.toString();
                    IMLogger.d("Notch info : " + IMSDKNotch.jsonNotchInfoList);
                } catch (Throwable unused2) {
                }
            }
        });
        return "[]";
    }
}
