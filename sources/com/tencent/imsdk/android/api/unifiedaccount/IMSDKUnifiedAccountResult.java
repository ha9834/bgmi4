package com.tencent.imsdk.android.api.unifiedaccount;

import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKUnifiedAccountResult extends IMSDKResult {

    @JsonProp("token")
    public String accountToken;

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE)
    public int accountType;

    @JsonProp("email")
    public String emailAccount;

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_EXPIRE)
    public long expireTime;

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_IS_RECEIVE_EMAIL)
    public int isReceiveEmail;

    @JsonProp("is_register")
    public int isRegister;

    @JsonProp("isset_pwd")
    public int isSetPwd;

    @JsonProp("phone")
    public String phoneAccount;

    @JsonProp("phonearea")
    public String phoneArea;

    @JsonProp("phoneextra")
    public String phoneExtra;

    @JsonProp("ret")
    public int retCode;

    @JsonProp("msg")
    public String retMsg;

    @JsonProp("uid")
    public String uid;

    @JsonProp("expire_time")
    public long verifyCodeExpire;

    public IMSDKUnifiedAccountResult(int i, String str) {
        super(i, str);
    }

    public IMSDKUnifiedAccountResult(int i, int i2) {
        super(i, i2);
        this.retCode = i2;
    }

    public IMSDKUnifiedAccountResult(String str) throws JSONException {
        super(str);
        if (this.retCode == 0) {
            this.imsdkRetCode = 1;
            this.imsdkRetMsg = "success";
        }
        this.thirdRetCode = this.retCode;
        this.thirdRetMsg = this.retMsg;
    }

    public IMSDKUnifiedAccountResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
        this.retCode = i2;
        this.retMsg = str2;
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", retCode=" + this.retCode + ", retMsg='" + this.retMsg + "', accountType=" + this.accountType + ", emailAccount'=" + this.emailAccount + "', phoneAccount='" + this.phoneAccount + "', accountToken='" + this.accountToken + "', uid='" + this.uid + "', expireTime'=" + this.expireTime + "', phoneArea'='" + this.phoneArea + "', phoneExtra'='" + this.phoneExtra + "', verifyCodeExpire='" + this.verifyCodeExpire + "', isRegister=" + this.isRegister + ", isSetPwd=" + this.isSetPwd + ", isReceiveEmail=" + this.isReceiveEmail;
    }
}
