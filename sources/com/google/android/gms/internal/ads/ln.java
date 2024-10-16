package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ln implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lk f2321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ln(lk lkVar) {
        this.f2321a = lkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
