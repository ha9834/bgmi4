package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

/* loaded from: classes2.dex */
public final class JsContext {

    /* renamed from: a, reason: collision with root package name */
    private final JsVirtualMachine f6422a;
    private final IX5JsContext b;
    private ExceptionHandler c;
    private String d;

    /* loaded from: classes2.dex */
    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine == null) {
            throw new IllegalArgumentException("The virtualMachine value can not be null");
        }
        this.f6422a = jsVirtualMachine;
        this.b = this.f6422a.a();
        try {
            this.b.setPerContextData(this);
        } catch (AbstractMethodError unused) {
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.b.destroy();
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback, URL url) {
        this.b.evaluateJavascript(str, valueCallback, url);
    }

    public JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public JsValue evaluateScript(String str, URL url) {
        IX5JsValue evaluateScript = this.b.evaluateScript(str, url);
        if (evaluateScript == null) {
            return null;
        }
        return new JsValue(this, evaluateScript);
    }

    public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<JsValue> valueCallback, URL url) {
        this.b.evaluateScriptAsync(str, valueCallback == null ? null : new android.webkit.ValueCallback<IX5JsValue>() { // from class: com.tencent.smtt.sdk.JsContext.1
            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(IX5JsValue iX5JsValue) {
                valueCallback.onReceiveValue(iX5JsValue == null ? null : new JsValue(JsContext.this, iX5JsValue));
            }
        }, url);
    }

    public ExceptionHandler exceptionHandler() {
        return this.c;
    }

    public String name() {
        return this.d;
    }

    public void removeJavascriptInterface(String str) {
        this.b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.c = exceptionHandler;
        if (exceptionHandler == null) {
            this.b.setExceptionHandler(null);
        } else {
            this.b.setExceptionHandler(new android.webkit.ValueCallback<IX5JsError>() { // from class: com.tencent.smtt.sdk.JsContext.2
                @Override // android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(IX5JsError iX5JsError) {
                    JsContext.this.c.handleException(JsContext.this, new JsError(iX5JsError));
                }
            });
        }
    }

    public void setName(String str) {
        this.d = str;
        this.b.setName(str);
    }

    public void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.b.stealValueFromOtherCtx(str, jsContext.b, str2);
    }

    public int getNativeBufferId() {
        return this.b.getNativeBufferId();
    }

    public byte[] getNativeBuffer(int i) {
        return this.b.getNativeBuffer(i);
    }

    public int setNativeBuffer(int i, byte[] bArr) {
        return this.b.setNativeBuffer(i, bArr);
    }

    public JsVirtualMachine virtualMachine() {
        return this.f6422a;
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.a();
    }
}
