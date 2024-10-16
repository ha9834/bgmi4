package com.tencent.msdk.stat;

/* loaded from: classes.dex */
public class StatSpecifyReportedInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f6286a = null;
    private String b = null;
    private String c = null;
    private boolean d = false;
    private boolean e = false;

    public String getAppKey() {
        return this.f6286a;
    }

    public String getInstallChannel() {
        return this.b;
    }

    public String getVersion() {
        return this.c;
    }

    public boolean isImportant() {
        return this.e;
    }

    public boolean isSendImmediately() {
        return this.d;
    }

    public void setAppKey(String str) {
        this.f6286a = str;
    }

    public void setImportant(boolean z) {
        this.e = z;
    }

    public void setInstallChannel(String str) {
        this.b = str;
    }

    public void setSendImmediately(boolean z) {
        this.d = z;
    }

    public void setVersion(String str) {
        this.c = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f6286a + ", installChannel=" + this.b + ", version=" + this.c + ", sendImmediately=" + this.d + ", isImportant=" + this.e + "]";
    }
}
