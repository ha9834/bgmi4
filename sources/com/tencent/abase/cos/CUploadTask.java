package com.tencent.abase.cos;

/* loaded from: classes2.dex */
public class CUploadTask {
    private long mCListener;
    private long mCTask;
    private CosUploadTask task = new CosUploadTask();

    public native void nativeOnUploadFinished(long j, long j2, int i);

    public void upload(String str, String str2, long j, String str3, long j2, long j3) {
        this.mCListener = j2;
        this.mCTask = j3;
        this.task.setCredentialInfo(str3);
        this.task.setResultListener(new CosResultListener() { // from class: com.tencent.abase.cos.CUploadTask.1
            @Override // com.tencent.abase.cos.CosResultListener
            public void onFinished(int i) {
                CUploadTask cUploadTask = CUploadTask.this;
                cUploadTask.nativeOnUploadFinished(cUploadTask.mCTask, CUploadTask.this.mCListener, i);
            }
        });
        this.task.upload(str, str2, j);
    }
}
