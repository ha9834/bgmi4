package com.ihoc.mgpa;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IMGPAService {

    /* loaded from: classes2.dex */
    public interface Callback {
        void notifySystemInfo(String str);
    }

    /* loaded from: classes2.dex */
    public interface TouchEventListener {
        boolean onTouch(TouchEventWrapper touchEventWrapper, View view, MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface TouchEventWrapper {
        void onTuringTouchIsCollecting(boolean z);

        boolean onTuringTouchListener(TouchEventListener touchEventListener);
    }

    void enableDebugMode();

    String getDataFromTGPA(String str, String str2);

    int getVersionCode();

    String getVersionName();

    void init(Activity activity, String str);

    void init(Context context, String str);

    void registerCallback();

    void registerCallback(Callback callback);

    void setLogAble(boolean z);

    void updateGameInfo(int i, String str);

    void updateGameInfo(String str, String str2);

    void updateGameInfo(String str, Map<String, String> map);
}
