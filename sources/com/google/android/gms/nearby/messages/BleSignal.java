package com.google.android.gms.nearby.messages;

/* loaded from: classes2.dex */
public interface BleSignal {
    public static final int UNKNOWN_TX_POWER = Integer.MIN_VALUE;

    int getRssi();

    int getTxPower();
}
