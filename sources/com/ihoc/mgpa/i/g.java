package com.ihoc.mgpa.i;

import com.intlgame.core.INTLMethodID;

/* loaded from: classes2.dex */
public enum g {
    GET_DEVICE_ID_PERMISSION_ERROR(-3),
    VMP_EXCEPTION(-2),
    VMP_FAILED(-1),
    VMP_SUCCESS(0),
    CANNT_FIND_LOCAL_CONFIG(1),
    CANNT_READ_LOCAL_CONFIG(2),
    READ_LOCAL_CONFIG_EXCEPTION(3),
    GET_LOCAL_CONFIG_EMPTY(4),
    PARSE_JSON_CONFIG_EXCEPTION(5),
    PARSE_JSON_VALUE_EXCEPTION(6),
    START_SERVER_FAILED(7),
    INIT_THREAD_TIMEOUT(8),
    REALLY_INIT_EXCEPTION(9),
    CONTEXT_IS_NULL(10),
    DOWNLOAD_CONFIG_EXCEPTION(11),
    DOWNLOAD_CONFIG_EMPTY(12),
    DOWNLOAD_CONFIG_SAVE_FILE_EXCEPTION(13),
    DOWNLOAD_CODE_EXCEPTION(14),
    DOWNLOAD_CONFIG_CONTENT_NOT_JSON(15),
    DOWNLOAD_CONFIG_CONTENT_ERROR(16),
    DOWNLOAD_NEW_CONFIG_EXCEPTION(-11),
    DOWNLOAD_NEW_CONFIG_EMPTY(-12),
    DOWNLOAD_NEW_CONFIG_SAVE_FILE_EXCEPTION(-13),
    DOWNLOAD_NEW_CODE_EXCEPTION(-14),
    DOWNLOAD_NEW_CONFIG_CONTENT_JSON_ERROR(-15),
    DOWNLOAD_NEW_CONFIG_CONTENT_ERROR(-16),
    DOWNLOAD_NEW_CONFIG_HAS_NO_RET(-17),
    DOWNLOAD_NEW_CONFIG_RET_IS_NOT_0(-18),
    DOWNLOAD_NEW_CONFIG_HAS_NO_DATA(-19),
    DOWNLOAD_NEW_CONFIG_DATA_IS_NULL(-20),
    DEVICE_IS_REAL(20),
    DEVICE_IS_NOT_REAL(21),
    DEVICE_IS_UNKOWN(22),
    DEVICE_CONFIG_GET_EXCEPTION(23),
    DEVICE_CONFIG_AVAILABLE_IS_FALSE(24),
    ERROR_OPTIMIZING_CONFIG_NOT_AVAILABL(30),
    ERROR_CONFIG_JSON_SYNTAX_EXCEPTION(31),
    ERROR_FPS_STRATEGY_NOT_AVAILABLE(41),
    VIVO_MOBILE_NOT_SUPPORT_SDK(301),
    VIVO_CREATE_SDK_OBJECT_NULL(302),
    VIVO_MOBILE_REGISTER_FAILED(INTLMethodID.INTL_METHOD_ID_WEBVIEW_JS_SHARE),
    VIVO2_LOCALSOCKET_NOT_AVAILABLE(351),
    SAMSUNG_GAME_SDK_MANAGER_IS_NOT_AVAILABLE(401),
    SAMSUNG_GAME_SDK_MANAGER_CAN_NOT_INITIALIZE(402),
    SAMSUNG_GAME_SDK_MANAGER_REGISTER_CALLBACK_FALSE(403),
    SAMSUNG_GAME_SDK_MANAGER_IS_NOT_REGISTERED(404),
    SAMSUNG_GAME_SDK_MANAGER_CANCEL_REGISTERED_FAILED(INTLMethodID.INTL_METHOD_ID_PUSH_ADD_LOCAL_NOTIFICATION),
    SAMSUNG2_GAME_SERVICE_HELPER_IS_NULL(451),
    SAMSUNG2_GAME_SERVICE_HELPER_INIT_FAILED(452),
    SAMSUNG2_GAME_SERVICE_HELPER_REGISTERED_FAILED(453),
    SAMSUNG2_GAME_SERVICE_HELPER_UN_BIND_SUCC(454),
    SAMSUNG2_GAME_SERVICE_HELPER_INIT_EXCEPTION(455),
    SAMSUNG_SPA_NOT_SUPPORT(460),
    HUAWEI2_MOBILE_NOT_SUPPORT_SDK(501),
    XIAOMI_MOBILE_NOT_SUPPORT_SDK(601),
    XIAOMI_MOBILE_REGISTER_FAILED(INTLMethodID.INTL_METHOD_ID_TOOLS_CONVERT_SHORT_URL),
    XIAOMI_MOBILE_UNREGISTER_FAILED(INTLMethodID.INTL_METHOD_ID_DISPLAY_CUTOUT),
    XIAOMI_MOBILE_NOTIFY_GAME_SECENE_FAILED(604),
    OPPO_MOBILE_NOT_SUPPORT_SDK(701),
    TGPA_BINDER_NOT_SUPPORT(801),
    TGPA_BINDER_REGISTER_FAILED(802),
    TGPA_BINDER_AUTH_FAILED(803),
    PREDOWNLOAD_FUNC_IS_NOT_AVAILABLE(1001),
    PREDOWNLOAD_MAIN_VERSION_IS_NULL(1002),
    PREDOWNLOAD_SUB_VERSION_IS_NULL(1003),
    PREDOWNLOAD_SAVE_FILE_EXCEPTION(1004),
    PREDOWNLOAD_CLOSE_FILE_EXCEPTION(1005),
    PREDOWNLOAD_ENCRYPT_EXCEPTION(1006),
    PREDOWNLOAD_DELETE_FILE_FAILED(1007),
    SDKBASE_RUNEXCEPTION(10000),
    CLOUDCONFIG_CHECKEXCEPTION(10010),
    REPORTINFO_CHECKEXCEPTION(10020);

    private int va;

    g(int i) {
        this.va = i;
    }

    public String a() {
        return String.valueOf(this.va);
    }
}