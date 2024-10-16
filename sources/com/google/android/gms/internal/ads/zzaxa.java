package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzaxa extends zzdbh {
    public zzaxa(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzk.zzlk().zza(e, "AdMobHandler.handleMessage");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdbh
    public final void a(Message message) {
        try {
            super.a(message);
        } catch (Throwable th) {
            zzk.zzlg();
            zzaxi.zza(zzk.zzlk().getApplicationContext(), th);
            throw th;
        }
    }
}
