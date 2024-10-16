package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* loaded from: classes2.dex */
public class DateSorter {
    public static int DAY_COUNT;

    /* renamed from: a, reason: collision with root package name */
    private android.webkit.DateSorter f6420a;
    private IX5DateSorter b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            this.b = a2.c().h(context);
        } else {
            this.f6420a = new android.webkit.DateSorter(context);
        }
    }

    public int getIndex(long j) {
        if (r.a() != null && r.b()) {
            return this.b.getIndex(j);
        }
        return this.f6420a.getIndex(j);
    }

    public String getLabel(int i) {
        if (r.a() != null && r.b()) {
            return this.b.getLabel(i);
        }
        return this.f6420a.getLabel(i);
    }

    public long getBoundary(int i) {
        if (r.a() != null && r.b()) {
            return this.b.getBoundary(i);
        }
        return this.f6420a.getBoundary(i);
    }

    private static boolean a() {
        return r.a() != null && r.b();
    }
}
