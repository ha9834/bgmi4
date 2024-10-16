package com.intlgame;

import android.content.Context;
import com.intlgame.foundation.INTLLog;
import com.intlgame.foundation.NDKHelper;

/* loaded from: classes2.dex */
public final class INTLApp {
    private Context mAppContext;
    private boolean mInitialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Singleton {
        private static final INTLApp INSTANCE = new INTLApp();

        private Singleton() {
        }
    }

    private INTLApp() {
    }

    public static INTLApp getInstance() {
        return Singleton.INSTANCE;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public void init(Context context) {
        if (this.mInitialized) {
            return;
        }
        this.mAppContext = context;
        NDKHelper.loadSO();
        NDKHelper.init(context);
        INTLLog.setAppContext(context);
        this.mInitialized = true;
    }
}
