package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblx implements zzbls {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxk f2922a;

    public zzblx(zzcxk zzcxkVar) {
        this.f2922a = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzk(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f2922a.zzbb(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
