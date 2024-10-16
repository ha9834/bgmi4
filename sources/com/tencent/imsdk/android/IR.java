package com.tencent.imsdk.android;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class IR {
    public static final String BASE_VERSION = "2.10.1";
    public static final String CONFIG_FILE_NAME = "iMSDK_config";
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String MODULE_ACCOUNT = "base_account";
    public static final String MODULE_AUTH = "base_auth";
    public static final String MODULE_BIND = "base_bind";
    public static final String MODULE_CONFIG = "base_config";
    public static final String MODULE_FRIEND = "base_friend";
    public static final String MODULE_GAME = "base_game";
    public static final String MODULE_LOGIN = "base_login";
    public static final String MODULE_NETWORK = "base_network";
    public static final String MODULE_NOTICE = "base_notice";
    public static final String MODULE_PAY = "base_pay";
    public static final String MODULE_PUSH = "base_push";
    public static final String MODULE_URL = "base_url";
    public static final String MODULE_WEBVIEW = "base_webview";
    public static final String PLATFORM = "2";

    /* loaded from: classes.dex */
    public static class account {
        public static final String ACCOUNT_AREACODE = "sAreaCode";
        public static final String ACCOUNT_AREACODE_TIME = "iCodeTime";
        public static final String ACCOUNT_BINDID = "iBindChannel";
        public static final String ACCOUNT_CHANNEL_ID = "26";
        public static final String ACCOUNT_CODE_TYPE = "iCodeType";
        public static final String ACCOUNT_OPENID = "iOpenid";
        public static final String ACCOUNT_PASSWORD = "sPassword";
        public static final String ACCOUNT_RECOVERY_CODE = "sRecoveryCode";
        public static final String ACCOUNT_TOKEN = "sInnerToken";
        public static final String ACCOUNT_TYPE = "iAccountType";
        public static final String ACCOUNT_USERNAME = "sAccount";
        public static final String ACCOUNT_VERIFY_CODE = "sVerifyCode";
        public static final String ACCOUNT_VERIFY_CODE_TIME = "sTimestamp";
        public static final String ACCOUNT_VERIFY_DATA = "sVerifyData";
        public static final String ACCOUNT_VERIFY_TYPE = "iVerifyType";
        public static final String EMAIL_CHANNEL_NAME = "Email";
        public static final String EMAIL_CODE = "1";
        public static final String EMAIL_TAG = "@";
        public static final String PHONE_CHANNEL_NAME = "Phone";
        public static final String PHONE_CODE = "2";
    }

    /* loaded from: classes.dex */
    public static class config {
        public static final String IMSDK_DOCS_TOOL_URL = "IMSDK_DOCS_TOOL_URL";
        public static final String IMSDK_SERVER_LOG_URL = "IMSDK_SERVER_LOG_URL";
    }

    /* loaded from: classes.dex */
    public static class def {

        @Keep
        public static final String DEFAULT_CHANNEL_ID = "5";
        public static final String DEFAULT_EMPTY = "";
        public static final int DEFAULT_GAME_ID = 11;
        public static final int DEFAULT_INVALID_CODE = -1;
        public static final String DEFAULT_PACKAGE_NAME_ACCOUNT_FORMAT = "com.tencent.imsdk.android.account.%s.%sAccount";
        public static final String DEFAULT_PACKAGE_NAME_AUTH_FORMAT = "com.tencent.imsdk.android.auth.%s.%sAuth";
        public static final String DEFAULT_PACKAGE_NAME_FRIEND_FORMAT = "com.tencent.imsdk.android.friend.%s.%sFriend";
        public static final String DEFAULT_PACKAGE_NAME_GAME_SERVICE_FORMAT = "com.tencent.imsdk.android.game.%s.%sGame";
        public static final String DEFAULT_PACKAGE_NAME_HELP_FORMAT = "com.tencent.imsdk.android.help.%s.%sHelp";
        public static final String DEFAULT_PACKAGE_NAME_LOGIN_FORMAT = "com.tencent.imsdk.android.login.%s.%sLogin";
        public static final String DEFAULT_PACKAGE_NAME_NOTICE_FORMAT = "com.tencent.imsdk.android.notice.%s.%sNotice";
        public static final String DEFAULT_PACKAGE_NAME_PAY_FORMAT = "com.tencent.imsdk.android.pay.%s.%sPay";
        public static final String DEFAULT_PACKAGE_NAME_PUSH_FORMAT = "com.tencent.imsdk.android.push.%s.%sPush";
        public static final String DEFAULT_PACKAGE_NAME_STAT_FORMAT = "com.tencent.imsdk.android.stat.%s.%sStat";
        public static final String DEFAULT_PACKAGE_NAME_WEBVIEW_FORMAT = "com.tencent.imsdk.android.webview.%s.%sWebView";
        public static final String DEFAULT_VERSION = "1.0";
        public static final String IMSDK_KEYWORD = "IMSDK";
    }

    /* loaded from: classes.dex */
    public static class encoding {
        public static final String DEFAULT = "UTF-8";
        public static final String UTF8 = "UTF-8";
    }

    /* loaded from: classes.dex */
    public static class fuse {
        public static final String CLOSE = "0";
        public static final String IMSDK_FUSE_AUTH_CONNECT = "IMSDK_AUTH_CONNECT";
        public static final String IMSDK_FUSE_AUTH_DELETE = "IMSDK_AUTH_DELETE";
        public static final String IMSDK_FUSE_AUTH_EMAIL = "IMSDK_AUTH_EMAIL";
        public static final String IMSDK_FUSE_AUTH_MIGRATE = "IMSDK_AUTH_MIGRATE";
        public static final String IMSDK_FUSE_GAME = "IMSDK_GAME";
        public static final String IMSDK_FUSE_HELP = "IMSDK_HELP";
        public static final String IMSDK_FUSE_LOG_REPORT = "IMSDK_LOG_REPORT";
        public static final String IMSDK_FUSE_NOTICE = "IMSDK_NOTICE";
        public static final String IMSDK_INNER_STAT_ENABLE = "IMSDK_INNER_STAT_ENABLE";
        public static final String OPEN = "1";
    }

    /* loaded from: classes.dex */
    public static class id {
        public static final String CHANNEL_ID = "iChannel";
        public static final int INVALID_KEY_ERROR = -905;
    }

    /* loaded from: classes.dex */
    public static class meta {
        public static final String GAME_ID = "IMSDK_GAME_ID";
        public static final String IMSDK_ACCOUNT_CHECK_POPUP_STATUS_ENABLE = "IMSDK_ACCOUNT_CHECK_POPUP_STATUS_ENABLE";
        public static final String IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE = "IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE";
        public static final String IMSDK_ANDROID_ID_ENABLE = "IMSDK_ANDROID_ID_ENABLE";
        public static final String IMSDK_APPLICATION_NAME = "IMSDK_PROXY_APPLICATION_NAME";
        public static final String IMSDK_BIND_FORCE_TARGET_LOGOUT = "IMSDK_BIND_FORCE_TARGET_LOGOUT";
        public static final String IMSDK_CHECK_CHANNEL_LOGIN_STATUS = "IMSDK_CHECK_CHANNEL_LOGIN_STATUS";
        public static final String IMSDK_DEBUG = "IMSDK_DEBUG";
        public static final String IMSDK_DEVICE_ID_ENABLE = "IMSDK_DEVICE_ID_ENABLE";
        public static final String IMSDK_DEVICE_INFO_ENABLE = "IMSDK_DEVICE_INFO_ENABLE";
        public static final String IMSDK_ENCRYPT_LOGIN_INFO = "IMSDK_ENCRYPT_LOGIN_INFO";
        public static final String IMSDK_GOOGLE_ADID_ENABLE = "IMSDK_GOOGLE_ADID_ENABLE";
        public static final String IMSDK_GUEST_EXTRA_INFO = "IMSDK_GUEST_EXTRA_INFO";
        public static final String IMSDK_GUEST_RESTORE = "IMSDK_GUEST_RESTORE";
        public static final String IMSDK_INNER_REPORT_LOG = "IMSDK_INNER_REPORT_LOG";
        public static final String IMSDK_INNER_REPORT_TYPE = "IMSDK_INNER_REPORT_TYPE";
        public static final String IMSDK_INNER_VOLLEY_DEBUG = "IMSDK_INNER_VOLLEY_DEBUG";
        public static final String IMSDK_LOCAL_LOG_BEGIN = "IMSDK_LOCAL_LOG_BEGIN";
        public static final String IMSDK_LOCAL_LOG_ENABLE = "IMSDK_LOCAL_LOG_ENABLE";
        public static final String IMSDK_LOCAL_LOG_END = "IMSDK_LOCAL_LOG_END";
        public static final String IMSDK_LOCAL_LOG_MAXFILESIZE = "IMSDK_LOCAL_LOG_MAXFILESIZE";
        public static final String IMSDK_LOCAL_LOG_MAXLOGSIZE = "IMSDK_LOCAL_LOG_MAXLOGSIZE";
        public static final String IMSDK_LOCAL_LOG_RETRY = "IMSDK_LOCAL_LOG_RETRY";
        public static final String IMSDK_MAC_ADDRESS_ENABLE = "IMSDK_MAC_ADDRESS_ENABLE";
        public static final String IMSDK_MAC_ADDRESS_FIX_ENABLE = "IMSDK_MAC_ADDRESS_FIX_ENABLE";
        public static final String IMSDK_MAC_DEFAULT_ADDRESS = "IMSDK_MAC_DEFAULT_ADDRESS";
        public static final String IMSDK_MTA_REPORT_LOG = "IMSDK_MTA_REPORT_LOG";
        public static final String IMSDK_NETWORK_BACK_OFF_FACTOR = "IMSDK_NETWORK_BACK_OFF_FACTOR";
        public static final String IMSDK_NETWORK_MAX_RETRIES = "IMSDK_NETWORK_MAX_RETRIES";
        public static final String IMSDK_NETWORK_TIMEOUT_MS = "IMSDK_NETWORK_TIMEOUT_MS";
        public static final String IMSDK_SERIAL_ENABLE = "IMSDK_SERIAL_ENABLE";
        public static final String IMSDK_SERVER_CONFIG = "IMSDK_SERVER_CONFIG";
        public static final String IMSDK_SERVER_CONFIG_VERSION = "IMSDK_SERVER_CONFIG_VERSION";
        public static final String IMSDK_SERVER_HELP = "IMSDK_SERVER_HELP";
        public static final String IMSDK_SERVER_HELP_SCHEME = "IMSDK_SERVER_HELP_SCHEME";
        public static final String IMSDK_SERVER_HELP_VERSION = "IMSDK_SERVER_HELP_VERSION";
        public static final String IMSDK_SERVER_NOTICE = "IMSDK_SERVER_NOTICE";
        public static final String IMSDK_SERVER_NOTICE_VERSION = "IMSDK_SERVER_NOTICE_VERSION";
        public static final String IMSDK_SERVER_SDKAPI = "IMSDK_SERVER_SDKAPI";
        public static final String IMSDK_SERVER_SDKAPI_VERSION = "IMSDK_SERVER_SDKAPI_VERSION";
        public static final String IMSDK_SERVER_UNIFIED_ACCOUNT = "IMSDK_SERVER_UNIFIED_ACCOUNT";
        public static final String IMSDK_UNIFIED_ACCOUNT_APP_ID = "IMSDK_UNIFIED_ACCOUNT_APP_ID";
        public static final String IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID = "IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID";
        public static final String IMSDK_UNIFIED_ACCOUNT_CHECK_PASSWORD = "IMSDK_UNIFIED_ACCOUNT_CHECK_PASSWORD";
        public static final String IMSDK_UNIFIED_ACCOUNT_PLATFORM_TYPE = "IMSDK_UNIFIED_ACCOUNT_PLATFORM_TYPE";
        public static final String IMSDK_UNIFIED_ACCOUNT_SDK_KEY = "IMSDK_UNIFIED_ACCOUNT_SDK_KEY";
        public static final String IMSDK_WEBVIEW_X5_WORK = "IMSDK_WEBVIEW_QQ_X5_CORE_WORK";
        public static final String LOG_LEVEL = "IMSDK_LOG_LEVEL";
    }

    /* loaded from: classes.dex */
    public static class path {
        public static final String ACCOUNT_AREA_CODE = "imsdkuser/areacode";
        public static final String ACCOUNT_AUTO_BIND = "imsdkuser/aotbind";
        public static final String ACCOUNT_CHECK_RECOVERY_CODE = "imsdkuser/recoverycheck";
        public static final String ACCOUNT_GET_RECOVERY_CODE = "imsdkuser/recoverycode";
        public static final String ACCOUNT_LOGIN = "imsdkuser/login";
        public static final String ACCOUNT_RESET_PASSWORD = "imsdkuser/modpwd";
        public static final String ACCOUNT_VERIFY_CODE = "imsdkuser/sendcode";
        public static final String BIND_INFO = "bind/bindRelationInfo";
        public static final String BIND_PATH = "bind/bind";
        public static final String CHECK_LOGIN_PATH = "user/checkandlogin";
        public static final String CHECK_TOKEN_PATH = "user/checkTokenValid";
        public static final String CONNECT_PATH = "account/connect";
        public static final String DELETE_ALL_ACCOUNT_PATH = "account/deleteAllAccount";
        public static final String DELETE_DEVICE_ACCOUNT_PATH = "account/deleteDeviceAccount";
        public static final String DISCONNECT_PATH = "account/disconnect";
        public static final String DOCS_EXTRA_MSG = "ex";
        public static final String DOCS_IMSDK_CHANNEL = "c";
        public static final String DOCS_IMSDK_CODE = "ic";
        public static final String DOCS_THIRD_CODE = "tc";
        public static final String DOCS_THIRD_MSG = "tm";
        public static final String EMAIL_CONNECT = "next/connect";
        public static final String EMAIL_RECOVER = "next/recover";
        public static final String EMAIL_SEND_CODE = "next/sendEmail";
        public static final String GET_BIND_PATH = "bind/bindRelationInfo";
        public static final String GET_CONFIG_PATH = "conf/get";
        public static final String GET_FRIENDS_IN_GAME = "friends/lists";
        public static final String GET_MIGRATE_CODE_PATH = "account/getMigrateCode";
        public static final String GET_MIGRATE_INFO_PATH = "account/getMigrateInfo";
        public static final String GET_NOTICE_PATH = "notice/getNotice";
        public static final String GET_TICKET_PATH = "user/getTicket";
        public static final String GUEST_PATH = "user/login";
        public static final String LOGIN_PATH = "user/login";
        public static final String LOGOUT_ALL_PATH = "user/logoutAll";
        public static final String LOGOUT_PATH = "user/logout";
        public static final String MIGRATE_PATH = "account/migrate";
        public static final String QUICK_LOGIN = "user/quickLogin";
        public static final String RECONNECT_PATH = "account/reconnect";
        public static final String RECOVER_PATH = "account/recover";
        public static final String REFRESH_LOGIN_PATH = "user/renewalToken";
        public static final String RESTORE_PATH = "account/restore";
        public static final String UNIFIED_ACCOUNT_CHANGE_PASSWORD_PATH = "account/changepassword";
        public static final String UNIFIED_ACCOUNT_LOGIN_PATH = "account/login";
        public static final String UNIFIED_ACCOUNT_LOGIN_WITH_CODE_PATH = "account/loginwithcode";
        public static final String UNIFIED_ACCOUNT_MODIFY_PATH = "account/modify";
        public static final String UNIFIED_ACCOUNT_POPSTATUS_PATH = "account/popupstatus";
        public static final String UNIFIED_ACCOUNT_REGISTER_PATH = "account/register";
        public static final String UNIFIED_ACCOUNT_REGISTER_STATUS_PATH = "account/registerstatus";
        public static final String UNIFIED_ACCOUNT_VERIFY_CODE_PATH = "account/sendcode";
        public static final String UNIFIED_ACCOUNT_VERIFY_CODE_STATUS_PATH = "account/codestatus";
        public static final String URL_CONVERT = "url/getUrl";
    }

    /* loaded from: classes.dex */
    public static class preferences {
        public static final String PREFS_CHANNEL_FILE = "imsdk_channel";
        public static final String PREFS_CHANNEL_KEY = "channel_key";
    }

    /* loaded from: classes.dex */
    public static class unifiedAccount {
        public static final String UNIFIED_ACCOUNT_ACCOUNT_MODIFY = "account_modify";
        public static final String UNIFIED_ACCOUNT_ACCOUNT_TYPE_MODIFY = "account_type_modify";
        public static final String UNIFIED_ACCOUNT_AREA_CODE = "area_code";
        public static final String UNIFIED_ACCOUNT_AREA_CODE_MODIFY = "area_code_modify";
        public static final String UNIFIED_ACCOUNT_CODE_TYPE = "code_type";
        public static final String UNIFIED_ACCOUNT_DINFO = "dinfo";
        public static final String UNIFIED_ACCOUNT_EXPIRE = "expire";
        public static final String UNIFIED_ACCOUNT_EXTRA = "extra_json";
        public static final String UNIFIED_ACCOUNT_IS_RECEIVE_EMAIL = "is_receive_email";
        public static final String UNIFIED_ACCOUNT_LANG_TYPE = "lang_type";
        public static final String UNIFIED_ACCOUNT_PASSWORD = "password";
        public static final String UNIFIED_ACCOUNT_PTICKET = "pticket";
        public static final String UNIFIED_ACCOUNT_QCAPTCHA = "qcaptcha";
        public static final String UNIFIED_ACCOUNT_SESSION_ID = "sid";
        public static final String UNIFIED_ACCOUNT_TOKEN = "token";
        public static final String UNIFIED_ACCOUNT_TYPE = "account_type";
        public static final String UNIFIED_ACCOUNT_UID = "uid";
        public static final String UNIFIED_ACCOUNT_USERNAME = "account";
        public static final String UNIFIED_ACCOUNT_VERIFY_CODE = "verify_code";
        public static final String UNIFIED_ACCOUNT_VERIFY_CODE_MODIFY = "verify_code_modify";
        public static final String UNIFIED_ACCOUNT_VERIFY_TYPE = "verify_type";
    }

    /* loaded from: classes.dex */
    public static class url {
        public static final String IMSDK_DOCS_TOOL_URL = "http://docs.itop.qq.com/tool/log.html";
        public static final String IMSDK_SERVER_LOG_URL = "https://clientrz2.itop.qq.com/v1.0/client/report";
    }
}
