package com.tencent.hawk.utils;

import com.tencent.hawk.bridge.DevPacket;

/* loaded from: classes2.dex */
public class CpuUtil {
    private static final int errorFreq = 15;
    private static int mCpuCores = DevPacket.getCpuCoreNum();
    private static int[] mCpuFreqs = null;
    private static final int maxCores = 16;

    /* JADX WARN: Can't wrap try/catch for region: R(7:25|26|(2:31|23)|28|29|30|23) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] getCpuCurFreqs() {
        /*
            int r0 = com.tencent.hawk.utils.CpuUtil.mCpuCores
            r1 = 16
            if (r0 > r1) goto L91
            if (r0 != 0) goto La
            goto L91
        La:
            int[] r1 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs
            if (r1 != 0) goto L12
            int[] r0 = new int[r0]
            com.tencent.hawk.utils.CpuUtil.mCpuFreqs = r0
        L12:
            int[] r0 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs
            r1 = 15
            java.util.Arrays.fill(r0, r1)
            r0 = 0
        L1a:
            int r1 = com.tencent.hawk.utils.CpuUtil.mCpuCores
            if (r0 >= r1) goto L8e
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            r2.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.lang.String r3 = "/sys/devices/system/cpu/cpu"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            r2.append(r0)     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.lang.String r3 = "/cpufreq/scaling_cur_freq"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6e java.lang.NumberFormatException -> L70 java.io.IOException -> L7c
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            if (r1 == 0) goto L63
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            java.lang.String r2 = ""
            java.lang.String r4 = r1.trim()     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            if (r2 != 0) goto L63
            int[] r2 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
            int r1 = r1 / 1000
            r2[r0] = r1     // Catch: java.lang.Throwable -> L67 java.lang.NumberFormatException -> L6a java.io.IOException -> L6c
        L63:
            r3.close()     // Catch: java.io.IOException -> L85
            goto L85
        L67:
            r0 = move-exception
            r1 = r3
            goto L88
        L6a:
            r1 = r3
            goto L70
        L6c:
            r1 = r3
            goto L7c
        L6e:
            r0 = move-exception
            goto L88
        L70:
            int[] r2 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs     // Catch: java.lang.Throwable -> L6e
            r3 = 13
            r2[r0] = r3     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L85
        L78:
            r1.close()     // Catch: java.io.IOException -> L85
            goto L85
        L7c:
            int[] r2 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs     // Catch: java.lang.Throwable -> L6e
            r3 = 14
            r2[r0] = r3     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L85
            goto L78
        L85:
            int r0 = r0 + 1
            goto L1a
        L88:
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.io.IOException -> L8d
        L8d:
            throw r0
        L8e:
            int[] r0 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs
            return r0
        L91:
            int[] r0 = com.tencent.hawk.utils.CpuUtil.mCpuFreqs
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.utils.CpuUtil.getCpuCurFreqs():int[]");
    }
}
