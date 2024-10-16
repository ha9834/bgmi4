package com.tdatamaster.tdm.defines;

/* loaded from: classes2.dex */
public class UserInfo {
    public int AccountType;
    public int Age;
    public int Gender;
    public int Level;
    public String NickName;
    public String Region;
    public String UserID;

    public UserInfo() {
    }

    public UserInfo(String str, String str2, String str3, int i, int i2, int i3, int i4) {
        this.UserID = str;
        this.NickName = str2;
        this.Region = str3;
        this.Gender = i;
        this.AccountType = i2;
        this.Age = i3;
        this.Level = i4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TDMUserInfo{UserID=");
        stringBuffer.append(this.UserID);
        stringBuffer.append(",NickName=");
        stringBuffer.append(this.NickName);
        stringBuffer.append(",Region=");
        stringBuffer.append(this.Region);
        stringBuffer.append(",Gender=");
        stringBuffer.append(this.Gender);
        stringBuffer.append(",AccountType=");
        stringBuffer.append(this.AccountType);
        stringBuffer.append(",Age=");
        stringBuffer.append(this.Age);
        stringBuffer.append(",Level=");
        stringBuffer.append(this.Level);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
