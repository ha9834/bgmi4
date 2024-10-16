package com.google.android.gms.internal.firebase_messaging;

/* loaded from: classes2.dex */
final class h extends e {

    /* renamed from: a, reason: collision with root package name */
    private final g f4015a = new g();

    @Override // com.google.android.gms.internal.firebase_messaging.e
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f4015a.a(th, true).add(th2);
    }
}
