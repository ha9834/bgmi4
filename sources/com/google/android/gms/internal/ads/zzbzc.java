package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzbzc {
    public static final zzbzc zzfpd = new zzbze().zzaip();

    /* renamed from: a, reason: collision with root package name */
    private final zzafl f3133a;
    private final zzafi b;
    private final zzafx c;
    private final zzafu d;
    private final zzaje e;
    private final androidx.b.g<String, zzafr> f;
    private final androidx.b.g<String, zzafo> g;

    public final zzafl zzaii() {
        return this.f3133a;
    }

    public final zzafi zzaij() {
        return this.b;
    }

    public final zzafx zzaik() {
        return this.c;
    }

    public final zzafu zzail() {
        return this.d;
    }

    public final zzaje zzaim() {
        return this.e;
    }

    public final zzafr zzfn(String str) {
        return this.f.get(str);
    }

    public final zzafo zzfo(String str) {
        return this.g.get(str);
    }

    public final ArrayList<String> zzain() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.c != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.f3133a != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.b != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.f.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.e != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzaio() {
        ArrayList<String> arrayList = new ArrayList<>(this.f.size());
        for (int i = 0; i < this.f.size(); i++) {
            arrayList.add(this.f.b(i));
        }
        return arrayList;
    }

    private zzbzc(zzbze zzbzeVar) {
        this.f3133a = zzbzeVar.f3134a;
        this.b = zzbzeVar.b;
        this.c = zzbzeVar.c;
        this.f = new androidx.b.g<>(zzbzeVar.f);
        this.g = new androidx.b.g<>(zzbzeVar.g);
        this.d = zzbzeVar.d;
        this.e = zzbzeVar.e;
    }
}
