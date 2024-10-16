package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.devbrackets.android.exomedia.b.f;
import com.devbrackets.android.exomedia.ui.widget.a;
import com.google.android.gms.games.Notifications;
import com.tencent.grobot.lite.R;
import com.tencent.imsdk.android.tools.log.LogUtils;

@TargetApi(21)
/* loaded from: classes.dex */
public class c extends com.devbrackets.android.exomedia.ui.widget.a {

    /* renamed from: a, reason: collision with root package name */
    protected ProgressBar f1052a;
    protected ImageView b;
    protected ViewGroup c;
    protected ImageButton d;
    protected ImageButton e;
    protected View f;
    protected a g;

    public c(Context context) {
        super(context);
        this.g = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setup(Context context) {
        super.setup(context);
        this.internalListener = new b();
        d();
        setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.playPauseButton.requestFocus();
        this.f = this.playPauseButton;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected int getLayoutResource() {
        return R.layout.exomedia_default_controls_leanback;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setPosition(long j) {
        this.currentTimeTextView.setText(f.a(j));
        this.f1052a.setProgress((int) j);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void setDuration(long j) {
        if (j != this.f1052a.getMax()) {
            this.endTimeTextView.setText(f.a(j));
            this.f1052a.setMax((int) j);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void updateProgress(long j, long j2, int i) {
        this.f1052a.setSecondaryProgress((int) (r4.getMax() * (i / 100.0f)));
        this.f1052a.setProgress((int) j);
        this.currentTimeTextView.setText(f.a(j));
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindDrawable(Drawable drawable) {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardDrawable(Drawable drawable) {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindButtonEnabled(boolean z) {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setEnabled(z);
            this.enabledViews.put(R.id.exomedia_controls_rewind_btn, z);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardButtonEnabled(boolean z) {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setEnabled(z);
            this.enabledViews.put(R.id.exomedia_controls_fast_forward_btn, z);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setRewindButtonRemoved(boolean z) {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setFastForwardButtonRemoved(boolean z) {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void retrieveViews() {
        super.retrieveViews();
        this.f1052a = (ProgressBar) findViewById(R.id.exomedia_controls_video_progress);
        this.e = (ImageButton) findViewById(R.id.exomedia_controls_rewind_btn);
        this.d = (ImageButton) findViewById(R.id.exomedia_controls_fast_forward_btn);
        this.b = (ImageView) findViewById(R.id.exomedia_controls_leanback_ripple);
        this.c = (ViewGroup) findViewById(R.id.exomedia_controls_parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void registerListeners() {
        super.registerListeners();
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.devbrackets.android.exomedia.ui.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.devbrackets.android.exomedia.ui.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.b();
            }
        });
        this.previousButton.setOnFocusChangeListener(this.g);
        this.e.setOnFocusChangeListener(this.g);
        this.playPauseButton.setOnFocusChangeListener(this.g);
        this.d.setOnFocusChangeListener(this.g);
        this.nextButton.setOnFocusChangeListener(this.g);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected void updateButtonDrawables() {
        updateButtonDrawables(R.color.exomedia_default_controls_leanback_button_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void updateButtonDrawables(int i) {
        super.updateButtonDrawables(i);
        this.e.setImageDrawable(com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_rewind_white, i));
        this.d.setImageDrawable(com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_fast_forward_white, i));
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected void animateVisibility(boolean z) {
        if (this.isVisible == z) {
            return;
        }
        if (!this.isLoading) {
            ViewGroup viewGroup = this.c;
            viewGroup.startAnimation(new com.devbrackets.android.exomedia.ui.a.a(viewGroup, z, 300L));
        }
        this.isVisible = z;
        onVisibilityChanged();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected void updateTextContainerVisibility() {
        if (this.isVisible) {
            boolean isTextContainerEmpty = isTextContainerEmpty();
            if (this.hideEmptyTextContainer && isTextContainerEmpty && this.textContainer.getVisibility() == 0) {
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.a(this.textContainer, false, 300L));
            } else {
                if ((this.hideEmptyTextContainer && isTextContainerEmpty) || this.textContainer.getVisibility() == 0) {
                    return;
                }
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.a(this.textContainer, true, 300L));
            }
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void showLoading(boolean z) {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        this.controlsContainer.setVisibility(8);
        this.b.setVisibility(8);
        this.loadingProgressBar.setVisibility(0);
        show();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void finishLoading() {
        if (this.isLoading) {
            boolean z = false;
            this.isLoading = false;
            this.controlsContainer.setVisibility(0);
            this.b.setVisibility(0);
            this.loadingProgressBar.setVisibility(8);
            if (this.videoView != null && this.videoView.c()) {
                z = true;
            }
            updatePlaybackState(z);
        }
    }

    protected void a() {
        if (this.buttonsListener == null || !this.buttonsListener.d()) {
            this.internalListener.d();
        }
    }

    protected void b() {
        if (this.buttonsListener == null || !this.buttonsListener.e()) {
            this.internalListener.e();
        }
    }

    protected void a(long j) {
        if (this.seekListener == null || !this.seekListener.a(j)) {
            this.internalListener.a(j);
        }
    }

    protected void c() {
        show();
        if (this.videoView == null || !this.videoView.c()) {
            return;
        }
        hideDelayed();
    }

    protected void d() {
        ViewOnKeyListenerC0080c viewOnKeyListenerC0080c = new ViewOnKeyListenerC0080c();
        setOnKeyListener(viewOnKeyListenerC0080c);
        this.playPauseButton.setOnKeyListener(viewOnKeyListenerC0080c);
        this.previousButton.setOnKeyListener(viewOnKeyListenerC0080c);
        this.nextButton.setOnKeyListener(viewOnKeyListenerC0080c);
        this.e.setOnKeyListener(viewOnKeyListenerC0080c);
        this.d.setOnKeyListener(viewOnKeyListenerC0080c);
    }

    protected void a(View view) {
        int nextFocusRightId = view.getNextFocusRightId();
        if (nextFocusRightId == -1) {
            return;
        }
        View findViewById = findViewById(nextFocusRightId);
        if (findViewById.getVisibility() != 0) {
            a(findViewById);
            return;
        }
        findViewById.requestFocus();
        this.f = findViewById;
        this.g.onFocusChange(findViewById, true);
    }

    protected void b(View view) {
        int nextFocusLeftId = view.getNextFocusLeftId();
        if (nextFocusLeftId == -1) {
            return;
        }
        View findViewById = findViewById(nextFocusLeftId);
        if (findViewById.getVisibility() != 0) {
            b(findViewById);
            return;
        }
        findViewById.requestFocus();
        this.f = findViewById;
        this.g.onFocusChange(findViewById, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a implements View.OnFocusChangeListener {
        protected a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                c.this.b.startAnimation(new d(a(view)));
            }
        }

        protected int a(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            c.this.b.getLocationOnScreen(iArr);
            return (i - ((c.this.b.getWidth() - view.getWidth()) / 2)) - iArr[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.devbrackets.android.exomedia.ui.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnKeyListenerC0080c implements View.OnKeyListener {
        protected ViewOnKeyListenerC0080c() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i != 4) {
                if (i != 85) {
                    switch (i) {
                        case 19:
                            c.this.c();
                            return true;
                        case 20:
                            c.this.hide();
                            return true;
                        case 21:
                            c.this.c();
                            c cVar = c.this;
                            cVar.b(cVar.f);
                            return true;
                        case 22:
                            c.this.c();
                            c cVar2 = c.this;
                            cVar2.a(cVar2.f);
                            return true;
                        case 23:
                            c.this.c();
                            c.this.f.callOnClick();
                            return true;
                        default:
                            switch (i) {
                                case 87:
                                    c.this.onNextClick();
                                    return true;
                                case 88:
                                    c.this.onPreviousClick();
                                    return true;
                                case 89:
                                    c.this.a();
                                    return true;
                                case 90:
                                    c.this.b();
                                    return true;
                                default:
                                    switch (i) {
                                        case 126:
                                            if (c.this.videoView != null && !c.this.videoView.c()) {
                                                c.this.videoView.d();
                                                return true;
                                            }
                                            break;
                                        case Notifications.NOTIFICATION_TYPES_ALL /* 127 */:
                                            if (c.this.videoView != null && c.this.videoView.c()) {
                                                c.this.videoView.e();
                                                return true;
                                            }
                                            break;
                                    }
                            }
                    }
                } else {
                    c.this.onPlayPauseClick();
                    return true;
                }
            } else {
                if (c.this.isVisible && c.this.canViewHide && !c.this.isLoading) {
                    c.this.hide();
                    return true;
                }
                if (c.this.c.getAnimation() != null) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class d extends TranslateAnimation implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        protected int f1057a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public d(int i) {
            super(0.0f, i, 0.0f, 0.0f);
            this.f1057a = i;
            setDuration(250L);
            setAnimationListener(this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.b.setX(c.this.b.getX() + this.f1057a);
            c.this.b.clearAnimation();
        }
    }

    /* loaded from: classes.dex */
    protected class b extends a.C0079a {
        protected b() {
            super();
        }

        @Override // com.devbrackets.android.exomedia.ui.widget.a.C0079a, com.devbrackets.android.exomedia.a.g
        public boolean e() {
            if (c.this.videoView == null) {
                return false;
            }
            long currentPosition = c.this.videoView.getCurrentPosition() + LogUtils.LOG_FUSE_TIME;
            if (currentPosition > c.this.f1052a.getMax()) {
                currentPosition = c.this.f1052a.getMax();
            }
            c.this.a(currentPosition);
            return true;
        }

        @Override // com.devbrackets.android.exomedia.ui.widget.a.C0079a, com.devbrackets.android.exomedia.a.g
        public boolean d() {
            if (c.this.videoView == null) {
                return false;
            }
            long currentPosition = c.this.videoView.getCurrentPosition() - LogUtils.LOG_FUSE_TIME;
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            c.this.a(currentPosition);
            return true;
        }
    }
}
