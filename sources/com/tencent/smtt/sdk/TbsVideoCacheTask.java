package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* renamed from: a, reason: collision with root package name */
    Context f6478a;
    TbsVideoCacheListener b;
    private String e;
    private String f;
    private boolean c = false;
    private l d = null;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.f6478a = null;
        this.b = null;
        this.f6478a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString("url");
        }
        a(bundle);
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    private void a(Bundle bundle) {
        UselessClass uselessClass;
        if (this.d == null) {
            c.a(true).a(this.f6478a, false, false, null);
            p a2 = c.a(true).a();
            if (a2 != null) {
                uselessClass = a2.a();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                uselessClass = null;
            }
            if (uselessClass != null) {
                this.d = new l(uselessClass);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        l lVar = this.d;
        if (lVar != null) {
            this.g = lVar.a(this.f6478a, this, bundle);
            if (this.g == null) {
                this.b.onVideoDownloadError(this, -1, "init task error!", null);
                return;
            }
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "init error!", null);
        }
    }

    public void pauseTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("pauseTask mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call pauseTask");
            this.d.a();
        } else {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
            }
        }
    }

    public void stopTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("stopTask mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call stopTask");
            this.d.c();
        } else {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
            }
        }
    }

    public void resumeTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("resumeTask mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call resumeTask");
            this.d.b();
        } else {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
            }
        }
    }

    public void removeTask(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("removeTask mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call removeTask");
            this.d.a(z);
        } else {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
            }
        }
    }

    public long getContentLength() {
        StringBuilder sb = new StringBuilder();
        sb.append("getContentLength mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call getContentLength");
            return this.d.d();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0L;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0L;
    }

    public int getDownloadedSize() {
        StringBuilder sb = new StringBuilder();
        sb.append("getDownloadedSize mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call getDownloadedSize");
            return this.d.e();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        StringBuilder sb = new StringBuilder();
        sb.append("getProgress mWizard = ");
        sb.append(this.d == null ? Constants.NULL_VERSION_ID : "not null");
        sb.append("  mDownloadWorker = ");
        sb.append(this.g == null ? Constants.NULL_VERSION_ID : "not null");
        Log.d("TbsVideoCacheTask", sb.toString());
        if (this.d != null && this.g != null) {
            Log.d("TbsVideoCacheTask", "mWizard call getProgress");
            return this.d.f();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }
}
