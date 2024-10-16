package com.tencent.quantum.download;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.hawk.bridge.HawkAgent;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.quantum.download.GCBGDownloadNotification;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class GCBGDownloadService extends Service {
    public static final int DOWNLOAD_REQUIRED = 1;
    public static final String EXTRA_DWONLOAD_INFO = "PUBG_DLINFO";
    public static final String EXTRA_PENDING_INTENT = "PUBG_EPI";
    public static final int MSG_WHAT_TICK_UPDATE_DOWNLOAD = 1;
    public static final int NO_DOWNLOAD_REQUIRED = 0;
    public static final int PMDT_DWON_PROGRESS = 0;
    public static final int PMDT_DWON_RETURN = 1;
    public static final String TAG = "BackgroudDowndloadService";
    public static final int TIMER_DELAY_STOP = 5;
    public static final int TIMER_PERIOD = 100;
    private int delayStopTickTimes;
    private GCBGDownloadInitData downloadInfo;
    private ArrayList<GCBGDownloadFileData> mDownloadFiles;
    private TimerHandler mHandler;
    private long mLatestErrorCode;
    private GCBGDownloadNotification mNotification;
    private PendingIntent mPendingIntent;
    private Timer mTimer;

    public native void PostGameStatusToTGPA(int i, String str);

    public native GCBGDownloadProgressInfo QueryProgress();

    public static int startDownloadServiceIfRequired(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        PendingIntent pendingIntent;
        String packageName = context.getPackageName();
        String name = GCBGDownloadService.class.getName();
        if (intent == null || (pendingIntent = (PendingIntent) intent.getParcelableExtra(EXTRA_PENDING_INTENT)) == null) {
            return 0;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_DWONLOAD_INFO);
        Intent intent2 = new Intent();
        intent2.setClassName(packageName, name);
        if (parcelableExtra != null) {
            intent2.putExtra(EXTRA_DWONLOAD_INFO, parcelableExtra);
        }
        if (pendingIntent != null) {
            intent2.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Log.d(TAG, "startDownloadServiceIfRequired: startForegraoundService");
            context.startForegroundService(intent2);
            return 1;
        }
        Log.d(TAG, "startDownloadServiceIfRequired: startService");
        context.startService(intent2);
        return 1;
    }

    public static void stopDownloadService(Context context) {
        String packageName = context.getPackageName();
        String name = GCBGDownloadService.class.getName();
        Intent intent = new Intent();
        intent.setClassName(packageName, name);
        context.stopService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        createNotification();
        this.mHandler = new TimerHandler(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        PendingIntent pendingIntent;
        Log.d(TAG, "onStartCommand");
        this.mDownloadFiles = new ArrayList<>();
        if (intent != null) {
            if (intent.getParcelableExtra(EXTRA_DWONLOAD_INFO) != null) {
                this.downloadInfo = (GCBGDownloadInitData) intent.getParcelableExtra(EXTRA_DWONLOAD_INFO);
            }
            this.mPendingIntent = (PendingIntent) intent.getParcelableExtra(EXTRA_PENDING_INTENT);
        }
        if (this.downloadInfo != null && (pendingIntent = this.mPendingIntent) != null) {
            GCBGDownloadNotification gCBGDownloadNotification = this.mNotification;
            if (gCBGDownloadNotification != null) {
                gCBGDownloadNotification.setPendingIntent(pendingIntent);
            }
            for (String str : this.downloadInfo.getmDownloadDetail().split(",")) {
                if (str != null && str.trim().length() > 0) {
                    this.mDownloadFiles.add(new GCBGDownloadFileData(str));
                }
            }
            startTimerTask();
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        cancelTimer();
        super.onDestroy();
    }

    private void createNotification() {
        try {
            this.mNotification = new GCBGDownloadNotification(this, getPackageManager().getApplicationLabel(getApplicationInfo()));
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(GCBGDownloadNotification.NOTIFICATION_ID, this.mNotification.getNormalDescriptionNotify("Application Running...").b());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startTimerTask() {
        this.mTimer = new Timer();
        this.delayStopTickTimes = 5;
        this.mTimer.schedule(new TimerTask() { // from class: com.tencent.quantum.download.GCBGDownloadService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                GCBGDownloadService.this.mHandler.sendMessage(GCBGDownloadService.this.mHandler.obtainMessage(1));
            }
        }, 0L, 100L);
    }

    private void updateNotificationProgress(long j, long j2, boolean z, int i) {
        String format;
        if (z) {
            this.mNotification.swithMode(GCBGDownloadNotification.NotificationMode.TEXT);
            if (i <= 0) {
                format = this.downloadInfo.getmCompleteText();
            } else {
                format = format(this.downloadInfo.getmErrorText(), Long.valueOf(this.mLatestErrorCode));
            }
        } else {
            String format2 = String.format("%.2fM", Float.valueOf((((float) j) / 1024.0f) / 1024.0f));
            String format3 = String.format("%.2fM", Float.valueOf((((float) j2) / 1024.0f) / 1024.0f));
            this.mNotification.swithMode(GCBGDownloadNotification.NotificationMode.PROGRESS);
            format = format(this.downloadInfo.getmProgressTextFormat(), format3, format2);
        }
        Log.d(TAG, "updateNotificationProgress: " + String.valueOf(j) + ", " + String.valueOf(j2) + ", " + String.valueOf(z));
        this.mNotification.onDownloadProgress(format, j2, j);
    }

    public void onHandlerTimerTask(boolean z, int i, long j, long j2, long j3, long j4, boolean z2, long j5) {
        GCBGDownloadFileData downloadFileByTaskId = getDownloadFileByTaskId(j);
        if (downloadFileByTaskId == null) {
            Log.d(TAG, "onHandlerTimerTask: do nothing by taskid not found");
        } else if (i == 0) {
            Log.d(TAG, "onHandlerTimerTask: PMDT_DWON_PROGRESS");
            downloadFileByTaskId.setmDownloadState(2);
            downloadFileByTaskId.setmDownloadedSize(j3);
        } else if (i == 1) {
            Log.d(TAG, "onHandlerTimerTask: PMDT_DWON_RETURN");
            if (z2) {
                downloadFileByTaskId.setmDownloadState(1);
                downloadFileByTaskId.setmDownloadedSize(downloadFileByTaskId.getmTotalSize());
            } else {
                this.mLatestErrorCode = j5;
                downloadFileByTaskId.setmDownloadState(-1);
            }
        } else {
            Log.d(TAG, "onHandlerTimerTask: do nothing by type not match");
        }
        Iterator<GCBGDownloadFileData> it = this.mDownloadFiles.iterator();
        long j6 = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            GCBGDownloadFileData next = it.next();
            if (next.getmDownloadState() == 1) {
                i2++;
            }
            if (next.getmDownloadState() == -1) {
                i3++;
            }
            j6 += next.getmDownloadedSize();
        }
        boolean z3 = i2 + i3 == this.mDownloadFiles.size() || this.mDownloadFiles.size() == 0;
        long j7 = j6 + this.downloadInfo.getmProgressSize();
        if (!z3 && this.downloadInfo.getmTotalSize() < j7) {
            z3 = true;
        }
        updateNotificationProgress(this.downloadInfo.getmTotalSize(), j7, z3, i3);
        String str = "0";
        if (z3) {
            str = CocosPayHelper.AP_MIDAS_RESP_RESULT_CHANNEL_ERR;
        } else if (this.downloadInfo.getmTotalSize() > 0) {
            str = String.valueOf(Math.round((float) ((j7 * 100) / this.downloadInfo.getmTotalSize())));
        }
        HawkAgent.postInfoToTGPA(75, str);
        if (z3) {
            this.delayStopTickTimes--;
            if (this.delayStopTickTimes <= 0) {
                cancelTimer();
            }
        }
    }

    private void cancelTimer() {
        Log.d(TAG, "cancelTimer");
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    private String format(String str, Object... objArr) {
        String str2 = str;
        for (int i = 0; i < objArr.length; i++) {
            str2 = str2.replaceAll(String.format("\\{%d\\}", Integer.valueOf(i)), String.valueOf(objArr[i]));
        }
        return str2;
    }

    public GCBGDownloadFileData getDownloadFileByTaskId(long j) {
        Iterator<GCBGDownloadFileData> it = this.mDownloadFiles.iterator();
        while (it.hasNext()) {
            GCBGDownloadFileData next = it.next();
            if (next.getmTaskId() == j) {
                return next;
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class TimerHandler extends Handler {
        WeakReference<GCBGDownloadService> mWeakReference;

        TimerHandler(GCBGDownloadService gCBGDownloadService) {
            this.mWeakReference = new WeakReference<>(gCBGDownloadService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            GCBGDownloadService gCBGDownloadService = this.mWeakReference.get();
            if (message.what != 1) {
                return;
            }
            GCBGDownloadProgressInfo gCBGDownloadProgressInfo = null;
            try {
                gCBGDownloadProgressInfo = gCBGDownloadService.QueryProgress();
                if (gCBGDownloadProgressInfo != null) {
                    Log.d(GCBGDownloadService.TAG, "handleMessage QueryProgress: " + gCBGDownloadProgressInfo.toString());
                } else {
                    Log.d(GCBGDownloadService.TAG, "handleMessage QueryProgress: return null ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (gCBGDownloadProgressInfo != null) {
                gCBGDownloadService.onHandlerTimerTask(gCBGDownloadProgressInfo.isExecuteSuccess(), gCBGDownloadProgressInfo.getmType(), gCBGDownloadProgressInfo.getTaskId(), gCBGDownloadProgressInfo.getFileId(), gCBGDownloadProgressInfo.getNowSize(), gCBGDownloadProgressInfo.getTotalSize(), gCBGDownloadProgressInfo.isSuccess(), gCBGDownloadProgressInfo.getErrorCode());
            }
        }
    }
}
