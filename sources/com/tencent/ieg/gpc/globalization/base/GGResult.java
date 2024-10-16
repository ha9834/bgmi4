package com.tencent.ieg.gpc.globalization.base;

/* loaded from: classes2.dex */
public class GGResult {
    public static final int CANCEL = 2;
    public static final int FILE_NOT_EXIST = 5;
    public static final int PLUGIN_NOT_INIT = 4;
    public static final int SUCCESS = 1;
    public static final int TIMEOUT = 3;
    public static final int UNKNOWN_ERROR = 0;
    public int code;
    public String msg;

    public GGResult(int i, String str) {
        this.code = 0;
        this.msg = "";
        this.code = i;
        this.msg = str;
    }

    public String toJasonString() {
        return "{\"code\" : " + String.valueOf(this.code) + ", \"msg\": \"" + this.msg + "\"}";
    }
}
