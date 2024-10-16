package com.google.android.gms.tagmanager;

/* loaded from: classes2.dex */
final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f5152a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, String str) {
        this.b = qVar;
        this.f5152a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f5152a);
    }
}
