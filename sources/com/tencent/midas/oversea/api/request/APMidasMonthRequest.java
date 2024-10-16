package com.tencent.midas.oversea.api.request;

/* loaded from: classes.dex */
public class APMidasMonthRequest extends APMidasBaseRequest {
    public static final int SERVICETYPE_NORMAL = 1;
    public static final int SERVICETYPE_RENEW = 2;
    public static final int SERVICETYPE_UPGRADE = 3;
    private static final long serialVersionUID = -557287896140460926L;
    public String serviceCode = "";
    public String serviceName = "";
    public String remark = "";
    public boolean autoPay = false;
    public int serviceType = 1;

    public APMidasMonthRequest() {
        this.mType = "unimonth";
        this.mOldType = 4;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getRemark() {
        return this.remark;
    }

    public boolean getAutoPay() {
        return this.autoPay;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceCode(String str) {
        this.serviceCode = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setAutoPay(boolean z) {
        this.autoPay = z;
    }

    public void setServiceType(int i) {
        this.serviceType = i;
    }
}
