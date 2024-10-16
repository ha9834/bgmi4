package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcoc implements zzcjz<zzaov, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final zzclc f3343a;

    public zzcoc(zzclc zzclcVar) {
        this.f3343a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzaov, zzcla> zzd(String str, JSONObject jSONObject) throws RemoteException {
        zzaov zzcy = this.f3343a.zzcy(str);
        if (zzcy == null) {
            return null;
        }
        return new zzcjy<>(zzcy, new zzcla(), str);
    }
}
