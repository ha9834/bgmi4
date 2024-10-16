package com.tencent.ieg.gpc.globalization.base.social;

import android.content.Intent;
import com.tencent.ieg.gpc.globalization.base.GGMoudle;

/* loaded from: classes2.dex */
public abstract class GGShare extends GGMoudle {
    protected int sharerId = 0;
    protected GGShareListener shareListener = null;

    public void activityResultHandler(int i, int i2, Intent intent) {
    }

    public void shareImage(String str, String str2) {
    }

    public void shareImageWithLink(String str, String str2, String str3) {
    }

    public void shareVideo(String str, String str2) {
    }

    public void setShareListener(GGShareListener gGShareListener) {
        this.shareListener = gGShareListener;
    }
}
