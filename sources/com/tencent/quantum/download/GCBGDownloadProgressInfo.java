package com.tencent.quantum.download;

/* loaded from: classes.dex */
public class GCBGDownloadProgressInfo {
    private long mErrorCode;
    private boolean mExecuteSuccess;
    private long mFileId;
    private boolean mIsSuccess;
    private long mNowSize;
    private long mTaskId;
    private long mTotalSize;
    private int mType;

    public GCBGDownloadProgressInfo(boolean z, int i, long j, long j2, long j3, long j4, boolean z2, long j5) {
        this.mExecuteSuccess = z;
        this.mType = i;
        this.mTaskId = j;
        this.mFileId = j2;
        this.mNowSize = j3;
        this.mTotalSize = j4;
        this.mIsSuccess = z2;
        this.mErrorCode = j5;
    }

    public int getmType() {
        return this.mType;
    }

    public long getTaskId() {
        return this.mTaskId;
    }

    public long getFileId() {
        return this.mFileId;
    }

    public long getNowSize() {
        return this.mNowSize;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public long getErrorCode() {
        return this.mErrorCode;
    }

    public boolean isExecuteSuccess() {
        return this.mExecuteSuccess;
    }

    public String toString() {
        return "mExecuteSuccess:" + String.valueOf(this.mExecuteSuccess) + ",mType:" + String.valueOf(this.mType) + ",mTaskId:" + String.valueOf(this.mTaskId) + ",mFileId:" + String.valueOf(this.mFileId) + ",mNowSize:" + String.valueOf(this.mNowSize) + ",mTotalSize:" + String.valueOf(this.mTotalSize) + ",mIsSuccess:" + String.valueOf(this.mIsSuccess) + ",mErrorCode:" + String.valueOf(this.mErrorCode);
    }
}
