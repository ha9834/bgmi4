package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bp implements zzaho<zzalf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdh f2080a;
    private final /* synthetic */ zzajw b;
    private final /* synthetic */ zzazk c;
    private final /* synthetic */ zzakh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(zzakh zzakhVar, zzdh zzdhVar, zzajw zzajwVar, zzazk zzazkVar) {
        this.d = zzakhVar;
        this.f2080a = zzdhVar;
        this.b = zzajwVar;
        this.c = zzazkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzalf zzalfVar, Map map) {
        Object obj;
        int i;
        obj = this.d.f2745a;
        synchronized (obj) {
            zzawz.zzeo("JS Engine is requesting an update");
            i = this.d.h;
            if (i == 0) {
                zzawz.zzeo("Starting reload.");
                this.d.h = 2;
                this.d.a(this.f2080a);
            }
            this.b.zzb("/requestReload", (zzaho<? super zzalf>) this.c.get());
        }
    }
}
