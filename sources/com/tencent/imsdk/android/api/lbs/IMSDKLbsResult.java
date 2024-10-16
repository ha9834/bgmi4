package com.tencent.imsdk.android.api.lbs;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKLbsResult extends IMSDKResult {

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("sCity")
    public String cityName;

    @JsonProp("iCityNo")
    public int cityNumber;

    @JsonProp("sCountry")
    public String countryName;

    @JsonProp("iCountryNo")
    public int countryNumber;

    @JsonProp("iGameId")
    public int gameId;

    @JsonProp("iGuid")
    public String guid;

    @JsonProp("sInnerToken")
    public String guidToken;

    @JsonProp("iExpireTime")
    public long guidTokenExpire;

    @JsonProp("sBirthdate")
    public String guidUserBirthday;

    @JsonProp("sUserName")
    public String guidUserNick;

    @JsonProp("sPictureUrl")
    public String guidUserPortrait;

    @JsonProp("iGender")
    public int guidUserSex;

    @JsonProp("iOpenid")
    public String openId;

    @JsonProp("sProvince")
    public String provinceName;

    @JsonProp("iProvinceNo")
    public int provinceNumber;

    public IMSDKLbsResult(int i) {
        super(i);
    }

    public IMSDKLbsResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKLbsResult(int i, String str) {
        super(i, str);
    }

    public IMSDKLbsResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKLbsResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKLbsResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", countryNumber=" + this.countryNumber + ", countryName=" + this.countryName + ", sProvince=" + this.countryName + ", iProvinceNo=" + this.countryName + ", cityNumber=" + this.cityNumber + ", cityName=" + this.cityName;
    }
}
