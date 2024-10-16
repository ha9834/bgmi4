package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* loaded from: classes2.dex */
public class d {
    private static d e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6540a;
    private Context b;
    private File c;
    private boolean d;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            dVar = e;
        }
        return dVar;
    }

    private File c() {
        try {
            if (this.c == null) {
                this.c = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
                if (this.c == null || !this.c.isDirectory()) {
                    return null;
                }
            }
            File file = new File(this.c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        this.d = z;
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedInputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public void b() {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File c;
        Properties properties;
        BufferedOutputStream bufferedOutputStream2;
        ?? r0 = 0;
        r0 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            try {
                c = c();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (c == null) {
            try {
                r0.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                r0.close();
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        bufferedInputStream = new BufferedInputStream(new FileInputStream(c));
        try {
            properties = new Properties();
            properties.load(bufferedInputStream);
            properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f6540a));
            properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(c));
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            properties.store(bufferedOutputStream2, (String) null);
            try {
                bufferedInputStream.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            bufferedOutputStream2.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream3 = bufferedOutputStream2;
            bufferedInputStream.close();
            bufferedOutputStream3.close();
            throw th;
        }
    }
}
