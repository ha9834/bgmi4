package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class hz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2231a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzbcd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hz(zzbcd zzbcdVar, String str, String str2) {
        this.c = zzbcdVar;
        this.f2231a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.c.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.c.r;
            zzbcnVar2.zzl(this.f2231a, this.b);
        }
    }
}
