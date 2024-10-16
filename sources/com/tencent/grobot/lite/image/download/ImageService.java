package com.tencent.grobot.lite.image.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.amazonaws.services.s3.internal.Constants;
import com.nostra13.universalimageloader.a.b.a.b;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.d.a;
import com.nostra13.universalimageloader.core.e;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.core.IService;
import com.tencent.grobot.lite.core.IServiceCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ImageService implements a, IService {
    public static final int CALLBACK_TYPE_CANCEL = 3;
    public static final int CALLBACK_TYPE_COMPLETE = 1;
    public static final int CALLBACK_TYPE_FAIL = 2;
    public static final int CALLBACK_TYPE_START = 0;
    private final Map<String, IServiceCallback> listeners = new ConcurrentHashMap();
    private final d loader;

    public ImageService(GRobotApplication gRobotApplication) {
        boolean isHighPerformace = gRobotApplication.isHighPerformace();
        e a2 = new e.a(gRobotApplication.context).a(new c.a().a(Bitmap.Config.RGB_565).a(true).b(true).a(isHighPerformace ? ImageScaleType.IN_SAMPLE_POWER_OF_2 : ImageScaleType.EXACTLY).a(new Handler(Looper.getMainLooper())).a()).a(isHighPerformace ? 3 : 1).a(new b(isHighPerformace ? 2097152 : Constants.MB)).b(isHighPerformace ? 2097152 : Constants.MB).a(new com.nostra13.universalimageloader.a.a.a.b(com.nostra13.universalimageloader.b.e.a(gRobotApplication.context))).c(isHighPerformace ? 4194304 : 10485760).d(isHighPerformace ? 10 : 100).a(isHighPerformace ? 640 : 480, isHighPerformace ? 480 : 320, null).a();
        this.loader = d.a();
        this.loader.a(a2);
    }

    @Override // com.nostra13.universalimageloader.core.d.a
    public void onLoadingStarted(String str, View view) {
        IServiceCallback iServiceCallback = this.listeners.get(str);
        if (iServiceCallback != null) {
            iServiceCallback.onResult(0, str, new Object[0]);
        }
    }

    @Override // com.nostra13.universalimageloader.core.d.a
    public void onLoadingFailed(String str, View view, FailReason failReason) {
        IServiceCallback iServiceCallback = this.listeners.get(str);
        if (iServiceCallback != null) {
            iServiceCallback.onResult(2, str, failReason);
            this.listeners.remove(str);
        }
    }

    @Override // com.nostra13.universalimageloader.core.d.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        IServiceCallback iServiceCallback = this.listeners.get(str);
        if (iServiceCallback != null) {
            iServiceCallback.onResult(1, str, bitmap);
            this.listeners.remove(str);
        }
    }

    @Override // com.nostra13.universalimageloader.core.d.a
    public void onLoadingCancelled(String str, View view) {
        IServiceCallback iServiceCallback = this.listeners.get(str);
        if (iServiceCallback != null) {
            iServiceCallback.onResult(3, str, new Object[0]);
            this.listeners.remove(str);
        }
    }

    @Override // com.tencent.grobot.lite.core.IService
    public void onDestroy() {
        this.listeners.clear();
    }

    public void load(Context context, Object obj, Object obj2, Object obj3, int i, ImageView imageView, IServiceCallback iServiceCallback) {
        String str = (String) obj;
        this.loader.a(str, imageView, this);
        if (iServiceCallback != null) {
            this.listeners.put(str, iServiceCallback);
        }
    }
}
