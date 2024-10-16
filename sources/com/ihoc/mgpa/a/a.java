package com.ihoc.mgpa.a;

/* loaded from: classes2.dex */
public enum a {
    LOWPOWER(1),
    FPSSTRATEGY(2),
    VENDOR(3),
    TRANSCEIVER(4),
    APP_DATEFORWARD(5),
    CPU_LOCK(6),
    VACANT_DOWNLOAD(7),
    COPY_PREDOWNLOAD_FROM_PROVIDER(8);

    private int j;

    a(int i2) {
        this.j = i2;
    }

    public String a() {
        return String.valueOf(this.j);
    }
}
