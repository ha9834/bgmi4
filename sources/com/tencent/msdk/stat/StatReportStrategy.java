package com.tencent.msdk.stat;

/* loaded from: classes.dex */
public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);


    /* renamed from: a, reason: collision with root package name */
    int f6284a;

    StatReportStrategy(int i) {
        this.f6284a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public int a() {
        return this.f6284a;
    }
}
