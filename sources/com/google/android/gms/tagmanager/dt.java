package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dt implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TagManager f5127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(TagManager tagManager) {
        this.f5127a = tagManager;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.f5127a.dispatch();
        }
    }
}
