package com.tencent.msdk.stat;

import android.content.Context;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f6327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f6327a = dVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Context context;
        if (StatConfig.isDebugEnable()) {
            com.tencent.msdk.stat.common.j.b().i("TimerTask run");
        }
        context = this.f6327a.c;
        StatServiceImpl.d(context);
        cancel();
        this.f6327a.a();
    }
}
