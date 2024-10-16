package com.intlgame.api.compliance;

/* loaded from: classes2.dex */
public class INTLCompliance {
    public static native void commitBirthday(String str);

    public static native String getConfigString(String str);

    public static native void init(String str, String str2, String str3);

    public static native void queryUserStatus();

    public static native void sendEmail(String str, String str2);

    public static native void setAdulthood(int i);

    public static native void setComplianceObserver(INTLComplianceObserver iNTLComplianceObserver);

    public static native void setEUAgreeStatus(int i);

    public static native void setParentCertificateStatus(int i);

    public static native boolean setUserProfile(String str, String str2, String str3, int i, String str4);
}
