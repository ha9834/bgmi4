package com.tencent.grobot.lite.image.upload.cos.utils;

import android.text.TextUtils;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
public class URLEncodeUtils {
    public static String cosPathEncode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            String[] split = str.split("/", -1);
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (i == 0 && "".equals(split[i])) {
                    sb.append('/');
                } else {
                    if (length > 1 && i == length - 1 && "".equals(split[i])) {
                        break;
                    }
                    if (!"".equals(split[i])) {
                        String[] split2 = split[i].split(" ", -1);
                        int length2 = split2.length;
                        for (int i2 = 0; i2 < length2; i2++) {
                            if (i2 == 0 && "".equals(split2[i2])) {
                                sb.append("%20");
                            } else {
                                if (length2 > 1 && i2 == length2 - 1 && "".equals(split2[i2])) {
                                    break;
                                }
                                sb.append(URLEncoder.encode(split2[i2], HttpUtils.DEFAULT_ENCODE_NAME));
                                if (i2 != length2 - 1) {
                                    sb.append("%20");
                                }
                            }
                        }
                    }
                    if (i != length - 1) {
                        sb.append("/");
                    }
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
