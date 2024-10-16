package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbml implements zzalm<zzbmp> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2933a;
    private final zzty b;
    private final PowerManager c;

    public zzbml(Context context, zzty zztyVar) {
        this.f2933a = context;
        this.b = zztyVar;
        this.c = (PowerManager) context.getSystemService("power");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzalm
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzj(zzbmp zzbmpVar) throws JSONException {
        boolean isScreenOn;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzbmpVar.zzfge == null) {
            jSONObject = new JSONObject();
        } else {
            zzud zzudVar = zzbmpVar.zzfge;
            if (this.b.zzmh() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzudVar.zzbtp;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.b.zzmg()).put("activeViewJSON", this.b.zzmh()).put("timestamp", zzbmpVar.timestamp).put("adFormat", this.b.zzmf()).put("hashCode", this.b.zzmi());
            zzty zztyVar = this.b;
            JSONObject put2 = put.put("isMraid", false).put("isStopped", false).put("isPaused", zzbmpVar.zzfgb).put("isNative", this.b.zzmj());
            if (Build.VERSION.SDK_INT >= 20) {
                isScreenOn = this.c.isInteractive();
            } else {
                isScreenOn = this.c.isScreenOn();
            }
            put2.put("isScreenOn", isScreenOn).put("appMuted", zzk.zzll().zzpr()).put("appVolume", zzk.zzll().zzpq()).put("deviceVolume", zzaya.zzba(this.f2933a.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.f2933a.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzudVar.zzza).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzudVar.zzbtq.top).put("bottom", zzudVar.zzbtq.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzudVar.zzbtq.left).put("right", zzudVar.zzbtq.right)).put("adBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzudVar.zzbtr.top).put("bottom", zzudVar.zzbtr.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzudVar.zzbtr.left).put("right", zzudVar.zzbtr.right)).put("globalVisibleBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzudVar.zzbts.top).put("bottom", zzudVar.zzbts.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzudVar.zzbts.left).put("right", zzudVar.zzbts.right)).put("globalVisibleBoxVisible", zzudVar.zzbtt).put("localVisibleBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzudVar.zzbtu.top).put("bottom", zzudVar.zzbtu.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzudVar.zzbtu.left).put("right", zzudVar.zzbtu.right)).put("localVisibleBoxVisible", zzudVar.zzbtv).put("hitBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzudVar.zzbtw.top).put("bottom", zzudVar.zzbtw.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzudVar.zzbtw.left).put("right", zzudVar.zzbtw.right)).put("screenDensity", this.f2933a.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmpVar.zzbtk);
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcql)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                if (zzudVar.zzbty != null) {
                    for (Rect rect2 : zzudVar.zzbty) {
                        jSONArray2.put(new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect2.top).put("bottom", rect2.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmpVar.zzfgd)) {
                jSONObject3.put("doneReasonCode", AnalyticsEventKey.URL);
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
