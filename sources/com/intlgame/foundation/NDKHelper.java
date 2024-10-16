package com.intlgame.foundation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.util.UUID;

/* loaded from: classes2.dex */
public class NDKHelper {
    private static String SO_NAME = "INTLFoundation";
    private static Context mAppContext;
    protected static boolean mIsLoadedSO;
    private static boolean mIsLoadingSO;
    private static Handler mMainHandler;

    public native void runOnUiThreadHandler(long j, int i);

    public static boolean loadSO() {
        if (!mIsLoadedSO && !mIsLoadingSO) {
            mIsLoadingSO = true;
            INTLLog.i("try to load " + SO_NAME + ".so");
            try {
                System.loadLibrary(SO_NAME);
                System.loadLibrary("INTLCompliance");
                mIsLoadedSO = true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("INTL", SO_NAME + ".so loading failed.");
            }
        } else {
            INTLLog.i(SO_NAME + ".so have been loaded");
        }
        mIsLoadingSO = false;
        return mIsLoadedSO;
    }

    public static boolean checkSOLoaded() {
        if (mIsLoadedSO) {
            return true;
        }
        Log.e("NDKHelper", "--------------------------------------------\n.so has not been loaded.  \n");
        return false;
    }

    public static void init(Context context) {
        mAppContext = context;
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    public boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void runOnUIThread(final long j, final int i) {
        if (checkSOLoaded()) {
            mMainHandler.post(new Runnable() { // from class: com.intlgame.foundation.-$$Lambda$NDKHelper$9ptgeCaKEWq_lq-teRdaXjZIvC4
                @Override // java.lang.Runnable
                public final void run() {
                    NDKHelper.lambda$runOnUIThread$0(NDKHelper.this, i, j);
                }
            });
        }
    }

    public static /* synthetic */ void lambda$runOnUIThread$0(NDKHelper nDKHelper, int i, long j) {
        Log.d("compliance", "runOnUiThreadHandler: " + i + APLogFileUtil.SEPARATOR_LOG + j);
        nDKHelper.runOnUiThreadHandler(j, i);
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public Context getApplicationContext() {
        return mAppContext;
    }
}
