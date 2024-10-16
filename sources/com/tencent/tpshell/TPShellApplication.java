package com.tencent.tpshell;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class TPShellApplication extends Application {
    private final native int initialize(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6);

    static {
        System.loadLibrary("tprt");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Initial();
    }

    protected final void Initial() {
        ApplicationInfo applicationInfo = getApplicationInfo();
        String str = "";
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/cmdline")));
                String str2 = bufferedReader.readLine().toString();
                bufferedReader.close();
                str = str2.substring(0, str2.indexOf(0));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
                return;
            }
        } catch (Throwable th) {
        }
        String str3 = applicationInfo.packageName;
        String str4 = applicationInfo.dataDir;
        String str5 = applicationInfo.nativeLibraryDir;
        String str6 = applicationInfo.sourceDir;
        File filesDir = getFilesDir();
        if (Build.VERSION.SDK_INT >= 21) {
            Field declaredField = applicationInfo.getClass().getDeclaredField("splitSourceDirs");
            declaredField.setAccessible(true);
            if (initialize(str3, filesDir.getAbsolutePath(), str5, str6, (String[]) declaredField.get(applicationInfo), str, str4) != 0) {
                throw new Exception("initialize failed.");
            }
            return;
        }
        if (initialize(str3, filesDir.getAbsolutePath(), str5, str6, null, str, str4) != 0) {
            throw new Exception("initialize failed.");
        }
    }
}
