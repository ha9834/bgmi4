package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes2.dex */
final class cq implements Videos.CaptureStateResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, Status status) {
        this.f4246a = status;
    }

    @Override // com.google.android.gms.games.video.Videos.CaptureStateResult
    public final CaptureState getCaptureState() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4246a;
    }
}
