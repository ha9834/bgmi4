package com.intlgame.api;

import com.intlgame.core.INTLErrorCode;
import com.intlgame.tools.json.JsonProp;
import com.intlgame.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class INTLResult extends JsonSerializable {
    private static final String DEFAULT_EMPTY = "";

    @JsonProp("extraJson")
    public String extra_json_;

    @JsonProp("methodID")
    public int method_id_;

    @JsonProp("retCode")
    public int ret_code_;

    @JsonProp("retMsg")
    public String ret_msg_;

    @JsonProp("ret")
    public int third_code_;

    @JsonProp("msg")
    public String third_msg_;

    public INTLResult() {
    }

    public INTLResult(int i) {
        this.ret_code_ = i;
        this.ret_msg_ = INTLErrorCode.get(i);
    }

    public INTLResult(int i, int i2) {
        this(i, i2, 1, "");
    }

    public INTLResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public INTLResult(String str) throws JSONException {
        super(str);
    }

    public INTLResult(int i, int i2, int i3, String str) {
        this(i, i2, INTLErrorCode.get(i2), i3, str);
    }

    public INTLResult(int i, int i2, String str, int i3, String str2) {
        this.ret_code_ = i2;
        this.ret_msg_ = str;
        this.third_code_ = i3;
        this.third_msg_ = str2;
        this.method_id_ = i;
    }

    public INTLResult(int i, int i2, int i3) {
        this(i, i2, INTLErrorCode.get(i2), i3, "");
    }

    public INTLResult(int i, int i2, String str) {
        this(0, i, INTLErrorCode.get(i), i2, str);
    }

    public String toString() {
        return "INTLResult{methodNameID=" + this.method_id_ + ", retCode=" + this.ret_code_ + ", retMsg='" + this.ret_msg_ + "', thirdCode=" + this.third_code_ + ", thirdMsg='" + this.third_msg_ + "', extraJson='" + this.extra_json_ + "'}";
    }
}
