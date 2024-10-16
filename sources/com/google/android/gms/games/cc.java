package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes.dex */
final class cc implements PendingResultUtil.ResultConverter<Videos.CaptureAvailableResult, Boolean> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Boolean convert(Videos.CaptureAvailableResult captureAvailableResult) {
        Videos.CaptureAvailableResult captureAvailableResult2 = captureAvailableResult;
        if (captureAvailableResult2 == null) {
            return false;
        }
        return Boolean.valueOf(captureAvailableResult2.isAvailable());
    }
}
