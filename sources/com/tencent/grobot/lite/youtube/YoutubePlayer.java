package com.tencent.grobot.lite.youtube;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.devbrackets.android.exomedia.a.d;
import com.devbrackets.android.exomedia.core.video.scale.ScaleType;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.devbrackets.android.exomedia.ui.widget.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.ui.container.Frame;
import com.tencent.grobot.lite.ui.container.FrameActivity;

/* loaded from: classes2.dex */
public class YoutubePlayer extends Frame implements d {
    private boolean isPrepared;
    private VideoView vvPlayer;

    public YoutubePlayer(FrameActivity frameActivity, Bundle bundle) {
        super(frameActivity, bundle);
        this.isPrepared = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onCreate() {
        super.onCreate();
        this.vvPlayer.setVideoURI(Uri.parse(this.args.getString("site")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public View view() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.frame_youtube_player, (ViewGroup) null, false);
        this.vvPlayer = (VideoView) inflate.findViewById(R.id.vv_player);
        this.vvPlayer.setControls((a) new PlayerController(this.context));
        this.vvPlayer.setOnPreparedListener(this);
        this.vvPlayer.setMeasureBasedOnAspectRatioEnabled(false);
        this.vvPlayer.setScaleType(ScaleType.FIT_XY);
        return inflate;
    }

    @Override // com.devbrackets.android.exomedia.a.d
    public void onPrepared() {
        this.isPrepared = true;
        this.vvPlayer.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onResume() {
        if (!this.isPrepared || this.vvPlayer.c()) {
            return;
        }
        this.vvPlayer.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onPause() {
        if (this.vvPlayer.c()) {
            this.vvPlayer.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onStop() {
        if (this.vvPlayer.c()) {
            this.vvPlayer.f();
        }
    }
}
