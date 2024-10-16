package com.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.UnsupportedEncodingException;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class d implements com.a.a.a.d {

    /* renamed from: a, reason: collision with root package name */
    protected WebView f939a;

    public d(Context context, com.a.a.a.a aVar) {
        this.f939a = new WebView(context);
        this.f939a.setWillNotDraw(true);
        WebSettings settings = this.f939a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName(HttpUtils.DEFAULT_ENCODE_NAME);
        this.f939a.addJavascriptInterface(new b(aVar), "evgeniiJsEvaluator");
    }

    @Override // com.a.a.a.d
    public void a(String str) {
        try {
            String encodeToString = Base64.encodeToString(("<script>" + str + "</script>").getBytes("UTF-8"), 0);
            this.f939a.loadUrl("data:text/html;charset=utf-8;base64," + encodeToString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
