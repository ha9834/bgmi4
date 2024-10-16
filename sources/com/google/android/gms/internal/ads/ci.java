package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ci implements zzahw {

    /* renamed from: a, reason: collision with root package name */
    private final zzakw f2096a;
    private final zzbbr b;
    private final /* synthetic */ zzalu c;

    public ci(zzalu zzaluVar, zzakw zzakwVar, zzbbr zzbbrVar) {
        this.c = zzaluVar;
        this.f2096a = zzakwVar;
        this.b = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void zzc(JSONObject jSONObject) {
        zzall zzallVar;
        try {
            try {
                zzbbr zzbbrVar = this.b;
                zzallVar = this.c.f2753a;
                zzbbrVar.set(zzallVar.zzd(jSONObject));
                this.f2096a.release();
            } catch (IllegalStateException unused) {
                this.f2096a.release();
            } catch (JSONException e) {
                this.b.set(e);
                this.f2096a.release();
            }
        } catch (Throwable th) {
            this.f2096a.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(@Nullable String str) {
        try {
            if (str == null) {
                this.b.setException(new zzali());
            } else {
                this.b.setException(new zzali(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.f2096a.release();
        }
    }
}
