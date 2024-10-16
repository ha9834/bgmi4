package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.devbrackets.android.exomedia.a.g;
import com.devbrackets.android.exomedia.a.h;
import com.devbrackets.android.exomedia.a.i;
import com.devbrackets.android.exomedia.b.c;
import com.tencent.grobot.lite.R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends RelativeLayout implements b {
    protected static final long CONTROL_VISIBILITY_ANIMATION_LENGTH = 300;
    public static final int DEFAULT_CONTROL_HIDE_DELAY = 2000;
    protected g buttonsListener;
    protected boolean canViewHide;
    protected ViewGroup controlsContainer;
    protected TextView currentTimeTextView;
    protected TextView descriptionTextView;
    protected SparseBooleanArray enabledViews;
    protected TextView endTimeTextView;
    protected long hideDelay;
    protected boolean hideEmptyTextContainer;
    protected C0079a internalListener;
    protected boolean isLoading;
    protected boolean isVisible;
    protected ProgressBar loadingProgressBar;
    protected ImageButton nextButton;
    protected Drawable pauseDrawable;
    protected Drawable playDrawable;
    protected ImageButton playPauseButton;
    protected ImageButton previousButton;
    protected com.devbrackets.android.exomedia.b.c progressPollRepeater;
    protected h seekListener;
    protected TextView subTitleTextView;
    protected ViewGroup textContainer;
    protected TextView titleTextView;
    protected VideoView videoView;
    protected Handler visibilityHandler;
    protected i visibilityListener;

    public void addExtraView(View view) {
    }

    protected abstract void animateVisibility(boolean z);

    protected abstract int getLayoutResource();

    public void removeExtraView(View view) {
    }

    public void setFastForwardButtonEnabled(boolean z) {
    }

    public void setFastForwardButtonRemoved(boolean z) {
    }

    public void setFastForwardDrawable(Drawable drawable) {
    }

    public abstract void setPosition(long j);

    public void setRewindButtonEnabled(boolean z) {
    }

    public void setRewindButtonRemoved(boolean z) {
    }

    public void setRewindDrawable(Drawable drawable) {
    }

    public abstract void updateProgress(long j, long j2, int i);

    protected abstract void updateTextContainerVisibility();

    public a(Context context) {
        super(context);
        this.visibilityHandler = new Handler();
        this.progressPollRepeater = new com.devbrackets.android.exomedia.b.c();
        this.internalListener = new C0079a();
        this.enabledViews = new SparseBooleanArray();
        this.hideDelay = 2000L;
        this.isLoading = false;
        this.isVisible = true;
        this.canViewHide = true;
        this.hideEmptyTextContainer = true;
        setup(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibilityHandler = new Handler();
        this.progressPollRepeater = new com.devbrackets.android.exomedia.b.c();
        this.internalListener = new C0079a();
        this.enabledViews = new SparseBooleanArray();
        this.hideDelay = 2000L;
        this.isLoading = false;
        this.isVisible = true;
        this.canViewHide = true;
        this.hideEmptyTextContainer = true;
        setup(context);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.visibilityHandler = new Handler();
        this.progressPollRepeater = new com.devbrackets.android.exomedia.b.c();
        this.internalListener = new C0079a();
        this.enabledViews = new SparseBooleanArray();
        this.hideDelay = 2000L;
        this.isLoading = false;
        this.isVisible = true;
        this.canViewHide = true;
        this.hideEmptyTextContainer = true;
        setup(context);
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.visibilityHandler = new Handler();
        this.progressPollRepeater = new com.devbrackets.android.exomedia.b.c();
        this.internalListener = new C0079a();
        this.enabledViews = new SparseBooleanArray();
        this.hideDelay = 2000L;
        this.isLoading = false;
        this.isVisible = true;
        this.canViewHide = true;
        this.hideEmptyTextContainer = true;
        setup(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.progressPollRepeater.a(new c.b() { // from class: com.devbrackets.android.exomedia.ui.widget.a.1
            @Override // com.devbrackets.android.exomedia.b.c.b
            public void a() {
                a.this.updateProgress();
            }
        });
        VideoView videoView = this.videoView;
        if (videoView == null || !videoView.c()) {
            return;
        }
        updatePlaybackState(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.progressPollRepeater.b();
        this.progressPollRepeater.a((c.b) null);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void onAttachedToView(VideoView videoView) {
        videoView.addView(this);
        setVideoView(videoView);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void onDetachedFromView(VideoView videoView) {
        videoView.removeView(this);
        setVideoView(null);
    }

    @Deprecated
    public void setVideoView(VideoView videoView) {
        this.videoView = videoView;
    }

    public void setSeekListener(h hVar) {
        this.seekListener = hVar;
    }

    public void setButtonListener(g gVar) {
        this.buttonsListener = gVar;
    }

    public void setVisibilityListener(i iVar) {
        this.visibilityListener = iVar;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void updatePlaybackState(boolean z) {
        updatePlayPauseImage(z);
        this.progressPollRepeater.a();
        if (z) {
            hideDelayed();
        } else {
            show();
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.titleTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setSubTitle(CharSequence charSequence) {
        this.subTitleTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setDescription(CharSequence charSequence) {
        this.descriptionTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setPlayPauseDrawables(Drawable drawable, Drawable drawable2) {
        this.playDrawable = drawable;
        this.pauseDrawable = drawable2;
        VideoView videoView = this.videoView;
        updatePlayPauseImage(videoView != null && videoView.c());
    }

    public void setPreviousDrawable(Drawable drawable) {
        this.previousButton.setImageDrawable(drawable);
    }

    public void setNextDrawable(Drawable drawable) {
        this.nextButton.setImageDrawable(drawable);
    }

    public void updatePlayPauseImage(boolean z) {
        this.playPauseButton.setImageDrawable(z ? this.pauseDrawable : this.playDrawable);
    }

    public void setPreviousButtonEnabled(boolean z) {
        this.previousButton.setEnabled(z);
        this.enabledViews.put(R.id.exomedia_controls_previous_btn, z);
    }

    public void setNextButtonEnabled(boolean z) {
        this.nextButton.setEnabled(z);
        this.enabledViews.put(R.id.exomedia_controls_next_btn, z);
    }

    public void setPreviousButtonRemoved(boolean z) {
        this.previousButton.setVisibility(z ? 8 : 0);
    }

    public void setNextButtonRemoved(boolean z) {
        this.nextButton.setVisibility(z ? 8 : 0);
    }

    public List<View> getExtraViews() {
        return new LinkedList();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void show() {
        this.visibilityHandler.removeCallbacksAndMessages(null);
        clearAnimation();
        animateVisibility(true);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void hide(boolean z) {
        if (z) {
            hideDelayed();
        } else {
            hide();
        }
    }

    public void hide() {
        if (!this.canViewHide || this.isLoading) {
            return;
        }
        this.visibilityHandler.removeCallbacksAndMessages(null);
        clearAnimation();
        animateVisibility(false);
    }

    public void hideDelayed() {
        hideDelayed(this.hideDelay);
    }

    public void hideDelayed(long j) {
        this.hideDelay = j;
        if (j < 0 || !this.canViewHide || this.isLoading) {
            return;
        }
        this.visibilityHandler.postDelayed(new Runnable() { // from class: com.devbrackets.android.exomedia.ui.widget.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        }, j);
    }

    public void setHideDelay(long j) {
        this.hideDelay = j;
    }

    public void setCanHide(boolean z) {
        this.canViewHide = z;
    }

    public void setHideEmptyTextContainer(boolean z) {
        this.hideEmptyTextContainer = z;
        updateTextContainerVisibility();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void retrieveViews() {
        this.currentTimeTextView = (TextView) findViewById(R.id.exomedia_controls_current_time);
        this.endTimeTextView = (TextView) findViewById(R.id.exomedia_controls_end_time);
        this.titleTextView = (TextView) findViewById(R.id.exomedia_controls_title);
        this.subTitleTextView = (TextView) findViewById(R.id.exomedia_controls_sub_title);
        this.descriptionTextView = (TextView) findViewById(R.id.exomedia_controls_description);
        this.playPauseButton = (ImageButton) findViewById(R.id.exomedia_controls_play_pause_btn);
        this.previousButton = (ImageButton) findViewById(R.id.exomedia_controls_previous_btn);
        this.nextButton = (ImageButton) findViewById(R.id.exomedia_controls_next_btn);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.exomedia_controls_video_loading);
        this.controlsContainer = (ViewGroup) findViewById(R.id.exomedia_controls_interactive_container);
        this.textContainer = (ViewGroup) findViewById(R.id.exomedia_controls_text_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerListeners() {
        this.playPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.devbrackets.android.exomedia.ui.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.onPlayPauseClick();
            }
        });
        this.previousButton.setOnClickListener(new View.OnClickListener() { // from class: com.devbrackets.android.exomedia.ui.widget.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.onPreviousClick();
            }
        });
        this.nextButton.setOnClickListener(new View.OnClickListener() { // from class: com.devbrackets.android.exomedia.ui.widget.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.onNextClick();
            }
        });
    }

    protected void updateButtonDrawables() {
        updateButtonDrawables(R.color.exomedia_default_controls_button_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateButtonDrawables(int i) {
        this.playDrawable = com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_play_arrow_white, i);
        this.pauseDrawable = com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_pause_white, i);
        this.playPauseButton.setImageDrawable(this.playDrawable);
        this.previousButton.setImageDrawable(com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_skip_previous_white, i));
        this.nextButton.setImageDrawable(com.devbrackets.android.exomedia.b.d.a(getContext(), R.drawable.exomedia_ic_skip_next_white, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayPauseClick() {
        g gVar = this.buttonsListener;
        if (gVar == null || !gVar.a()) {
            this.internalListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreviousClick() {
        g gVar = this.buttonsListener;
        if (gVar == null || !gVar.b()) {
            this.internalListener.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNextClick() {
        g gVar = this.buttonsListener;
        if (gVar == null || !gVar.c()) {
            this.internalListener.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setup(Context context) {
        View.inflate(context, getLayoutResource(), this);
        retrieveViews();
        registerListeners();
        updateButtonDrawables();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTextContainerEmpty() {
        if (this.titleTextView.getText() != null && this.titleTextView.getText().length() > 0) {
            return false;
        }
        if (this.subTitleTextView.getText() == null || this.subTitleTextView.getText().length() <= 0) {
            return this.descriptionTextView.getText() == null || this.descriptionTextView.getText().length() <= 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged() {
        i iVar = this.visibilityListener;
        if (iVar == null) {
            return;
        }
        if (this.isVisible) {
            iVar.a();
        } else {
            iVar.b();
        }
    }

    protected void updateProgress() {
        VideoView videoView = this.videoView;
        if (videoView != null) {
            updateProgress(videoView.getCurrentPosition(), this.videoView.getDuration(), this.videoView.getBufferPercentage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.devbrackets.android.exomedia.ui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a implements g, h {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f1051a = false;

        @Override // com.devbrackets.android.exomedia.a.g
        public boolean b() {
            return false;
        }

        @Override // com.devbrackets.android.exomedia.a.g
        public boolean c() {
            return false;
        }

        @Override // com.devbrackets.android.exomedia.a.g
        public boolean d() {
            return false;
        }

        @Override // com.devbrackets.android.exomedia.a.g
        public boolean e() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public C0079a() {
        }

        @Override // com.devbrackets.android.exomedia.a.g
        public boolean a() {
            if (a.this.videoView == null) {
                return false;
            }
            if (a.this.videoView.c()) {
                a.this.videoView.e();
                return true;
            }
            a.this.videoView.d();
            return true;
        }

        @Override // com.devbrackets.android.exomedia.a.h
        public boolean f() {
            if (a.this.videoView == null) {
                return false;
            }
            if (a.this.videoView.c()) {
                this.f1051a = true;
                a.this.videoView.a(true);
            }
            a.this.show();
            return true;
        }

        @Override // com.devbrackets.android.exomedia.a.h
        public boolean a(long j) {
            if (a.this.videoView == null) {
                return false;
            }
            a.this.videoView.a(j);
            if (!this.f1051a) {
                return true;
            }
            this.f1051a = false;
            a.this.videoView.d();
            a.this.hideDelayed();
            return true;
        }
    }
}
