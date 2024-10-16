package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbxx implements zzbzb {

    /* renamed from: a */
    private final Context f3114a;
    private final zzbzc b;
    private final JSONObject c;
    private final zzccj d;
    private final zzbyt e;
    private final zzdh f;
    private final zzbrt g;
    private final zzbri h;
    private final zzcxm i;
    private final zzbai j;
    private final zzcxv k;
    private final zzbmn l;
    private final zzbzq m;
    private final Clock n;
    private final zzbva o;
    private final zzdae p;
    private boolean r;
    private zzaag y;
    private boolean q = false;
    private boolean s = false;
    private boolean t = false;
    private Point u = new Point();
    private Point v = new Point();
    private long w = 0;
    private long x = 0;

    public zzbxx(Context context, zzbzc zzbzcVar, JSONObject jSONObject, zzccj zzccjVar, zzbyt zzbytVar, zzdh zzdhVar, zzbrt zzbrtVar, zzbri zzbriVar, zzcxm zzcxmVar, zzbai zzbaiVar, zzcxv zzcxvVar, zzbmn zzbmnVar, zzbzq zzbzqVar, Clock clock, zzbva zzbvaVar, zzdae zzdaeVar) {
        this.f3114a = context;
        this.b = zzbzcVar;
        this.c = jSONObject;
        this.d = zzccjVar;
        this.e = zzbytVar;
        this.f = zzdhVar;
        this.g = zzbrtVar;
        this.h = zzbriVar;
        this.i = zzcxmVar;
        this.j = zzbaiVar;
        this.k = zzcxvVar;
        this.l = zzbmnVar;
        this.m = zzbzqVar;
        this.n = clock;
        this.o = zzbvaVar;
        this.p = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.u = new Point();
        this.v = new Point();
        if (!this.r) {
            this.o.zzq(view);
            this.r = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.l.zzq(this);
        if (map != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = it2.next().getValue().get();
                if (view3 != null) {
                    view3.setOnTouchListener(onTouchListener);
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        this.u = new Point();
        this.v = new Point();
        this.o.zzr(view);
        this.r = false;
    }

    private final boolean a(String str) {
        JSONObject optJSONObject = this.c.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject a2 = a(map, map2, view2);
        JSONObject a3 = a(view2);
        JSONObject b = b(view2);
        JSONObject c = c(view2);
        String a4 = a(view, map);
        a(view, a3, a2, b, c, a4, b(a4), null, z, false);
    }

    private final String a(View view, Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int zzahv = this.e.zzahv();
        if (zzahv == 6) {
            return "3099";
        }
        switch (zzahv) {
            case 1:
                return "1099";
            case 2:
                return "2099";
            case 3:
                return null;
            default:
                return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzfi(String str) {
        a(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzf(Bundle bundle) {
        if (bundle == null) {
            zzawz.zzdp("Click data is null. No click is reported.");
        } else if (!a("click_reporting")) {
            zzawz.zzen("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            a(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzk.zzlg().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.t) {
            zzawz.zzdp("Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!a()) {
            zzawz.zzdp("Custom click reporting failed. Ad unit id not whitelisted.");
            return;
        }
        JSONObject a2 = a(map, map2, view);
        JSONObject a3 = a(view);
        JSONObject b = b(view);
        JSONObject c = c(view);
        String a4 = a(null, map);
        a(view, a3, a2, b, c, a4, b(a4), null, z, true);
    }

    private final boolean a() {
        return this.c.optBoolean("allow_custom_click_gesture", false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzro() {
        this.t = true;
    }

    private final void a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.c);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.b.zzfo(this.e.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.e.zzahv());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.k.zzdgs != null && this.k.zzdgs.zzbqh);
            jSONObject8.put("custom_mute_enabled", (this.e.getMuteThisAdReasons().isEmpty() || this.e.zzahx() == null) ? false : true);
            if (this.m.zzaiz() != null && this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.n.currentTimeMillis());
            if (this.t && a()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.b.zzfo(this.e.getCustomTemplateId()) != null);
            jSONObject8.put("click_signals", d(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.n.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.w);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.x);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbao.zza(this.d.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzawz.zzc("Unable to create click JSON.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, MotionEvent motionEvent, View view2) {
        int[] e = e(view2);
        this.u = new Point(((int) motionEvent.getRawX()) - e[0], ((int) motionEvent.getRawY()) - e[1]);
        long currentTimeMillis = this.n.currentTimeMillis();
        this.x = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.w = currentTimeMillis;
            this.v = this.u;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(this.u.x, this.u.y);
        this.f.zza(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzg(Bundle bundle) {
        if (bundle == null) {
            zzawz.zzdp("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!a("touch_reporting")) {
            zzawz.zzen("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.f.zzcg().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahk() {
        a(null, null, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void setClickConfirmingView(View view) {
        if (!this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzawz.zzep("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbzq zzbzqVar = this.m;
        if (view != null) {
            view.setOnClickListener(zzbzqVar);
            view.setClickable(true);
            zzbzqVar.c = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzagd zzagdVar) {
        if (!this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzawz.zzep("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.m.zza(zzagdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void cancelUnconfirmedClick() {
        if (this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.m.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzaak zzaakVar) {
        try {
            if (this.s) {
                return;
            }
            if (zzaakVar == null && this.e.zzahx() != null) {
                this.s = true;
                this.p.zzed(this.e.zzahx().zzpt());
                zzahl();
            } else {
                this.s = true;
                this.p.zzed(zzaakVar.zzpt());
                zzahl();
            }
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzaag zzaagVar) {
        this.y = zzaagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahl() {
        try {
            if (this.y != null) {
                this.y.onAdMuted();
            }
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        a(a(view), a(map, map2, view), b(view), c(view), null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahm() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.c);
            zzbao.zza(this.d.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean zzh(Bundle bundle) {
        if (!a("impression_reporting")) {
            zzawz.zzen("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return a(null, null, null, null, zzk.zzlg().zza(bundle, (JSONObject) null));
    }

    private final boolean a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            this.d.zza("/logScionEvent", new pz(this));
            this.d.zza("/nativeImpression", new qb(this));
            zzbao.zza(this.d.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.q || this.i.zzgkj == null) {
                return true;
            }
            this.q |= zzk.zzlq().zzb(this.f3114a, this.j.zzbsx, this.i.zzgkj.toString(), this.k.zzglb);
            return true;
        } catch (JSONException e) {
            zzawz.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final JSONObject a(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, a(rect.right - rect.left));
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, a(rect.bottom - rect.top));
        jSONObject.put("x", a(rect.left));
        jSONObject.put("y", a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0104 A[Catch: JSONException -> 0x0115, TryCatch #3 {JSONException -> 0x0115, blocks: (B:18:0x00dc, B:23:0x00fe, B:25:0x0111, B:26:0x0104, B:27:0x010b, B:28:0x00eb, B:31:0x00f5), top: B:17:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b A[Catch: JSONException -> 0x0115, TryCatch #3 {JSONException -> 0x0115, blocks: (B:18:0x00dc, B:23:0x00fe, B:25:0x0111, B:26:0x0104, B:27:0x010b, B:28:0x00eb, B:31:0x00f5), top: B:17:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5 A[Catch: JSONException -> 0x0115, TryCatch #3 {JSONException -> 0x0115, blocks: (B:18:0x00dc, B:23:0x00fe, B:25:0x0111, B:26:0x0104, B:27:0x010b, B:28:0x00eb, B:31:0x00f5), top: B:17:0x00dc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final org.json.JSONObject a(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxx.a(android.view.View):org.json.JSONObject");
    }

    private static JSONObject b(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("contained_in_scroll_view", zzaxi.zzp(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject c(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("can_show_on_lock_screen", zzaxi.zzo(view));
            zzk.zzlg();
            jSONObject.put("is_keyguard_locked", zzaxi.zzat(this.f3114a));
        } catch (JSONException unused) {
            zzawz.zzep("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final JSONObject a(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] e = e(view);
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            View view2 = entry.getValue().get();
            if (view2 != null) {
                int[] e2 = e(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, a(view2.getMeasuredWidth()));
                    jSONObject4.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, a(view2.getMeasuredHeight()));
                    boolean z = false;
                    jSONObject4.put("x", a(e2[0] - e[0]));
                    jSONObject4.put("y", a(e2[1] - e[1]));
                    jSONObject4.put("relative_to", "ad_view");
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = a(rect);
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
                        jSONObject5.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
                        jSONObject5.put("x", a(e2[0] - e[0]));
                        jSONObject5.put("y", a(e2[1] - e[1]));
                        jSONObject5.put("relative_to", "ad_view");
                        jSONObject = jSONObject5;
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        jSONObject3.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                        jSONObject3.put("text", textView.getText());
                    }
                    if (map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable()) {
                        z = true;
                    }
                    jSONObject3.put("is_clickable", z);
                    jSONObject2.put(entry.getKey(), jSONObject3);
                } catch (JSONException unused) {
                    zzawz.zzep("Unable to get asset views information");
                }
            }
        }
        return jSONObject2;
    }

    private final String d(View view) {
        try {
            JSONObject optJSONObject = this.c.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.f.zzcg().zza(this.f3114a, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzawz.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final JSONObject b(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put("click_point", b());
            jSONObject.put("asset_id", str);
        } catch (Exception e2) {
            e = e2;
            zzawz.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    private final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(this.u.x));
            jSONObject.put("y", a(this.u.y));
            jSONObject.put("start_x", a(this.v.x));
            jSONObject.put("start_y", a(this.v.y));
            return jSONObject;
        } catch (JSONException e) {
            zzawz.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    private static int[] e(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private final int a(int i) {
        return zzyt.zzpa().zzb(this.f3114a, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void destroy() {
        this.d.destroy();
    }
}
