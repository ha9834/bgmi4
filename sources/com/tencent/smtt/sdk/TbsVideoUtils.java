package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
public class TbsVideoUtils {

    /* renamed from: a, reason: collision with root package name */
    private static n f6479a;

    private static void a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (f6479a == null) {
                c.a(true).a(context, false, false, null);
                p a2 = c.a(true).a();
                UselessClass a3 = a2 != null ? a2.a() : null;
                if (a3 != null) {
                    f6479a = new n(a3);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        n nVar = f6479a;
        if (nVar != null) {
            nVar.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        n nVar = f6479a;
        return nVar != null ? nVar.a(context) : "";
    }
}
