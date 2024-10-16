package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzaso implements zzasb {

    /* renamed from: a, reason: collision with root package name */
    private zzalj<JSONObject, JSONObject> f2795a;
    private zzalj<JSONObject, JSONObject> b;

    public zzaso(Context context) {
        this.f2795a = zzk.zzlt().zza(context, zzbai.zzxc()).zza("google.afma.request.getAdDictionary", zzalo.zzddi, zzalo.zzddi);
        this.b = zzk.zzlt().zza(context, zzbai.zzxc()).zza("google.afma.sdkConstants.getSdkConstants", zzalo.zzddi, zzalo.zzddi);
    }

    @Override // com.google.android.gms.internal.ads.zzasb
    public final zzalj<JSONObject, JSONObject> zztt() {
        return this.b;
    }
}
