package com.tencent.imsdk.android.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.Keep;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Keep
/* loaded from: classes.dex */
public final class IMSDKProxyActivity extends Activity {
    private static final String TAG = "LifeCycle";
    private static Context mCtx;
    private static Queue<Pair<LifeCycleCallback, Integer>> mLifeAndRCodeContainer = new ConcurrentLinkedQueue();
    private static volatile LifeCycleCallback mCurLifeCycle = null;

    @Keep
    /* loaded from: classes.dex */
    public static abstract class LifeCycleCallback {
        protected void onActivityCfgChanged(Configuration configuration) {
        }

        protected abstract void onActivityCreate(Bundle bundle, Activity activity);

        /* JADX INFO: Access modifiers changed from: protected */
        public void onActivityDestroy() {
        }

        protected void onActivityPause() {
        }

        protected abstract boolean onActivityResult(int i, int i2, Intent intent);

        protected void onActivityResume() {
        }

        protected void onNewIntent(Intent intent) {
        }

        public boolean onRequestPermResult(int i, String[] strArr, int[] iArr) {
            return false;
        }
    }

    public static void registerLifeCycle(Context context, LifeCycleCallback lifeCycleCallback) {
        registerLifeCycle(context, -1, lifeCycleCallback);
    }

    public static void registerLifeCycle(Context context, int i, LifeCycleCallback lifeCycleCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("LifeCycle mCurCtx is ");
        sb.append(context == null ? Constants.NULL_VERSION_ID : "not null");
        IMLogger.d(sb.toString());
        mLifeAndRCodeContainer.add(Pair.create(lifeCycleCallback, Integer.valueOf(i)));
        mCtx = context;
        loop();
    }

    private static void loop() {
        Context context;
        StringBuilder sb = new StringBuilder();
        sb.append("LifeCycle current LifeCycle instance is ");
        sb.append(mCurLifeCycle == null ? Constants.NULL_VERSION_ID : mCurLifeCycle.getClass().getName());
        sb.append(", queue is ");
        sb.append(mLifeAndRCodeContainer.isEmpty() ? "empty" : MessengerShareContentUtility.WEBVIEW_RATIO_FULL);
        IMLogger.d(sb.toString());
        boolean z = true;
        Pair<LifeCycleCallback, Integer> poll = mLifeAndRCodeContainer.poll();
        if (mCurLifeCycle == null && poll != null) {
            LifeCycleCallback lifeCycleCallback = (LifeCycleCallback) poll.first;
            mCurLifeCycle = lifeCycleCallback;
            if (lifeCycleCallback != null && (context = mCtx) != null) {
                z = false;
                Intent intent = new Intent(context, (Class<?>) IMSDKProxyActivity.class);
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                if (((Integer) poll.second).intValue() == -1) {
                    mCtx.startActivity(intent);
                } else {
                    Context context2 = mCtx;
                    if (context2 instanceof Activity) {
                        ((Activity) context2).startActivityForResult(intent, ((Integer) poll.second).intValue());
                    }
                }
            }
        }
        if (z) {
            mLifeAndRCodeContainer.clear();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IMLogger.d("LifeCycle onCreate");
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onActivityCreate(bundle, this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IMLogger.d("LifeCycle onResume");
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onActivityResume();
        } else if (mLifeAndRCodeContainer.size() == 0 && mCtx == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onNewIntent(intent);
        } else if (mLifeAndRCodeContainer.size() == 0 && mCtx == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (mCurLifeCycle != null && mCurLifeCycle.onActivityResult(i, i2, intent)) {
            finish();
        } else if (mLifeAndRCodeContainer.size() == 0 && mCtx == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (mCurLifeCycle != null && mCurLifeCycle.onRequestPermResult(i, strArr, iArr)) {
            finish();
        } else if (mLifeAndRCodeContainer.size() == 0 && mCtx == null) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onActivityCfgChanged(configuration);
        } else if (mLifeAndRCodeContainer.size() == 0 && mCtx == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onActivityPause();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        IMLogger.d("LifeCycle onDestroy");
        if (mCurLifeCycle != null) {
            mCurLifeCycle.onActivityDestroy();
            mCurLifeCycle = null;
            loop();
        }
    }
}
