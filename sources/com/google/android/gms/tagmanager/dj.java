package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dj implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ di f5122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(di diVar) {
        this.f5122a = diVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        boolean d;
        int i;
        if (1 == message.what) {
            obj = df.f5118a;
            if (obj.equals(message.obj)) {
                this.f5122a.f5121a.dispatch();
                d = this.f5122a.f5121a.d();
                if (!d) {
                    di diVar = this.f5122a;
                    i = diVar.f5121a.e;
                    diVar.zzh(i);
                }
            }
        }
        return true;
    }
}
