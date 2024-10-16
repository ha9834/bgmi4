package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import com.helpshift.common.domain.network.NetworkConstants;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.midaskey.APMidasToolAES;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes.dex */
public class APMidasHttpRequest extends Request {
    private APMidasEncodeKey encodeKey;
    public final String uuid = UUID.randomUUID().toString();
    private final ArrayList<APMidasHttpEncodeParameter> encodeParameters = new ArrayList<>();
    boolean needUseBaseKeyToEncode = false;
    protected boolean needFrontGetKeyInterceptor = true;
    protected boolean needEndGetKeyInterceptor = true;
    protected boolean needMidasHostHeader = true;

    protected void onEncodeFinish() {
    }

    protected void onEncodeStart() {
    }

    public APMidasHttpRequest() {
        addHttpHeader("Accept-Charset", "UTF-8");
        addHttpHeader("Content-Type", NetworkConstants.contentType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final APMidasEncodeKey getEncodeKey() {
        return this.encodeKey;
    }

    public final String getEncodeKeyString() {
        APMidasEncodeKey aPMidasEncodeKey = this.encodeKey;
        return aPMidasEncodeKey == null ? "" : aPMidasEncodeKey.key;
    }

    public final String getOpenIDFromRequest() {
        String parameter = getParameter("openid");
        return !TextUtils.isEmpty(parameter) ? parameter : "";
    }

    public final String getOfferIDFromRequest() {
        String parameter = getParameter("offer_id");
        return !TextUtils.isEmpty(parameter) ? parameter : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasEncodeParameters() {
        ArrayList<APMidasHttpEncodeParameter> arrayList = this.encodeParameters;
        return arrayList != null && arrayList.size() > 0;
    }

    public String getEncodeParameter(String str) {
        ArrayList<APMidasHttpEncodeParameter> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = this.encodeParameters) == null || arrayList.size() == 0) {
            return "";
        }
        Iterator<APMidasHttpEncodeParameter> it = this.encodeParameters.iterator();
        while (it.hasNext()) {
            APMidasHttpEncodeParameter next = it.next();
            if (str.equals(next.key)) {
                return next.value;
            }
        }
        return "";
    }

    public final void addHttpEncodeParameter(String str, String str2) {
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || this.encodeParameters.size() == 0) {
            APMidasHttpEncodeParameter aPMidasHttpEncodeParameter = new APMidasHttpEncodeParameter();
            aPMidasHttpEncodeParameter.key = str;
            aPMidasHttpEncodeParameter.value = str2;
            this.encodeParameters.add(aPMidasHttpEncodeParameter);
            return;
        }
        Iterator<APMidasHttpEncodeParameter> it = this.encodeParameters.iterator();
        while (it.hasNext()) {
            APMidasHttpEncodeParameter next = it.next();
            if (str.equals(next.key)) {
                next.value = str2;
                return;
            }
        }
        APMidasHttpEncodeParameter aPMidasHttpEncodeParameter2 = new APMidasHttpEncodeParameter();
        aPMidasHttpEncodeParameter2.key = str;
        aPMidasHttpEncodeParameter2.value = str2;
        this.encodeParameters.add(aPMidasHttpEncodeParameter2);
    }

    public void doEncodeParameters(APMidasNetworkManager aPMidasNetworkManager, APMidasEncodeKey aPMidasEncodeKey, String str) {
        if (aPMidasEncodeKey == null || this.encodeParameters.isEmpty() || TextUtils.isEmpty(aPMidasEncodeKey.key)) {
            return;
        }
        this.encodeKey = aPMidasEncodeKey;
        onEncodeStart();
        String encodeParametersListToString = encodeParametersListToString();
        if (TextUtils.isEmpty(encodeParametersListToString)) {
            return;
        }
        addHttpParameters("encrypt_msg", APMidasToolAES.encryptAES(encodeParametersListToString, aPMidasEncodeKey.key, aPMidasNetworkManager.getIV()));
        addHttpParameters("key_len", "newkey");
        addHttpParameters("key_time", str);
        addHttpParameters("msg_len", Integer.toString(encodeParametersListToString.length()));
        onEncodeFinish();
    }

    public boolean isEncodeWithBaseKey() {
        APMidasEncodeKey aPMidasEncodeKey = this.encodeKey;
        return (aPMidasEncodeKey == null || TextUtils.isEmpty(aPMidasEncodeKey.key) || !IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_BASE.equals(this.encodeKey.keyType)) ? false : true;
    }

    public boolean isEncodeWithSecretKey() {
        APMidasEncodeKey aPMidasEncodeKey = this.encodeKey;
        return (aPMidasEncodeKey == null || TextUtils.isEmpty(aPMidasEncodeKey.key) || !IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET.equals(this.encodeKey.keyType)) ? false : true;
    }

    public boolean isEncodeWithCryptKey() {
        APMidasEncodeKey aPMidasEncodeKey = this.encodeKey;
        return (aPMidasEncodeKey == null || TextUtils.isEmpty(aPMidasEncodeKey.key) || !IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_CRYPT.equals(this.encodeKey.keyType)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class APMidasHttpEncodeParameter {
        public String key;
        public String value;

        private APMidasHttpEncodeParameter() {
        }
    }

    protected String encodeParametersListToString() {
        ArrayList<APMidasHttpEncodeParameter> arrayList = this.encodeParameters;
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<APMidasHttpEncodeParameter> it = this.encodeParameters.iterator();
        while (it.hasNext()) {
            APMidasHttpEncodeParameter next = it.next();
            if (!TextUtils.isEmpty(next.key)) {
                sb.append(next.key);
                sb.append("=");
            }
            sb.append(next.value);
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
