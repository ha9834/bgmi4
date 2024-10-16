package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager f1380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(GoogleApiManager googleApiManager) {
        this.f1380a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        this.f1380a.p.sendMessage(this.f1380a.p.obtainMessage(1, Boolean.valueOf(z)));
    }
}
