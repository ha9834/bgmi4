package com.tencent.crashsight.core.api;

import com.tencent.crashsight.core.UQMErrorCode;
import com.tencent.crashsight.core.tools.json.JsonProp;
import com.tencent.crashsight.core.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UQMRet extends JsonSerializable {

    @JsonProp("extraJson")
    public String extraJson;

    @JsonProp("methodNameID")
    public int methodNameID;

    @JsonProp("retCode")
    public int retCode;

    @JsonProp("retMsg")
    public String retMsg;

    @JsonProp("ret")
    public int thirdCode;

    @JsonProp("msg")
    public String thirdMsg;

    public UQMRet() {
    }

    public UQMRet(int i) {
        this.retCode = i;
        this.retMsg = UQMErrorCode.get(i);
    }

    public UQMRet(int i, int i2) {
        this(i, i2, 1, "");
    }

    public UQMRet(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public UQMRet(String str) throws JSONException {
        super(str);
    }

    public UQMRet(int i, int i2, int i3, String str) {
        this(i, i2, UQMErrorCode.get(i2), i3, str);
    }

    public UQMRet(int i, int i2, String str, int i3, String str2) {
        this.retCode = i2;
        this.retMsg = str;
        this.thirdCode = i3;
        this.thirdMsg = str2;
        this.methodNameID = i;
    }

    public UQMRet(int i, int i2, int i3) {
        this(i, i2, UQMErrorCode.get(i2), i3, "");
    }

    public UQMRet(int i, int i2, String str) {
        this(0, i, UQMErrorCode.get(i), i2, str);
    }

    public String toString() {
        return "UQMRet{methodNameID=" + this.methodNameID + ", retCode=" + this.retCode + ", retMsg='" + this.retMsg + "', thirdCode=" + this.thirdCode + ", thirdMsg='" + this.thirdMsg + "', extraJson='" + this.extraJson + "'}";
    }
}
