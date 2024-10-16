package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes2.dex */
final class co implements Videos.CaptureCapabilitiesResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, Status status) {
        this.f4245a = status;
    }

    @Override // com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult
    public final VideoCapabilities getCapabilities() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4245a;
    }
}
