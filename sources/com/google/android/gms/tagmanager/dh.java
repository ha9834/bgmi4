package com.google.android.gms.tagmanager;

/* loaded from: classes2.dex */
final class dh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ df f5120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(df dfVar) {
        this.f5120a = dfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar arVar;
        arVar = this.f5120a.c;
        arVar.a();
    }
}
