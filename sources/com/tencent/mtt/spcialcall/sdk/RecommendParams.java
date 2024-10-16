package com.tencent.mtt.spcialcall.sdk;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mtt.des.DesUtils;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class RecommendParams {
    public static final String BROWSER_VER = "qb_ver";
    public static final int FROM_TYPE_AIO = 2;
    public static final int FROM_TYPE_DYM = 4;
    public static final int FROM_TYPE_PUB_ACCOUNT = 1;
    public static final int FROM_TYPE_QZONE = 3;
    public static final String KEY_FROM = "from";
    public static final String KEY_PUB_UIN = "puin";
    public static final String KEY_REFFER = "ref";
    public static final String KEY_TITLE = "title";
    public static final String KEY_UIN = "uin";
    public static final String KEY_URL = "url";
    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private Bundle mBundle = new Bundle();

    public RecommendParams put(String str, String str2) {
        this.mBundle.putCharSequence(str, str2);
        return this;
    }

    public String buildUpon(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : this.mBundle.keySet()) {
            String string = this.mBundle.getString(str2);
            if (!TextUtils.isEmpty(string)) {
                if (sb.length() != 0) {
                    sb.append('&');
                }
                sb.append(str2);
                sb.append('=');
                sb.append(URLEncoder.encode(string));
            }
        }
        String encode = encode(sb.toString());
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(AnalyticsEventKey.PROTOCOL, encode);
        return buildUpon.toString();
    }

    private String encode(String str) {
        try {
            return base64Encode(DesUtils.DesEncrypt("24Xdf8j6".getBytes(HttpUtils.DEFAULT_ENCODE_NAME), str.getBytes(HttpUtils.DEFAULT_ENCODE_NAME), 1));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String base64Encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            if (i2 == length) {
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            if (i4 == length) {
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(base64EncodeChars[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            stringBuffer.append(base64EncodeChars[i3 >>> 2]);
            stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(base64EncodeChars[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(base64EncodeChars[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }
}
