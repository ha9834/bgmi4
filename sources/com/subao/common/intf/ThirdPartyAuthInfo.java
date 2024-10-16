package com.subao.common.intf;

/* loaded from: classes2.dex */
public class ThirdPartyAuthInfo {
    private final String accessToken;
    private final long expiresIn;
    private final String openId;
    private final String refreshToken;

    public ThirdPartyAuthInfo(String str, String str2, String str3, long j) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.openId = str3;
        this.expiresIn = j;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }
}
