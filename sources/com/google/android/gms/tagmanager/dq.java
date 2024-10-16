package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dq implements DataLayer.b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5125a;

    public dq(Context context) {
        this.f5125a = context;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get("url");
        }
        if (obj2 == null || !(obj2 instanceof String) || (queryParameter = Uri.parse((String) obj2).getQueryParameter(Constants.REFERRER)) == null) {
            return;
        }
        zzcw.zzf(this.f5125a, queryParameter);
    }
}
