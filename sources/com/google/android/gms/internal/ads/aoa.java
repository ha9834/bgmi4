package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

@TargetApi(23)
/* loaded from: classes2.dex */
final class aoa implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzth f1997a;

    private aoa(zzth zzthVar, MediaCodec mediaCodec) {
        this.f1997a = zzthVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this != this.f1997a.b) {
            return;
        }
        this.f1997a.g();
    }
}
