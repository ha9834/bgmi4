package com.devbrackets.android.exomedia.core.e.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public class a extends d {
    @Override // com.devbrackets.android.exomedia.core.e.a.d
    public MediaSource a(Context context, Uri uri, String str, Handler handler, TransferListener transferListener) {
        return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(a(context, str, transferListener)), a(context, str, null)).createMediaSource(uri);
    }
}
