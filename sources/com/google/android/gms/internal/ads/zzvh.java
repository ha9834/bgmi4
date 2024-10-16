package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzvh {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzvi> priorityQueue) {
        if (strArr.length < i2) {
            a(i, b(strArr, 0, strArr.length), a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long b = b(strArr, 0, i2);
        a(i, b, a(strArr, 0, i2), i2, priorityQueue);
        long a2 = a(16785407L, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            b = ((((((b + 1073807359) - ((((zzve.zzbn(strArr[i3 - 1]) + 2147483647L) % 1073807359) * a2) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzve.zzbn(strArr[(i3 + i2) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            a(i, b, a(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    @VisibleForTesting
    private static void a(int i, long j, String str, int i2, PriorityQueue<zzvi> priorityQueue) {
        zzvi zzviVar = new zzvi(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().c <= zzviVar.c && priorityQueue.peek().f3759a <= zzviVar.f3759a)) && !priorityQueue.contains(zzviVar)) {
            priorityQueue.add(zzviVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    private static String a(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzawz.zzen("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    private static long b(String[] strArr, int i, int i2) {
        long zzbn = (zzve.zzbn(strArr[0]) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzbn = (((zzbn * 16785407) % 1073807359) + ((zzve.zzbn(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzbn;
    }

    @VisibleForTesting
    private static long a(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return a((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }
}
