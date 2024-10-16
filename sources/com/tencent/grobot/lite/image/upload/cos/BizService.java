package com.tencent.grobot.lite.image.upload.cos;

import com.tencent.grobot.lite.image.upload.cos.utils.URLEncodeUtils;
import com.tencent.grobot.lite.image.upload.cos.utils.Utils;

/* loaded from: classes2.dex */
public class BizService {
    private static BizService bizService;
    private static byte[] syncObj = new byte[0];
    public String appId = "1300267969";
    public String bucketName = "xiaoyue-abroad-cos";
    public String bucket = "xiaoyue-abroad-cos-1300267969";
    public String region = "na-siliconvalley";
    public String AllowPrefix = "*";
    public String token = "";
    public String secretId = "";
    public String secretKey = "";
    public long expiredTime = 0;

    private BizService() {
    }

    public static BizService getInstance() {
        BizService bizService2;
        synchronized (syncObj) {
            if (bizService == null) {
                bizService = new BizService();
            }
            bizService2 = bizService;
        }
        return bizService2;
    }

    public static void onDestory() {
        synchronized (syncObj) {
            bizService = null;
        }
    }

    public void setCosTicket(String str, String str2, String str3, int i) {
        this.token = str;
        this.secretId = str2;
        this.secretKey = str3;
        this.expiredTime = i;
    }

    public String getUrl(String str) {
        return "https://" + this.bucket + ".cos." + this.region + ".myqcloud.com/" + URLEncodeUtils.cosPathEncode(str);
    }

    public String getHost() {
        return this.bucket + ".cos." + this.region + ".myqcloud.com";
    }

    public String getAuthorization(String str, String str2, String str3) {
        String str4 = String.valueOf((int) (System.currentTimeMillis() / 1000)) + ";" + this.expiredTime;
        return "q-sign-algorithm=sha1&q-ak=" + this.secretId + "&q-sign-time=" + str4 + "&q-key-time=" + str4 + "&q-header-list=" + str2 + "&q-url-param-list=&q-signature=" + signature("sha1\n" + str4 + "\n" + Utils.encodeHexString(Utils.sha1("put\n/" + str + "\n\n" + str3 + "\n"), true) + "\n", signature(str4, this.secretKey));
    }

    private static String signature(String str, String str2) {
        byte[] hmacSha1 = Utils.hmacSha1(str, str2);
        return hmacSha1 != null ? new String(Utils.encodeHex(hmacSha1)) : "";
    }
}
