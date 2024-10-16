package com.ihoc.mgpa.a;

import com.tencent.connect.common.Constants;
import com.tencent.midas.oversea.api.CocosPayHelper;

/* loaded from: classes2.dex */
public enum g {
    NO_SET(CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR),
    DEFAULT("0"),
    START("1"),
    UPDATE("2"),
    LOGIN_LOAD("3"),
    MAIN_UI("4"),
    SCENE_LOAD("5"),
    SCENE_LOAD_WAIT(Constants.VIA_SHARE_TYPE_INFO),
    PLAYING("7"),
    WATCH_MODE(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);

    private String l;

    g(String str) {
        this.l = str;
    }

    public String a() {
        return this.l;
    }
}
