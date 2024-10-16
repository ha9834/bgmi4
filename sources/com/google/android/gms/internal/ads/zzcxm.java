package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcxm {
    public final String zzatl;
    public final boolean zzbrm;
    public final String zzdej;
    public final String zzdeu;
    public final String zzdev;
    public final List<String> zzdfe;
    public final List<String> zzdff;
    public final String zzdfk;
    public final boolean zzdfr;
    public final boolean zzdfs;
    public final boolean zzdft;
    public final List<String> zzdnl;
    public final String zzdno;
    public final String zzdnr;

    @Nullable
    public final zzato zzdnx;
    public final List<String> zzdny;
    public final List<String> zzdnz;
    public final boolean zzdoh;
    public final boolean zzdok;
    public final boolean zzdol;
    public final boolean zzdpc;
    public final String zzemu;
    public final int zzflt;
    public final List<String> zzgjy;
    public final int zzgjz;
    public final List<String> zzgka;
    public final List<String> zzgkb;
    public final List<String> zzgkc;
    public final List<zzcxn> zzgkd;

    @Nullable
    public final zzcxq zzgke;
    public final List<String> zzgkf;
    public final List<zzcxn> zzgkg;
    public final JSONObject zzgkh;
    public final zzauy zzgki;
    public final JSONObject zzgkj;
    public final JSONObject zzgkk;
    public final boolean zzgkl;
    public final int zzgkm;
    public final int zzgkn;
    public final JSONObject zzgko;
    public final int zzgkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxm(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> list;
        char c;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<zzcxn> emptyList10 = Collections.emptyList();
        List<String> emptyList11 = Collections.emptyList();
        List<zzcxn> emptyList12 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jsonReader.beginObject();
        List<String> list2 = emptyList11;
        List<zzcxn> list3 = emptyList12;
        JSONObject jSONObject5 = jSONObject;
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        JSONObject jSONObject6 = jSONObject2;
        JSONObject jSONObject7 = jSONObject3;
        String str6 = "";
        JSONObject jSONObject8 = jSONObject4;
        zzcxq zzcxqVar = null;
        zzauy zzauyVar = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = -1;
        int i2 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i3 = 0;
        List<String> list4 = emptyList8;
        List<String> list5 = emptyList9;
        List<zzcxn> list6 = emptyList10;
        zzato zzatoVar = null;
        String str7 = "";
        String str8 = "";
        List<String> list7 = emptyList6;
        List<String> list8 = emptyList7;
        int i4 = 0;
        List<String> list9 = emptyList5;
        List<String> list10 = emptyList4;
        List<String> list11 = emptyList3;
        List<String> list12 = emptyList2;
        int i5 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str9 = nextName == null ? "" : nextName;
            List<zzcxn> list13 = list6;
            switch (str9.hashCode()) {
                case -1980587809:
                    list = list5;
                    if (str9.equals("debug_signals")) {
                        c = 26;
                        break;
                    }
                    break;
                case -1965512151:
                    list = list5;
                    if (str9.equals("omid_settings")) {
                        c = '&';
                        break;
                    }
                    break;
                case -1440104884:
                    list = list5;
                    if (str9.equals("is_custom_close_blocked")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1439500848:
                    list = list5;
                    if (str9.equals("orientation")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1428969291:
                    list = list5;
                    if (str9.equals("enable_omid")) {
                        c = '$';
                        break;
                    }
                    break;
                case -1403779768:
                    list = list5;
                    if (str9.equals("showable_impression_type")) {
                        c = ')';
                        break;
                    }
                    break;
                case -1360811658:
                    list = list5;
                    if (str9.equals("ad_sizes")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1306015996:
                    list = list5;
                    if (str9.equals("adapters")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1289032093:
                    list = list5;
                    if (str9.equals(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
                        c = 27;
                        break;
                    }
                    break;
                case -1234181075:
                    list = list5;
                    if (str9.equals("allow_pub_rendered_attribution")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1152230954:
                    list = list5;
                    if (str9.equals(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1146534047:
                    list = list5;
                    if (str9.equals("is_scroll_aware")) {
                        c = '(';
                        break;
                    }
                    break;
                case -1115838944:
                    list = list5;
                    if (str9.equals("fill_urls")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1081936678:
                    list = list5;
                    if (str9.equals("allocation_id")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1078050970:
                    list = list5;
                    if (str9.equals("video_complete_urls")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1051269058:
                    list = list5;
                    if (str9.equals("active_view")) {
                        c = 23;
                        break;
                    }
                    break;
                case -982608540:
                    list = list5;
                    if (str9.equals("valid_from_timestamp")) {
                        c = 11;
                        break;
                    }
                    break;
                case -776859333:
                    list = list5;
                    if (str9.equals("click_urls")) {
                        c = 2;
                        break;
                    }
                    break;
                case -544216775:
                    list = list5;
                    if (str9.equals("safe_browsing")) {
                        c = 24;
                        break;
                    }
                    break;
                case -437057161:
                    list = list5;
                    if (str9.equals("imp_urls")) {
                        c = 3;
                        break;
                    }
                    break;
                case -404326515:
                    list = list5;
                    if (str9.equals("render_timeout_ms")) {
                        c = '#';
                        break;
                    }
                    break;
                case -29338502:
                    list = list5;
                    if (str9.equals("allow_custom_click_gesture")) {
                        c = 30;
                        break;
                    }
                    break;
                case 3107:
                    list = list5;
                    if (str9.equals("ad")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3355:
                    list = list5;
                    if (str9.equals("id")) {
                        c = 21;
                        break;
                    }
                    break;
                case 3076010:
                    list = list5;
                    if (str9.equals("data")) {
                        c = 20;
                        break;
                    }
                    break;
                case 63195984:
                    list = list5;
                    if (str9.equals("render_test_label")) {
                        c = 31;
                        break;
                    }
                    break;
                case 107433883:
                    list = list5;
                    if (str9.equals("qdata")) {
                        c = 22;
                        break;
                    }
                    break;
                case 230323073:
                    list = list5;
                    if (str9.equals("ad_load_urls")) {
                        c = 4;
                        break;
                    }
                    break;
                case 418392395:
                    list = list5;
                    if (str9.equals("is_closable_area_disabled")) {
                        c = '!';
                        break;
                    }
                    break;
                case 597473788:
                    list = list5;
                    if (str9.equals("debug_dialog_string")) {
                        c = 25;
                        break;
                    }
                    break;
                case 673261304:
                    list = list5;
                    if (str9.equals("reward_granted_urls")) {
                        c = 7;
                        break;
                    }
                    break;
                case 754887508:
                    list = list5;
                    if (str9.equals("container_sizes")) {
                        c = 15;
                        break;
                    }
                    break;
                case 791122864:
                    list = list5;
                    if (str9.equals("impression_type")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1010584092:
                    list = list5;
                    if (str9.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1100650276:
                    list = list5;
                    if (str9.equals("rewards")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1321720943:
                    list = list5;
                    if (str9.equals("allow_pub_owned_ad_view")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1637553475:
                    list = list5;
                    if (str9.equals("bid_response")) {
                        c = '%';
                        break;
                    }
                    break;
                case 1638957285:
                    list = list5;
                    if (str9.equals("video_start_urls")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1688341040:
                    list = list5;
                    if (str9.equals("video_reward_urls")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1839650832:
                    list = list5;
                    if (str9.equals("renderers")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1875425491:
                    list = list5;
                    if (str9.equals("is_analytics_logging_enabled")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 2072888499:
                    list = list5;
                    if (str9.equals("manual_tracking_urls")) {
                        c = 14;
                        break;
                    }
                    break;
                default:
                    list = list5;
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    emptyList = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 1:
                    String nextString = jsonReader.nextString();
                    if ("banner".equals(nextString)) {
                        i5 = 1;
                    } else if ("interstitial".equals(nextString)) {
                        i5 = 2;
                    } else if ("native_express".equals(nextString)) {
                        i5 = 3;
                    } else if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(nextString)) {
                        i5 = 4;
                    } else {
                        i5 = "rewarded".equals(nextString) ? 5 : 0;
                    }
                    list6 = list13;
                    list5 = list;
                    continue;
                case 2:
                    list12 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 3:
                    list11 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 4:
                    list10 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 5:
                    i4 = jsonReader.nextInt();
                    if (i4 != 0 && i4 != 1) {
                        i4 = 0;
                    }
                    list6 = list13;
                    list5 = list;
                    continue;
                case 6:
                    list9 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 7:
                    zzazc.zza(jsonReader);
                    break;
                case '\b':
                    list7 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\t':
                    list8 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\n':
                    str7 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 11:
                    str8 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\f':
                    zzatoVar = zzato.zza(zzazc.zzd(jsonReader));
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\r':
                    list4 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 14:
                    list5 = zzazc.zza(jsonReader);
                    list6 = list13;
                    continue;
                case 15:
                    list6 = zzcxn.a(jsonReader);
                    list5 = list;
                    continue;
                case 16:
                    zzcxqVar = new zzcxq(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 17:
                    list3 = zzcxn.a(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 18:
                    list2 = zzazc.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 19:
                    str = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 20:
                    jSONObject5 = zzazc.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 21:
                    str2 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 22:
                    str3 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 23:
                    str4 = zzazc.zzc(jsonReader).toString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 24:
                    zzauyVar = zzauy.zzg(zzazc.zzc(jsonReader));
                    list6 = list13;
                    list5 = list;
                    continue;
                case 25:
                    str5 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 26:
                    jSONObject6 = zzazc.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 27:
                    jSONObject7 = zzazc.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case 28:
                    z = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 29:
                    z2 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 30:
                    z3 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case 31:
                    z4 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case ' ':
                    z5 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '!':
                    z6 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\"':
                    String nextString2 = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString2)) {
                        zzk.zzli();
                        i = 6;
                    } else if ("portrait".equalsIgnoreCase(nextString2)) {
                        zzk.zzli();
                        i = 7;
                    } else {
                        i = -1;
                    }
                    list6 = list13;
                    list5 = list;
                    continue;
                case '#':
                    i2 = jsonReader.nextInt();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '$':
                    z7 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '%':
                    str6 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '&':
                    jSONObject8 = zzazc.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    continue;
                case '\'':
                    z8 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case '(':
                    z9 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    continue;
                case ')':
                    i3 = jsonReader.nextInt();
                    list6 = list13;
                    list5 = list;
                    continue;
                default:
                    jsonReader.skipValue();
                    break;
            }
            list6 = list13;
            list5 = list;
        }
        jsonReader.endObject();
        this.zzgjy = emptyList;
        this.zzflt = i5;
        this.zzdfe = list12;
        this.zzdff = list11;
        this.zzgka = list10;
        this.zzgjz = i4;
        this.zzdny = list9;
        this.zzdnz = list7;
        this.zzgkb = list8;
        this.zzdeu = str7;
        this.zzdev = str8;
        this.zzdnx = zzatoVar;
        this.zzgkc = list4;
        this.zzdnl = list5;
        this.zzgkd = list6;
        this.zzgke = zzcxqVar;
        this.zzgkf = list2;
        this.zzgkg = list3;
        this.zzdej = str;
        this.zzgkh = jSONObject5;
        this.zzatl = str2;
        this.zzdfk = str3;
        this.zzdnr = str4;
        this.zzgki = zzauyVar;
        this.zzdno = str5;
        this.zzgkj = jSONObject6;
        this.zzgkk = jSONObject7;
        this.zzdfr = z;
        this.zzdfs = z2;
        this.zzdft = z3;
        this.zzdpc = z4;
        this.zzgkl = z5;
        this.zzbrm = z6;
        this.zzgkm = i;
        this.zzgkn = i2;
        this.zzdoh = z7;
        this.zzemu = str6;
        this.zzgko = jSONObject8;
        this.zzdok = z8;
        this.zzdol = z9;
        this.zzgkp = i3;
    }
}
