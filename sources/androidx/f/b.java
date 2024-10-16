package androidx.f;

import android.os.Trace;

/* loaded from: classes.dex */
final class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void a() {
        Trace.endSection();
    }
}
