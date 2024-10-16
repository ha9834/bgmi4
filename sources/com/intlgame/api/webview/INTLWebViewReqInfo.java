package com.intlgame.api.webview;

import com.intlgame.tools.json.JsonProp;
import com.intlgame.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class INTLWebViewReqInfo extends JsonSerializable {
    public static final int WEBVIEW_SCREEN_DEFAULT = 1;
    public static final int WEBVIEW_SCREEN_LANDSCAPE = 3;
    public static final int WEBVIEW_SCREEN_PORTRAIT = 2;
    public boolean encrypt_enable_;

    @JsonProp("extra_json_")
    public String extra_json_;
    public boolean full_screen_enable_;

    @JsonProp("screen_orientation_")
    public int screen_orientation_;

    @JsonProp("system_browser_enable_")
    public boolean system_browser_enable_;

    @JsonProp("url_")
    public String url_;

    public INTLWebViewReqInfo() {
    }

    public INTLWebViewReqInfo(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public INTLWebViewReqInfo(String str) throws JSONException {
        super(str);
    }

    public String toString() {
        return "INTLWebViewReqInfo{url_='" + this.url_ + "', system_browser_enable_=" + this.system_browser_enable_ + ", screen_orientation_=" + this.screen_orientation_ + ", full_screen_enable_=" + this.full_screen_enable_ + ", encrypt_enable_=" + this.encrypt_enable_ + ", extra_json_='" + this.extra_json_ + "'}";
    }
}
