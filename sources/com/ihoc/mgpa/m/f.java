package com.ihoc.mgpa.m;

import android.app.Activity;
import android.content.Context;
import com.ihoc.mgpa.IMGPAService;
import com.tencent.turingsmi.sdk.DataUsageType;
import com.tencent.turingsmi.sdk.GestureType;
import com.tencent.turingsmi.sdk.ITuringTouchWrapper;
import com.tencent.turingsmi.sdk.StartConfig;
import com.tencent.turingsmi.sdk.StopConfig;
import com.tencent.turingsmi.sdk.TuringSMIConfig;
import com.tencent.turingsmi.sdk.TuringSMIJob;
import com.tencent.turingsmi.sdk.TuringSMIService;
import com.tencent.turingsmi.sdk.UploadConfig;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
class f {
    f() {
    }

    public static void a() {
        TuringSMIService.stop(StopConfig.build().setNeedSamples(false));
    }

    public static void a(int i) {
        TuringSMIService.upload(UploadConfig.build().setScenes(i));
    }

    public static void a(String str, int i, Activity activity) {
        TuringSMIService.start(StartConfig.build().setUniqueId(str).setScenes(i).setMonitorActivity(activity).setDataUsageType(DataUsageType.DATA_USAGE_TYPE_IDENTIFY_TRAIN).setGestureType(GestureType.GESTURETYPE_MULTI), new d());
    }

    public static void a(String str, int i, IMGPAService.TouchEventWrapper touchEventWrapper) {
        TuringSMIService.start(StartConfig.build().setUniqueId(str).setScenes(i).setMonitorTouchWrapper((ITuringTouchWrapper) Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{ITuringTouchWrapper.class}, new h(touchEventWrapper))).setDataUsageType(DataUsageType.DATA_USAGE_TYPE_IDENTIFY_TRAIN).setGestureType(GestureType.GESTURETYPE_MULTI), new e());
    }

    public static boolean a(Context context, boolean z) {
        TuringSMIJob.Builder builder = new TuringSMIJob.Builder();
        builder.setTuringSMIConfig(new TuringSMIConfig());
        builder.setITuringInfoProvider(new c());
        try {
            TuringSMIService.init(context, builder.build());
            return true;
        } catch (Exception e) {
            throw new Exception("the error is that turing shield sdk init exception!", e);
        }
    }
}
