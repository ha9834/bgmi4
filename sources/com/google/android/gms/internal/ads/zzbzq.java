package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzbzq implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    String f3142a;
    Long b;
    WeakReference<View> c;
    private final zzccj d;
    private final Clock e;
    private zzagd f;
    private zzaho g;

    public zzbzq(zzccj zzccjVar, Clock clock) {
        this.d = zzccjVar;
        this.e = clock;
    }

    public final void zza(zzagd zzagdVar) {
        this.f = zzagdVar;
        zzaho<Object> zzahoVar = this.g;
        if (zzahoVar != null) {
            this.d.zzb("/unconfirmedClick", zzahoVar);
        }
        this.g = new ql(this, zzagdVar);
        this.d.zza("/unconfirmedClick", this.g);
    }

    public final zzagd zzaiz() {
        return this.f;
    }

    public final void cancelUnconfirmedClick() {
        if (this.f == null || this.b == null) {
            return;
        }
        a();
        try {
            this.f.onUnconfirmedClickCancelled();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.f3142a != null && this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.f3142a);
            hashMap.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, String.valueOf(this.e.currentTimeMillis() - this.b.longValue()));
            hashMap.put("messageType", "onePointFiveClick");
            this.d.zza("sendMessageToNativeJs", hashMap);
        }
        a();
    }

    private final void a() {
        View view;
        this.f3142a = null;
        this.b = null;
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.c = null;
    }
}
