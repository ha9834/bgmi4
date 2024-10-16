package com.google.android.gms.internal.ads;

import android.os.Trace;

/* loaded from: classes2.dex */
public final class zzkp {
    public static void beginSection(String str) {
        if (zzkq.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzkq.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
