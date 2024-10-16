package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class fm implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f2175a = new AtomicInteger(1);
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(String str) {
        this.b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.b;
        int andIncrement = this.f2175a.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
