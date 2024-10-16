package com.devbrackets.android.exomedia.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.devbrackets.android.exomedia.b.f;
import com.tencent.grobot.lite.R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class d extends com.devbrackets.android.exomedia.ui.widget.a {

    /* renamed from: a, reason: collision with root package name */
    protected SeekBar f1058a;
    protected LinearLayout b;
    protected boolean c;

    public d(Context context) {
        super(context);
        this.c = false;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected int getLayoutResource() {
        return R.layout.exomedia_default_controls_mobile;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void setPosition(long j) {
        this.currentTimeTextView.setText(f.a(j));
        this.f1058a.setProgress((int) j);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.b
    public void setDuration(long j) {
        if (j != this.f1058a.getMax()) {
            this.endTimeTextView.setText(f.a(j));
            this.f1058a.setMax((int) j);
        }
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void updateProgress(long j, long j2, int i) {
        if (this.c) {
            return;
        }
        this.f1058a.setSecondaryProgress((int) (r4.getMax() * (i / 100.0f)));
        this.f1058a.setProgress((int) j);
        this.currentTimeTextView.setText(f.a(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void retrieveViews() {
        super.retrieveViews();
        this.f1058a = (SeekBar) findViewById(R.id.exomedia_controls_video_seek);
        this.b = (LinearLayout) findViewById(R.id.exomedia_controls_extra_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void registerListeners() {
        super.registerListeners();
        this.f1058a.setOnSeekBarChangeListener(new a());
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void addExtraView(View view) {
        this.b.addView(view);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void removeExtraView(View view) {
        this.b.removeView(view);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public List<View> getExtraViews() {
        int childCount = this.b.getChildCount();
        if (childCount <= 0) {
            return super.getExtraViews();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < childCount; i++) {
            linkedList.add(this.b.getChildAt(i));
        }
        return linkedList;
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    public void hideDelayed(long j) {
        this.hideDelay = j;
        if (j < 0 || !this.canViewHide || this.isLoading || this.c) {
            return;
        }
        this.visibilityHandler.postDelayed(new Runnable() { // from class: com.devbrackets.android.exomedia.ui.widget.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.animateVisibility(false);
            }
        }, j);
    }

    @Override // com.devbrackets.android.exomedia.ui.widget.a
    protected void animateVisibility(boolean z) {
        if (this.isVisible == z) {
            return;
        }
        if (!this.hideEmptyTextContainer || !isTextContainerEmpty()) {
            this.textContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.b(this.textContainer, z, 300L));
        }
        if (!this.isLoading) {
            this.controlsContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.a(this.controlsContainer, z, 300L));
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
                this.textContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.b(this.textContainer, false, 300L));
            } else {
                if ((this.hideEmptyTextContainer && isTextContainerEmpty) || this.textContainer.getVisibility() == 0) {
                    return;
                }
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new com.devbrackets.android.exomedia.ui.a.b(this.textContainer, true, 300L));
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

    /* loaded from: classes.dex */
    protected class a implements SeekBar.OnSeekBarChangeListener {
        private long b;

        protected a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.b = i;
                if (d.this.currentTimeTextView != null) {
                    d.this.currentTimeTextView.setText(f.a(this.b));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.c = true;
            if (dVar.seekListener == null || !d.this.seekListener.f()) {
                d.this.internalListener.f();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            d dVar = d.this;
            dVar.c = false;
            if (dVar.seekListener == null || !d.this.seekListener.a(this.b)) {
                d.this.internalListener.a(this.b);
            }
        }
    }
}
