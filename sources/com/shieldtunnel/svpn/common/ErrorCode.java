package com.shieldtunnel.svpn.common;

/* loaded from: classes2.dex */
public class ErrorCode {
    public static final int ALREADY_TEAR_DOWN = 1013;

    @Deprecated
    public static final int ILLEGAL_APP_GROUP_SID = 1016;
    public static final int ILLEGAL_PARAMETERS = 1012;
    public static final int ILLEGAL_STATUS = 1004;
    public static final int ILLEGAL_USER_STATE = 1010;
    public static final int INTERNAL_ERROR = 1017;
    public static final int INTERRUPT = 1018;
    public static final int IO_EXCEPTION = 1006;
    public static final int JNI_RETURN_FAIL = 1001;

    @Deprecated
    public static final int NETWORK_UNAVAILABLE = 1005;
    public static final int NOT_INIT = 1000;
    public static final int OK = 0;
    public static final int REPEATED_CALL = 1002;
    public static final int RUNTIME_EXCEPTION = 1007;
    public static final int SERVICE_DENIED = 1003;
    public static final int SERVICE_FAIL = 1008;
    public static final int SOCKET_ERROR = 1019;
    public static final int SOCKET_REGISTER_ERROR = 1020;
    public static final int SOCKET_UNREGISTER_ERROR = 1021;
    public static final int START_SERVICE_FAIL = 1015;
    public static final int TOO_LOW_OS_VERSION = 1014;
    public static final int UNAUTHORIZED = 1009;
    public static final int UNSUPPORTED = 1011;

    private ErrorCode() {
    }
}
