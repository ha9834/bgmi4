package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an implements zzahw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f1979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(zzahu zzahuVar, zzbbr zzbbrVar) {
        this.f1979a = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void zzc(JSONObject jSONObject) {
        this.f1979a.set(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(@Nullable String str) {
        this.f1979a.setException(new zzali(str));
    }
}
