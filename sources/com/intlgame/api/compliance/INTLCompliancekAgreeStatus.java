package com.intlgame.api.compliance;

/* loaded from: classes2.dex */
public enum INTLCompliancekAgreeStatus {
    kAgreeStatusDeny(-1),
    kAgreeStatusUnknown(0),
    kAgreeStatusAgree(1);

    private final int value;

    INTLCompliancekAgreeStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
