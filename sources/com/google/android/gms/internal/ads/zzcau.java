package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.services.s3.util.Mimetypes;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.games.GamesStatusCodes;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.webview.qq.WebViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcau {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3161a;
    private final zzcan b;
    private final zzdh c;
    private final zzbai d;
    private final com.google.android.gms.ads.internal.zza e;
    private final zzwj f;
    private final Executor g;
    private final zzady h;
    private final zzcbi i;
    private final ScheduledExecutorService j;

    public zzcau(Context context, zzcan zzcanVar, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar, Executor executor, zzcxv zzcxvVar, zzcbi zzcbiVar, ScheduledExecutorService scheduledExecutorService) {
        this.f3161a = context;
        this.b = zzcanVar;
        this.c = zzdhVar;
        this.d = zzbaiVar;
        this.e = zzaVar;
        this.f = zzwjVar;
        this.g = executor;
        this.h = zzcxvVar.zzdgs;
        this.i = zzcbiVar;
        this.j = scheduledExecutorService;
    }

    public static List<zzabj> zzi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzabj a2 = a(optJSONArray.optJSONObject(i));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static zzabj zzj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return a(optJSONObject);
    }

    private static zzabj a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzabj(optString, optString2);
    }

    public final zzbbh<zzadw> zzc(JSONObject jSONObject, String str) {
        return a(jSONObject.optJSONObject(str), this.h.zzcym);
    }

    public final zzbbh<List<zzadw>> zzd(JSONObject jSONObject, String str) {
        return a(jSONObject.optJSONArray(str), this.h.zzcym, this.h.zzbqe);
    }

    private final zzbbh<List<zzadw>> a(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzbar.zzm(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(a(jSONArray.optJSONObject(i), z));
        }
        return zzbar.zza(zzbar.zze(arrayList), qw.f2451a, this.g);
    }

    private final zzbbh<zzadw> a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzbar.zzm(null);
        }
        final String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzbar.zzm(null);
        }
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        final int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1);
        final int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1);
        if (z) {
            return zzbar.zzm(new zzadw(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return a(jSONObject.optBoolean("require"), (zzbbh<Object>) zzbar.zza(this.b.zza(optString, optDouble, optBoolean), new zzbam(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.qx

            /* renamed from: a, reason: collision with root package name */
            private final String f2452a;
            private final double b;
            private final int c;
            private final int d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2452a = optString;
                this.b = optDouble;
                this.c = optInt;
                this.d = optInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                String str = this.f2452a;
                return new zzadw(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.b, this.c, this.d);
            }
        }, this.g), (Object) null);
    }

    public final zzbbh<zzadt> zze(JSONObject jSONObject, String str) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzbar.zzm(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return a(optJSONObject.optBoolean("require"), (zzbbh<Object>) zzbar.zza(a(optJSONArray, false, true), new zzbam(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.qy

            /* renamed from: a, reason: collision with root package name */
            private final zzcau f2453a;
            private final JSONObject b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2453a = this;
                this.b = optJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                return this.f2453a.a(this.b, (List) obj);
            }
        }, this.g), (Object) null);
    }

    private static Integer a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzbbh<zzbgz> zzl(JSONObject jSONObject) {
        JSONObject zza = zzazc.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzbar.zzm(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzawz.zzep("Required field 'vast_xml' is missing");
                return zzbar.zzm(null);
            }
            return a((zzbbh<Object>) zzbar.zza(this.i.zzm(optJSONObject), ((Integer) zzyt.zzpe().zzd(zzacu.zzcse)).intValue(), TimeUnit.SECONDS, this.j), (Object) null);
        }
        return a(zza.optBoolean("require"), this.i.zzq(zza.optString(IR.MODULE_URL), zza.optString("html")), (Object) null);
    }

    private static <T> zzbbh<T> a(zzbbh<T> zzbbhVar, T t) {
        final Object obj = null;
        return zzbar.zza(zzbbhVar, Exception.class, new zzbal(obj) { // from class: com.google.android.gms.internal.ads.ra

            /* renamed from: a, reason: collision with root package name */
            private final Object f2456a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2456a = obj;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj2) {
                Object obj3 = this.f2456a;
                zzawz.zza("Error during loading assets.", (Exception) obj2);
                return zzbar.zzm(obj3);
            }
        }, zzbbm.zzeaf);
    }

    private static <T> zzbbh<T> a(boolean z, final zzbbh<T> zzbbhVar, T t) {
        if (z) {
            return zzbar.zza(zzbbhVar, new zzbal(zzbbhVar) { // from class: com.google.android.gms.internal.ads.rc

                /* renamed from: a, reason: collision with root package name */
                private final zzbbh f2458a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2458a = zzbbhVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return obj != null ? this.f2458a : zzbar.zzd(new zzcmw("Retrieve required value in native ad response failed.", 0));
                }
            }, zzbbm.zzeaf);
        }
        return a(zzbbhVar, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(String str, Object obj) throws Exception {
        zzk.zzlh();
        zzbgz zza = zzbhf.zza(this.f3161a, zzbin.zzabu(), "native-omid", false, false, this.c, this.d, null, null, this.e, this.f);
        final zzbbq zzn = zzbbq.zzn(zza);
        zza.zzaai().zza(new zzbij(zzn) { // from class: com.google.android.gms.internal.ads.rd

            /* renamed from: a, reason: collision with root package name */
            private final zzbbq f2459a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2459a = zzn;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.f2459a.zzxe();
            }
        });
        zza.loadData(str, Mimetypes.MIMETYPE_HTML, "UTF-8");
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzadt a(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer a2 = a(jSONObject, WebViewManager.INTENT_KEY_BG_COLOR);
        Integer a3 = a(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzadt(optString, list, a2, a3, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND) + optInt2, this.h.zzbqf, optBoolean);
    }
}
