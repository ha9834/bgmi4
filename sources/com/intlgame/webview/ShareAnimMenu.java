package com.intlgame.webview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class ShareAnimMenu {
    private ViewGroup contentContainer;
    private Context context;
    private ViewGroup decorView;
    private boolean isDismissed;
    private ViewGroup rootView;

    /* loaded from: classes2.dex */
    public interface IDismissListener {
        void onDismiss();
    }

    public ShareAnimMenu(Context context, int i) {
        this.contentContainer = null;
        this.context = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        this.rootView = (ViewGroup) from.inflate(com.intlgame.api.compliance.R.layout.intl_webview_share_container, this.decorView, false);
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            this.contentContainer = (ViewGroup) viewGroup.findViewById(com.intlgame.api.compliance.R.id.share_view_container);
            ViewGroup viewGroup2 = this.contentContainer;
            if (viewGroup2 != null) {
                viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
                LayoutInflater.from(context).inflate(i, this.contentContainer);
            }
        }
    }

    private boolean isShowing() {
        return this.decorView.findViewById(com.intlgame.api.compliance.R.id.share_bg_container) != null;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.decorView = viewGroup;
    }

    public void show() {
        if (isShowing()) {
            return;
        }
        this.decorView.addView(this.rootView);
        View findViewById = this.rootView.findViewById(com.intlgame.api.compliance.R.id.share_bg_container);
        if (findViewById != null) {
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.intlgame.webview.ShareAnimMenu.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    ShareAnimMenu.this.dismiss(null);
                    return false;
                }
            });
            ViewGroup viewGroup = this.contentContainer;
            if (viewGroup != null) {
                viewGroup.startAnimation(AnimationUtils.loadAnimation(this.context, com.intlgame.api.compliance.R.anim.intl_webview_anim_share_slide_in));
            }
        }
    }

    public void dismiss(final IDismissListener iDismissListener) {
        Animation loadAnimation;
        if (this.isDismissed || (loadAnimation = AnimationUtils.loadAnimation(this.context, com.intlgame.api.compliance.R.anim.intl_webview_anim_share_slide_out)) == null) {
            return;
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.intlgame.webview.ShareAnimMenu.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ShareAnimMenu.this.decorView.post(new Runnable() { // from class: com.intlgame.webview.ShareAnimMenu.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShareAnimMenu.this.decorView.removeView(ShareAnimMenu.this.rootView);
                        ShareAnimMenu.this.isDismissed = false;
                        if (iDismissListener != null) {
                            iDismissListener.onDismiss();
                        }
                    }
                });
            }
        });
        ViewGroup viewGroup = this.contentContainer;
        if (viewGroup != null) {
            viewGroup.startAnimation(loadAnimation);
            this.isDismissed = true;
        }
    }

    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }
}
