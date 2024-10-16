package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cp implements zzahw {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbr f2102a;
    private final /* synthetic */ zzamd b;

    public cp(zzamd zzamdVar, zzbbr zzbbrVar) {
        this.b = zzamdVar;
        this.f2102a = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void zzc(JSONObject jSONObject) {
        zzall zzallVar;
        try {
            zzbbr zzbbrVar = this.f2102a;
            zzallVar = this.b.f2755a;
            zzbbrVar.set(zzallVar.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.f2102a.set(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(@Nullable String str) {
        try {
            if (str == null) {
                this.f2102a.setException(new zzali());
            } else {
                this.f2102a.setException(new zzali(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
