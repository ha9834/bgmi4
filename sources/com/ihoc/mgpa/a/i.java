package com.ihoc.mgpa.a;

import com.tencent.connect.common.Constants;

/* loaded from: classes2.dex */
public enum i {
    GAMEVERSION("1"),
    SCENE("2"),
    FPS("3"),
    MODELQUALITY("5"),
    PICQUALITY(Constants.VIA_SHARE_TYPE_INFO),
    VISIBLEPLAYER("7"),
    NETDELAY(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO),
    GAMERESULT("9"),
    SYSTEMINFO(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ),
    FPSTARGET(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE),
    RESOLUTION(Constants.VIA_REPORT_TYPE_SET_AVATAR),
    THREADID(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);

    private String n;

    i(String str) {
        this.n = str;
    }

    public String a() {
        return this.n;
    }
}
