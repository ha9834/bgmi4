package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzhr f4854a;
    private final /* synthetic */ zzhq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(zzhq zzhqVar, zzhr zzhrVar) {
        this.b = zzhqVar;
        this.f4854a = zzhrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4854a, false);
        zzhq zzhqVar = this.b;
        zzhqVar.f4946a = null;
        zzhqVar.zzs().a((zzhr) null);
    }
}
