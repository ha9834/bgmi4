package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public class Log {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* loaded from: classes2.dex */
    private static class LogInstanceHolder {
        private static volatile Log instance;

        private LogInstanceHolder() {
        }

        static {
            long Log_GetInstance = INTLFoundationJNI.Log_GetInstance();
            if (Log_GetInstance != 0) {
                instance = new Log(Log_GetInstance, false);
            }
        }

        static Log getInstance() {
            if (instance == null) {
                synchronized (LogInstanceHolder.class) {
                    if (instance == null) {
                        long Log_GetInstance = INTLFoundationJNI.Log_GetInstance();
                        if (Log_GetInstance != 0) {
                            instance = new Log(Log_GetInstance, false);
                        }
                    }
                }
            }
            return instance;
        }
    }

    protected Log(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Log log) {
        if (log == null) {
            return 0L;
        }
        return log.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                INTLFoundationJNI.delete_Log(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static Log GetInstance() {
        return LogInstanceHolder.getInstance();
    }

    public void Init() {
        INTLFoundationJNI.Log_Init(this.swigCPtr, this);
    }

    public void OutputLog(LogLevel logLevel, String str, boolean z, boolean z2, String str2, String str3, int i, String str4) {
        INTLFoundationJNI.Log_OutputLog(this.swigCPtr, this, logLevel.swigValue(), str, z, z2, str2, str3, i, str4);
    }

    public void ReportLogFiles() {
        INTLFoundationJNI.Log_ReportLogFiles(this.swigCPtr, this);
    }

    public void DeleteLogFiles(long j) {
        INTLFoundationJNI.Log_DeleteLogFiles(this.swigCPtr, this, j);
    }

    public void set_max_log_file_size(long j) {
        INTLFoundationJNI.Log_set_max_log_file_size(this.swigCPtr, this, j);
    }

    public void set_file_excess_action(FileExcessAction fileExcessAction) {
        INTLFoundationJNI.Log_set_file_excess_action(this.swigCPtr, this, fileExcessAction.swigValue());
    }

    public void set_log_file_path_dir(String str) {
        INTLFoundationJNI.Log_set_log_file_path_dir(this.swigCPtr, this, str);
    }

    public void set_enable_encrypt(boolean z) {
        INTLFoundationJNI.Log_set_enable_encrypt(this.swigCPtr, this, z);
    }

    public void set_enable_compress(boolean z) {
        INTLFoundationJNI.Log_set_enable_compress(this.swigCPtr, this, z);
    }

    public void set_log_level(LogLevel logLevel) {
        INTLFoundationJNI.Log_set_log_level(this.swigCPtr, this, logLevel.swigValue());
    }

    public void set_enable_console_output(boolean z) {
        INTLFoundationJNI.Log_set_enable_console_output(this.swigCPtr, this, z);
    }

    public void set_enable_file_output(boolean z) {
        INTLFoundationJNI.Log_set_enable_file_output(this.swigCPtr, this, z);
    }

    public void set_enable_auto_delete_log_file(boolean z) {
        INTLFoundationJNI.Log_set_enable_auto_delete_log_file(this.swigCPtr, this, z);
    }

    public void set_log_file_limit_hours(int i) {
        INTLFoundationJNI.Log_set_log_file_limit_hours(this.swigCPtr, this, i);
    }

    public void FileOutputAsync(String str) {
        INTLFoundationJNI.Log_FileOutputAsync(this.swigCPtr, this, str);
    }

    public void DeleteFileAsync(long j) {
        INTLFoundationJNI.Log_DeleteFileAsync(this.swigCPtr, this, j);
    }
}
