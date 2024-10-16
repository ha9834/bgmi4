package com.intlgame.api.compliance;

/* loaded from: classes2.dex */
public enum INTLCompliancekAgeStatus {
    Minor(-1),
    kAgeStatusUnknown(0),
    kAgeStatusAdult(1);

    private final int value;

    INTLCompliancekAgeStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
