package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.tencent.midas.oversea.comm.MConstants;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzasj extends zzasl {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2794a = new Object();
    private final Context b;
    private SharedPreferences c;
    private final zzalj<JSONObject, JSONObject> d;

    public zzasj(Context context, zzalj<JSONObject, JSONObject> zzaljVar) {
        this.b = context.getApplicationContext();
        this.d = zzaljVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final zzbbh<Void> zztz() {
        synchronized (this.f2794a) {
            if (this.c == null) {
                this.c = this.b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzk.zzln().currentTimeMillis() - this.c.getLong("js_last_update", 0L) < ((Long) zzyt.zzpe().zzd(zzacu.zzcrw)).longValue()) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.d.zzi(zzu(this.b)), new zzbam(this) { // from class: com.google.android.gms.internal.ads.ed

            /* renamed from: a, reason: collision with root package name */
            private final zzasj f2142a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2142a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                return this.f2142a.a((JSONObject) obj);
            }
        }, zzbbm.zzeaf);
    }

    public static JSONObject zzu(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbai.zzxc().zzbsx);
            jSONObject.put("mf", zzyt.zzpe().zzd(zzacu.zzcrx));
            jSONObject.put("cl", "248613007");
            jSONObject.put("rapid_rc", MConstants.DevEnv);
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 11140);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void a(JSONObject jSONObject) {
        zzacu.zza(this.b, 1, jSONObject);
        this.c.edit().putLong("js_last_update", zzk.zzln().currentTimeMillis()).apply();
        return null;
    }
}
