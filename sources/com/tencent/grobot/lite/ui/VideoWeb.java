package com.tencent.grobot.lite.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.ui.container.Frame;
import com.tencent.grobot.lite.ui.container.FrameActivity;

/* loaded from: classes2.dex */
public final class VideoWeb extends Frame {
    private static boolean isInit;
    private Runnable hideRunnable;
    private Handler mainHander;
    private View rootView;
    private View topLayout;
    private WebView wb;

    public VideoWeb(FrameActivity frameActivity, Bundle bundle) {
        super(frameActivity, bundle);
        this.mainHander = new Handler(Looper.getMainLooper());
        this.hideRunnable = new Runnable() { // from class: com.tencent.grobot.lite.ui.VideoWeb.3
            @Override // java.lang.Runnable
            public void run() {
                VideoWeb.this.topLayout.setVisibility(8);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public View view() {
        if (Build.VERSION.SDK_INT >= 28 && !isInit) {
            WebView.setDataDirectorySuffix("vlink");
            isInit = true;
        }
        View inflate = this.context.getLayoutInflater().inflate(R.layout.video, (ViewGroup) null, false);
        this.wb = (WebView) inflate.findViewById(R.id.web);
        this.rootView = inflate.findViewById(R.id.root);
        this.topLayout = inflate.findViewById(R.id.topLayout);
        WebSettings settings = this.wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3");
        this.wb.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.grobot.lite.ui.VideoWeb.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (VideoWeb.this.topLayout.getVisibility() == 0) {
                        VideoWeb.this.topLayout.setVisibility(8);
                    } else {
                        VideoWeb.this.topLayout.setVisibility(0);
                        VideoWeb.this.mainHander.removeCallbacks(VideoWeb.this.hideRunnable);
                        VideoWeb.this.mainHander.postDelayed(VideoWeb.this.hideRunnable, 3000L);
                    }
                }
                return false;
            }
        });
        this.topLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.ui.VideoWeb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoWeb.this.context.finish();
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onCreate() {
        super.onCreate();
        this.wb.loadUrl(this.args.getString("site"));
    }
}
