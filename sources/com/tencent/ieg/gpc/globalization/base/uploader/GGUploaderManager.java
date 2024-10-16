package com.tencent.ieg.gpc.globalization.base.uploader;

import android.app.Activity;
import com.tencent.ieg.gpc.globalization.utils.ReflectUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class GGUploaderManager {
    private static GGUploaderManager _instance;
    protected Activity mActivity;
    private Map<String, GGUploader> mChannelInsCache = new HashMap();
    protected GGUploader mUploader;

    public static GGUploaderManager GetInstance(Activity activity) {
        if (_instance == null) {
            _instance = new GGUploaderManager(activity);
        }
        return _instance;
    }

    public GGUploader getCurrentUploader() {
        return this.mUploader;
    }

    public GGUploaderManager(Activity activity) {
        this.mActivity = activity;
    }

    public GGUploader getUploader(String str) {
        if (!initChannelInstance(str)) {
            return null;
        }
        this.mUploader = this.mChannelInsCache.get(str);
        return this.mUploader;
    }

    public boolean initChannelInstance(String str) {
        GGUploader gGUploader;
        if (!str.isEmpty() && this.mChannelInsCache.get(str) == null && (gGUploader = (GGUploader) ReflectUtil.createInstance(GGUploader.class, String.format("com.tencent.ieg.gpc.globalization.gg%s.%sUploader", str.toLowerCase(Locale.US), str))) != null) {
            gGUploader.initialize(this.mActivity);
            this.mChannelInsCache.put(str, gGUploader);
        }
        return this.mChannelInsCache.containsKey(str);
    }
}
