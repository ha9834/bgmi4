package com.tencent.gsdk.api;

/* loaded from: classes2.dex */
public enum e {
    PayStart(0),
    ClickPay(1),
    PayDone(2);

    int d;

    e(int i) {
        this.d = 0;
        this.d = i;
    }

    public static e a(int i) {
        switch (i) {
            case 0:
                return PayStart;
            case 1:
                return ClickPay;
            case 2:
                return PayDone;
            default:
                return null;
        }
    }
}
