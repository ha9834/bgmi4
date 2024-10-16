package com.tencent.imsdk.android.base.unifiedaccount;

import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import org.json.JSONException;

/* loaded from: classes.dex */
class UnifiedAccountToken extends JsonSerializable {

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME)
    public String account;

    @JsonProp("accountType")
    public int accountType;

    @JsonProp(IR.unifiedAccount.UNIFIED_ACCOUNT_EXPIRE)
    public long expire;

    @JsonProp("token")
    public String token;

    @JsonProp("uid")
    public String uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        return (T.ckIsEmpty(this.account) || T.ckIsEmpty(this.uid) || T.ckIsEmpty(this.token) || this.expire <= System.currentTimeMillis() / 1000) ? false : true;
    }

    public UnifiedAccountToken() {
    }

    public UnifiedAccountToken(String str) throws JSONException {
        super(str);
    }

    public String toString() {
        return super.toString() + "accountType='" + this.accountType + "', account=" + this.account + ", uid=" + this.uid + ", token='" + this.token + "', expire='" + this.expire + '\'';
    }
}
