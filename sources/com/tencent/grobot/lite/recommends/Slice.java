package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.view.View;
import com.tencent.grobot.lite.common.ComponentRef;

/* loaded from: classes2.dex */
public abstract class Slice implements ComponentRef {
    final Feeds container;
    protected final Context context;
    public View v;

    public abstract void fixNotchScreen();

    public int height() {
        return -1;
    }

    public void start(Object... objArr) {
    }

    public void stop(Object... objArr) {
    }

    public abstract View view();

    public int width() {
        return -1;
    }

    public Slice(Feeds feeds) {
        this.context = feeds.context();
        this.container = feeds;
    }
}
