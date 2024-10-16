package com.tencent.msdk.stat.common;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* loaded from: classes.dex */
final class q implements Comparator<ScanResult> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        int abs = Math.abs(scanResult.level);
        int abs2 = Math.abs(scanResult2.level);
        if (abs > abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }
}
