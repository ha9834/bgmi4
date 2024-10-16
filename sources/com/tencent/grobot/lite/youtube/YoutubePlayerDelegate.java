package com.tencent.grobot.lite.youtube;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import at.huber.youtubeExtractor.Format;
import at.huber.youtubeExtractor.a;
import at.huber.youtubeExtractor.b;
import at.huber.youtubeExtractor.c;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.ui.VideoWeb;
import com.tencent.grobot.lite.ui.container.Router;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class YoutubePlayerDelegate {
    private static final String BASE_YOUTUBE_URL = "http://youtube.com/watch?v=";
    private static final String TAG = "YoutubePlayerDelegate";

    public static void play(Activity activity, YoutubeParams youtubeParams) {
        if (activity == null || youtubeParams == null) {
            new IllegalArgumentException("Argument can not be null.").printStackTrace();
            return;
        }
        if (TextUtils.isEmpty(youtubeParams.videoId)) {
            new IllegalArgumentException("VID can not be null.").printStackTrace();
            return;
        }
        TLog.d(TAG, "play, params=" + youtubeParams);
        new Extractor(activity, youtubeParams).extract(BASE_YOUTUBE_URL + youtubeParams.videoId, true, false);
    }

    private YoutubePlayerDelegate() {
        throw new UnsupportedOperationException("Can not create an object of the class.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Extractor extends b {
        private final WeakReference<Context> ctx;
        private final YoutubeParams params;

        private Extractor(Context context, YoutubeParams youtubeParams) {
            super(context);
            this.ctx = new WeakReference<>(context);
            this.params = youtubeParams;
        }

        @Override // at.huber.youtubeExtractor.b
        protected void onExtractionComplete(SparseArray<c> sparseArray, a aVar) {
            Context context = this.ctx.get();
            if (context == null) {
                return;
            }
            if (sparseArray != null && sparseArray.size() > 0) {
                c cVar = null;
                for (int i = 0; i < sparseArray.size(); i++) {
                    c cVar2 = sparseArray.get(sparseArray.keyAt(i));
                    Format b = cVar2.b();
                    if (cVar == null) {
                        if (b.c() >= 360) {
                            if (!"mp4".equals(b.b())) {
                            }
                            cVar = cVar2;
                        }
                    } else {
                        if (b.c() >= 360) {
                            Format b2 = cVar.b();
                            if (b.c() >= b2.c() && b.a() >= b2.a()) {
                            }
                            cVar = cVar2;
                        }
                    }
                }
                if (cVar != null && !TextUtils.isEmpty(cVar.a())) {
                    Bundle bundle = new Bundle();
                    bundle.putString("site", cVar.a());
                    bundle.putString("videoName", this.params.videoName);
                    Router.jump(context, YoutubePlayer.class, bundle, false, true);
                    return;
                }
                playUseWebView(context, this.params);
                return;
            }
            playUseWebView(context, this.params);
        }

        private void playUseWebView(Context context, YoutubeParams youtubeParams) {
            Bundle bundle = new Bundle();
            bundle.putString("site", "https://h5.vlinkapi.com/sdk/video.html?videoId=" + youtubeParams.videoId);
            bundle.putString("videoName", youtubeParams.videoName);
            Router.jump(context, VideoWeb.class, bundle, false, true);
        }
    }
}
