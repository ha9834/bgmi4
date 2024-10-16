package com.tencent.quantum.download;

/* loaded from: classes.dex */
public class GCBGDownloadFileData {
    public static final int DOWNLOAD_DOWNLOAIDNG = 2;
    public static final int DOWNLOAD_FAIL = -1;
    public static final int DOWNLOAD_NONE = 0;
    public static final int DOWNLOAD_SUCC = 1;
    private int mDownloadState;
    private long mDownloadedSize;
    private long mFileId;
    private String mFileName;
    private long mTaskId;
    private long mTotalSize;

    public GCBGDownloadFileData(String str) {
        this.mDownloadState = 0;
        this.mDownloadedSize = 0L;
        String[] split = str.split("\\|");
        if (split.length == 4) {
            this.mTaskId = Long.valueOf(split[0]).longValue();
            this.mFileId = Long.valueOf(split[1]).longValue();
            this.mTotalSize = Long.valueOf(split[2]).longValue();
            this.mFileName = split[3];
            this.mDownloadState = 0;
            this.mDownloadedSize = 0L;
        }
    }

    public long getmTotalSize() {
        return this.mTotalSize;
    }

    public long getmTaskId() {
        return this.mTaskId;
    }

    public long getmFileId() {
        return this.mFileId;
    }

    public String getmFileName() {
        return this.mFileName;
    }

    public int getmDownloadState() {
        return this.mDownloadState;
    }

    public void setmDownloadState(int i) {
        this.mDownloadState = i;
    }

    public long getmDownloadedSize() {
        return this.mDownloadedSize;
    }

    public void setmDownloadedSize(long j) {
        this.mDownloadedSize = j;
    }
}
