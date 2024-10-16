package com.intlgame.core;

import com.intlgame.tools.IT;

/* loaded from: classes2.dex */
public class INTLErrorCode {
    public static final int API_DEPRECATED = 23;
    public static final int APP_NOT_SUPPORT = 16;
    public static final int CANCEL = 2;
    public static final int DINED_BY_APP = 26;
    public static final int DISABLED = 19;
    public static final int FILE_SYSTEM = 8;
    public static final int FREQUENCY_LIMIT = 25;
    public static final int GROUP_UNKNOWN_ERROR = 1200;
    public static final int INVALID_ARGUMENT = 11;
    public static final int IN_PROGRESS = 22;
    public static final int LIBCURL_ERROR = 24;
    public static final int LOGIN_ACCOUNT_REFRESH = 1014;
    public static final int LOGIN_CACHE_EXPIRE = 1002;
    public static final int LOGIN_CODE_FOR_CONNECT = 1006;
    public static final int LOGIN_KEY_STORE_VERIFY_ERROR = 1004;
    public static final int LOGIN_NEED_LOGIN = 1012;
    public static final int LOGIN_NEED_SELECT_ACCOUNT = 1013;
    public static final int LOGIN_NEED_USER_DATA = 1005;
    public static final int LOGIN_NEED_USER_DATA_SERVER = 1010;
    public static final int LOGIN_NOCACHE = 1001;
    public static final int LOGIN_UNKNOWN_ERROR = 1000;
    public static final int LOGIN_URL_USER_LOGIN = 1011;
    public static final int NEED_APP = 15;
    public static final int NEED_CHANNEL = 18;
    public static final int NEED_CONFIG = 13;
    public static final int NEED_INIT = 17;
    public static final int NEED_LOGIN = 10;
    public static final int NEED_LOGIN_AND_QUERY_ID_TOKEN = 31;
    public static final int NEED_NAME_AUTH = 20;
    public static final int NEED_PERMISSION = 12;
    public static final int NEED_PLUGIN = 9;
    public static final int NETWORK = 4;
    public static final int NOTICE_UNKNOWN_ERROR = 1300;
    public static final int NOT_SUPPORT = 7;
    public static final int NO_ASSIGN = 1;
    public static final int PUSH_NOTIFICATION_CLICK = 1401;
    public static final int PUSH_NOTIFICATION_SHOW = 1402;
    public static final int PUSH_RECEIVER_TEXT = 1400;
    public static final int REAL_NAME_FAIL = 21;
    public static final int SERVER = 5;
    public static final int SERVICE_REFUSE = 14;
    public static final int SHARE_UNKNOWN_ERROR = 1100;
    public static final int SUCCESS = 0;
    public static final int SYSTEM = 3;
    public static final int THIRD = 9999;
    public static final int TIMEOUT = 6;
    public static final int UNKNOWN = -1;
    public static final int WEBVIEW_NOT_AVAILABLE = 1501;
    public static final int WEBVIEW_UNKNOWN_ERROR = 1500;

    public static String get(int i) {
        return IT.getRetMsg(i);
    }
}
