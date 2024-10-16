package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzalo {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f2751a = Charset.forName("UTF-8");
    public static final zzaln<JSONObject> zzddi = new cd();
    public static final zzall<InputStream> zzddj = cc.f2093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ InputStream a(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(f2751a));
    }
}
