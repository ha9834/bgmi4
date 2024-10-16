package com.intlgame.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import com.intlgame.foundation.INTLLog;
import com.intlgame.webview.WebViewResID;

/* loaded from: classes2.dex */
public class ToolBarAmin {
    private Animation mAnimationTitlebarHide;
    private Animation mAnimationTitlebarShow;
    private Animation mAnimationToolbarHide;
    private Animation mAnimationToolbarShow;
    private int mBarHeight;
    private ValueAnimator mColorHide;
    private ValueAnimator mColorShow;
    private Context mContext;
    private GestureDetector mDetector;
    private int mFlingLimitX;
    private int mFlingLimitY;
    private View mTitleBar;
    private ValueAnimator mTitleBarHide;
    private ValueAnimator mTitleBarShow;
    private View mToolBar;
    private ValueAnimator mToolBarHide;
    private ValueAnimator mToolBarShow;
    private WebView mWebView;
    private boolean mIsShow = true;
    private boolean titlebarHideable = false;
    private boolean toolbarPortraitHideable = false;
    private boolean toolbarLandscapeHideable = false;
    private boolean mToolBarEnable = true;

    public ToolBarAmin(ViewGroup viewGroup, ViewGroup viewGroup2, WebView webView) {
        INTLLog.i("Construct tool bar amin");
        this.mTitleBar = viewGroup;
        this.mToolBar = viewGroup2;
        this.mWebView = webView;
        this.mContext = webView.getContext();
        this.mDetector = new GestureDetector(this.mContext, new WebViewGestureListener());
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.intlgame.view.ToolBarAmin.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ToolBarAmin.this.mDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        initAnimation();
    }

    public void setTitleBarHideable(boolean z) {
        this.titlebarHideable = z;
        INTLLog.i("WebView ToolBar titlebarHideable:" + z);
    }

    public void setToolBarPortraitHideable(boolean z) {
        this.toolbarPortraitHideable = z;
        INTLLog.i("WebView ToolBar toolbarPortraitHideable:" + z);
    }

