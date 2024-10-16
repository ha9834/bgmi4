package com.tencent.ieg.gpc.globalization.base.uploader;

import com.tencent.ieg.gpc.globalization.base.GGConfig;
import com.tencent.ieg.gpc.globalization.base.GGMoudle;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class GGUploader extends GGMoudle {
    private static final String UPLOAD_TIME_OUT = "UPLOAD_TIME_OUT";
    public static Map<String, String> authorData;
    protected int taskId = 0;
    protected GGUploaderListener uploaderListener = null;
    Timer mTimer = null;

    public void cancelUpload(int i) {
    }

    public void upload(String str) {
    }

    public void upload(String str, String str2) {
    }

    public void setListener(GGUploaderListener gGUploaderListener) {
        this.uploaderListener = gGUploaderListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTimer() {
        String config = GGConfig.getConfig(UPLOAD_TIME_OUT);
        int parseInt = !config.isEmpty() ? Integer.parseInt(config) : 60;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.tencent.ieg.gpc.globalization.base.uploader.GGUploader.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (GGUploader.this.uploaderListener == null || GGUploader.this.taskId == 0) {
                    return;
                }
                GGUploader.this.uploaderListener.onStateChanged(GGUploader.this.taskId, GGUploaderState.UPLOAD_TIMEOUT, "Upload Time out!!");
                GGUploader gGUploader = GGUploader.this;
                gGUploader.uploaderListener = null;
                gGUploader.cancelUpload(gGUploader.taskId);
            }
        }, parseInt * 1000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }
}
