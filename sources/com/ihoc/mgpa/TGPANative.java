package com.ihoc.mgpa;

import android.content.Context;
import com.ihoc.mgpa.d.b;
import com.ihoc.mgpa.i.f;
import com.ihoc.mgpa.n.a;
import com.ihoc.mgpa.n.m;

/* loaded from: classes2.dex */
public final class TGPANative {
    private static boolean sIsSupportGradishWrapper;

    public static native synchronized String dbg();

    public static native String getIVParameter();

    public static native String getKey();

    public static native long getThreadAffinity(int i, int i2);

    public static native synchronized String goa(Context context, int i);

    public static native void init();

    private static boolean isDebug() {
        return m.c();
    }

    private static boolean isGradishDebugIDEnable() {
        return f.L();
    }

    private static boolean isGradishEnable() {
        return f.ca();
    }

    public static boolean isTgpaLibLoad() {
        return sIsSupportGradishWrapper;
    }

    public static native boolean setThreadAffinity(int i, int[] iArr, int i2);

    public static boolean tryLoadLibrary() {
        if (sIsSupportGradishWrapper) {
            return true;
        }
        sIsSupportGradishWrapper = b.a(a.a(), "tgpa");
        if (sIsSupportGradishWrapper) {
            m.c("load TGPA lib success!!!", new Object[0]);
        } else {
            m.b("load TGPA lib failed!!!", new Object[0]);
        }
        return sIsSupportGradishWrapper;
    }

    public static native synchronized String yje(Context context);

    public static native synchronized String zkf(Context context);
}
