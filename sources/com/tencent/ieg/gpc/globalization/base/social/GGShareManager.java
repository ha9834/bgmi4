package com.tencent.ieg.gpc.globalization.base.social;

import android.app.Activity;
import com.tencent.ieg.gpc.globalization.utils.ReflectUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class GGShareManager {
    private static final String TAG = "GGShareManager";
    protected Activity mActivity;
    private Map<String, GGShare> mChannelInsCache = new HashMap();
    protected GGShare mShare;

    public GGShareManager(Activity activity) {
        this.mActivity = activity;
    }

    public GGShare getCurrentShare() {
        return this.mShare;
    }

    public GGShare getShare(String str) {
        if (!initChannelInstance(str)) {
            return null;
        }
        this.mShare = this.mChannelInsCache.get(str);
        return this.mShare;
    }

    public boolean initChannelInstance(String str) {
        GGShare gGShare;
        if (!str.isEmpty() && this.mChannelInsCache.get(str) == null && (gGShare = (GGShare) ReflectUtil.createInstance(GGShare.class, String.format("com.tencent.ieg.gpc.globalization.gg%s.GG%sShare", str.toLowerCase(Locale.US), str))) != null) {
            gGShare.initialize(this.mActivity);
            this.mChannelInsCache.put(str, gGShare);
        }
        return this.mChannelInsCache.containsKey(str);
    }
}
