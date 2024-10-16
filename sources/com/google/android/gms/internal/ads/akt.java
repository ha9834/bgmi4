package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class akt implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akt(String str) {
        this.f1940a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f1940a);
    }
}
