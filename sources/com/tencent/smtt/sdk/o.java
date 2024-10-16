package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.android.gms.drive.DriveFile;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
class o extends FrameLayout implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    private Object f6531a;
    private q b;
    private VideoView c;
    private Context d;
    private String e;

    public o(Context context) {
        super(context.getApplicationContext());
        this.d = null;
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    private void b(Bundle bundle, Object obj) {
        boolean z;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.b.a(this.f6531a, bundle, this, obj);
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        VideoView videoView = this.c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.c == null) {
            this.c = new VideoView(getContext());
        }
        this.e = bundle.getString("videoUrl");
        this.c.setVideoURI(Uri.parse(this.e));
        this.c.setOnErrorListener(this);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        if (this.b == null) {
            c.a(true).a(getContext().getApplicationContext(), false, false, null);
            p a2 = c.a(true).a();
            UselessClass a3 = a2 != null ? a2.a() : null;
            if (a3 != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new q(a3);
            }
        }
        if (this.b != null) {
            Object obj = this.f6531a;
        }
    }

    public boolean b() {
        return (this.b == null || this.f6531a == null) ? false : true;
    }

    public void a(Activity activity) {
        VideoView videoView;
        if (b() || (videoView = this.c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            Window window = activity.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            window.addFlags(1024);
            window.addFlags(128);
            frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            MediaController mediaController = new MediaController(activity);
            mediaController.setMediaPlayer(this.c);
            this.c.setMediaController(mediaController);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.c, layoutParams);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            this.c.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !b() && (videoView2 = this.c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!b() && (videoView = this.c) != null) {
                videoView.stopPlayback();
                this.c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.f6531a, activity, i);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.d instanceof Activity) {
                Activity activity = (Activity) this.d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                intent.setDataAndType(Uri.parse(this.e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void c() {
        if (b()) {
            this.b.a(this.f6531a);
        }
    }
}
