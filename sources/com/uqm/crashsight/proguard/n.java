package com.uqm.crashsight.proguard;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static Proxy f6623a;

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            f6623a = null;
        } else {
            f6623a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String b = b(str);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String c = c(str);
        return (TextUtils.isEmpty(c) && Build.VERSION.SDK_INT < 28) ? d(str) : c;
    }

    public static void a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            f6623a = null;
        } else {
            f6623a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    readLine = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                return "";
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (readLine != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return readLine;
        }
        bufferedReader.close();
        return "";
    }

    public static Proxy a() {
        return f6623a;
    }

    private static String c(String str) {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty(str, "");
                try {
                    fileInputStream2.close();
                } catch (Throwable unused) {
                }
                return property;
            } catch (Throwable unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return "";
                }
                try {
                    fileInputStream.close();
                    return "";
                } catch (Throwable unused3) {
                    return "";
                }
            }
        } catch (Throwable th) {
            th = th;
        }
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
