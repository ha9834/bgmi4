package com.tencent.midas.oversea.data;

/* loaded from: classes.dex */
public class Cfg {
    public String mDetectDoain;
    public String mDomain;
    public String[] mIpList;
    public String mReportDomain;

    public Cfg(String str, String[] strArr) {
        this.mReportDomain = "";
        this.mDetectDoain = "";
        this.mDomain = str;
        this.mIpList = strArr;
    }

    public Cfg(String str, String[] strArr, String str2, String str3) {
        this.mReportDomain = "";
        this.mDetectDoain = "";
        this.mDomain = str;
        this.mIpList = strArr;
        this.mReportDomain = str2;
        this.mDetectDoain = str3;
    }
}
