package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class di implements zzfq {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ df f5121a;
    private Handler b;

    private di(df dfVar) {
        Context context;
        this.f5121a = dfVar;
        context = this.f5121a.b;
        this.b = new zzdj(context.getMainLooper(), new dj(this));
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void zzjt() {
        Object obj;
        Handler handler = this.b;
        obj = df.f5118a;
        handler.removeMessages(1, obj);
        this.b.sendMessage(a());
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void cancel() {
        Object obj;
        Handler handler = this.b;
        obj = df.f5118a;
        handler.removeMessages(1, obj);
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void zzh(long j) {
        Object obj;
        Handler handler = this.b;
        obj = df.f5118a;
        handler.removeMessages(1, obj);
        this.b.sendMessageDelayed(a(), j);
    }

    private final Message a() {
        Object obj;
        Handler handler = this.b;
        obj = df.f5118a;
        return handler.obtainMessage(1, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ di(df dfVar, dg dgVar) {
        this(dfVar);
    }
}
