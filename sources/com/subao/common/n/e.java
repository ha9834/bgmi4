package com.subao.common.n;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.amazonaws.services.s3.internal.Constants;
import com.subao.common.e.r;
import com.subao.common.n.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static d.a f6135a = d.a.f6134a;

    public static String a(Context context, ApplicationInfo applicationInfo) {
        PackageManager packageManager;
        CharSequence loadLabel;
        if (applicationInfo == null) {
            applicationInfo = context.getApplicationInfo();
        }
        if (applicationInfo == null || (packageManager = context.getPackageManager()) == null || (loadLabel = applicationInfo.loadLabel(packageManager)) == null) {
            return null;
        }
        return loadLabel.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, long j) {
        try {
            return a(d.a(new File(str), Constants.MB), str2, j);
        } catch (IOException unused) {
            return j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static long a(byte[] r6, java.lang.String r7, long r8) {
        /*
            int r0 = r6.length
            r1 = 0
        L2:
            if (r1 >= r0) goto L34
            r2 = r6[r1]
            r3 = 10
            if (r1 == 0) goto Lc
            if (r2 != r3) goto L31
        Lc:
            if (r2 != r3) goto L10
            int r1 = r1 + 1
        L10:
            r2 = r1
        L11:
            if (r2 >= r0) goto L31
            int r3 = r2 - r1
            r4 = r6[r2]
            char r5 = r7.charAt(r3)
            if (r4 == r5) goto L1e
            goto L31
        L1e:
            int r4 = r7.length()
            int r4 = r4 + (-1)
            if (r3 != r4) goto L2e
            int r7 = r6.length
            r8 = -1
            long r6 = com.subao.common.e.a(r6, r2, r7, r8)
            return r6
        L2e:
            int r2 = r2 + 1
            goto L11
        L31:
            int r1 = r1 + 1
            goto L2
        L34:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subao.common.n.e.a(byte[], java.lang.String, long):long");
    }

    public static long a(Context context) {
        return a(context, Build.VERSION.SDK_INT);
    }

    static long a(Context context, int i) {
        if (i >= 16) {
            return b(context);
        }
        return a();
    }

    static long a() {
        long b = b("/proc/meminfo", "MemTotal", -1L);
        return b > 0 ? b * 1024 : b;
    }

    @TargetApi(16)
    private static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static String a() {
            try {
                return a(e.f6135a.b("/proc/cpuinfo"));
            } catch (IOException unused) {
                return null;
            } catch (RuntimeException unused2) {
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static String a(Reader reader) {
            String group;
            BufferedReader bufferedReader = new BufferedReader(reader);
            try {
                Pattern compile = Pattern.compile("Hardware\\s*:\\s*(.+)", 2);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        throw new EOFException();
                    }
                    Matcher matcher = compile.matcher(readLine);
                    if (matcher.find() && (group = matcher.group(1)) != null) {
                        return group.trim();
                    }
                }
            } finally {
                com.subao.common.e.a(bufferedReader);
            }
        }

        public static int b() {
            return a(Build.VERSION.SDK_INT);
        }

        static int a(int i) {
            if (i <= 10) {
                return 1;
            }
            try {
                int a2 = a(e.f6135a.a("/sys/devices/system/cpu/"));
                if (a2 > 1) {
                    return a2;
                }
                return 1;
            } catch (RuntimeException unused) {
                return 1;
            }
        }

        private static int a(File file) {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.subao.common.n.e.a.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    String name = file2.getName();
                    if (!name.startsWith("cpu")) {
                        return false;
                    }
                    for (int i = 3; i < name.length(); i++) {
                        if (!Character.isDigit(name.charAt(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            });
            if (listFiles == null) {
                return 0;
            }
            return listFiles.length;
        }

        public static long c() {
            try {
                int b = b();
                long j = -1;
                for (int i = 0; i < b; i++) {
                    try {
                        long a2 = a(String.format(r.f6001a, "%s/cpu%d/cpufreq/cpuinfo_max_freq", "/sys/devices/system/cpu/", Integer.valueOf(i)));
                        if (a2 > j) {
                            j = a2;
                        }
                    } catch (IOException | RuntimeException unused) {
                        return j;
                    }
                }
                if (j > 0) {
                    return j;
                }
                long b2 = e.b("/proc/cpuinfo", "cpu MHz", -1L);
                return b2 != -1 ? b2 * 1000 : j;
            } catch (IOException unused2) {
                return -1L;
            } catch (RuntimeException unused3) {
                return -1L;
            }
        }

        private static long a(String str) {
            InputStream inputStream = null;
            try {
                inputStream = e.f6135a.c(str);
                byte[] bArr = new byte[128];
                return com.subao.common.e.a(bArr, 0, inputStream.read(bArr), -1L);
            } finally {
                com.subao.common.e.a((Closeable) inputStream);
            }
        }
    }
}
