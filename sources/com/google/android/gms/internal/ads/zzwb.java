package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzwb {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("lock")
    private zzvu f3765a;

    @GuardedBy("lock")
    private boolean b;
    private final Context c;
    private final Object d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwb(Context context) {
        this.c = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<InputStream> a(zzvv zzvvVar) {
        apf apfVar = new apf(this);
        apg apgVar = new apg(this, zzvvVar, apfVar);
        apk apkVar = new apk(this, apfVar);
        synchronized (this.d) {
            this.f3765a = new zzvu(this.c, zzk.zzlu().zzwr(), apgVar, apkVar);
            this.f3765a.checkAvailabilityAndConnect();
        }
        return apfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.d) {
            if (this.f3765a == null) {
                return;
            }
            this.f3765a.disconnect();
            this.f3765a = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzwb zzwbVar, boolean z) {
        zzwbVar.b = true;
        return true;
    }
}
