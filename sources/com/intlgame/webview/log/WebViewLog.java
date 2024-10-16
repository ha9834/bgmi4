package com.intlgame.webview.log;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.intlgame.common.ForegroundService;
import com.intlgame.webview.WebViewAIDL;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class WebViewLog {
    private List<LogTask> mTaskQueue;
    private WebViewAIDL mWebViewAIDLInstance;
    private ServiceConnection serviceConnection;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface LOG_LEVEL {
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int WARN = 3;
    }

    private WebViewLog() {
        this.serviceConnection = null;
        this.mWebViewAIDLInstance = null;
        this.mTaskQueue = new ArrayList();
    }

    public static WebViewLog getInstance() {
        return SingletonHolder.instance;
    }

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        private static final WebViewLog instance = new WebViewLog();

        private SingletonHolder() {
        }
    }

    public void bindService(Application application) {
        try {
            if (this.serviceConnection == null) {
                this.serviceConnection = new ServiceConnection() { // from class: com.intlgame.webview.log.WebViewLog.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        try {
                            WebViewLog.this.mWebViewAIDLInstance = WebViewAIDL.Stub.asInterface(iBinder);
                            if (WebViewLog.this.mTaskQueue.size() > 0) {
                                WebViewLog.this.runTask();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        WebViewLog.this.mWebViewAIDLInstance = null;
                    }
                };
            }
            Intent intent = new Intent(ForegroundService.FOREGROUND_SERVICE_ACTION);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(application.getPackageName());
            application.bindService(intent, this.serviceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unbindService(Application application) {
        try {
            if (this.serviceConnection != null) {
                new Intent(ForegroundService.FOREGROUND_SERVICE_ACTION).setPackage(application.getPackageName());
                application.unbindService(this.serviceConnection);
            }
            try {
                this.mTaskQueue.clear();
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        writeLog(1, str);
    }

    public void i(String str) {
        writeLog(2, str);
    }

    public void w(String str) {
        writeLog(3, str);
    }

    public void e(String str) {
        writeLog(4, str);
    }

    private boolean isStringNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    private void writeLog(int i, String str) {
        if (isStringNullOrEmpty(str)) {
            return;
        }
        try {
            this.mTaskQueue.add(new LogTask(i, str));
        } catch (Exception unused) {
        }
        runTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTask() {
        if (this.mWebViewAIDLInstance == null) {
            return;
        }
        while (this.mTaskQueue.size() > 0) {
            try {
                try {
                    LogTask remove = this.mTaskQueue.remove(0);
                    if (this.mWebViewAIDLInstance != null && remove != null) {
                        this.mWebViewAIDLInstance.writeLog(remove.level, remove.log);
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LogTask {
        private final int level;
        private final String log;

        LogTask(int i, String str) {
            this.level = i;
            this.log = str;
        }
    }
}
