package com.tencent.grobot.lite.youtube;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.devbrackets.android.exomedia.b.f;
import com.devbrackets.android.exomedia.ui.a.b;
import com.devbrackets.android.exomedia.ui.widget.a;
import com.tencent.grobot.lite.R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlayerController extends a implements View.OnClickListener {
    private View btnClose;
    protected LinearLayout extraViewsContainer;
    protected SeekBar seekBar;
    protected boolean userInteracting;

    public PlayerController(Context context) {
        super(context);
        this.userInteracting = false;
    }

    public PlayerController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.userInteracting = false;
    }

    public PlayerController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.userInteracting = false;
    }

    @TargetApi(21)
    public PlayerController(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.userInteracting = false;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected int getLayoutResource() {
        return R.layout.layout_player_controller;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setPosition(long j) {
        this.currentTimeTextView.setText(f.a(j));
        this.seekBar.setProgress((int) j);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void setDuration(long j) {
        if (j != this.seekBar.getMax()) {
            this.endTimeTextView.setText(f.a(j));
            this.seekBar.setMax((int) j);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void updateProgress(long j, long j2, int i) {
        if (this.userInteracting) {
            return;
        }
        this.seekBar.setSecondaryProgress((int) (r4.getMax() * (i / 100.0f)));
        this.seekBar.setProgress((int) j);
        this.currentTimeTextView.setText(f.a(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void retrieveViews() {
        super.retrieveViews();
        this.seekBar = (SeekBar) findViewById(R.id.exomedia_controls_video_seek);
        this.extraViewsContainer = (LinearLayout) findViewById(R.id.exomedia_controls_extra_container);
        this.btnClose = findViewById(R.id.topLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void registerListeners() {
        super.registerListeners();
        this.seekBar.setOnSeekBarChangeListener(new SeekBarChanged());
        this.btnClose.setOnClickListener(this);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void addExtraView(View view) {
        this.extraViewsContainer.addView(view);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void removeExtraView(View view) {
        this.extraViewsContainer.removeView(view);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public List<View> getExtraViews() {
        int childCount = this.extraViewsContainer.getChildCount();
        if (childCount <= 0) {
            return super.getExtraViews();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < childCount; i++) {
            linkedList.add(this.extraViewsContainer.getChildAt(i));
        }
        return linkedList;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void hideDelayed(long j) {
        this.hideDelay = j;
        if (j < 0 || !this.canViewHide || this.isLoading || this.userInteracting) {
            return;
        }
        this.visibilityHandler.postDelayed(new Runnable() { // from class: com.tencent.grobot.lite.youtube.PlayerController.1
            @Override // java.lang.Runnable
            public void run() {
                PlayerController.this.animateVisibility(false);
            }
        }, j);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected void animateVisibility(boolean z) {
        if (this.isVisible == z) {
            return;
        }
        if (!this.hideEmptyTextContainer || !isTextContainerEmpty()) {
            this.textContainer.startAnimation(new b(this.textContainer, z, 300L));
        }
        if (!this.isLoading) {
            this.controlsContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.a(this.controlsContainer, z, 300L));
        }
        if (!this.isLoading) {
            this.btnClose.setVisibility(z ? 0 : 8);
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
                this.textContainer.startAnimation(new b(this.textContainer, false, 300L));
            } else {
                if ((this.hideEmptyTextContainer && isTextContainerEmpty) || this.textContainer.getVisibility() == 0) {
                    return;
                }
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new b(this.textContainer, true, 300L));
            }
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void showLoading(boolean z) {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        this.loadingProgressBar.setVisibility(0);
        if (z) {
            this.controlsContainer.setVisibility(8);
        } else {
            this.playPauseButton.setEnabled(false);
            this.previousButton.setEnabled(false);
            this.nextButton.setEnabled(false);
        }
        show();
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void finishLoading() {
        if (this.isLoading) {
            boolean z = false;
            this.isLoading = false;
            this.loadingProgressBar.setVisibility(8);
            this.controlsContainer.setVisibility(0);
            this.playPauseButton.setEnabled(true);
            this.previousButton.setEnabled(this.enabledViews.get(R.id.exomedia_controls_previous_btn, true));
            this.nextButton.setEnabled(this.enabledViews.get(R.id.exomedia_controls_next_btn, true));
            if (this.videoView != null && this.videoView.c()) {
                z = true;
            }
            updatePlaybackState(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.topLayout) {
            ((Activity) getContext()).finish();
        }
    }

    /* loaded from: classes2.dex */
    protected class SeekBarChanged implements SeekBar.OnSeekBarChangeListener {
        private long seekToTime;

        protected SeekBarChanged() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.seekToTime = i;
                if (PlayerController.this.currentTimeTextView != null) {
                    PlayerController.this.currentTimeTextView.setText(f.a(this.seekToTime));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            PlayerController playerController = PlayerController.this;
            playerController.userInteracting = true;
            if (playerController.seekListener == null || !PlayerController.this.seekListener.f()) {
                PlayerController.this.internalListener.f();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            PlayerController playerController = PlayerController.this;
            playerController.userInteracting = false;
            if (playerController.seekListener == null || !PlayerController.this.seekListener.a(this.seekToTime)) {
                PlayerController.this.internalListener.a(this.seekToTime);
            }
        }
    }
}
