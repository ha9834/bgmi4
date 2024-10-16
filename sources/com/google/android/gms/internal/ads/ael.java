package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes2.dex */
final class ael extends aeh {
    @Override // com.google.android.gms.internal.ads.aeh
    public final void a(Throwable th, Throwable th2) {
    }

    @Override // com.google.android.gms.internal.ads.aeh
    public final void a(Throwable th) {
        th.printStackTrace();
    }

    @Override // com.google.android.gms.internal.ads.aeh
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
