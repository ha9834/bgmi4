package com.intlgame.webview;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.intlgame.foundation.INTLLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes2.dex */
public class WebViewProxy extends WebView {
    public WebViewProxy(Context context) {
        super(context);
        init();
    }

    public WebViewProxy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th) {
            INTLLog.e(th.getMessage());
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewClassic");
            Method method = cls.getMethod("fromWebView", WebView.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, this);
            if (invoke != null) {
                Field declaredField = cls.getDeclaredField("mListBoxDialog");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj != null) {
                    Dialog dialog = (Dialog) obj;
                    dialog.setOnCancelListener(null);
                    Class<?> cls2 = Class.forName("android.app.Dialog");
                    Field declaredField2 = cls2.getDeclaredField("CANCEL");
                    declaredField2.setAccessible(true);
                    int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                    Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                    declaredField3.setAccessible(true);
                    ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                }
            }
        } catch (Exception e) {
            INTLLog.e(e.getMessage());
        }
        try {
            Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            declaredField4.setAccessible(true);
            ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
            if (componentCallbacks != null) {
                declaredField4.set(null, null);
                Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                declaredField5.setAccessible(true);
                Object obj2 = declaredField5.get(null);
                if (obj2 != null) {
                    List list = (List) obj2;
                    synchronized (list) {
                        list.remove(componentCallbacks);
                    }
                }
            }
        } catch (Exception e2) {
            INTLLog.e(e2.getMessage());
        }
    }
}
