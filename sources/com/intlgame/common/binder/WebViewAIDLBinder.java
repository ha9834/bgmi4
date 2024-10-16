package com.intlgame.common.binder;

import android.os.RemoteException;
import com.intlgame.foundation.INTLLog;
import com.intlgame.webview.WebViewAIDL;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class WebViewAIDLBinder extends WebViewAIDL.Stub {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface LOG_LEVEL {
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int WARN = 3;
    }

    @Override // com.intlgame.webview.WebViewAIDL
    public void writeLog(int i, String str) throws RemoteException {
        if (str != null) {
            try {
                if (str.trim().length() == 0) {
                    return;
                }
                switch (i) {
                    case 1:
                        INTLLog.d(str);
                        break;
                    case 2:
                        INTLLog.i(str);
                        break;
                    case 3:
                        INTLLog.w(str);
                        break;
                    case 4:
                        INTLLog.e(str);
                        break;
                }
            } catch (Exception unused) {
            }
        }
    }
}
