package com.ihoc.mgpa.predownload;

import android.os.Build;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.c.r;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.predownload.h;
import com.intlgame.webview.WebViewManager;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements h.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f5698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar) {
        this.f5698a = hVar;
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public HashMap<String, String> a() {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap<String, String> hashMap = new HashMap<>();
        str = this.f5698a.d;
        hashMap.put("api_key", str);
        hashMap.put("model", com.ihoc.mgpa.n.f.d());
        hashMap.put("manufacturer", Build.MANUFACTURER);
        str2 = this.f5698a.b;
        hashMap.put(WebViewManager.KEY_JS_CHANNEL, str2);
        str3 = this.f5698a.f5699a;
        hashMap.put("app_name", str3);
        hashMap.put("sdk_code", String.valueOf(BuildConfig.VERSION_CODE));
        hashMap.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put(DeviceInfoName.XID_STRING, r.c());
        str4 = this.f5698a.f;
        hashMap.put("oaid", str4 == null ? "" : this.f5698a.f);
        return hashMap;
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public void a(String str) {
        if (str != null) {
            m.a("Channel download result report success. data: %s", str);
        } else {
            m.a("Channel download result report failed. ", new Object[0]);
        }
    }

    @Override // com.ihoc.mgpa.predownload.h.c
    public HashMap<String, String> b() {
        HashMap<String, String> a2;
        a2 = this.f5698a.a();
        return a2;
    }
}
