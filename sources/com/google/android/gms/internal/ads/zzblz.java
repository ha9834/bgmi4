package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblz implements zzbls {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2924a;

    public zzblz(Context context) {
        this.f2924a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzk(Map<String, String> map) {
        CookieManager zzaz;
        String str = map.get("cookie");
        if (TextUtils.isEmpty(str) || (zzaz = zzk.zzli().zzaz(this.f2924a)) == null) {
            return;
        }
        zzaz.setCookie("googleads.g.doubleclick.net", str);
    }
}