    public void setToolBarLandscapeHideable(boolean z) {
        this.toolbarLandscapeHideable = z;
        INTLLog.i("WebView ToolBar toolbarLandscapeHideable:" + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOrientation() {
        View view = this.mTitleBar;
        if (view == null) {
            return 1;
        }
        return view.getResources().getConfiguration().orientation;
    }

    private void initAnimation() {
        if (this.mTitleBar == null) {
            INTLLog.e("title bar can not be null");
            return;
        }
        showToolBar();
        if (!this.mToolBarEnable) {
            INTLLog.i("tool bar not enable, return");
            return;
        }
        this.mFlingLimitX = this.mContext.getResources().getDimensionPixelSize(WebViewResID.dimen_fling_limit_x);
        this.mFlingLimitY = this.mContext.getResources().getDimensionPixelSize(WebViewResID.dimen_fling_limit_y);
        if (Build.VERSION.SDK_INT < 11) {
            this.mAnimationToolbarHide = AnimationUtils.loadAnimation(this.mContext, WebViewResID.anim_toolbar_hide);
            this.mAnimationToolbarHide.setAnimationListener(new WebViewAnimListener(2));
            this.mAnimationToolbarShow = AnimationUtils.loadAnimation(this.mContext, WebViewResID.anim_toolbar_show);
            this.mAnimationToolbarShow.setAnimationListener(new WebViewAnimListener(1));
            this.mAnimationTitlebarHide = AnimationUtils.loadAnimation(this.mContext, WebViewResID.anim_titlebar_hide);
            this.mAnimationTitlebarShow = AnimationUtils.loadAnimation(this.mContext, WebViewResID.anim_titlebar_show);
            return;
        }
        this.mBarHeight = this.mContext.getResources().getDimensionPixelSize(WebViewResID.dimen_titlebar_height);
        this.mTitleBarHide = ValueAnimator.ofInt(0, -this.mBarHeight);
        this.mTitleBarHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.2
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) ToolBarAmin.this.mTitleBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ToolBarAmin.this.mTitleBar.setLayoutParams(this.lp);
            }
        });
        this.mTitleBarHide.setInterpolator(new AccelerateInterpolator());
        long j = 120;
        this.mTitleBarHide.setDuration(j);
        this.mTitleBarShow = ValueAnimator.ofInt(-this.mBarHeight, 0);
        this.mTitleBarShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.3
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) ToolBarAmin.this.mTitleBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ToolBarAmin.this.mTitleBar.setLayoutParams(this.lp);
            }
        });
        this.mTitleBarShow.setInterpolator(new DecelerateInterpolator());
        this.mTitleBarShow.setDuration(j);
        this.mToolBarHide = ValueAnimator.ofInt(0, -this.mBarHeight);
        this.mToolBarHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.4
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) ToolBarAmin.this.mToolBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ToolBarAmin.this.mToolBar.setLayoutParams(this.lp);
            }
        });
        this.mToolBarHide.setInterpolator(new AccelerateInterpolator());
        this.mToolBarHide.setDuration(j);
        this.mToolBarShow = ValueAnimator.ofInt(-this.mBarHeight, 0);
        this.mToolBarShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.5
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) ToolBarAmin.this.mToolBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ToolBarAmin.this.mToolBar.setLayoutParams(this.lp);
            }
        });
        this.mToolBarShow.setInterpolator(new DecelerateInterpolator());
        this.mToolBarShow.setDuration(j);
        int color = this.mContext.getResources().getColor(WebViewResID.color_toolbar_visible);
        int color2 = this.mContext.getResources().getColor(WebViewResID.color_toolbar_invisible);
        this.mColorHide = ValueAnimator.ofObject(new ColorEvaluator(), Integer.valueOf(color), Integer.valueOf(color2));
        this.mColorHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToolBarAmin.this.mToolBar.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mColorHide.setDuration(j);
        this.mColorShow = ValueAnimator.ofObject(new ColorEvaluator(), Integer.valueOf(color2), Integer.valueOf(color));
        this.mColorShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.view.ToolBarAmin.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToolBarAmin.this.mToolBar.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mColorShow.setDuration(j);
    }

    private void showToolBar() {
        if (!this.mToolBarEnable) {
            this.mTitleBar.setVisibility(8);
            this.mToolBar.setVisibility(8);
            return;
        }
        this.mTitleBar.setVisibility(0);
        this.mToolBar.setVisibility(0);
        if (getOrientation() == 2) {
            this.mTitleBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationDuration(int i) {
        long j = i;
        this.mTitleBarHide.setDuration(j);
        this.mTitleBarShow.setDuration(j);
        this.mToolBarHide.setDuration(j);
        this.mToolBarShow.setDuration(j);
        this.mColorHide.setDuration(j);
        this.mColorShow.setDuration(j);
    }

    public void setToolBarEnable(boolean z) {
        INTLLog.i("setToolBarEnable:" + z);
        this.mToolBarEnable = z;
        showToolBar();
    }

    public void showTitleBar(boolean z) {
        if (this.mToolBarEnable) {
            INTLLog.i("showTitleBar:" + z);
            this.mTitleBar.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class WebViewAnimListener implements Animation.AnimationListener {
        private static final int STATE_HIDE = 2;
        private static final int STATE_SHOW = 1;
        private int state;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        WebViewAnimListener(int i) {
            this.state = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (ToolBarAmin.this.mToolBar == null) {
                INTLLog.e("mToolBar bar can not be null");
            } else if (this.state == 2) {
                ToolBarAmin.this.mToolBar.setVisibility(8);
                if (2 != ToolBarAmin.this.mTitleBar.getResources().getConfiguration().orientation) {
                    ToolBarAmin.this.mTitleBar.setVisibility(8);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (ToolBarAmin.this.mToolBar == null) {
                INTLLog.e("mToolBar bar can not be null");
                return;
            }
            if (this.state == 1) {
                if (ToolBarAmin.this.mToolBar.getVisibility() == 8) {
                    ToolBarAmin.this.mToolBar.setVisibility(0);
                }
                if (2 == ToolBarAmin.this.getOrientation() || ToolBarAmin.this.mTitleBar.getVisibility() != 8) {
                    return;
                }
                ToolBarAmin.this.mTitleBar.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    class WebViewGestureListener extends GestureDetector.SimpleOnGestureListener {
        public WebViewGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ToolBarAmin.this.mToolBarEnable) {
                int contentHeight = (int) (ToolBarAmin.this.mWebView.getContentHeight() * ToolBarAmin.this.mWebView.getScale());
                if (ToolBarAmin.this.mIsShow && contentHeight < ToolBarAmin.this.mWebView.getHeight() + 60) {
                    INTLLog.i("contentHeight : " + contentHeight + "WebViewHeight" + (ToolBarAmin.this.mWebView.getHeight() + 60));
                    return false;
                }
                if (motionEvent.getX() - motionEvent2.getX() > ToolBarAmin.this.mFlingLimitX || motionEvent2.getX() - motionEvent.getX() > ToolBarAmin.this.mFlingLimitX) {
                    return false;
                }
                if (motionEvent.getY() - motionEvent2.getY() > ToolBarAmin.this.mFlingLimitY) {
                    if (!ToolBarAmin.this.mIsShow) {
                        return false;
                    }
                    ToolBarAmin.this.mIsShow = false;
                    try {
                        if (Build.VERSION.SDK_INT >= 11) {
                            ToolBarAmin.this.setAnimationDuration((int) (((ToolBarAmin.this.mBarHeight * 1000) * 5) / (-f2)));
                            if (ToolBarAmin.this.titlebarHideable) {
                                ToolBarAmin.this.mTitleBarHide.start();
                            }
                            if (2 == ToolBarAmin.this.getOrientation()) {
                                if (ToolBarAmin.this.toolbarLandscapeHideable) {
                                    ToolBarAmin.this.mToolBarHide.start();
                                    ToolBarAmin.this.mColorHide.start();
                                }
                            } else if (ToolBarAmin.this.toolbarPortraitHideable) {
                                ToolBarAmin.this.mToolBarHide.start();
                                ToolBarAmin.this.mColorHide.start();
                            }
                        } else {
                            if (ToolBarAmin.this.titlebarHideable) {
                                ToolBarAmin.this.mTitleBar.startAnimation(ToolBarAmin.this.mAnimationTitlebarHide);
                            }
                            if (2 == ToolBarAmin.this.getOrientation()) {
                                if (ToolBarAmin.this.toolbarLandscapeHideable) {
                                    ToolBarAmin.this.mToolBar.startAnimation(ToolBarAmin.this.mAnimationToolbarHide);
                                }
                            } else if (ToolBarAmin.this.toolbarPortraitHideable) {
                                ToolBarAmin.this.mToolBar.startAnimation(ToolBarAmin.this.mAnimationToolbarHide);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (motionEvent2.getY() - motionEvent.getY() <= ToolBarAmin.this.mFlingLimitY || ToolBarAmin.this.mIsShow) {
                    return false;
                }
                ToolBarAmin.this.mIsShow = true;
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        ToolBarAmin.this.setAnimationDuration((int) (((ToolBarAmin.this.mBarHeight * 1000) * 5) / f2));
                        if (ToolBarAmin.this.titlebarHideable) {
                            ToolBarAmin.this.mTitleBarShow.start();
                        }
                        if (2 == ToolBarAmin.this.getOrientation()) {
                            if (ToolBarAmin.this.toolbarLandscapeHideable) {
                                ToolBarAmin.this.mToolBarShow.start();
                                ToolBarAmin.this.mColorShow.start();
                            }
                        } else if (ToolBarAmin.this.toolbarPortraitHideable) {
                            ToolBarAmin.this.mToolBarShow.start();
                            ToolBarAmin.this.mColorShow.start();
                        }
                    } else {
                        if (ToolBarAmin.this.titlebarHideable) {
                            ToolBarAmin.this.mTitleBar.startAnimation(ToolBarAmin.this.mAnimationTitlebarShow);
                        }
                        if (2 == ToolBarAmin.this.getOrientation()) {
                            if (ToolBarAmin.this.toolbarLandscapeHideable) {
                                ToolBarAmin.this.mToolBar.startAnimation(ToolBarAmin.this.mAnimationToolbarShow);
                            }
                        } else if (ToolBarAmin.this.toolbarPortraitHideable) {
                            ToolBarAmin.this.mToolBar.startAnimation(ToolBarAmin.this.mAnimationToolbarShow);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }
}
