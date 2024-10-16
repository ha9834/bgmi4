package com.ihoc.mgpa.predownload;

import android.content.Context;
import android.os.Build;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.c.r;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.predownload.h;
import com.intlgame.webview.WebViewManager;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f implements h.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f5697a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar, Context context, ArrayList arrayList) {
        this.c = hVar;
        this.f5697a = context;
        this.b = arrayList;
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public HashMap<String, String> a() {
        String b;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        b = this.c.b(this.f5697a, this.b);
        m.a("tgpa appData : %s", b);
        String valueOf = String.valueOf(System.currentTimeMillis());
        str = this.c.d;
        str2 = this.c.e;
        String format = String.format("app_data=%s&time_stamp=%s&api_key=%s&api_secret=%s", b, valueOf, str, str2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("time_stamp", valueOf);
        hashMap.put("app_data", b);
        hashMap.put("api_sign", String.valueOf(com.ihoc.mgpa.n.g.a(format)));
        str3 = this.c.d;
        hashMap.put("api_key", str3);
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put("manufacturer", Build.MANUFACTURER);
        str4 = this.c.b;
        hashMap.put(WebViewManager.KEY_JS_CHANNEL, str4);
        str5 = this.c.f5699a;
        hashMap.put("app_name", str5);
        hashMap.put("sdk_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put(DeviceInfoName.XID_STRING, r.c());
        str6 = this.c.f;
        hashMap.put("oaid", str6 == null ? "" : this.c.f);
        return hashMap;
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public void a(String str) {
        String a2;
        GameCallback gameCallback;
        GameCallback gameCallback2;
        a2 = this.c.a(str);
        m.a("onResponse: callback data has been prepared, data: %s", a2);
        gameCallback = this.c.g;
        if (gameCallback == null) {
            m.b("onResponse: no callback is found!", new Object[0]);
        } else {
            gameCallback2 = this.c.g;
            gameCallback2.getPreDownloadVersionInfo(a2);
        }
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public HashMap<String, String> b() {
        HashMap<String, String> a2;
        a2 = this.c.a();
        return a2;
    }
}
