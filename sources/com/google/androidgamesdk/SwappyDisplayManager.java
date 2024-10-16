package com.google.androidgamesdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private LooperThread mLooper;
    private WindowManager mWindowManager;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final boolean DEBUG = false;
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = 1000000000;

    private native void nOnRefreshRateChanged(long j, long j2, long j3, long j4);

    private native void nSetSupportedRefreshRates(long j, long[] jArr, int[] iArr);

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    /* loaded from: classes2.dex */
    private class LooperThread extends Thread {
        private Condition mCondition;
        public Handler mHandler;
        private Lock mLock;

        private LooperThread() {
            this.mLock = new ReentrantLock();
            this.mCondition = this.mLock.newCondition();
        }

        @Override // java.lang.Thread
        public void start() {
            this.mLock.lock();
            super.start();
            try {
                this.mCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mLock.unlock();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i("SwappyDisplayManager", "Starting looper thread");
            this.mLock.lock();
            Looper.prepare();
            this.mHandler = new Handler();
            this.mCondition.signal();
            this.mLock.unlock();
            Looper.loop();
            Log.i("SwappyDisplayManager", "Terminating looper thread");
        }
    }

    @TargetApi(23)
    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    public SwappyDisplayManager(long j, Activity activity) {
        String string;
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128);
            if (activityInfo.metaData != null && (string = activityInfo.metaData.getString("android.app.lib_name")) != null) {
                System.loadLibrary(string);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("SwappyDisplayManager", e.getMessage());
        }
        this.mCookie = j;
        this.mActivity = activity;
        this.mWindowManager = (WindowManager) this.mActivity.getSystemService(WindowManager.class);
        Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            this.mLooper = new LooperThread();
            this.mLooper.start();
            displayManager.registerDisplayListener(this, this.mLooper.mHandler);
        }
    }

    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i = 0;
        for (Display.Mode mode : supportedModes) {
            if (modeMatchesCurrentResolution(mode)) {
                i++;
            }
        }
        long[] jArr = new long[i];
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < supportedModes.length; i3++) {
            if (modeMatchesCurrentResolution(supportedModes[i3])) {
                jArr[i2] = 1.0E9f / supportedModes[i3].getRefreshRate();
                iArr[i2] = supportedModes[i3].getModeId();
                i2++;
            }
        }
        nSetSupportedRefreshRates(this.mCookie, jArr, iArr);
    }

    public void setPreferredRefreshRate(final int i) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.google.androidgamesdk.SwappyDisplayManager.1
            @Override // java.lang.Runnable
            public void run() {
                Window window = SwappyDisplayManager.this.mActivity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.preferredDisplayModeId = i;
                window.setAttributes(attributes);
            }
        });
    }

    public void terminate() {
        this.mLooper.mHandler.getLooper().quit();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        synchronized (this) {
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z = true;
            boolean z2 = (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth()) | (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight());
            if (refreshRate == this.mCurrentMode.getRefreshRate()) {
                z = false;
            }
            this.mCurrentMode = mode;
            if (z2) {
                updateSupportedRefreshRates(defaultDisplay);
            }
            if (z) {
                long j = 1.0E9f / refreshRate;
                nOnRefreshRateChanged(this.mCookie, j, defaultDisplay.getAppVsyncOffsetNanos(), j - (this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }
}
