package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ang implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ane f1982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ang(ane aneVar) {
        this.f1982a = aneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzqk zzqkVar;
        z = this.f1982a.H;
        if (z) {
            return;
        }
        zzqkVar = this.f1982a.q;
        zzqkVar.zza((zzqk) this.f1982a);
    }
}
