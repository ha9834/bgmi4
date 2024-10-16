package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcd f4342a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzae zzaeVar, zzcd zzcdVar) {
        this.b = zzaeVar;
        this.f4342a = zzcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.f4384a;
        nVar.a(this.f4342a);
    }
}
