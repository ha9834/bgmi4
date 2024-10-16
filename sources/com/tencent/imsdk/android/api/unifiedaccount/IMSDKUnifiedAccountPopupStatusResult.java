package com.tencent.imsdk.android.api.unifiedaccount;

import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKUnifiedAccountPopupStatusResult extends IMSDKResult {

    @JsonProp("need_popup")
    public int needPopup;

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_PTICKET)
    public String pTicket;

    @JsonProp("ret")
    public int retCode;

    @JsonProp("msg")
    public String retMsg;

    public IMSDKUnifiedAccountPopupStatusResult(int i, String str) {
        super(i, str);
    }

    public IMSDKUnifiedAccountPopupStatusResult(int i, int i2) {
        super(i, i2);
        this.retCode = i2;
    }

    public IMSDKUnifiedAccountPopupStatusResult(String str) throws JSONException {
        super(str);
        if (this.retCode == 0) {
            this.imsdkRetCode = 1;
            this.imsdkRetMsg = "success";
        }
        this.thirdRetCode = this.retCode;
        this.thirdRetMsg = this.retMsg;
    }

    public IMSDKUnifiedAccountPopupStatusResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
        this.retCode = i2;
        this.retMsg = str2;
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", retCode=" + this.retCode + ", retMsg='" + this.retMsg + "', need_popup=" + this.needPopup + ", pticket='" + this.pTicket;
    }
}
