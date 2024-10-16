package com.google.android.gms.internal.ads;

import android.os.Trace;

/* loaded from: classes2.dex */
public final class zzsx {
    public static void beginSection(String str) {
        if (zzsy.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzsy.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
