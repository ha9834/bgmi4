package com.tencent.msdk.stat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new l()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        StatLogger statLogger;
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (Exception e) {
            statLogger = j.k;
            statLogger.e((Throwable) e);
        }
        return i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        StatLogger statLogger;
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (Throwable th) {
            statLogger = j.k;
            statLogger.e(th);
        }
        return i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                strArr[0] = strArr[0] + split[i] + " ";
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr[0];
    }
}
