package com.tencent.mtt.spcialcall;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mtt.spcialcall.sdk.WebViewProxy;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class JsUtils {
    private static final String TAG = "JsUtils";

    public static String generateJs(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("var ");
        sb.append(str);
        sb.append("={};");
        try {
            Class<?> cls = Class.forName("java.lang.Object");
            for (Method method : obj.getClass().getMethods()) {
                if (method.getDeclaringClass() != cls) {
                    String name = method.getName();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!checkParameterType(parameterTypes)) {
                        Log.w(TAG, "Only string parameters are supported!");
                    } else {
                        sb.append(generateJs(str, name, parameterTypes.length));
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            Log.w(TAG, e);
            return null;
        }
    }

    private static boolean checkParameterType(Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!"java.lang.String".equals(cls.getName())) {
                return false;
            }
        }
        return true;
    }

    private static String generateJs(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            sb.append("$");
            sb.append(0);
            for (int i2 = 1; i2 < i; i2++) {
                sb.append(",");
                sb.append("$");
                sb.append(i2);
            }
        }
        return str + '.' + str2 + "=function(" + ((CharSequence) sb) + "){return mttsp_exec('" + str + "','" + str2 + "',[" + ((CharSequence) sb) + "]);};";
    }

    public static String exec(WebViewProxy webViewProxy, String str, String str2, JSONArray jSONArray) {
        Object javascriptInterface = webViewProxy.getJavascriptInterface(str);
        String str3 = null;
        if (javascriptInterface == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("java.lang.String");
            int length = jSONArray.length();
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = cls;
            }
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArray.getString(i2);
            }
            Object invoke = javascriptInterface.getClass().getMethod(str2, clsArr).invoke(javascriptInterface, strArr);
            if (invoke == null) {
                return null;
            }
            str3 = invoke.toString();
            return str3;
        } catch (Exception e) {
            Log.w(TAG, e);
            return str3;
        }
    }
}
