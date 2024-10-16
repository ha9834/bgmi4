package com.subao.common.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.subao.common.i.n;
import com.subao.common.i.o;
import com.subao.common.i.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.e.g f6026a;
    private final r b;
    private final m c;

    public a(Context context, com.subao.common.e.g gVar, r rVar) {
        this.f6026a = gVar;
        this.b = rVar;
        this.c = new m(context);
    }

    public static l a(Context context) {
        ApplicationInfo applicationInfo;
        CharSequence loadLabel;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        return new l((packageManager == null || (applicationInfo = context.getApplicationInfo()) == null || (loadLabel = applicationInfo.loadLabel(packageManager)) == null) ? null : loadLabel.toString(), packageName);
    }

    public r a() {
        return this.b;
    }

    public m b() {
        return this.c;
    }

    public q a(k kVar, int i, int i2) {
        return new q(kVar, q.c.START, i, i2, null, this.b, this.f6026a);
    }

    public o a(long j, o.a aVar) {
        return new o(this.f6026a, j, aVar, this.c, this.b);
    }

    public n a(k kVar, List<n.a> list) {
        return new n(kVar, this.f6026a, this.b, list);
    }

    public n a(k kVar, String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("param", str2);
        return a(kVar, a(str, hashMap));
    }

    public n a(k kVar, int i, int i2, boolean z) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("result", Integer.toString(i));
        hashMap.put("net", Integer.toString(i2));
        hashMap.put("accel", z ? "1" : "0");
        return a(kVar, a("tg_accel_recommend", hashMap));
    }

    private List<n.a> a(String str, Map<String, String> map) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new n.a(str, System.currentTimeMillis() / 1000, map));
        return arrayList;
    }
}
