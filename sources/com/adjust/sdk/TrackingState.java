package com.adjust.sdk;

/* loaded from: classes.dex */
public enum TrackingState {
    OPTED_OUT(1);

    private int value;

    TrackingState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
