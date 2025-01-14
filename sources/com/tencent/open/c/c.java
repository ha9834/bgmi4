package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6382a;
    private KeyEvent b;
    private com.tencent.open.web.security.a c;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f6382a);
        if (!f6382a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            switch (keyCode) {
                case 66:
                    return super.dispatchKeyEvent(keyEvent);
                case 67:
                    com.tencent.open.web.security.a.b = true;
                    return super.dispatchKeyEvent(keyEvent);
                default:
                    if (keyEvent.getUnicodeChar() == 0) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                        this.b = new KeyEvent(0, 17);
                        return super.dispatchKeyEvent(this.b);
                    }
                    return super.dispatchKeyEvent(keyEvent);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f6382a);
        if (!f6382a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                return super.onKeyDown(i, keyEvent);
            }
            switch (keyCode) {
                case 66:
                    return super.onKeyDown(i, keyEvent);
                case 67:
                    com.tencent.open.web.security.a.b = true;
                    return super.onKeyDown(i, keyEvent);
                default:
                    if (keyEvent.getUnicodeChar() == 0) {
                        return super.onKeyDown(i, keyEvent);
                    }
                    if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                        this.b = new KeyEvent(0, 17);
                        return super.onKeyDown(this.b.getKeyCode(), this.b);
                    }
                    return super.onKeyDown(i, keyEvent);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            f6382a = true;
            this.c = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
            return this.c;
        }
        f6382a = false;
        return onCreateInputConnection;
    }
}
