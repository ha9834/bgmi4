package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzczs {
    SIGNALS("signals"),
    REQUEST_PARCEL("request-parcel"),
    SERVER_TRANSACTION("server-transaction"),
    RENDERER("renderer"),
    GMS_SIGNALS("gms-signals"),
    AD_REQUEST("ad_request"),
    BUILD_URL("build-url"),
    HTTP("http"),
    PRE_PROCESS("preprocess"),
    GET_SIGNALS("get-signals"),
    JS_SIGNALS("js-signals"),
    RENDER_CONFIG_INIT("render-config-init"),
    RENDER_CONFIG_WATERFALL("render-config-waterfall"),
    ADAPTER_LOAD_AD_SYN("adapter-load-ad-syn"),
    ADAPTER_LOAD_AD_ACK("adapter-load-ad-ack"),
    ADAPTER_WRAP_ADAPTER("wrap-adapter"),
    CUSTOM_RENDER_SYN("custom-render-syn"),
    CUSTOM_RENDER_ACK("custom-render-ack"),
    WEBVIEW_COOKIE("webview-cookie"),
    GENERATE_SIGNALS("generate-signals");

    private final String zzgmf;

    zzczs(String str) {
        this.zzgmf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.zzgmf;
    }
}
