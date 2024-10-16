package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

@zzard
/* loaded from: classes2.dex */
public final class zzyt {

    /* renamed from: a, reason: collision with root package name */
    private static zzyt f3783a = new zzyt();
    private final zzazt b;
    private final zzyh c;
    private final String d;
    private final zzacp e;
    private final zzacq f;
    private final zzacr g;
    private final zzbai h;
    private final Random i;
    private final WeakHashMap<Object, String> j;

    protected zzyt() {
        this(new zzazt(), new zzyh(new zzxx(), new zzxw(), new zzabk(), new zzagk(), new zzatf(), new zzauj(), new zzaqf(), new zzagl()), new zzacp(), new zzacq(), new zzacr(), zzazt.zzwz(), new zzbai(0, 15000000, true), new Random(), new WeakHashMap());
    }

    private zzyt(zzazt zzaztVar, zzyh zzyhVar, zzacp zzacpVar, zzacq zzacqVar, zzacr zzacrVar, String str, zzbai zzbaiVar, Random random, WeakHashMap<Object, String> weakHashMap) {
        this.b = zzaztVar;
        this.c = zzyhVar;
        this.e = zzacpVar;
        this.f = zzacqVar;
        this.g = zzacrVar;
        this.d = str;
        this.h = zzbaiVar;
        this.i = random;
        this.j = weakHashMap;
    }

    public static zzazt zzpa() {
        return f3783a.b;
    }

    public static zzyh zzpb() {
        return f3783a.c;
    }

    public static zzacq zzpc() {
        return f3783a.f;
    }

    public static zzacp zzpd() {
        return f3783a.e;
    }

    public static zzacr zzpe() {
        return f3783a.g;
    }

    public static String zzpf() {
        return f3783a.d;
    }

    public static zzbai zzpg() {
        return f3783a.h;
    }

    public static Random zzph() {
        return f3783a.i;
    }
}
