package com.shieldtunnel.svpn.common.g;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static File f5828a;

    public static File a(Context context) {
        File dir = context.getDir("shieldtunnel.svpn", 0);
        f5828a = dir;
        return dir;
    }

    public static File a() {
        return f5828a;
    }

    public static File a(String str) {
        return new File(f5828a, str);
    }
}
