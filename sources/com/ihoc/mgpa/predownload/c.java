package com.ihoc.mgpa.predownload;

import android.content.Context;
import com.ihoc.mgpa.n.i;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.predownload.b;
import com.ihoc.mgpa.predownload.h;
import com.intlgame.webview.WebViewManager;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private static String f5692a = "default";
    private String b;
    private String c;
    private String d;

    private h a() {
        h.b a2;
        String str;
        String packageName;
        h.b bVar = new h.b();
        if (com.ihoc.mgpa.i.f.M()) {
            m.d("sdk will request the test env, make sure don't do this in the release app!", new Object[0]);
            bVar.a(com.ihoc.mgpa.i.f.M());
        }
        String str2 = this.b;
        if (str2 == null || this.c == null) {
            m.b("request params error, ple check the apiKey & apiSecret!", new Object[0]);
            a2 = bVar.a("");
            str = "";
        } else {
            a2 = bVar.a(str2);
            str = this.c;
        }
        a2.b(str);
        String str3 = this.d;
        if (str3 == null) {
            m.d("request params error, ple check the device id!", new Object[0]);
            str3 = "";
        }
        bVar.e(str3);
        String str4 = f5692a;
        if (str4 == null) {
            m.b("request params error, ple check the channel!", new Object[0]);
            str4 = "";
        }
        bVar.c(str4);
        if (com.ihoc.mgpa.n.a.a() == null) {
            m.b("request params error, ple check the context!", new Object[0]);
            packageName = "";
        } else {
            packageName = com.ihoc.mgpa.n.a.a().getPackageName();
        }
        bVar.d(packageName);
        return bVar.a();
    }

    @Override // com.ihoc.mgpa.predownload.b
    public int a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return a(context, str, new a(str2, str3, str4, str5, str6)).a();
    }

    public b.EnumC0140b a(Context context, String str, a aVar) {
        m.c("Start to combine predownloaded package.", new Object[0]);
        if (context == null) {
            return b.EnumC0140b.ContextIsNULL;
        }
        if (str == null) {
            return b.EnumC0140b.ChannelIsNULL;
        }
        if (aVar.f5686a == null) {
            return b.EnumC0140b.CDNUrlOrMD5IsNULL;
        }
        if (aVar.e == null) {
            return b.EnumC0140b.GamePackageNameIsNULL;
        }
        String str2 = aVar.c;
        if (str2 == null) {
            return b.EnumC0140b.PredownFilePathIsNULL;
        }
        if (!i.h(str2)) {
            return b.EnumC0140b.PredownFilePathNotExsit;
        }
        e eVar = new e(aVar);
        eVar.d();
        com.ihoc.mgpa.n.a.a(context);
        f5692a = str;
        String a2 = a().a(context.getPackageName(), aVar);
        eVar.b();
        b.EnumC0140b a3 = eVar.a(a2);
        if (a3 == b.EnumC0140b.Success) {
            m.c("request combine info success!", new Object[0]);
            a3 = eVar.a(a2, aVar);
        } else {
            m.b("request combine info failed. error code: %d", Integer.valueOf(a3.a()));
        }
        if (a3 == b.EnumC0140b.Success) {
            m.c("combine apk success.", new Object[0]);
        } else {
            m.b("combine apk failed. error code: %d", Integer.valueOf(a3.a()));
        }
        eVar.c();
        HashMap<String, String> a4 = eVar.a();
        a4.put("status", a3 == b.EnumC0140b.Success ? "0" : "1");
        a4.put("error_code", String.valueOf(a3.a()));
        a().a(a4);
        return a3;
    }

    @Override // com.ihoc.mgpa.predownload.b
    public void a(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback) {
        m.c("Start to get game version predownload info.", new Object[0]);
        f5692a = str;
        a().a(gameCallback).a(context, arrayList);
        m.a("Start to get game version update info , wait for callback.", new Object[0]);
    }

    @Override // com.ihoc.mgpa.predownload.b
    public void a(Context context, HashMap<String, String> hashMap) {
        String str;
        com.ihoc.mgpa.n.a.a(context);
        if (hashMap.containsKey(WebViewManager.KEY_JS_CHANNEL) && (str = hashMap.get(WebViewManager.KEY_JS_CHANNEL)) != null) {
            f5692a = str;
        }
        hashMap.put("event_name", "PreDownloadFile");
        hashMap.put("load_time", String.valueOf(System.currentTimeMillis() / 1000));
        a().a(hashMap);
    }

    @Override // com.ihoc.mgpa.predownload.b
    public void a(String str) {
        this.b = str;
    }

    @Override // com.ihoc.mgpa.predownload.b
    public void b(String str) {
        this.d = str;
    }

    @Override // com.ihoc.mgpa.predownload.b
    public void c(String str) {
        this.c = str;
    }
}
