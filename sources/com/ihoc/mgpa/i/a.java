package com.ihoc.mgpa.i;

/* loaded from: classes2.dex */
public enum a {
    VMP_INIT("TGPA_INIT"),
    VMP_DOWNLOAD_CONFIG("TGPA_GETCONFIG"),
    VMP_REGCALL("TGPA_REGCALL"),
    VMP_SOCKETINFO("TGPA_GAMEINFO"),
    VMP_HANDLE_EXCEPTION("TGPA_EXCEPTION"),
    VMP_CALLBACK("TGPA_VENDORINFO"),
    VMP_SCENETIME("TGPA_SCENETIME"),
    VMP_HARDWAREAPPLY("TGPA_HARDWAREAPPLY"),
    VMP_DEVICE_CHECK("TGPA_DEVICECHECK"),
    VMP_SETTINGS("TGPA_GAMESETTING"),
    VMP_SPA("TGPA_SPA"),
    VMP_STRATEGY_INFO("TGPA_STRATEGYINFO"),
    VMP_MATCH_FPS("TGPA_MATCHFPS"),
    VMP_REPORT_UNIQUE_ID("TGPA_UNIQUEID"),
    VMP_REPORT_PREDOWNLOAD1("TGPA_PREDOWNLOAD1"),
    VMP_REPORT_PREDOWNLOAD2("TGPA_PREDOWNLOAD2"),
    VMP_REPORT_PREDOWNLOAD3("TGPA_PREDOWNLOAD3"),
    VMP_NOTCH_INFO("TGPA_NOTCH"),
    VMP_THREAD_AFFINITY_INFO("TGPA_THREAD_AFFINITY"),
    VMP_MATCH_NETLATENCY("TGPA_MATCH_NETLATENCY"),
    VMP_BACKGROUND_DOWNLOAD("TGPA_BACKGROUND_DOWNLOAD"),
    VMP_HAPTIC_SUPPORT("TGPA_HAPTIC_SUPPORT"),
    VMP_HAPTIC_SETTING("TGPA_HAPTIC_SETTING"),
    VMP_IN_GAME_PRE_DOWNLOAD("TGPA_IN_GAME_PREDOWNLOAD"),
    VMP_REPORT_PREDOWNLOAD_COPY("VMP_REPORT_PREDOWNLOAD_COPY");

    private String A;

    a(String str) {
        this.A = str;
    }

    public String a() {
        return this.A;
    }
}
