package com.tencent.grobot.lite.ui.container;

import android.content.Context;
import android.os.Bundle;
import com.tencent.grobot.lite.recommends.Feeds;

/* loaded from: classes2.dex */
public class RouterCompat {
    public static final void main(Context context, Bundle bundle) {
        Router.jump(context, Feeds.class, bundle, false, false);
    }

    private RouterCompat() {
        throw new UnsupportedOperationException("Can not create an object.");
    }
}
