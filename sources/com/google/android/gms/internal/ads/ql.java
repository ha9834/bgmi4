package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ql implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzagd f2441a;
    private final /* synthetic */ zzbzq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ql(zzbzq zzbzqVar, zzagd zzagdVar) {
        this.b = zzbzqVar;
        this.f2441a = zzagdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        try {
            this.b.b = Long.valueOf(Long.parseLong(map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzawz.zzen("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.b.f3142a = map.get("id");
        String str = map.get("asset_id");
        zzagd zzagdVar = this.f2441a;
        if (zzagdVar == null) {
            zzawz.zzdp("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzagdVar.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
