package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public class INTLFoundationJNI {
    public static final native long CommonLogHeader_actual_size__get(long j, CommonLogHeader commonLogHeader);

    public static final native void CommonLogHeader_actual_size__set(long j, CommonLogHeader commonLogHeader, long j2);

    public static final native long CommonLogHeader_reserved_space_get(long j, CommonLogHeader commonLogHeader);

    public static final native void CommonLogHeader_reserved_space_set(long j, CommonLogHeader commonLogHeader, long j2);

    public static final native String DEFAULT_LOG_TAG_get();

    public static final native int INTL_COMPRESS_FLAG_get();

    public static final native int INTL_ENCRYTP_FLAG_get();

    public static final native String INTL_FILE_NAME_FORMAT_get();

    public static final native int INTL_FILE_NAME_LENGTH_get();

    public static final native boolean INTL_LOG_DEFAULT_AUTO_DELETE_FILE_ENABLE_get();

    public static final native boolean INTL_LOG_DEFAULT_COMPRESS_ENABLE_get();

    public static final native boolean INTL_LOG_DEFAULT_CONSOLE_OUTPUT_ENABLE_get();

    public static final native boolean INTL_LOG_DEFAULT_ENCRYPT_ENABLE_get();

    public static final native int INTL_LOG_DEFAULT_FILE_LIMIT_HOURS_get();

    public static final native boolean INTL_LOG_DEFAULT_FILE_OUTPUT_ENABLE_get();

    public static final native int INTL_LOG_DEFAULT_MAX_FILE_SIZE_get();

    public static final native String INTL_NEWLINE_FLAG_get();

    public static final native int INTL_NO_COMPRESS_FLAG_get();

    public static final native int INTL_NO_ENCRYTP_FLAG_get();

    public static final native int INTL_OS_ANDROID_get();

    public static final native int INTL_OS_IOS_get();

    public static final native int INTL_OS_MAC_get();

    public static final native int INTL_OS_PLAY_STATION_get();

    public static final native int INTL_OS_SWITCH_get();

    public static final native int INTL_OS_WINDOWS_get();

    public static final native int INTL_OS_XBOX_get();

    public static final native String INTL_PATH_SLASH_get();

    public static final native int LOG_MAX_LENGTH_get();

    public static final native String LOG_PREFIX_FORMAT_get();

    public static final native void Log_DeleteFileAsync(long j, Log log, long j2);

    public static final native void Log_DeleteLogFiles(long j, Log log, long j2);

    public static final native void Log_FileOutputAsync(long j, Log log, String str);

    public static final native long Log_GetInstance();

    public static final native void Log_Init(long j, Log log);

    public static final native void Log_OutputLog(long j, Log log, int i, String str, boolean z, boolean z2, String str2, String str3, int i2, String str4);

    public static final native void Log_ReportLogFiles(long j, Log log);

    public static final native void Log_set_enable_auto_delete_log_file(long j, Log log, boolean z);

    public static final native void Log_set_enable_compress(long j, Log log, boolean z);

    public static final native void Log_set_enable_console_output(long j, Log log, boolean z);

    public static final native void Log_set_enable_encrypt(long j, Log log, boolean z);

    public static final native void Log_set_enable_file_output(long j, Log log, boolean z);

    public static final native void Log_set_file_excess_action(long j, Log log, int i);

    public static final native void Log_set_log_file_limit_hours(long j, Log log, int i);

    public static final native void Log_set_log_file_path_dir(long j, Log log, String str);

    public static final native void Log_set_log_level(long j, Log log, int i);

    public static final native void Log_set_max_log_file_size(long j, Log log, long j2);

    public static final native int MINIMUM_JSON_LEN_get();

    public static final native short SingleLineLogHeader_encrypt_compress_flag_get(long j, SingleLineLogHeader singleLineLogHeader);

    public static final native void SingleLineLogHeader_encrypt_compress_flag_set(long j, SingleLineLogHeader singleLineLogHeader, short s);

    public static final native long SingleLineLogHeader_log_len_get(long j, SingleLineLogHeader singleLineLogHeader);

    public static final native void SingleLineLogHeader_log_len_set(long j, SingleLineLogHeader singleLineLogHeader, long j2);

    public static final native long SingleLineLogHeader_reserved_space_get(long j, SingleLineLogHeader singleLineLogHeader);

    public static final native void SingleLineLogHeader_reserved_space_set(long j, SingleLineLogHeader singleLineLogHeader, long j2);

    public static final native void delete_CommonLogHeader(long j);

    public static final native void delete_Log(long j);

    public static final native void delete_SingleLineLogHeader(long j);

    public static final native int kFileExcessActionReWrite_get();

    public static final native int kFileExcessActionStopAppend_get();

    public static final native int kLogLevelDebug_get();

    public static final native int kLogLevelError_get();

    public static final native int kLogLevelInfo_get();

    public static final native int kLogLevelWarn_get();

    public static final native long new_CommonLogHeader();

    public static final native long new_SingleLineLogHeader();
}
