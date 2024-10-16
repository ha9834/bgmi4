package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bo implements zzaho<zzalf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzala f2079a;
    private final /* synthetic */ zzajw b;
    private final /* synthetic */ zzakh c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(zzakh zzakhVar, zzala zzalaVar, zzajw zzajwVar) {
        this.c = zzakhVar;
        this.f2079a = zzalaVar;
        this.b = zzajwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzalf zzalfVar, Map map) {
        Object obj;
        zzayp zzaypVar;
        obj = this.c.f2745a;
        synchronized (obj) {
            if (this.f2079a.getStatus() != -1 && this.f2079a.getStatus() != 1) {
                this.c.h = 0;
                zzaypVar = this.c.e;
                zzaypVar.zzh(this.b);
                this.f2079a.zzo(this.b);
                this.c.g = this.f2079a;
                zzawz.zzds("Successfully loaded JS Engine.");
            }
        }
    }
}
