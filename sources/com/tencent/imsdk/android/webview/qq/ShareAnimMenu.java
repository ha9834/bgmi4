package com.tencent.imsdk.android.webview.qq;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShareAnimMenu {
    private ViewGroup contentContainer;
    private Context context;
    private ViewGroup decorView;
    private boolean isDismissed;
    private ViewGroup rootView;

    /* loaded from: classes.dex */
    public interface IDismissListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareAnimMenu(Context context, int i) {
        this.contentContainer = null;
        this.context = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        this.rootView = (ViewGroup) from.inflate(ResourceUtil.getLayoutId(context, "layout_share_container"), this.decorView, false);
        if (this.rootView != null) {
            this.contentContainer = (ViewGroup) this.rootView.findViewById(ResourceUtil.getId(context, "share_view_container"));
            ViewGroup viewGroup = this.contentContainer;
            if (viewGroup != null) {
                viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
                LayoutInflater.from(context).inflate(i, this.contentContainer);
            }
        }
    }

    private boolean isShowing() {
        return this.decorView.findViewById(ResourceUtil.getId(this.decorView.getContext(), "share_bg_container")) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show() {
        if (isShowing()) {
            return;
        }
        this.decorView.addView(this.rootView);
        View findViewById = this.rootView.findViewById(ResourceUtil.getId(this.decorView.getContext(), "share_bg_container"));
        if (findViewById != null) {
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.imsdk.android.webview.qq.ShareAnimMenu.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    ShareAnimMenu.this.dismiss(null);
                    return false;
                }
            });
            int animId = ResourceUtil.getAnimId(this.context, "slide_in_bottom");
            ViewGroup viewGroup = this.contentContainer;
            if (viewGroup != null) {
                try {
                    viewGroup.startAnimation(AnimationUtils.loadAnimation(this.context, animId));
                } catch (Resources.NotFoundException unused) {
                    IMLogger.e("loadAnimation slide_in_bottom error!", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dismiss(final IDismissListener iDismissListener) {
        if (this.isDismissed) {
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(this.context, ResourceUtil.getAnimId(this.context, "slide_out_bottom"));
        } catch (Resources.NotFoundException unused) {
            IMLogger.e("loadAnimation slide_out_bottom error!", new Object[0]);
        }
        if (animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.imsdk.android.webview.qq.ShareAnimMenu.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    ShareAnimMenu.this.decorView.post(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.ShareAnimMenu.2.1
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
                viewGroup.startAnimation(animation);
                this.isDismissed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }
}
