package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes2.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f6523a;
    private static Context b;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(Context context) {
        if (f6523a == null) {
            synchronized (h.class) {
                if (f6523a == null) {
                    f6523a = new h();
                }
            }
        }
        b = context.getApplicationContext();
        return f6523a;
    }

    File a() {
        j.a();
        File file = new File(j.e(b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    private Properties d() {
        Properties properties;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File a2 = a();
                properties = new Properties();
                if (a2 != null) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream2 = bufferedInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream2 = bufferedInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return properties;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return properties;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            properties = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return b("install_core_ver");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return a("install_status");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str) {
        Properties d = d();
        if (d == null || d.getProperty(str) == null) {
            return -1;
        }
        return Integer.parseInt(d.getProperty(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str) {
        Properties d = d();
        if (d == null || d.getProperty(str) == null) {
            return 0;
        }
        return Integer.parseInt(d.getProperty(str));
    }
}
