package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public final class zzab {

    /* renamed from: a, reason: collision with root package name */
    private zzx f4115a;
    private zzs h;
    private final zzag i;
    private String j;
    private zzt k;
    private zzah n;
    private zzci o;
    private zzv p;
    private zzw b = new zzw();
    private zzw c = new zzw();
    private int d = 10;
    private int e = 16384;
    private boolean f = true;
    private boolean g = true;
    private int l = 20000;
    private int m = 20000;
    private boolean q = true;
    private boolean r = true;

    @Deprecated
    private boolean s = false;
    private zzck t = zzck.zzgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzag zzagVar, String str) {
        this.i = zzagVar;
        zzw(null);
    }

    public final zzag zzs() {
        return this.i;
    }

    public final String getRequestMethod() {
        return this.j;
    }

    public final zzab zzw(String str) {
        if (!(str == null || zzy.a(str))) {
            throw new IllegalArgumentException();
        }
        this.j = str;
        return this;
    }

    public final zzt zzt() {
        return this.k;
    }

    public final zzab zza(zzt zztVar) {
        this.k = (zzt) zzdt.checkNotNull(zztVar);
        return this;
    }

    public final zzs zzu() {
        return this.h;
    }

    public final zzab zza(zzs zzsVar) {
        this.h = zzsVar;
        return this;
    }

    public final zzab zza(zzv zzvVar) {
        this.p = zzvVar;
        return this;
    }

    public final int zzv() {
        return this.e;
    }

    public final boolean zzw() {
        return this.f;
    }

    public final zzab zza(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException();
        }
        this.l = i;
        return this;
    }

    public final zzab zzb(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException();
        }
        this.m = i;
        return this;
    }

    public final zzw zzx() {
        return this.b;
    }

    public final zzw zzy() {
        return this.c;
    }

    public final zzab zza(zzx zzxVar) {
        this.f4115a = zzxVar;
        return this;
    }

    public final zzah zzz() {
        return this.n;
    }

    public final zzab zza(zzah zzahVar) {
        this.n = zzahVar;
        return this;
    }

    public final zzab zza(zzci zzciVar) {
        this.o = zzciVar;
        return this;
    }

    public final zzci zzaa() {
        return this.o;
    }

    public final boolean zzab() {
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0275 A[Catch: all -> 0x02a0, TRY_LEAVE, TryCatch #0 {all -> 0x02a0, blocks: (B:74:0x020f, B:76:0x0215, B:80:0x0229, B:84:0x0233, B:86:0x0245, B:87:0x024d, B:88:0x0272, B:90:0x0275), top: B:73:0x020f }] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.google.android.gms.internal.firebase_remote_config.zzcm, com.google.android.gms.internal.firebase_remote_config.zzu] */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.google.android.gms.internal.firebase_remote_config.zzcg] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.firebase_remote_config.zzac zzac() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzab.zzac():com.google.android.gms.internal.firebase_remote_config.zzac");
    }
}
