package com.intlgame.api;

import com.intlgame.tools.json.JsonProp;
import com.intlgame.tools.json.JsonSerializable;
import com.intlgame.webview.WebViewManager;

/* loaded from: classes2.dex */
public class INTLBaseParams extends JsonSerializable {

    @JsonProp(WebViewManager.KEY_JS_CHANNEL)
    public String channel_;

    @JsonProp("extraJson")
    public String extra_json_;

    @JsonProp("methodID")
    public int method_id_;

    @JsonProp("seqID")
    public String seq_id_;
}
