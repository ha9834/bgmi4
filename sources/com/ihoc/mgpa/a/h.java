package com.ihoc.mgpa.a;

/* loaded from: classes2.dex */
public enum h {
    FREQUENCY_SIGNAL(1),
    DEVICE_TEMP(2),
    FPS_COUNT_TIME(3),
    FREQUENCY_LEVEL(4),
    STRATEGY_SUPPORT(5),
    SCENE_SUPPORT(6),
    CPU_LOCK_STATUS(7),
    CPU_LOCK_NUM(8),
    SPA_PERF_CONFIG(9),
    SPA_PERF_LEVEL(10),
    UNIQUE_ID(11),
    APP_CALLBACK(12);

    private int n;

    h(int i) {
        this.n = i;
    }

    public String a() {
        return String.valueOf(this.n);
    }
}
