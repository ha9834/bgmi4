package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6339a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context, int i) {
        this.f6339a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.flushDataToDB(this.f6339a);
            aj.a(this.f6339a).a(this.b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
