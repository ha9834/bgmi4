package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzctp implements zzcva<zzcto> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3432a;
    private final zzcxv b;
    private final PackageInfo c;
    private final zzaxb d;

    public zzctp(zzbbl zzbblVar, zzcxv zzcxvVar, @Nullable PackageInfo packageInfo, zzaxb zzaxbVar) {
        this.f3432a = zzbblVar;
        this.b = zzcxvVar;
        this.c = packageInfo;
        this.d = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcto> zzalm() {
        return this.f3432a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yt

            /* renamed from: a, reason: collision with root package name */
            private final zzctp f2646a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2646a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2646a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ArrayList arrayList, Bundle bundle) {
        String str;
        String str2;
        JSONArray optJSONArray;
        String str3;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.b.zzgld);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsg)).booleanValue() && this.b.zzdgs.versionCode > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            switch (this.b.zzdgs.zzbqd) {
                case 1:
                    str3 = "any";
                    break;
                case 2:
                    str3 = "landscape";
                    break;
                case 3:
                    str3 = "portrait";
                    break;
                case 4:
                    str3 = MessengerShareContentUtility.IMAGE_RATIO_SQUARE;
                    break;
                default:
                    str3 = "unknown";
                    break;
            }
            if (!"unknown".equals(str3)) {
                bundle.putString("native_media_orientation", str3);
            }
        }
        switch (this.b.zzdgs.zzbqc) {
            case 0:
                str = "any";
                break;
            case 1:
                str = "portrait";
                break;
            case 2:
                str = "landscape";
                break;
            default:
                str = "unknown";
                break;
        }
        if (!"unknown".equals(str)) {
            bundle.putString("native_image_orientation", str);
        }
        bundle.putBoolean("native_multiple_images", this.b.zzdgs.zzbqe);
        bundle.putBoolean("use_custom_mute", this.b.zzdgs.zzbqh);
        PackageInfo packageInfo = this.c;
        int i = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i > this.d.zzvq()) {
            this.d.zzvw();
            this.d.zzct(i);
        }
        JSONObject zzvv = this.d.zzvv();
        String jSONArray = (zzvv == null || (optJSONArray = zzvv.optJSONArray(this.b.zzglb)) == null) ? null : optJSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray)) {
            bundle.putString("native_advanced_settings", jSONArray);
        }
        if (this.b.zzglg > 1) {
            bundle.putInt("max_num_ads", this.b.zzglg);
        }
        if (this.b.zzdne != null) {
            zzaiy zzaiyVar = this.b.zzdne;
            switch (zzaiyVar.zzdbe) {
                case 1:
                    str2 = AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL;
                    break;
                case 2:
                    str2 = AnalyticsEventKey.PROTOCOL;
                    break;
                default:
                    int i2 = zzaiyVar.zzdbe;
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Instream ad video aspect ratio ");
                    sb.append(i2);
                    sb.append(" is wrong.");
                    zzbad.zzen(sb.toString());
                    str2 = AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL;
                    break;
            }
            bundle.putString("ia_var", str2);
            bundle.putBoolean("instr", true);
        }
        if (this.b.zzamn() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcto a() throws Exception {
        final ArrayList<String> arrayList = this.b.zzglc;
        if (arrayList == null) {
            return yu.f2647a;
        }
        if (arrayList.isEmpty()) {
            return yv.f2648a;
        }
        return new zzcto(this, arrayList) { // from class: com.google.android.gms.internal.ads.yw

            /* renamed from: a, reason: collision with root package name */
            private final zzctp f2649a;
            private final ArrayList b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2649a = this;
                this.b = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Bundle bundle) {
                this.f2649a.a(this.b, bundle);
            }
        };
    }
}
