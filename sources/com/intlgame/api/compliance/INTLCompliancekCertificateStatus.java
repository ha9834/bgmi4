package com.intlgame.api.compliance;

/* loaded from: classes2.dex */
public enum INTLCompliancekCertificateStatus {
    kParentCertificateStatusDeny(-1),
    kParentCertificateStatusUnknown(0),
    kParentCertificateStatusAgree(1);

    private final int value;

    INTLCompliancekCertificateStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
