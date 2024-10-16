package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class db {
    private zzot f;

    /* renamed from: a, reason: collision with root package name */
    private final Set<zzox> f5114a = new HashSet();
    private final Map<zzox, List<zzot>> b = new HashMap();
    private final Map<zzox, List<String>> d = new HashMap();
    private final Map<zzox, List<zzot>> c = new HashMap();
    private final Map<zzox, List<String>> e = new HashMap();

    public final Set<zzox> a() {
        return this.f5114a;
    }

    public final void a(zzox zzoxVar) {
        this.f5114a.add(zzoxVar);
    }

    public final Map<zzox, List<zzot>> b() {
        return this.b;
    }

    public final Map<zzox, List<String>> c() {
        return this.d;
    }

    public final Map<zzox, List<String>> d() {
        return this.e;
    }

    public final void a(zzox zzoxVar, zzot zzotVar) {
        List<zzot> list = this.b.get(zzoxVar);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(zzoxVar, list);
        }
        list.add(zzotVar);
    }

    public final void a(zzox zzoxVar, String str) {
        List<String> list = this.d.get(zzoxVar);
        if (list == null) {
            list = new ArrayList<>();
            this.d.put(zzoxVar, list);
        }
        list.add(str);
    }

    public final Map<zzox, List<zzot>> e() {
        return this.c;
    }

    public final void b(zzox zzoxVar, zzot zzotVar) {
        List<zzot> list = this.c.get(zzoxVar);
        if (list == null) {
            list = new ArrayList<>();
            this.c.put(zzoxVar, list);
        }
        list.add(zzotVar);
    }

    public final void b(zzox zzoxVar, String str) {
        List<String> list = this.e.get(zzoxVar);
        if (list == null) {
            list = new ArrayList<>();
            this.e.put(zzoxVar, list);
        }
        list.add(str);
    }

    public final zzot f() {
        return this.f;
    }

    public final void a(zzot zzotVar) {
        this.f = zzotVar;
    }
}
