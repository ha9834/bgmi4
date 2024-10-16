package com.tencent.gsdk.utils.a;

import android.content.Context;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static List<d> f6237a;

    public static void a(int i) {
        com.tencent.gsdk.utils.g.b("ReportManager.init(" + i + ") called.");
        a(i, (Context) null, (String) null);
    }

    public static void a(int i, Context context, String str) {
        f6237a = f.a(i);
        com.tencent.gsdk.utils.g.b("sReporters:" + Arrays.toString(f6237a.toArray()));
        if (context == null || str == null) {
            return;
        }
        for (d dVar : f6237a) {
            if (!dVar.a(context, str)) {
                com.tencent.gsdk.utils.g.b(dVar + " init failed");
            }
        }
    }

    public static void a(String str, Map<String, String> map) {
        a(f6237a, str, map);
    }

    private static void a(List<d> list, String str, Map<String, String> map) {
        for (d dVar : list) {
            if (!dVar.a(str, map)) {
                com.tencent.gsdk.utils.g.b(dVar + " report failed");
            }
        }
    }
}
