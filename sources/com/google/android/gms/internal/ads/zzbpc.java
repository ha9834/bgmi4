package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* loaded from: classes2.dex */
public class zzbpc {

    /* renamed from: a, reason: collision with root package name */
    protected zzcxu f2989a;
    protected zzcxm b;
    protected zzbry c;
    protected zzbso d;
    protected String e;

    public final zzbry zzafy() {
        return this.c;
    }

    public void zzafl() {
        this.d.onAdLoaded();
    }

    public final String getMediationAdapterClassName() {
        return this.e;
    }

    public final String zzpj() {
        String a2 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(this.e) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(this.e) ? a(this.b) : null;
        return a2 == null ? this.e : a2;
    }

    public void destroy() {
        this.c.zzbr(null);
    }

    private static String a(zzcxm zzcxmVar) {
        try {
            return zzcxmVar.zzgkh.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }
}
