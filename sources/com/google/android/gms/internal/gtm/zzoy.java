package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzoy {

    /* renamed from: a, reason: collision with root package name */
    private final List<zzot> f4427a;
    private final List<zzot> b;
    private final List<zzot> c;
    private final List<zzot> d;
    private final List<zzot> e;
    private final List<zzot> f;
    private final List<String> g;
    private final List<String> h;
    private final List<String> i;
    private final List<String> j;

    private zzoy() {
        this.f4427a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    public final zzoy zzd(zzot zzotVar) {
        this.f4427a.add(zzotVar);
        return this;
    }

    public final zzoy zze(zzot zzotVar) {
        this.b.add(zzotVar);
        return this;
    }

    public final zzoy zzf(zzot zzotVar) {
        this.c.add(zzotVar);
        return this;
    }

    public final zzoy zzct(String str) {
        this.i.add(str);
        return this;
    }

    public final zzoy zzg(zzot zzotVar) {
        this.d.add(zzotVar);
        return this;
    }

    public final zzoy zzcu(String str) {
        this.j.add(str);
        return this;
    }

    public final zzoy zzh(zzot zzotVar) {
        this.e.add(zzotVar);
        return this;
    }

    public final zzoy zzcv(String str) {
        this.g.add(str);
        return this;
    }

    public final zzoy zzi(zzot zzotVar) {
        this.f.add(zzotVar);
        return this;
    }

    public final zzoy zzcw(String str) {
        this.h.add(str);
        return this;
    }

    public final zzox zzms() {
        return new zzox(this.f4427a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }
}
