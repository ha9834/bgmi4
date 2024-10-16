package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes2.dex */
final class cm implements Videos.CaptureAvailableResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar, Status status) {
        this.f4244a = status;
    }

    @Override // com.google.android.gms.games.video.Videos.CaptureAvailableResult
    public final boolean isAvailable() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4244a;
    }
}
