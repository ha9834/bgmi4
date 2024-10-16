package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class anu implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anu(String str) {
        this.f1994a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f1994a);
    }
}
