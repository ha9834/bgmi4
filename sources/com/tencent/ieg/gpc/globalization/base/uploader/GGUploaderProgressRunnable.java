package com.tencent.ieg.gpc.globalization.base.uploader;

/* loaded from: classes2.dex */
public class GGUploaderProgressRunnable implements Runnable {
    public long mBytesCurrent;
    public long mBytesTotal;
    public int mId;

    @Override // java.lang.Runnable
    public void run() {
    }

    public GGUploaderProgressRunnable(int i, long j, long j2) {
        this.mId = 0;
        this.mBytesCurrent = 0L;
        this.mBytesTotal = 0L;
        this.mId = i;
        this.mBytesCurrent = j;
        this.mBytesTotal = j2;
    }
}
