package com.google.android.gms.internal.gtm;

import java.io.PrintStream;
import java.util.List;

/* loaded from: classes2.dex */
final class av extends as {

    /* renamed from: a, reason: collision with root package name */
    private final at f4307a = new at();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.as
    public final void a(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> a2 = this.f4307a.a(th, false);
        if (a2 == null) {
            return;
        }
        synchronized (a2) {
            for (Throwable th2 : a2) {
                printStream.print("Suppressed: ");
                th2.printStackTrace(printStream);
            }
        }
    }
}
