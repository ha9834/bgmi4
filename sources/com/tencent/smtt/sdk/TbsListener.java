package com.tencent.smtt.sdk;

/* loaded from: classes2.dex */
public interface TbsListener {
    public static final String tag_load_error = "loaderror";

    /* loaded from: classes2.dex */
    public interface ErrorCode {
        public static final int APK_INVALID = 204;
        public static final int APK_PATH_ERROR = 202;
        public static final int APK_VERSION_ERROR = 203;
        public static final int COPY_EXCEPTION = 215;
        public static final int COPY_FAIL = 212;
        public static final int COPY_INSTALL_SUCCESS = 220;
        public static final int COPY_SRCDIR_ERROR = 213;
        public static final int COPY_TMPDIR_ERROR = 214;
        public static final int CREATE_TEMP_CONF_ERROR = 225;
        public static final int DEXOPT_EXCEPTION = 209;
        public static final int DISK_FULL = 105;
        public static final int DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH = 113;
        public static final int DOWNLOAD_HAS_COPY_TBS_ERROR = 122;
        public static final int DOWNLOAD_HAS_LOCAL_TBS_ERROR = 120;
        public static final int DOWNLOAD_INSTALL_SUCCESS = 200;
        public static final int DOWNLOAD_INTERRUPT = 128;
        public static final int DOWNLOAD_OVER_FLOW = 112;
        public static final int DOWNLOAD_REDIRECT_EMPTY = 124;
        public static final int DOWNLOAD_RETRYTIMES302_EXCEED = 123;
        public static final int DOWNLOAD_SUCCESS = 100;
        public static final int DOWNLOAD_THROWABLE = 125;
        public static final int ERROR_CODE_DOWNLOAD_BASE = 100;
        public static final int ERROR_CODE_INSTALL_BASE = 200;
        public static final int ERROR_CODE_LOAD_BASE = 300;
        public static final int EXCEED_COPY_RETRY_NUM = 211;
        public static final int EXCEED_DEXOPT_RETRY_NUM = 208;
        public static final int EXCEED_INCR_UPDATE = 224;
        public static final int EXCEED_LZMA_RETRY_NUM = 223;
        public static final int EXCEED_UNZIP_RETRY_NUM = 201;
        public static final int FILE_DELETED = 106;
        public static final int FILE_RENAME_ERROR = 109;
        public static final int INCRUPDATE_INSTALL_SUCCESS = 221;
        public static final int INCR_UPDATE_ERROR = 216;
        public static final int INCR_UPDATE_EXCEPTION = 218;
        public static final int INCR_UPDATE_FAIL = 217;
        public static final int INFO_CODE_BASE = 400;
        public static final int INFO_CODE_MINIQB = 500;
        public static final int INFO_COOKIE_SWITCH_NONEED = 703;
        public static final int INFO_COOKIE_SWITCH_NO_KEYS = 701;
        public static final int INFO_COOKIE_SWITCH_REPORT_BASE = 700;
        public static final int INFO_COOKIE_SWITCH_TRANSFER = 704;
        public static final int INFO_COOKIE_SWITCH_VERSION_ERROR = 702;
        public static final int INFO_FORCE_SYSTEM_WEBVIEW_INNER = 401;
        public static final int INFO_FORCE_SYSTEM_WEBVIEW_OUTER = 402;
        public static final int INFO_GET_PROCESS_LOCK_FAILED = 801;
        public static final int INFO_GET_PROCESS_LOCK_NEED_REPAIR = 803;
        public static final int INFO_GET_PROCESS_LOCK_REPAIR_SUCCESS = 802;
        public static final int NEEDDOWNLOAD_1 = 140;
        public static final int NEEDDOWNLOAD_10 = 149;
        public static final int NEEDDOWNLOAD_2 = 141;
        public static final int NEEDDOWNLOAD_3 = 142;
        public static final int NEEDDOWNLOAD_4 = 143;
        public static final int NEEDDOWNLOAD_5 = 144;
        public static final int NEEDDOWNLOAD_6 = 145;
        public static final int NEEDDOWNLOAD_7 = 146;
        public static final int NEEDDOWNLOAD_8 = 147;
        public static final int NEEDDOWNLOAD_9 = 148;
        public static final int NEEDDOWNLOAD_FALSE_1 = 171;
        public static final int NEEDDOWNLOAD_FALSE_2 = 172;
        public static final int NEEDDOWNLOAD_FALSE_3 = 173;
        public static final int NEEDDOWNLOAD_FALSE_4 = 174;
        public static final int NEEDDOWNLOAD_FALSE_5 = 175;
        public static final int NEEDDOWNLOAD_FALSE_6 = 176;
        public static final int NEEDDOWNLOAD_TRUE = 170;
        public static final int NETWORK_NOT_WIFI_ERROR = 111;
        public static final int NETWORK_UNAVAILABLE = 101;
        public static final int NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING = 177;
        public static final int NONEEDTODOWN_ERROR = 110;
        public static final int PV_UPLOAD_ERROR = 126;
        public static final int READ_RESPONSE_ERROR = 103;
        public static final int RENAME_EXCEPTION = 219;
        public static final int ROM_NOT_ENOUGH = 210;
        public static final int SERVER_ERROR = 102;
        public static final int STARTDOWNLOAD_1 = 160;
        public static final int STARTDOWNLOAD_10 = 169;
        public static final int STARTDOWNLOAD_2 = 161;
        public static final int STARTDOWNLOAD_3 = 162;
        public static final int STARTDOWNLOAD_4 = 163;
        public static final int STARTDOWNLOAD_5 = 164;
        public static final int STARTDOWNLOAD_6 = 165;
        public static final int STARTDOWNLOAD_7 = 166;
        public static final int STARTDOWNLOAD_8 = 167;
        public static final int STARTDOWNLOAD_9 = 168;
        public static final int THREAD_INIT_ERROR = 121;
        public static final int THROWABLE_INITX5CORE = 325;
        public static final int UNKNOWN_ERROR = 107;
        public static final int UNLZMA_FAIURE = 222;
        public static final int UNZIP_DIR_ERROR = 205;
        public static final int UNZIP_IO_ERROR = 206;
        public static final int UNZIP_OTHER_ERROR = 207;
        public static final int VERIFY_ERROR = 108;
        public static final int WRITE_DISK_ERROR = 104;
    }

    void onDownloadFinish(int i);

    void onDownloadProgress(int i);

    void onInstallFinish(int i);
}
