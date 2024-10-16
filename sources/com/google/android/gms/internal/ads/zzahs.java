package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.IR;
import java.net.URISyntaxException;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahs<T extends zzbhx & zzbhy & zzbic & zzbif & zzbih> implements zzaho<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzb f2733a;
    private final zzapr b;

    public zzahs(com.google.android.gms.ads.internal.zzb zzbVar, zzapr zzaprVar) {
        this.f2733a = zzbVar;
        this.b = zzaprVar;
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (AnalyticsEventKey.PROTOCOL.equalsIgnoreCase(str)) {
            zzk.zzli();
            return 7;
        }
        if (AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL.equalsIgnoreCase(str)) {
            zzk.zzli();
            return 6;
        }
        if (IR.path.DOCS_IMSDK_CHANNEL.equalsIgnoreCase(str)) {
            return zzk.zzli().zzwf();
        }
        return -1;
    }

    private final void a(boolean z) {
        zzapr zzaprVar = this.b;
        if (zzaprVar != null) {
            zzaprVar.zzw(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static String a(Context context, zzdh zzdhVar, String str, View view, Activity activity) {
        if (zzdhVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzdhVar.zzd(parse)) {
                parse = zzdhVar.zza(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzdi unused) {
            return str;
        } catch (Exception e) {
            zzk.zzlk().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbhx zzbhxVar = (zzbhx) obj;
        String zzd = zzavx.zzd((String) map.get(AnalyticsEventKey.URL), zzbhxVar.getContext(), true);
        String str = (String) map.get(AnalyticsEventKey.ACTION_SHA);
        if (str == null) {
            zzawz.zzep("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.f2733a;
        if (zzbVar != null && !zzbVar.zzkx()) {
            this.f2733a.zzbk(zzd);
            return;
        }
        if ("expand".equalsIgnoreCase(str)) {
            if (((zzbhy) zzbhxVar).zzaan()) {
                zzawz.zzep("Cannot expand WebView that is already expanded.");
                return;
            } else {
                a(false);
                ((zzbic) zzbhxVar).zzc(a((Map<String, String>) map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            a(false);
            if (zzd != null) {
                ((zzbic) zzbhxVar).zza(a((Map<String, String>) map), b(map), zzd);
                return;
            } else {
                ((zzbic) zzbhxVar).zza(a((Map<String, String>) map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            a(true);
            if (TextUtils.isEmpty(zzd)) {
                zzawz.zzep("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbic) zzbhxVar).zza(new com.google.android.gms.ads.internal.overlay.zzc(new zzaht(zzbhxVar.getContext(), ((zzbif) zzbhxVar).zzaal(), ((zzbih) zzbhxVar).getView()).zze(map)));
                return;
            } catch (ActivityNotFoundException e) {
                zzawz.zzep(e.getMessage());
                return;
            }
        }
        a(true);
        String str2 = (String) map.get("intent_url");
        Intent intent = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                intent = Intent.parseUri(str2, 0);
            } catch (URISyntaxException e2) {
                String valueOf = String.valueOf(str2);
                zzawz.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String uri = data.toString();
            if (!TextUtils.isEmpty(uri)) {
                try {
                    uri = a(zzbhxVar.getContext(), ((zzbif) zzbhxVar).zzaal(), uri, ((zzbih) zzbhxVar).getView(), zzbhxVar.zzyd());
                } catch (Exception e3) {
                    zzawz.zzc("Error occurred while adding signals.", e3);
                    zzk.zzlk().zza(e3, "OpenGmsgHandler.onGmsg");
                }
                try {
                    data = Uri.parse(uri);
                } catch (Exception e4) {
                    String valueOf2 = String.valueOf(uri);
                    zzawz.zzc(valueOf2.length() != 0 ? "Error parsing the uri: ".concat(valueOf2) : new String("Error parsing the uri: "), e4);
                    zzk.zzlk().zza(e4, "OpenGmsgHandler.onGmsg");
                }
            }
            intent.setData(data);
        }
        if (intent != null) {
            ((zzbic) zzbhxVar).zza(new com.google.android.gms.ads.internal.overlay.zzc(intent));
        } else {
            ((zzbic) zzbhxVar).zza(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), !TextUtils.isEmpty(zzd) ? a(zzbhxVar.getContext(), ((zzbif) zzbhxVar).zzaal(), zzd, ((zzbih) zzbhxVar).getView(), zzbhxVar.zzyd()) : zzd, (String) map.get("m"), (String) map.get(AnalyticsEventKey.PROTOCOL), (String) map.get(IR.path.DOCS_IMSDK_CHANNEL), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
