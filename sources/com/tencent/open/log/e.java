package com.tencent.open.log;

import android.util.Log;

/* loaded from: classes.dex */
public final class e extends Tracer {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6391a = new e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (i == 4) {
            Log.i(str, str2, th);
            return;
        }
        if (i == 8) {
            Log.w(str, str2, th);
            return;
        }
        if (i == 16) {
            Log.e(str, str2, th);
            return;
        }
        if (i != 32) {
            switch (i) {
                case 1:
                    Log.v(str, str2, th);
                    return;
                case 2:
                    Log.d(str, str2, th);
                    return;
                default:
                    return;
            }
        }
        Log.e(str, str2, th);
    }
}
