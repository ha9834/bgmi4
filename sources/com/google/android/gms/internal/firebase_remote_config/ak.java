package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;

/* loaded from: classes2.dex */
final class ak extends aj {

    /* renamed from: a, reason: collision with root package name */
    private final ai f4028a = new ai();

    @Override // com.google.android.gms.internal.firebase_remote_config.aj
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f4028a.a(th, true).add(th2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.aj
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> a2 = this.f4028a.a(th, false);
        if (a2 == null) {
            return;
        }
        synchronized (a2) {
            for (Throwable th2 : a2) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
