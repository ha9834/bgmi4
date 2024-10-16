package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class ProcessUtils {

    /* renamed from: a, reason: collision with root package name */
    private static String f1506a;
    private static int b;

    private ProcessUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (f1506a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            f1506a = a(b);
        }
        return f1506a;
    }

    @Nullable
    private static String a(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = a(sb.toString());
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            str = bufferedReader.readLine().trim();
            IOUtils.closeQuietly(bufferedReader);
        } catch (IOException unused2) {
            IOUtils.closeQuietly(bufferedReader);
            return str;
        } catch (Throwable th2) {
            bufferedReader2 = bufferedReader;
            th = th2;
            IOUtils.closeQuietly(bufferedReader2);
            throw th;
        }
        return str;
    }

    private static BufferedReader a(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
