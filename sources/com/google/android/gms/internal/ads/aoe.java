package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aoe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzlh f2001a;
    private final /* synthetic */ zzto b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aoe(zzto zztoVar, zzlh zzlhVar) {
        this.b = zztoVar;
        this.f2001a = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.b.b;
        zztnVar.zzk(this.f2001a);
    }
}
