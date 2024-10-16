package com.devbrackets.android.exomedia.core.e.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.devbrackets.android.exomedia.ExoMedia;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public abstract class d {
    public abstract MediaSource a(Context context, Uri uri, String str, Handler handler, TransferListener transferListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public DataSource.Factory a(Context context, String str, TransferListener transferListener) {
        ExoMedia.b bVar = ExoMedia.a.d;
        DataSource.Factory a2 = bVar != null ? bVar.a(str, transferListener) : null;
        if (a2 == null) {
            ExoMedia.c cVar = ExoMedia.a.c;
            a2 = cVar != null ? cVar.a(str, transferListener) : null;
        }
        if (a2 == null) {
            a2 = new DefaultHttpDataSourceFactory(str, transferListener);
        }
        return new DefaultDataSourceFactory(context, transferListener, a2);
    }
}
