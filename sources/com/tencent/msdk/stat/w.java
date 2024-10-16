package com.tencent.msdk.stat;

/* loaded from: classes.dex */
/* synthetic */ class w {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6341a = new int[StatReportStrategy.values().length];

    static {
        try {
            f6341a[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6341a[StatReportStrategy.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6341a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6341a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6341a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6341a[StatReportStrategy.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f6341a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
