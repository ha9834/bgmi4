package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6296a;
    final /* synthetic */ Context b;
    final /* synthetic */ StatSpecifyReportedInfo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6296a = str;
        this.b = context;
        this.c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        String str = this.f6296a;
        if (str != null && str.trim().length() != 0) {
            StatServiceImpl.b(this.b, new f(this.f6296a), this.c);
        } else {
            statLogger = StatServiceImpl.q;
            statLogger.w("qq num is null or empty.");
        }
    }
}
